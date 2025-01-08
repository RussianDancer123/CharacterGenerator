package org.example.dnd_compendiumclient.compendiumclient;

import org.example.dnd_compendiumclient.compendiumclient.contract.AbilityScoreDetailDto;
import org.example.dnd_compendiumclient.compendiumclient.contract.CompendiumEntryResultDto;

public interface IAbilityScoreClient {
    CompendiumEntryResultDto getAbilityScore();
    AbilityScoreDetailDto getAbilityScoreDetail(String index);
}
