package org.example.dnd_compendiumdata.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CharacterClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String entityIndex;
    private String name;
    private String hitDie;

}
