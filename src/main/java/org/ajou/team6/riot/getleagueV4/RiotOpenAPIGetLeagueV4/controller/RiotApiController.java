package org.ajou.team6.riot.getleagueV4.RiotOpenAPIGetLeagueV4.controller;

import org.ajou.team6.riot.getleagueV4.RiotOpenAPIGetLeagueV4.domain.LeaguePosition;
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

    @GetMapping ("/riotopenapi/by-summoner-name/{summonerName}")
    public List<LeaguePosition.LeagueEntryDTO> getLeagueEntryDTOList(@PathVariable String summonerName) {
        return riotOpenApiService.getLeagueEntryDTOList(summonerName);
    }
}
