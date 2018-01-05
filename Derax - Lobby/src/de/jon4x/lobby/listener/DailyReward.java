package de.jon4x.lobby.listener;

import de.jon4x.coinapi.CoinAPI;
import de.jon4x.lobby.Main;
import de.jon4x.lobby.api.LobbySQL;
import de.jon4x.lobby.methods.Inventories;
import de.jon4x.lobby.methods.Scoreboard;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;

public class DailyReward implements Listener {

    @EventHandler
    public void onVillagerClick (PlayerInteractEntityEvent e) {
        if (e.getRightClicked().getType() == EntityType.VILLAGER) {
            Player p = e.getPlayer();
            p.closeInventory();
            e.setCancelled(true);
            Inventories.openReward(p);
        }
    }

    @EventHandler
    public void onClick(final InventoryClickEvent e) {
        Player p = (Player)e.getWhoClicked();
        ItemStack i = e.getCurrentItem();
        try {
            if (e.getClickedInventory() != null) {
                if (e.getClickedInventory().getName() == "§8× §6§lTägliche Belohnung §8»") {
                    if (i != null) {
                        if (i.getType() == Material.AIR)
                            return;
                        if (e.getCurrentItem().getItemMeta().getDisplayName() == "§8» §7Tägliche Belohnung") {
                            if (LobbySQL.getLastNormal(p.getUniqueId().toString()) < 1) {
                                LobbySQL.setLastNormal(p.getUniqueId().toString(), 2);
                                CoinAPI.addCoins(p.getUniqueId().toString(), 100);
                                p.playSound(p.getLocation(), Sound.NOTE_PLING, 0.5f, 1.0f);
                                Scoreboard.setScoreboard(p);
                                p.closeInventory();
                                p.sendMessage("");
                                p.sendMessage(Main.getPrefix() + "§7Du hast deine §7Tägliche Belohnung §7abgeholt!");
                                p.sendMessage(Main.getPrefix() + "§a§l+ 100 Coins");
                                p.sendMessage("");
                            } else {
                                p.sendMessage(Main.getPrefix() + "§cDeine nächste Belohnung ist ab §c§l24:00 Uhr §cverfügbar!");
                                p.playSound(p.getLocation(), Sound.ANVIL_LAND, 0.2f, 1.2f);
                                p.closeInventory();
                            }
                        }
                        if (e.getCurrentItem().getItemMeta().getDisplayName() == "§8» §6Tägliche Premium-Belohnung") {
                            if (p.hasPermission("premium")) {
                                if (LobbySQL.getLastPremium(p.getUniqueId().toString()) < 1) {
                                    LobbySQL.setLastPremium(p.getUniqueId().toString(), 2);
                                    CoinAPI.addCoins(p.getUniqueId().toString(), 200);
                                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 0.5f, 1.0f);
                                    Scoreboard.setScoreboard(p);
                                    p.closeInventory();
                                    p.sendMessage("");
                                    p.sendMessage(Main.getPrefix() + "§7Du hast deine §6Tägliche Premium-Belohnung §7abgeholt!");
                                    p.sendMessage(Main.getPrefix() + "§a§l+ 200 Coins");
                                    p.sendMessage("");
                                } else {
                                    p.sendMessage(Main.getPrefix() + "§cDeine nächste Belohnung ist ab §c§l24:00 Uhr §cverfügbar!");
                                    p.playSound(p.getLocation(), Sound.ANVIL_LAND, 0.2f, 1.2f);
                                    p.closeInventory();
                                }
                            } else {
                                p.sendMessage(Main.getPrefix() + "§cHierfür benötigst du den §6Premium-Rang");
                                p.playSound(p.getLocation(), Sound.ANVIL_LAND, 0.2f, 1.2f);
                                p.closeInventory();
                            }
                        }
                    }
                }
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
