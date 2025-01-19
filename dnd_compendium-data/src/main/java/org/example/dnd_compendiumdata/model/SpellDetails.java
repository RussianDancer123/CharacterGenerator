package org.example.dnd_compendiumdata.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class SpellDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique=true)
    private String entityIndex;

    @Column(columnDefinition = "TEXT")
    private String description;
}
