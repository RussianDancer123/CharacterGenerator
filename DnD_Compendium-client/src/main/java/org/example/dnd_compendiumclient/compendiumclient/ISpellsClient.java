package org.example.dnd_compendiumclient.compendiumclient;


import org.example.dnd_compendiumclient.compendiumclient.contract.CompendiumEntryResultDto;
import org.example.dnd_compendiumclient.compendiumclient.contract.SpellDto;
import org.example.dnd_compendiumclient.compendiumclient.contract.SpellResultDto;
import org.example.dnd_compendiumclient.compendiumclient.contract.details.SpellDetailDto;

public interface ISpellsClient {
    SpellResultDto getSpells();

    SpellDetailDto getSpellDetails(String entityIndex);
}
