package org.example.dnd_compendiumdata.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class PlayerCharacter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String playerName;
    private String name;

    @ManyToOne
    private CharacterClass characterClass;

    private int classLevel;

    @ManyToOne
    private Background background;

    @ManyToOne
    private SubRace subRace;

    @ManyToOne
    private Alignment alignment;

    private int experience;

    @ManyToOne
    private Race race;

    @OneToMany(mappedBy = "playerCharacter")
    private List<AbilityScore_Value> abilityScoreValues;

    @ManyToMany
    private List<Spell> spells;

}
