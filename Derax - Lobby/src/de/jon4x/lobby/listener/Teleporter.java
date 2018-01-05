package de.jon4x.lobby.listener;

import de.jon4x.lobby.Main;
import de.jon4x.lobby.itemmanager.ItemManager;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import static de.jon4x.lobby.methods.Inventories.openCompass;
import static de.jon4x.lobby.methods.Teleport.doTeleport;

public class Teleporter implements Listener {

    @EventHandler
    public void onTeleporter (PlayerInteractEvent e) {
        Player p = e.getPlayer();
        ItemStack i = p.getItemInHand();
        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (ItemManager.get(i, Material.COMPASS, "§8× §6Navigator §7(Rechtsklick)")) {
                openCompass(p);
            }
            else {
                return;
            }
        }
        else {
            return;
        }
    }

    @EventHandler
    public void onNavigatorClick (InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        ItemStack i = e.getCurrentItem();

        if (e.getClickedInventory() != null) {

            if (e.getClickedInventory().getName().equalsIgnoreCase("§8× §6§lNavigator §8»")) {
                if (i != null) {
                    if (i.getType() == Material.AIR)
                        return;

                    else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§b§lSpawn")) {
                        doTeleport(Main.getInstance().getSpawn(), p);
                    }
                    else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§eBedWars")) {
                        doTeleport(Main.getInstance().getBedWars(), p);
                    }
                    else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§eKnockout")) {
                        doTeleport(Main.getInstance().getKnockout(), p);
                    }
                    else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§6Tägliche Belohnung")) {
                        doTeleport(Main.getInstance().getDaily(), p);
                    }
                    else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§6Community")) {
                        doTeleport(Main.getInstance().getCommunity(), p);
                    }
                    else if (i.getType() == Material.BARRIER) {
                        p.playSound(p.getLocation(), Sound.ANVIL_LAND, 0.5f, 1.0f);
                        p.closeInventory();
                    }
                }
            }

        }
    }

}
