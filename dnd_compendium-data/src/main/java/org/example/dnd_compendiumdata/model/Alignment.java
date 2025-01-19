package org.example.dnd_compendiumdata.model;

import jakarta.persistence.*;

@Entity
public class Alignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String entityIndex;
    private String name;
    private String url;

    @Column(columnDefinition = "TEXT")
    private String description;
}
