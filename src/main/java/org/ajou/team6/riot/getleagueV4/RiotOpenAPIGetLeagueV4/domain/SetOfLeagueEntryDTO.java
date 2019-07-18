package org.ajou.team6.riot.getleagueV4.RiotOpenAPIGetLeagueV4.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@Builder
public class SetOfLeagueEntryDTO {
    @Id
    String summonerName;
    List<LeagueEntryDTO> leagueEntryDTOList;
}
