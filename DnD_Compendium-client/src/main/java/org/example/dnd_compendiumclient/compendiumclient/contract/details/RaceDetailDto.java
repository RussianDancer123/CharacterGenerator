package org.example.dnd_compendiumclient.compendiumclient.contract.details;

import com.fasterxml.jackson.annotation.JsonProperty;

public record RaceDetailDto(String index, String name, String age, String size, String url, int speed) {
}
