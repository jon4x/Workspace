package de.jon4x.lobbysystem.inventories;

import org.bukkit.entity.Player;

/**
 * Erstellt am 18 Jan 2018 - 08:18
 * Copyright (c) Jonas Laux. Alle Rechte vorbehalten.
 * Projekt >> LobbySystem
 */

public class Gadgets {

    private static Gadgets instance;

    public static Gadgets getInstance() {
        if (instance == null)
            instance = new Gadgets();
        return instance;
    }

    public void openBoots(Player p) {

    }

    public void openHeads(Player p) {

    }

    public void openWardrobe(Player p) {

    }

}
