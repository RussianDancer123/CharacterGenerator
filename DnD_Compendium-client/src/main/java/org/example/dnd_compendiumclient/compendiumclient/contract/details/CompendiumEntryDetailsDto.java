package org.example.dnd_compendiumclient.compendiumclient.contract.details;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record CompendiumEntryDetailsDto(
        @JsonProperty("desc")
        List<String> description, String index) {
}
