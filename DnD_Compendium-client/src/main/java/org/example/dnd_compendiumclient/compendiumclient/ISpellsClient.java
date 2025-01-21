package org.example.dnd_compendiumclient.compendiumclient;


import org.example.dnd_compendiumclient.compendiumclient.contract.CompendiumEntryResultDto;
import org.example.dnd_compendiumclient.compendiumclient.contract.SpellDto;
import org.example.dnd_compendiumclient.compendiumclient.contract.details.CompendiumEntryDetailsDto;

public interface ISpellsClient {
    CompendiumEntryResultDto getSpells();

    CompendiumEntryDetailsDto getSpellDetails(String entityIndex);
}
