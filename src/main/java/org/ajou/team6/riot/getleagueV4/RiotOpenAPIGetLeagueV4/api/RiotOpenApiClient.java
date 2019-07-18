package org.ajou.team6.riot.getleagueV4.RiotOpenAPIGetLeagueV4.api;

import org.ajou.team6.riot.getleagueV4.RiotOpenAPIGetLeagueV4.domain.LeagueEntryDTO;
import org.ajou.team6.riot.getleagueV4.RiotOpenAPIGetLeagueV4.domain.SummonerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Service
public class RiotOpenApiClient {
    private String key = null;
    private String openEncryptedIdUrl = "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/";
    private String openLeagueUrl = "https://kr.api.riotgames.com/lol/league/v4/entries/by-summoner/";
    private String requestParam = "?api_key={key}";

    @Autowired
    RestTemplate restTemplate;

    public void loadOpenRiotApiKey() {
        try {
            this.key = new String ( Files.readAllBytes( Paths.get("key") ) );
        }
        catch (IOException e) {
            this.key = null;
        }
    }

    public String getOpenRiotApiKey() {
        return this.key;
    }

    public SummonerDTO requestEncryptedSummonerIdBySummonerName(String summonerName) {
        if(this.key == null) loadOpenRiotApiKey();
        String RealUrl = this.openEncryptedIdUrl + summonerName + this.requestParam;
        return this.restTemplate.exchange(RealUrl, HttpMethod.GET, null, SummonerDTO.class, this.getOpenRiotApiKey()).getBody();
    }

    public List<LeagueEntryDTO> requestLeagueEntryDTOListByEncryptedId(String encryptedId) {
        String RealUrl = this.openLeagueUrl + encryptedId + this.requestParam;
        return this.restTemplate.exchange(RealUrl,HttpMethod.GET, null, new ParameterizedTypeReference<List<LeagueEntryDTO>>() {}, this.getOpenRiotApiKey()).getBody();
    }

}
