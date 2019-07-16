package org.ajou.team6.riot.getleagueV4.RiotOpenAPIGetLeagueV4.domain;

import lombok.Data;

import java.util.List;

@Data
public class SetOfLeagueEntryDTO {
    String summonerId;
    List<LeagueEntryDTO> leagueEntryDTOList;
}
