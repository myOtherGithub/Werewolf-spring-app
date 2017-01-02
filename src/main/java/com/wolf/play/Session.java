package com.wolf.play;

import java.util.Date;
import java.util.UUID;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sessions")
public class Session {
	
	private UUID token;
	private Date start;
	private Date expiration;
	private UUID playerUuid;
	
	public UUID getPlayerUuid() {
		return playerUuid;
	}
	public void setPlayerUuid(UUID playerUuid) {
		this.playerUuid = playerUuid;
	}
	public UUID getToken() {
		return token;
	}
	public void setToken(UUID token) {
		this.token = token;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getExpiration() {
		return expiration;
	}
	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}

}
