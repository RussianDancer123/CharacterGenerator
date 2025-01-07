package org.example.dnd_compendiumclient.compendiumclient.contract;

import org.springframework.web.util.UriComponentsBuilder;

public interface IDndCompendiumClientUriBuilderProvider {

    String host();

    default UriComponentsBuilder builder() {
        return UriComponentsBuilder.newInstance()
                .scheme("https")
                .path("api")
                .host(host());
    }
}
