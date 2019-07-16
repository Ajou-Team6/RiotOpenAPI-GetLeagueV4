package org.ajou.team6.riot.getleagueV4.RiotOpenAPIGetLeagueV4.repository;

import org.ajou.team6.riot.getleagueV4.RiotOpenAPIGetLeagueV4.domain.LeagueEntryDTO;
import org.ajou.team6.riot.getleagueV4.RiotOpenAPIGetLeagueV4.domain.SetOfLeagueEntryDTO;
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

    public void insertStoredLeague(SetOfLeagueEntryDTO League) {
        mongoTemplate.insert(League);
    }

    public SetOfLeagueEntryDTO findCurrentUserInfo(String summonerId) {
        Query query = Query.query(Criteria.where("summonerId").is(summonerId));
        return mongoTemplate.findOne(query, SetOfLeagueEntryDTO.class);
    }

    public SetOfLeagueEntryDTO updateStoredLeague(List<LeagueEntryDTO> league, String summonerId) {

        Criteria criteria = new Criteria("summonerId");

        criteria.is(summonerId);

        Query query = new Query(criteria);

        Update update = new Update();

        update.set("leagueEntryDTOList", league);

        mongoTemplate.updateFirst(query, update, "setOfLeagueEntryDTO");

        return mongoTemplate.findOne(query, SetOfLeagueEntryDTO.class);

    }

}
