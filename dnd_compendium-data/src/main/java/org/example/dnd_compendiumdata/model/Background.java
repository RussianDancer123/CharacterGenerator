package org.example.dnd_compendiumdata.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Background {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String entityIndex;
    private String name;
    private String url;
}
