package de.jon4x.bedwars.listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class Protect implements Listener {

    @EventHandler
    public void onWeather (WeatherChangeEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onInteract (PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (e.getAction() == Action.PHYSICAL) {
            if (e.getClickedBlock().getType() == Material.SOIL) {
                if (p != null) {
                    e.setCancelled(true);
                }
            }
        }
    }

}
