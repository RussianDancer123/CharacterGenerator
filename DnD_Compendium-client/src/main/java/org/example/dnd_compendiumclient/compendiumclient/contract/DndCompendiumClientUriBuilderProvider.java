package org.example.dnd_compendiumclient.compendiumclient.contract;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public record DndCompendiumClientUriBuilderProvider(String host) implements IDndCompendiumClientUriBuilderProvider {

    public DndCompendiumClientUriBuilderProvider(
            @Value("${dnd5eapi.host}") String host) {
        this.host = host;
    }
}
