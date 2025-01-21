package org.example.dnd_compendiumclient.compendiumclient;

import org.example.dnd_compendiumclient.compendiumclient.contract.CompendiumEntryResultDto;

public interface ICharacterClassClient {
    CompendiumEntryResultDto getCharacterClasses();

    int getCharacterClassHitDie(String entityIndex);
}
