package org.example.dnd_compendiumclient.compendiumclient;

import org.example.dnd_compendiumclient.compendiumclient.contract.AbilityScoreResultDto;

public interface ICompendiumClient {
    IAbilityScoreClient getAbilityScoreClient();
    IAlignmentClient getAlignmentClient();
    IBackgroundClient getBackgroundClient();
    ICharacterClassClient getCharacterClassClient();
    ISpellsClient getSpellsClient();
    IRaceClient getRaceClient();
}
