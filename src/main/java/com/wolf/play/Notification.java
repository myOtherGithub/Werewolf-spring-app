package com.wolf.play;

import java.util.UUID;

public class Notification {
	
	String message;
	String actionUrl;
	String imageUrl;
	UUID gameUuid;
	Boolean recieved;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getActionUrl() {
		return actionUrl;
	}
	public void setActionUrl(String actionUrl) {
		this.actionUrl = actionUrl;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public UUID getGameUuid() {
		return gameUuid;
	}
	public void setGameUuid(UUID gameUuid) {
		this.gameUuid = gameUuid;
	}
}
