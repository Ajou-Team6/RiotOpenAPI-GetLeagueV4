package org.ajou.team6.riot.getleagueV4.RiotOpenAPIGetLeagueV4.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.ajou.team6.riot.getleagueV4.RiotOpenAPIGetLeagueV4.api.RiotOpenApiClient;
import org.ajou.team6.riot.getleagueV4.RiotOpenAPIGetLeagueV4.domain.LeagueEntryDTO;
import org.ajou.team6.riot.getleagueV4.RiotOpenAPIGetLeagueV4.repository.RiotApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RiotOpenApiService {
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    RiotOpenApiClient riotOpenApiClient;
    @Autowired
    RiotApiRepository riotApiRepository;
    @Autowired
    MongoTemplate mongoTemplate;

    public List<LeagueEntryDTO> getLeagueEntryDTOList(String summonerId){
        List<LeagueEntryDTO> leagueEntryDTOList = riotOpenApiClient.requestLeagueByEncryptedId(summonerId);
        if(riotApiRepository.findCurrentUserInfo(summonerId)==null){
            riotApiRepository.insertStoredLeague(summonerId);
        }
        else{
            riotApiRepository.updateStoredLeague(leagueEntryDTOList, summonerId);
        }
        return leagueEntryDTOList;
    }
}
