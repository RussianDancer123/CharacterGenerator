package org.example.dnd_compendiumclient.compendiumclient.contract;

import java.util.List;

public record SpellResultDto(int count, List<SpellDto> results) {
}
