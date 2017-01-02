package com.wolf.play.implementation;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.wolf.play.Game;
import com.wolf.play.Player;

@Service
public class GameDataService {
	OmniMapper omniMapper = new OmniMapper();

	public Player getPlayer(UUID actionTarget) {
		return (Player) getByField(new Player(), "uuid", actionTarget.toString());
	}

	public List<Player> getPlayersWithUuids(Set<UUID> playerUuids) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setAction(UUID gameUuid, UUID randomUuid, UUID target) {
		
	}

	public Game obtainGame(UUID gameUuid) {
		return (Game) getByField(new Game(), "uuid", gameUuid.toString());
	}

	public Game saveGame(Game game) {
	//	mongoOperation.save(game);
		return game;
	}

	private Object getByField(Object clazz, String fieldName, String fieldValue){
		Query query = new Query();
		query.addCriteria(Criteria.where(fieldName).is(fieldValue));
		return null;
		//return mongoOperation.find(query, clazz.getClass());
	}

}
