package org.example.dnd_compendiumclient.compendiumclient;

import org.example.dnd_compendiumclient.compendiumclient.contract.AbilityScoreResultDto;

public interface ICompendiumClient {
    ISpellsClient getSpellsClient();
    IRaceClient getRaceClient();

    AbilityScoreResultDto getAbilityScore();
}
