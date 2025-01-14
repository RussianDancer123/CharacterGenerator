package org.example.dnd_compendiumdata.model;

import jakarta.persistence.*;

@Entity
public class SubRace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique=true)
    private String entityIndex;

    private String name;
    private String url;
}
