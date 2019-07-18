package org.ajou.team6.riot.getleagueV4.RiotOpenAPIGetLeagueV4.service;

import lombok.extern.slf4j.Slf4j;
import org.ajou.team6.riot.getleagueV4.RiotOpenAPIGetLeagueV4.api.RiotOpenApiClient;
import org.ajou.team6.riot.getleagueV4.RiotOpenAPIGetLeagueV4.domain.LeagueEntryDTO;
import org.ajou.team6.riot.getleagueV4.RiotOpenAPIGetLeagueV4.repository.RiotApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RiotOpenApiService {

    @Autowired
    RiotOpenApiClient riotOpenApiClient;
    @Autowired
    RiotApiRepository riotApiRepository;

    public List<LeagueEntryDTO> getLeagueEntryDTOList(String summonerName) {
        String encryptedId = riotOpenApiClient.requestEncryptedSummonerIdBySummonerName(summonerName).getId();
        List<LeagueEntryDTO> leagueEntryDTOList = riotOpenApiClient.requestLeagueEntryDTOListByEncryptedId(encryptedId);

        for(int i = 0; i < leagueEntryDTOList.size(); i++) {
            LeagueEntryDTO.CompositeKey id = new LeagueEntryDTO.CompositeKey(summonerName, leagueEntryDTOList.get(i).getQueueType());
            leagueEntryDTOList.get(i).setId(id);
            riotApiRepository.saveSetOfLeagueEntryDTO(leagueEntryDTOList.get(i));
            log.info("League Positions has been upserted successfully: " + summonerName + leagueEntryDTOList.get(i).getQueueType());
        }

        return leagueEntryDTOList;
    }
}
