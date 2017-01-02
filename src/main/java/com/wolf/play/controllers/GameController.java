package com.wolf.play.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wolf.play.Game;
import com.wolf.play.implementation.GameImpl;

@Controller
@RequestMapping(value="/game")
public class GameController {
	
	private GameImpl gameImpl = new GameImpl();
	
	 @RequestMapping(value="/createGame", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	 @ResponseBody
	 public Game createGame(Game newGame) {
		return gameImpl.saveGame(newGame);
	 }
	 
	 @RequestMapping(value="/joinGame", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	 @ResponseBody
	 public Game joinGame(UUID gameId) {
		//GameImpl.canJoinGame(gameId);
		return new Game();
	 }
	 
	 @RequestMapping(value="/beginGame", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	 @ResponseBody
	 public Game beginGame(UUID gameId) {
		//GameImpl.canJoinGame(gameId);
		return new Game();
	 }
	 
	 @RequestMapping(value="/setAction", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	 @ResponseBody
	 public Game setAction(UUID target) {
		//get cookie sessionInfo 
		//gameImpl.setAction(UUID.randomUUID(), target);
		return new Game();
	 }
	 
}





