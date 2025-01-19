package org.example.dnd_compendiumclient.compendiumclient.contract.details;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record AbilityScoreDetailDto(String index, String name, @JsonProperty("full_name") String fullName, List<String> desc, String url){
}
