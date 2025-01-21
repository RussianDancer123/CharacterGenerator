package org.example.dnd_compendiumclient.compendiumclient;

import org.example.dnd_compendiumclient.compendiumclient.contract.CompendiumEntryResultDto;
import org.example.dnd_compendiumclient.compendiumclient.contract.details.CompendiumEntryDetailsDto;

public interface IAlignmentClient {
    CompendiumEntryResultDto getAlignments();
    String getAlignmentDetails(String index);
}
