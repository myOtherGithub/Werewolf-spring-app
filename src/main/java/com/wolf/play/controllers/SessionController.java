package com.wolf.play.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wolf.play.Login;
import com.wolf.play.Player;
import com.wolf.play.Session;
import com.wolf.play.implementation.PlayerDataService;
import com.wolf.play.implementation.SessionService;

@Controller
@RequestMapping(value="/session")
public class SessionController {
	 
	 @Autowired
	 SessionService sessionService;
	 
	 @RequestMapping(value="/authorize", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	 @ResponseBody
	 public Session authorize(@RequestBody Login login) {
		return sessionService.authorizeAndCreateSession(login);
	 }
	 
}
