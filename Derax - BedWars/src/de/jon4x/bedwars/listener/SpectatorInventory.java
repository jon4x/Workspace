package de.jon4x.bedwars.listener;

import de.jon4x.bedwars.storage.Data;
import net.claymc.gameapi.api.GameState;
import net.claymc.gameapi.api.ItemManager;
import net.claymc.gameapi.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

/**
 * Created by Pascal Falk on 04.08.2017.
 * Plugin by WeLoveSpigotPlugins
 * https://youtube.com/welovespigotplugins
 * Coded with IntelliJ
 */
public class SpectatorInventory implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        if (DeathListener.spectator.contains(e.getPlayer())) {
            if (Data.ga.gs == GameState.INGAME) {
                if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                    if (e.getItem().getType() == Material.COMPASS) {

                        Inventory inv = Bukkit.createInventory(null, 18, "§8× §6§lTeleporter §8»");
                        e.getPlayer().openInventory(inv);

                        Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                            int i = 0;
                            for (Player all : JoinListener.alive) {
                                inv.setItem(i, new ItemManager(Material.SKULL_ITEM).setSkullOwner(all.getName()).setData((short) 3).setDisplayName("§6" + all.getName()).build());
                                i++;
                            }
                        });

                    }
                }

            }
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (Data.ga.gs == GameState.LOBBY) {
            e.setCancelled(true);
            return;
        }
        Player p = (Player) e.getWhoClicked();
        if (DeathListener.spectator.contains(p)) {
            e.setCancelled(true);
            if (e.getInventory().getName().equalsIgnoreCase("§8× §6§lTeleporter §8»")) {
                Player target = Bukkit.getServer().getPlayerExact(e.getCurrentItem().getItemMeta().getDisplayName().replace("§6", ""));
                if (p != null) {
                    p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 1f);
                    p.teleport(target.getLocation());
                    p.closeInventory();
                }
            }
        }
    }
}
