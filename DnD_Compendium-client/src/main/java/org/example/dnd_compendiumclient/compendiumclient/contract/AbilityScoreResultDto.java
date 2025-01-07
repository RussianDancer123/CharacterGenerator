package org.example.dnd_compendiumclient.compendiumclient.contract;

import java.util.List;

public record AbilityScoreResultDto(int count, List<AbilityScoreDto> results) {
}
