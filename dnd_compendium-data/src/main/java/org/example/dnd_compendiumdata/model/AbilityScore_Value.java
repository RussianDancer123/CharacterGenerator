package org.example.dnd_compendiumdata.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class AbilityScore_Value {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int value;

    @ManyToOne
    @JoinColumn(name="playerCharacter_id")
    @JsonIgnore
    private PlayerCharacter playerCharacter;

    @ManyToOne
    @JoinColumn(name="ability_score_id")
    private AbilityScore abilityScore;
}
