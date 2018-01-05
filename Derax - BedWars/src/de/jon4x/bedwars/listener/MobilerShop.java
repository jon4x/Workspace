package de.jon4x.bedwars.listener;

import de.jon4x.bedwars.shop.SHOP;
import org.bukkit.Material;
import org.bukkit.Sound;
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
public class MobilerShop implements Listener {
    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && e.getMaterial() == Material.ARMOR_STAND) {
            e.setCancelled(true);
            SHOP.openHauptInv(p);
            p.playSound(p.getLocation(), Sound.LEVEL_UP, (float) 0.5, (float) 0.5);
        }
    }
}
