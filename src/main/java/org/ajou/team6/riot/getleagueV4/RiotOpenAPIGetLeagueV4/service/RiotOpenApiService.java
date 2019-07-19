package org.ajou.team6.riot.getleagueV4.RiotOpenAPIGetLeagueV4.service;

import lombok.extern.slf4j.Slf4j;
import org.ajou.team6.riot.getleagueV4.RiotOpenAPIGetLeagueV4.api.RiotOpenApiClient;
import org.ajou.team6.riot.getleagueV4.RiotOpenAPIGetLeagueV4.domain.LeagueEntryDTO;
import org.ajou.team6.riot.getleagueV4.RiotOpenAPIGetLeagueV4.domain.LeaguePosition;
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

        for (LeagueEntryDTO leagueEntryDTO : leagueEntryDTOList) {
            LeaguePosition leaguePosition = new LeaguePosition(leagueEntryDTO);
            riotApiRepository.saveSetOfLeagueEntryDTO(leaguePosition);
            log.info("League Positions has been upserted successfully: " + summonerName + " " + leagueEntryDTO.getQueueType());
        }

        return leagueEntryDTOList;
    }
}
