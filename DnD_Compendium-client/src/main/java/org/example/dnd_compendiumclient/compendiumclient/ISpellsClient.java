package org.example.dnd_compendiumclient.compendiumclient;


import org.example.dnd_compendiumclient.compendiumclient.contract.SpellResultDto;

public interface ISpellsClient {
    SpellResultDto getSpells();
}
