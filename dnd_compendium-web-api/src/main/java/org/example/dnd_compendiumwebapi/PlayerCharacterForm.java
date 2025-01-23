package org.example.dnd_compendiumwebapi;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PlayerCharacterForm {
    private String name;
    private String playerName;
    private String gender;
    private int level;
    private int experience;
    private int cha;
    private int con;
    private int dex;
    private int inte;
    private int str;
    private int wis;
    private String characterClassIndex;
    private String subRaceIndex;
    private String alignmentIndex;
    private String raceIndex;
    private List<String> spellIndices;
    private List<String> skillIndices;

}
