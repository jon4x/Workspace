package de.jon4x.lobbysystem.inventories;

import org.bukkit.entity.Player;

/**
 * Erstellt am 18 Jan 2018 - 08:50
 * Copyright (c) Jonas Laux. Alle Rechte vorbehalten.
 * Projekt >> LobbySystem
 */

public class Settings {

    private static Settings instance;

    public static Settings getInstance() {
        if (instance == null)
            instance = new Settings();
        return instance;
    }

    public void openSettings (Player p) {

    }

}