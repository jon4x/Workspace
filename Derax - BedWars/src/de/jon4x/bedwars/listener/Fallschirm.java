package de.jon4x.bedwars.listener;

import net.claymc.gameapi.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

import java.util.HashMap;

/**
 * Created by Pascal Falk on 04.08.2017.
 * Plugin by WeLoveSpigotPlugins
 * https://youtube.com/welovespigotplugins
 * Coded with IntelliJ
 */
public class Fallschirm implements Listener {
    public static HashMap<Player, Integer> scheduler = new HashMap();

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && e.getMaterial() == Material.EGG) {
            final Player p = e.getPlayer();
            e.setCancelled(true);
            de.jon4x.bedwars.main.Main.removeInventoryItems(p.getInventory(), Material.EGG, 1);
            Chicken ch = (Chicken)p.getWorld().spawnEntity(p.getLocation(), EntityType.CHICKEN);
            p.setPassenger(ch);
            scheduler.put(p, Bukkit.getScheduler().scheduleAsyncRepeatingTask(Main.getInstance(), () -> {
                if (p.getPassenger() != null && p.getPassenger().getType() == EntityType.CHICKEN) {
                    p.setVelocity(new Vector(p.getLocation().getDirection().getX() * 0.5, p.getVelocity().getY() * 0.3, p.getLocation().getDirection().getZ() * 0.5));
                    p.setFallDistance(0.0f);
                    if (p.isOnGround()) {
                        p.getPassenger().remove();
                        Bukkit.getScheduler().cancelTask(Fallschirm.scheduler.get((Object)p).intValue());
                    }
                    if (p.getLocation().getY() < 20) {
                        p.getPassenger().remove();
                        Bukkit.getScheduler().cancelTask(Fallschirm.scheduler.get((Object)p).intValue());
                    }
                }
            }, 5, 5));
        }
    }
}
