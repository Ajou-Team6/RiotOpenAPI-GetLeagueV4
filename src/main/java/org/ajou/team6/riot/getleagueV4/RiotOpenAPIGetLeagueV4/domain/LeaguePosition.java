package org.ajou.team6.riot.getleagueV4.RiotOpenAPIGetLeagueV4.domain;

import lombok.Data;
import lombok.Value;
import org.springframework.data.annotation.Id;

@Data
public class LeaguePosition {

    @Id
    private CompositeKey id;
    private LeagueEntryDTO leagueEntryDTO;

    @Value
    static class CompositeKey {
        private String summonerName;
        private String queueType;
    }

    public LeaguePosition(LeagueEntryDTO leagueEntry) {
        id = new CompositeKey(leagueEntry.getSummonerName(), leagueEntry.getQueueType());
        leagueEntryDTO = leagueEntry;
    }

    @Data
    public static class LeagueEntryDTO {
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
    }

}
