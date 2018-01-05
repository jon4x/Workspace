package de.jon4x.lobby.listener;

import de.jon4x.lobby.itemmanager.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Gadgets implements Listener {

    Inventory gadgets = Bukkit.createInventory(null, 9*1, "§e§lGadgets §7»");

    @EventHandler
    public void onGadgets (PlayerInteractEvent e) {

        Player p = e.getPlayer();
        ItemStack i = p.getItemInHand();

        if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
            if (ItemManager.get(i, Material.CHEST, "§e§lGadgets §7(Rechtsklick)")) {
                p.playSound(p.getLocation(), Sound.WOOD_CLICK, 0.2f, 0.8f);
                gadgets.setItem(3, ItemManager.createItem(Material.IRON_BOOTS, 1, 0, "§6Schuhe", null));
                gadgets.setItem(5, ItemManager.createItem(Material.STAINED_GLASS, 1, 14, "§6Hats", null));
                p.openInventory(gadgets);
            }
        }
    }
}
