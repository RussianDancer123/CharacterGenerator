package org.example.dnd_compendiumclient.compendiumclient;

import org.example.dnd_compendiumclient.compendiumclient.contract.AbilityScoreDetailDto;
import org.example.dnd_compendiumclient.compendiumclient.contract.AbilityScoreResultDto;

public interface IAbilityScoreClient {
    AbilityScoreResultDto getAbilityScore();
    AbilityScoreDetailDto getAbilityScoreDetail(String index);
}
