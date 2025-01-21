package org.example.dnd_compendiumclient.compendiumclient.contract.details;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CharacterClassDetailsDto(
        @JsonProperty("hit_die")
        int hitDie) {
}
