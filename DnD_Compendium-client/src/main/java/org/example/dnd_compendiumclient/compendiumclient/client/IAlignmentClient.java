package org.example.dnd_compendiumclient.compendiumclient.client;

import org.example.dnd_compendiumclient.compendiumclient.contract.CompendiumEntryResultDto;

public interface IAlignmentClient {
    CompendiumEntryResultDto getAlignments();
    String getAlignmentDetails(String index);
}
