package org.example.dnd_compendiumwebapi.contract;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SpellDetailsDto {
    String name;
    int level;
    String description;

}
