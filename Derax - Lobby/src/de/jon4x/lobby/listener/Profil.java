package de.jon4x.lobby.listener;

import de.jon4x.lobby.itemmanager.ItemManager;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import static de.jon4x.lobby.methods.Inventories.openProfil;

public class Profil implements Listener {

    @EventHandler
    public void onOpenProfil (PlayerInteractEvent e) {
        Player p = e.getPlayer();
        ItemStack i = p.getItemInHand();
        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (ItemManager.get(i, Material.SKULL_ITEM, "§8× §eProfil §7(Rechtsklick)")) {
                openProfil(p);
            }
            else {
                return;
            }
        }
        else {
            return;
        }
    }

}
