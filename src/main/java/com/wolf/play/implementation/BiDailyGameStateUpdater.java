package com.wolf.play.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.scheduling.annotation.Scheduled;

import com.wolf.play.Game;
import com.wolf.play.enums.TimingType;

public class BiDailyGameStateUpdater {
	
	GameImpl gameImpl = new GameImpl();
	
	@Scheduled(cron="08,19 * * * ") //8am and 7pm every day.
	public void updateDailyGames(){
		Query query = new Query(Criteria
				.where("GameState").is("Active")
				.and("closingState").is(null)
				.and("TimingType").is(TimingType.BIDAILY)
		);
		//TODO:Get Games from query above
		List<Game> ongoingGames = new ArrayList<>();
		for(Game game: ongoingGames){
			gameImpl.gameStateChange(new Game().getUuid());
		}
	}
}
