package org.example.dnd_compendiumclient.compendiumclient.contract.details;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record AbilityScoreDetailsDto(
        @JsonProperty("full_name")
        String fullName,
        @JsonProperty("desc")
        List<String> description) {
}
