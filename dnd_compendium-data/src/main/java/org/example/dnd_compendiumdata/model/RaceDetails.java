package org.example.dnd_compendiumdata.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Table(name = "race_details")
@Getter
@Setter
@Accessors(chain = true)
public class RaceDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique=true)
    private String entityIndex;

    private String name;
    private String url;
    private int speed;
    @Column(columnDefinition = "TEXT")
    private String age;
    private String size;
}
