package org.example.dnd_compendiumclient.compendiumclient;

import org.example.dnd_compendiumclient.compendiumclient.contract.CompendiumEntryResultDto;
import org.example.dnd_compendiumclient.compendiumclient.contract.details.CompendiumEntryDetailsDto;

public interface ISkillClient {
    CompendiumEntryResultDto getSkillls();
    CompendiumEntryDetailsDto getSkillDetails(String entityIndex);
}
