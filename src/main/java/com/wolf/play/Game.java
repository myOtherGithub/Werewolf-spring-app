package com.wolf.play;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

import org.springframework.data.mongodb.core.mapping.Document;

import com.wolf.play.enums.GameState;
import com.wolf.play.enums.TimingType;

@Document(collection = "Game")
public class Game {
	
	private String gameName;
	
	private Date startTime;
	
	private UUID uuid;
	
	private boolean privateGame;
	
	private Date closingDate;
	
	private Map<UUID, GameSpecificPlayerInfo> players;
	
	private Date endTime;
	
	private GameState gameState;
	
	private TimingType timingType;
	
	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public boolean isPrivateGame() {
		return privateGame;
	}

	public void setPrivateGame(boolean privateGame) {
		this.privateGame = privateGame;
	}

	public Date getClosingDate() {
		return closingDate;
	}

	public void setClosingDate(Date closingDate) {
		this.closingDate = closingDate;
	}

	public Map<UUID, GameSpecificPlayerInfo> getPlayers() {
		return players;
	}

	public void addPlayer(UUID uuid) {
		players.put(uuid, new GameSpecificPlayerInfo());
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public GameState getGameState() {
		return gameState;
	}

	public void setGameState(GameState gameState) {
		this.gameState = gameState;
	}
	
	public void setTimingType(TimingType timingType){
		this.timingType = timingType;
	}
	
	public TimingType getTimingType(){
		return timingType;
	}

	public void nextGameState() {
		if(this.gameState == GameState.WAITING_DAY){
			this.gameState = GameState.WAITING_NIGHT;
		}else{
			this.gameState = GameState.WAITING_DAY;
		}
		
	}
	
}
