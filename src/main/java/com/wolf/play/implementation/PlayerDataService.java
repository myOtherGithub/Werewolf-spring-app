package com.wolf.play.implementation;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.wolf.play.Game;
import com.wolf.play.GameSpecificPlayerInfo;
import com.wolf.play.Notification;
import com.wolf.play.Player;
import com.wolf.play.repositories.PlayerRepository;

@Service
public class PlayerDataService {
	
	@Autowired
	@Qualifier("playerRepository")
	private PlayerRepository repository;
	
	public Player savePlayer(Player player){
		player.setUuid(UUID.randomUUID());
		repository.save(player);
		return player;
	}
	
	public void sendAllPlayersNotifications(Game game, Notification notification) {
		List<UUID> players = (List<UUID>) game.getPlayers().keySet();
		for(UUID uuid : players){
//			Player player = getPlayerByUuid(uuid.toString());
//			player.addNotification(notification);
//			mongoOperation.updateFirst(player);
			//db.savePlayer();
		}
	}

	public void sendSeerNotification(Game game) {
		Optional<GameSpecificPlayerInfo> vampire = game.getPlayers().values().stream().filter(a -> a.getIsSeer()).findFirst();
		List<UUID> playersUuids = (List<UUID>) game.getPlayers().keySet();
		for(UUID uuid : playersUuids){
			if(game.getPlayers().get(uuid).getIsSeer()){
				if(game.getPlayers().get(game.getPlayers().get(uuid).getActionTarget()).getIsVampire()){
					//db.findPlayer(uuid);
					Notification notification = new Notification();
					notification.setMessage("The person you selected was the vampire!");
					//player.addNotification(notification);
					//db.savePlayer();
				}else{
					//db.findPlayer(uuid);
					Notification notification = new Notification();
					notification.setMessage("The person you selected was not the vampire!");
					//player.addNotification(notification);
					//db.savePlayer();
				}
			}
		}
	}
}
