package de.jon4x.lobbysystem.inventories;

import org.bukkit.entity.Player;

/**
 * Erstellt am 18 Jan 2018 - 08:23
 * Copyright (c) Jonas Laux. Alle Rechte vorbehalten.
 * Projekt >> LobbySystem
 */

public class Teleporter {

    private static Teleporter instance;

    public static Teleporter getInstance() {
        if (instance == null)
            instance = new Teleporter();
        return instance;
    }

    public void openTeleporter(Player p) {

    }

}
