package org.example.dnd_compendiumclient;

import org.example.dnd_compendiumclient.compendiumclient.ICompendiumClient;

public class Main {
    public static void main(String[] args) {

    }

    public static void test(ICompendiumClient client){
        System.out.println(client.getSpellsClient().getSpells().results());
        System.out.println(client.getRaceClient().getRaces().results());
        System.out.println(client.getRaceClient().getSubRaces().results());
        System.out.println(client.getAbilityScoreClient().getAbilityScore().results());
    }
}
