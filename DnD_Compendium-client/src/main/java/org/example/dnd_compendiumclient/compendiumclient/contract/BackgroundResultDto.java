package org.example.dnd_compendiumclient.compendiumclient.contract;

import java.util.List;

public record BackgroundResultDto(int count, List<BackgroundDto> results) {
}
