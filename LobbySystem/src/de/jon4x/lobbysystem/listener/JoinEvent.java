package de.jon4x.lobbysystem.listener;

import de.jon4x.lobbysystem.itemmanager.ItemManager;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Erstellt am 18 Jan 2018 - 08:51
 * Copyright (c) Jonas Laux. Alle Rechte vorbehalten.
 * Projekt >> LobbySystem
 */

public class JoinEvent implements Listener {

    @EventHandler
    public void onJoin (PlayerJoinEvent e) {
        Player p = e.getPlayer();
        p.setHealthScale(6.0);
        p.setHealth(20.0);

        setJoinInv(p);
    }

    private void setJoinInv (Player p) {
        p.getInventory().clear();
        p.getInventory().setItem(0, ItemManager.createItem(Material.WATCH, 1, 0, "§bTeleporter §7(Rechtsklick)", null));
        p.getInventory().setItem(1, ItemManager.createItem(Material.REDSTONE_TORCH_ON, 1, 10,"§cEinstellungen §7(Rechtsklick)", null));
        p.getInventory().setItem(7, ItemManager.createItem(Material.DOUBLE_PLANT, 1, 0, "§6Gadgets §7(Rechtsklick)", null));
        p.getInventory().setItem(8, ItemManager.createSkull(Material.SKULL_ITEM, 1, p.getName(), "§dFreunde §7(Rechtsklick)", null));
    }
}
