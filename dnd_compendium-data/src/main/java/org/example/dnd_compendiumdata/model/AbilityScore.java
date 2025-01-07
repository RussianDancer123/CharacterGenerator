package org.example.dnd_compendiumdata.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AbilityScore {

    @Id
    private String entityIndex;

    private String name;
    private String fullName;
    private String description;
    private String url;


}
