package de.jon4x.lobbysystem.listener;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Vehicle;
import org.bukkit.entity.Weather;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.LeavesDecayEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerAchievementAwardedEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.vehicle.VehicleDamageEvent;
import org.bukkit.event.vehicle.VehicleEnterEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

/**
 * Erstellt am 18 Jan 2018 - 10:40
 * Copyright (c) Jonas Laux. Alle Rechte vorbehalten.
 * Projekt >> LobbySystem
 */

public class Protect implements Listener {

    @EventHandler
    public void onWeather (WeatherChangeEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onEnterVehicle (VehicleEnterEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onDamageVehicle (VehicleDamageEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onAchievement (PlayerAchievementAwardedEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onDrop (PlayerDropItemEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onPickup (PlayerPickupItemEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void entityDamage (EntityDamageEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void entityDamageEntity (EntityDamageByEntityEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onMobSpawn (CreatureSpawnEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onDecay (LeavesDecayEvent e) {
        e.setCancelled(true);
    }
}
