package org.ajou.team6.riot.getleagueV4.RiotOpenAPIGetLeagueV4.repository;

import org.ajou.team6.riot.getleagueV4.RiotOpenAPIGetLeagueV4.domain.LeagueEntryDTO;
import org.graalvm.compiler.lir.sparc.SPARCMove;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RiotApiRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    public void insertStoredLeague(String summonerId) {
        mongoTemplate.insert(summonerId);
    }

   

}
