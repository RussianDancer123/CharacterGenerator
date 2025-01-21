package org.example.dnd_compendiumclient.compendiumclient.client;


public interface ICompendiumClient {
    IAbilityScoreClient getAbilityScoreClient();
    IAlignmentClient getAlignmentClient();
    IBackgroundClient getBackgroundClient();
    ICharacterClassClient getCharacterClassClient();
    ISpellsClient getSpellsClient();
    IRaceClient getRaceClient();
    ISkillClient getSkillClient();
}
