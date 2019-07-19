package org.ajou.team6.riot.getleagueV4.RiotOpenAPIGetLeagueV4.domain;

import lombok.Data;
import lombok.Value;
import org.springframework.data.annotation.Id;

@Data
public class LeaguePosition {

    @Id
    private CompositeKey id;
    private LeagueEntryDTO leagueEntryDTO;

    public LeaguePosition(LeagueEntryDTO leagueEntry) {
        id = new CompositeKey(leagueEntry.getSummonerName(), leagueEntry.getQueueType());
        leagueEntryDTO = leagueEntry;
    }

    @Value
    static class CompositeKey {
        private String summonerName;
        private String queueType;
    }

}
