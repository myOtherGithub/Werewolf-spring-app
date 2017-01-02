package com.wolf.play.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.wolf.play.Player;

@Repository
public interface PlayerRepository extends MongoRepository<Player, String> {

    public Player findByAddress(String address);
    public List<Player> findByNumber(String number);
    public Player findByName(String name);
    public Player findByUuid(String uuid);
    
}