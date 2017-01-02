package com.wolf.play.implementation;

import java.util.Collections;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wolf.play.Game;
import com.wolf.play.GameSpecificPlayerInfo;
import com.wolf.play.Notification;
import com.wolf.play.Player;
import com.wolf.play.enums.GameState;

public class GameImpl {
	
	GameDataService gameDataService = new GameDataService();
	PlayerDataService playerDataService = new PlayerDataService();

	public void setAction(UUID gameUuid, UUID randomUuid, UUID target) {
		gameDataService.setAction(gameUuid, randomUuid, target);
		//TODO: get gametype here and only call if not bidaily.
		gameStateChange(gameUuid);
	}
	
	//gets the game and determines the state
	public Boolean gameStateChange(UUID gameUuid){
		Game game = gameDataService.obtainGame(gameUuid);
		int living = (int) game.getPlayers().values().stream().filter(b -> b.getLiving()).count();
		if(living <= 1){
			game.setGameState(GameState.COMPLETE);
			return true;
		}else{
			int voted = (int) game.getPlayers().values().stream().filter(b -> b.getLiving()).filter(c -> c.getActionTarget() == null).count();
			if(voted == 0){
				game.nextGameState();
				createNotifications(game);
				return true;
			}
			return false;
		}
	}
	
	public Game saveGame(Game game){
		gameDataService.saveGame(game);
		return game;
	}

	private void createNotifications(Game game) {
		Notification notification = new Notification();
		notification.setGameUuid(game.getUuid());
		if(game.getGameState().equals(GameState.WAITING_DAY)){
			Optional<GameSpecificPlayerInfo> vampire = game.getPlayers().values().stream().filter(a -> a.getIsVampire()).findFirst();
			Player vampireTarget = gameDataService.getPlayer(vampire.get().getActionTarget());
			notification.setMessage("Dawn of a new day "+vampireTarget.getName()+" is found dead in the village square");
			game.getPlayers().get(vampireTarget.getUuid()).setLiving(false);
			notification.setGameUuid(game.getUuid());
			playerDataService.sendAllPlayersNotifications(game, notification);
			playerDataService.sendSeerNotification(game);
			gameDataService.saveGame(game);
		}else if(game.getGameState().equals(GameState.WAITING_NIGHT)){
			int max = 0;
		    int curr = 0;
		    UUID currKey =  null;
		    for(UUID player : game.getPlayers().keySet()){
		    	 curr = Collections.frequency(game.getPlayers().keySet(), player);
		    	 if(max < curr){
	                 max = curr;
	                 currKey = player;
	              }
		    }
		    Player votedDeadPlayer = gameDataService.getPlayer(currKey);
			notification.setMessage("As another moon rises "+votedDeadPlayer.getName()+" is killed via the vote.");
			game.getPlayers().get(votedDeadPlayer.getUuid()).setLiving(false);
			gameDataService.saveGame(game);
		}else{
			notification.setMessage("The game is now over");
		}
	}
	
}
