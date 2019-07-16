package org.ajou.team6.riot.getleagueV4.RiotOpenAPIGetLeagueV4.controller;

import org.ajou.team6.riot.getleagueV4.RiotOpenAPIGetLeagueV4.api.RiotOpenApiClient;
import org.ajou.team6.riot.getleagueV4.RiotOpenAPIGetLeagueV4.domain.LeagueEntryDTO;
import org.ajou.team6.riot.getleagueV4.RiotOpenAPIGetLeagueV4.service.RiotOpenApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RiotApiController {

    @Autowired
    RiotOpenApiService riotOpenApiService;

    @Autowired
    RiotOpenApiClient riotOpenApiClient;

    @GetMapping ("/riotopenapi/by-summoner-name/{summonerName}")
    public List<LeagueEntryDTO> getLeagueEntryDTOList(@PathVariable String summonerName) {
        String encryptedSummonerId = riotOpenApiClient.requestEncryptedSummonerIdByName(summonerName).getId();
        return riotOpenApiService.getLeagueEntryDTOList(encryptedSummonerId);
    }
}
