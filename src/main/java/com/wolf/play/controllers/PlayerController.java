package com.wolf.play.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wolf.play.Login;
import com.wolf.play.Player;
import com.wolf.play.implementation.PlayerDataService;

@Controller
@RequestMapping(value="/player")
public class PlayerController {
	
	@Autowired
	private PlayerDataService playerService;
	
	 @RequestMapping(value="/finalizePlayer", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	 @ResponseBody
	 public Player createPlayer(@RequestBody Player player) {
		 playerService.savePlayer(player);
		return player;
	 }
	 
	 @RequestMapping(value="/authorizePlayer", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	 @ResponseBody
	 public Player authorize(Login login) {
		//checkPlayer
		return null;
	 }
	
	 @RequestMapping(method=RequestMethod.GET)
		String login(){
			System.out.println("welcome future user");
			return "CreateAccount";	
		};
	 
}
