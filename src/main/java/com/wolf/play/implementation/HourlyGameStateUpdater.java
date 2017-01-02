package com.wolf.play.implementation;

import org.springframework.scheduling.annotation.Scheduled;

public class HourlyGameStateUpdater {
	
	@Scheduled(cron="EVERYDAY")
	public void updateGameStates(){
		
	}

}
