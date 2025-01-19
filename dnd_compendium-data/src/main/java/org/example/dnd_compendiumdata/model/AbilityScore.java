package org.example.dnd_compendiumdata.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class AbilityScore{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String entityIndex;
    private String name;
    private String fullName;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String url;


}
