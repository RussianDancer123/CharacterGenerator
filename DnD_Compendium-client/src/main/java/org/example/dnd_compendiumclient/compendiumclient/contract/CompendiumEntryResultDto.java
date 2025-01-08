package org.example.dnd_compendiumclient.compendiumclient.contract;

import java.util.List;

public record CompendiumEntryResultDto(int count, List<CompendiumEntryDto> results) {
}
