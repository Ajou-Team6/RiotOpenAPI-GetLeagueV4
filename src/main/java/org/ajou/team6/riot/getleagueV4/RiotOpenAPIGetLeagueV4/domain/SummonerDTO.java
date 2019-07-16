package org.ajou.team6.riot.getleagueV4.RiotOpenAPIGetLeagueV4.domain;

import lombok.Data;

@Data
public class SummonerDTO {
    private String profileIconId;
    private String name;
    private String puuid;
    private int summonerLevel ;
    private String accountId;
    private String id;
    private String revisionDate;
}
