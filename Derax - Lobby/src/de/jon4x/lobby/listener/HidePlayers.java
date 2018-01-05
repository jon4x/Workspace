package de.jon4x.lobby.listener;

import de.jon4x.lobby.Main;
import de.jon4x.lobby.itemmanager.ItemManager;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.HashMap;
import java.util.UUID;

public class HidePlayers implements Listener {

    private HashMap <UUID, Long> cooldown = new HashMap<>();

    @EventHandler
    public void onHidePlayers (PlayerInteractEvent e) {

        int cooldownTime = 2;
        Player p = e.getPlayer();
        ItemStack i = p.getItemInHand();

        if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
            if (ItemManager.get(i, Material.INK_SACK, "§8× §cSpieler §8» §aAlle sichtbar §7(Rechtsklick)")) {
                if (cooldown.containsKey(p.getUniqueId())) {
                    long secondsLeft = ((cooldown.get(p.getUniqueId())/1000)+cooldownTime) - (System.currentTimeMillis()/1000);
                    if (secondsLeft > 0) {
                        p.sendMessage(Main.getPrefix() + "§cBitte habe einen moment Geduld!");
                        return;
                    }
                }
                cooldown.put(p.getUniqueId(), System.currentTimeMillis());

                Main.getInstance().getHideAll().remove(p.getUniqueId());
                Main.getInstance().getHideVIP().add(p.getUniqueId());
                p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 0.5f, 1.5f);
                p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 18, 10));
                p.getInventory().setItem(1, ItemManager.createItem(Material.INK_SACK, 1, 13, "§8× §cSpieler §8» §5VIP's sichtbar §7(Rechtsklick)", null));
                p.sendMessage(Main.getPrefix() + "§7Du siehst nun nurnoch §5VIP §7Spieler!");
                for (Player all : Main.getInstance().getServer().getOnlinePlayers()) {
                    p.hidePlayer(all);
                    if (all.hasPermission("vip")) {
                        p.showPlayer(all);
                    }
                }
            }
            else if (ItemManager.get(i, Material.INK_SACK, "§8× §cSpieler §8» §5VIP's sichtbar §7(Rechtsklick)")) {
                if (cooldown.containsKey(p.getUniqueId())) {
                    long secondsLeft = ((cooldown.get(p.getUniqueId())/1000)+cooldownTime) - (System.currentTimeMillis()/1000);
                    if (secondsLeft > 0) {
                        p.sendMessage(Main.getPrefix() + "§cBitte habe einen moment Geduld!");
                        return;
                    }
                }
                cooldown.put(p.getUniqueId(), System.currentTimeMillis());

                Main.getInstance().getHideVIP().remove(p.getUniqueId());
                Main.getInstance().getHideAll().add(p.getUniqueId());
                p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 0.5f, 1.5f);
                p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 18, 10));
                p.getInventory().setItem(1, ItemManager.createItem(Material.INK_SACK, 1, 1, "§8× §cSpieler §8» §cKeine sichtbar §7(Rechtsklick)", null));
                p.sendMessage(Main.getPrefix() + "§7Du siehst nun §ckeine §7Spieler mehr!");
                for (Player all : Main.getInstance().getServer().getOnlinePlayers()) {
                    p.hidePlayer(all);
                }
            }

            else if (ItemManager.get(i, Material.INK_SACK, "§8× §cSpieler §8» §cKeine sichtbar §7(Rechtsklick)")) {
                if (cooldown.containsKey(p.getUniqueId())) {
                    long secondsLeft = ((cooldown.get(p.getUniqueId())/1000)+cooldownTime) - (System.currentTimeMillis()/1000);
                    if (secondsLeft > 0) {
                        p.sendMessage(Main.getPrefix() + "§cBitte habe einen moment Geduld!");
                        return;
                    }
                }
                cooldown.put(p.getUniqueId(), System.currentTimeMillis());

                Main.getInstance().getHideVIP().remove(p.getUniqueId());
                Main.getInstance().getHideAll().remove(p.getUniqueId());
                p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 0.5f, 1.5f);
                p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 18, 10));
                p.getInventory().setItem(1, ItemManager.createItem(Material.INK_SACK, 1, 10, "§8× §cSpieler §8» §aAlle sichtbar §7(Rechtsklick)", null));
                p.sendMessage(Main.getPrefix() + "§7Du siehst nun wieder §aalle §7Spieler!");
                for (Player all : Main.getInstance().getServer().getOnlinePlayers()) {
                    p.showPlayer(all);
                }
            }
        }
    }
}
