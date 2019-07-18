package org.ajou.team6.riot.getleagueV4.RiotOpenAPIGetLeagueV4.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class LeagueEntryDTO {

    @Id
    private CompositeKey id;

    private String queueType;
    private String summonerName;
    private boolean hotStreak;
    private int wins;
    private boolean veteran;
    private int losses;
    private String rank;
    private String tier;
    private boolean inactive;
    private boolean freshBlood;
    private String leagueId;
    private String summonerId;
    private int leaguePoints;

    @Data
    public static class MiniSeries{
        private int losses;
        private String progress;
        private int target;
        private int wins;
    }

    @Data
    @AllArgsConstructor
    public static class CompositeKey {
        private String summonerName;
        private String queueType;
    }

}
