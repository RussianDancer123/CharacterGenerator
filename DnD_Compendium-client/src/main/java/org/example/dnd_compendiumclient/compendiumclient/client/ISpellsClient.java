package org.example.dnd_compendiumclient.compendiumclient.client;


import org.example.dnd_compendiumclient.compendiumclient.contract.SpellResultDto;
import org.example.dnd_compendiumclient.compendiumclient.contract.details.CompendiumEntryDetailsDto;

public interface ISpellsClient {
    SpellResultDto getSpells();

    CompendiumEntryDetailsDto getSpellDetails(String entityIndex);
}
