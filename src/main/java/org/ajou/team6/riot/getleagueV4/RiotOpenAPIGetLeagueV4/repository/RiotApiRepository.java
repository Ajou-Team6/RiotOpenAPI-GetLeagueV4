package org.ajou.team6.riot.getleagueV4.RiotOpenAPIGetLeagueV4.repository;

import org.ajou.team6.riot.getleagueV4.RiotOpenAPIGetLeagueV4.domain.SetOfLeagueEntryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RiotApiRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    public SetOfLeagueEntryDTO saveSetOfLeagueEntryDTO(SetOfLeagueEntryDTO leagueEntryDTOList) {
        return mongoTemplate.save(leagueEntryDTOList);
    }
}
