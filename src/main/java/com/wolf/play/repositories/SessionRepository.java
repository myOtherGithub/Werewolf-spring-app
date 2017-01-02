package com.wolf.play.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.wolf.play.Session;

@Repository
public interface SessionRepository extends MongoRepository<Session, String> {

    public List<Session> findByPlayerUuid(UUID playerUuid);
    public Session findByToken(UUID token);
    
}