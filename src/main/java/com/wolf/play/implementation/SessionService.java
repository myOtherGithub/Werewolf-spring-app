package com.wolf.play.implementation;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.wolf.play.Login;
import com.wolf.play.Player;
import com.wolf.play.Session;
import com.wolf.play.repositories.PlayerRepository;
import com.wolf.play.repositories.SessionRepository;

@Service
public class SessionService {
	
	@Autowired
	@Qualifier("sessionRepository")
	private SessionRepository sessionRepository;
	
	@Autowired
	@Qualifier("playerRepository")
	private PlayerRepository repository;
	
	OmniMapper omniMapper = new OmniMapper();
	
	public Session authenticate(Session session){
		Session checkSession = sessionRepository.findByToken(session.getToken());
		if(checkSession.getExpiration().before(new Date())){
			return null;
		}
		return session;
	}

	public Session authorizeAndCreateSession(Login login) {
		Player player = repository.findByName(login.getUsername());
		if(player != null && player.getPassword().getPasswordText().equals(login.getPassword())){
			Session session = new Session();
			session.setPlayerUuid(player.getUuid());
			session.setStart(new Date());
			session.setToken(UUID.randomUUID());
			sessionRepository.save(session);
			return session;
		}
		return null;
	}

	public boolean checkSession(Session session) {
		Session foundSession = sessionRepository.findByToken(session.getToken());
		if(foundSession == null){
			return false;
		}
		return true;
	}
}
