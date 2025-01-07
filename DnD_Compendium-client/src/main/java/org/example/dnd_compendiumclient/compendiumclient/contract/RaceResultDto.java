package org.example.dnd_compendiumclient.compendiumclient.contract;

import java.util.List;

public record RaceResultDto(int count, List<RaceDto> results) {
}
