package de.jon4x.bedwars.listener;

import de.jon4x.bedwars.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * Created by Pascal Falk on 04.08.2017.
 * Plugin by WeLoveSpigotPlugins
 * https://youtube.com/welovespigotplugins
 * Coded with IntelliJ
 */
public class Rettungsplattform implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && e.getMaterial() == Material.BLAZE_ROD) {
            e.setCancelled(true);
            Main.removeInventoryItems(p.getInventory(), Material.BLAZE_ROD, 1);
            final Location loc = p.getLocation().subtract(0.0, 1.0, 0.0);
            final Location loc2 = p.getLocation().subtract(0.0, 1.0, 1.0);
            final Location loc3 = p.getLocation().subtract(1.0, 1.0, 0.0);
            final Location loc4 = p.getLocation().subtract(0.0, 1.0, 0.0).add(0.0, 0.0, 1.0);
            final Location loc5 = p.getLocation().subtract(0.0, 1.0, 0.0).add(1.0, 0.0, 0.0);
            if (p.getLocation().subtract(0.0, 3.0, 1.0).getBlock().getType() == Material.AIR) {
                p.getLocation().subtract(0.0, 3.0, 1.0).getBlock().setType(Material.SLIME_BLOCK);
            }
            if (p.getLocation().subtract(1.0, 3.0, 0.0).getBlock().getType() == Material.AIR) {
                p.getLocation().subtract(1.0, 3.0, 0.0).getBlock().setType(Material.SLIME_BLOCK);
            }
            if (p.getLocation().subtract(0.0, 3.0, 0.0).add(1.0, 0.0, 0.0).getBlock().getType() == Material.AIR) {
                p.getLocation().subtract(0.0, 3.0, 0.0).add(1.0, 0.0, 0.0).getBlock().setType(Material.SLIME_BLOCK);
            }
            if (p.getLocation().subtract(0.0, 3.0, 0.0).add(0.0, 0.0, 1.0).getBlock().getType() == Material.AIR) {
                p.getLocation().subtract(0.0, 3.0, 0.0).add(0.0, 0.0, 1.0).getBlock().setType(Material.SLIME_BLOCK);
            }
            if (p.getLocation().subtract(0.0, 3.0, 0.0).getBlock().getType() == Material.AIR) {
                p.getLocation().subtract(0.0, 3.0, 0.0).getBlock().setType(Material.SLIME_BLOCK);
            }
            Bukkit.getScheduler().scheduleSyncDelayedTask(net.claymc.gameapi.main.Main.getInstance(), () -> {
                if (loc.getBlock().getType() == Material.SLIME_BLOCK) {
                    loc.getBlock().setType(Material.AIR);
                }
                if (loc2.getBlock().getType() == Material.SLIME_BLOCK) {
                    loc2.getBlock().setType(Material.AIR);
                }
                if (loc3.getBlock().getType() == Material.SLIME_BLOCK) {
                    loc3.getBlock().setType(Material.AIR);
                }
                if (loc4.getBlock().getType() == Material.SLIME_BLOCK) {
                    loc4.getBlock().setType(Material.AIR);
                }
                if (loc5.getBlock().getType() == Material.SLIME_BLOCK) {
                    loc5.getBlock().setType(Material.AIR);
                }
            }, 100);
        }
    }

}
