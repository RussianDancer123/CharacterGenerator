package org.example.dnd_compendiumclient.compendiumclient;

import org.example.dnd_compendiumclient.compendiumclient.contract.*;
import org.example.dnd_compendiumclient.compendiumclient.contract.details.RaceDetailDto;
import org.springframework.web.client.RestTemplate;

public class RaceClient implements IRaceClient{

    RestTemplate restTemplate;
    IDndCompendiumClientUriBuilderProvider provider;

    public RaceClient(IDndCompendiumClientUriBuilderProvider provider) {
        this.restTemplate = new RestTemplate();
        this.provider = provider;
    }

    @Override
    public CompendiumEntryResultDto getRaces(){
        var uri = provider.builder().pathSegment("races").toUriString();
        return restTemplate.getForEntity(uri, CompendiumEntryResultDto.class).getBody();
    }

    @Override
    public CompendiumEntryResultDto getSubRaces() {
        var uri = provider.builder().pathSegment("subraces").toUriString();
        return restTemplate.getForEntity(uri, CompendiumEntryResultDto.class).getBody();
    }


    @Override
    public RaceDetailDto getRaceDetailByIndex(String index){
        var uri = provider.builder().pathSegment("races").pathSegment(index).toUriString();
        return restTemplate.getForEntity(uri, RaceDetailDto.class).getBody();
    }

}
