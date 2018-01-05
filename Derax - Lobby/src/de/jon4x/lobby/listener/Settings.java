package de.jon4x.lobby.listener;

import de.jon4x.lobby.Main;
import de.jon4x.lobby.api.LobbySQL;
import de.jon4x.lobby.itemmanager.ItemManager;
import de.jon4x.lobby.methods.Inventories;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.UUID;


public class Settings implements Listener {

    private HashMap<UUID, Long> cooldown = new HashMap<>();

    @EventHandler
    public void onSettings (PlayerInteractEvent e) {
        Player p = e.getPlayer();
        ItemStack i = p.getItemInHand();
        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (ItemManager.get(i, Material.REDSTONE_COMPARATOR, "§8× §aEinstellungen §7(Rechtsklick)")) {
                Inventories.openSettings(p);
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
    public void clickInSetting (InventoryClickEvent e) {
        int cooldownTime = 2;
        Player p = (Player) e.getWhoClicked();
        ItemStack i = e.getCurrentItem();
        if (e.getClickedInventory() != null) {
            if (e.getClickedInventory().getName().equalsIgnoreCase("§8× §a§lEinstellungen §8»")) {
                if (i != null) {
                    if (i.getType() == Material.AIR)
                        return;
                    if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§eDoubleJump")) {
                        if (cooldown.containsKey(p.getUniqueId())) {
                            long secondsLeft = ((cooldown.get(p.getUniqueId())/1000)+cooldownTime) - (System.currentTimeMillis()/1000);
                            if (secondsLeft > 0) {
                                p.sendMessage(Main.getPrefix() + "§cBitte habe einen moment Geduld!");
                                return;
                            }
                        }
                        cooldown.put(p.getUniqueId(), System.currentTimeMillis());
                        if (LobbySQL.getDoubleJump(p.getUniqueId().toString()) == 0) {
                            p.getOpenInventory().setItem(22, ItemManager.createItem(Material.INK_SACK, 1, 1, "§c\u2718 §8\u00d7 §cDeaktiviert", null));
                            p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 0.5f, 2.0f);
                            LobbySQL.setDoubleJump(p.getUniqueId().toString(), 1);
                        }
                        else {
                            p.getOpenInventory().setItem(22, ItemManager.createItem(Material.INK_SACK, 1, 10, "§a\u2714 §8\u00d7 §aAktiviert", null));
                            p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 0.5f, 2.0f);
                            LobbySQL.setDoubleJump(p.getUniqueId().toString(), 0);
                        }
                    }
                    else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§7JumpPads")) {
                        if (cooldown.containsKey(p.getUniqueId())) {
                            long secondsLeft = ((cooldown.get(p.getUniqueId())/1000)+cooldownTime) - (System.currentTimeMillis()/1000);
                            if (secondsLeft > 0) {
                                p.sendMessage(Main.getPrefix() + "§cBitte habe einen moment Geduld!");
                                return;
                            }
                        }
                        cooldown.put(p.getUniqueId(), System.currentTimeMillis());
                        if (LobbySQL.getJumpPad(p.getUniqueId().toString()) == 0) {
                            p.getOpenInventory().setItem(24, ItemManager.createItem(Material.INK_SACK, 1, 1, "§c\u2718 §8\u00d7 §cDeaktiviert", null));
                            p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 0.5f, 2.0f);
                            LobbySQL.setJumpPad(p.getUniqueId().toString(), 1);
                        }
                        else {
                            p.getOpenInventory().setItem(24, ItemManager.createItem(Material.INK_SACK, 1, 10, "§a\u2714 §8\u00d7 §aAktiviert", null));
                            p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 0.5f, 2.0f);
                            LobbySQL.setJumpPad(p.getUniqueId().toString(), 0);
                        }
                    }
                    else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§9Chat")) {
                        if (cooldown.containsKey(p.getUniqueId())) {
                            long secondsLeft = ((cooldown.get(p.getUniqueId())/1000)+cooldownTime) - (System.currentTimeMillis()/1000);
                            if (secondsLeft > 0) {
                                p.sendMessage(Main.getPrefix() + "§cBitte habe einen moment Geduld!");
                                return;
                            }
                        }
                        cooldown.put(p.getUniqueId(), System.currentTimeMillis());
                        if (!Main.getInstance().getChatDisabled().contains(p.getUniqueId())) {
                            p.getOpenInventory().setItem(2 + 9 * 2, ItemManager.createItem(Material.INK_SACK, 1, 1, "§c✘ §8× §cDeaktiviert", null));
                            p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 0.5f, 2.0f);
                            Main.getInstance().getChatDisabled().add(p.getUniqueId());
                        }
                        else  {
                            p.getOpenInventory().setItem(2 + 9 * 2, ItemManager.createItem(Material.INK_SACK, 1, 10, "§a✔ §8× §aAktiviert", null));
                            p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 0.5f, 2.0f);
                            Main.getInstance().getChatDisabled().remove(p.getUniqueId());
                        }
                    }
                }
            }

        }
    }
}
