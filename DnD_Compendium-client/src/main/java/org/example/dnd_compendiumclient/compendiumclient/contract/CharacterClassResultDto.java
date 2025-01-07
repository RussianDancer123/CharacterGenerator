package org.example.dnd_compendiumclient.compendiumclient.contract;

import java.util.List;

public record CharacterClassResultDto(int count, List<CharacterClassDto> results) {
}
