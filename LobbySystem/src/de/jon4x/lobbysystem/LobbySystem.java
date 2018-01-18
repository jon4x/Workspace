package de.jon4x.lobbysystem;

import de.jon4x.lobbysystem.listener.JoinEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Erstellt am 18 Jan 2018 - 08:07
 * Copyright (c) Jonas Laux. Alle Rechte vorbehalten.
 * Projekt >> LobbySystem
 */

public class LobbySystem extends JavaPlugin {

    private static LobbySystem instance;

    // On Enable
    @Override
    public void onEnable() {
        // Print
        Bukkit.getConsoleSender().sendMessage("");
        // instance
        instance = this;
        // Register Events
        PluginManager pm = getServer().getPluginManager();
        registerEvents(pm);
    }

    // On Disable
    @Override
    public void onDisable() {
    }

    // Register Events
    private void registerEvents(PluginManager pluginManager) {
        pluginManager.registerEvents(new JoinEvent(), this);
    }

    // Register Commands
    private void registerCommands() {

    }

    // Getter
}
