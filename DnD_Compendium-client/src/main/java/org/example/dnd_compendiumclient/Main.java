package org.example.dnd_compendiumclient;

import org.example.dnd_compendiumclient.compendiumclient.ISpellsClient;
import org.example.dnd_compendiumclient.compendiumclient.SpellsClient;

public class Main {
    public static void main(String[] args) {

    }

    public static void test(){
        ISpellsClient spellsClient = new SpellsClient();
        System.out.println(spellsClient.getSpells().results());
    }
}
