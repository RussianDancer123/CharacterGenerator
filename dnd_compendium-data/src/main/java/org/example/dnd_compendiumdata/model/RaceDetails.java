package org.example.dnd_compendiumdata.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "race_details")
@Getter
@Setter
public class RaceDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique=true)
    private String entityIndex;

    private String name;
    private String url;
    private int speed;
    private String age;
    private String size;
}
