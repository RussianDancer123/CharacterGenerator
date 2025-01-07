package org.example.dnd_compendiumclient.compendiumclient.contract;

import java.util.List;

public record AlignmentResultDto(int count, List<AlignmentDto> results) {
}
