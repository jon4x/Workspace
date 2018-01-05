package de.jon4x.bedwars.listener;

import de.jon4x.bedwars.main.Main;
import de.jon4x.bedwars.manager.GameManager;
import de.jon4x.bedwars.manager.Spawner;
import de.jon4x.bedwars.storage.Data;
import net.claymc.gameapi.api.GameState;
import net.claymc.gameapi.api.ItemManager;
import net.claymc.gameapi.events.StartCountdownEndingEvent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;

/**
 * Created by Pascal Falk on 07.08.2017.
 * Plugin by WeLoveSpigotPlugins
 * https://youtube.com/welovespigotplugins
 * Coded with IntelliJ
 */
public class Voting implements Listener {


    public static boolean gold;
    public static ArrayList<Player> withGold = new ArrayList<>();
    public static ArrayList<Player> withoutGold = new ArrayList<>();

    @EventHandler
    public void onVote(PlayerInteractEvent e){
        Player p = e.getPlayer();
        if(e.getItem() != null){
            if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
                if(Data.ga.gs == GameState.LOBBY){
                    if(e.getItem().getType() == Material.CHEST) {
                        Inventory inv = Bukkit.createInventory(null, InventoryType.HOPPER, "§8× §6§lVoting §8»");
                        inv.setItem(1, new ItemManager(Material.GOLD_INGOT).setDisplayName("§6Gold-Voting").build());
                        inv.setItem(3, new ItemManager(Material.PAPER).setDisplayName("§cMap-Voting").build());
                        p.playSound(p.getLocation(), Sound.CHEST_OPEN, 0.1f,  0.5f);
                        p.openInventory(inv);
                        return;
                    }
                }
            }
        }
    }
    @EventHandler
    public void onClick(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        if (e.getClickedInventory() == null) {
            return;
        }
        if(e.getInventory().getName().equalsIgnoreCase("§8× §6§lVoting §8»")){
            e.setCancelled(true);
            if (e.getCurrentItem() == null) {
                return;
            }
            if (e.getCurrentItem().getType() == Material.AIR) {
                return;
            }
            if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Gold-Voting")) {
                p.getOpenInventory().setItem(0, new ItemManager(Material.GOLD_INGOT).setDisplayName("§a✔ §6Mit Gold spielen").addLoreLine("§8\u27A5 §7" + withGold.size() + " Vote(s)").build());
                p.getOpenInventory().setItem(4, new ItemManager(Material.GOLD_INGOT).setDisplayName("§c✖ §6Ohne Gold spielen").addLoreLine("§8\u27A5 §7" + withoutGold.size() + " Vote(s)").build());
                p.getOpenInventory().setItem(1, new ItemManager(Material.AIR).build());
                p.getOpenInventory().setItem(3, new ItemManager(Material.AIR).build());
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 1, 1);
                return;
            }
            if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a✔ §6Mit Gold spielen")){
                if(withGold.contains(p)){
                    p.sendMessage(Data.gc.getPrefix() + "§7Du hast bereits für dies Option gevoted.");
                    p.closeInventory();
                    return;
                }
                else{
                    if(withoutGold.contains(p)){
                        withoutGold.remove(p);
                    }
                    withGold.add(p);
                    p.closeInventory();
                    p.sendMessage(Data.gc.getPrefix() + "§7Du hast für das Spielen §6mit Gold §7gevoted.");
                    p.playSound(p.getLocation(), Sound.LEVEL_UP, 0.5f, 1);
                    return;
                }
            }
            if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§c✖ §6Ohne Gold spielen")){
                if(withoutGold.contains(p)){
                    p.closeInventory();
                    p.sendMessage(Data.gc.getPrefix() + "§7Du hast bereits für diese Option §7gevoted.");
                    return;
                }
                else{
                    if(withGold.contains(p)){
                        withGold.remove(p);
                        return;
                    }
                    withoutGold.add(p);
                    p.closeInventory();
                    p.sendMessage(Data.gc.getPrefix() + "§7Du hast für das Spielen §cohne Gold §7gevoted.");
                    p.playSound(p.getLocation(), Sound.LEVEL_UP, 0.5f, 1);
                    return;
                }
            }
            if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cMap-Voting")) {
                p.sendMessage(Data.gc.getPrefix() + "§7Das §cMap-Voting §7ist derzeit nicht verfügbar!");
                p.playSound(p.getLocation(), Sound.NOTE_BASS, 1, 1);
                p.closeInventory();
            }
        }
    }

    @EventHandler
    public void onStart(StartCountdownEndingEvent e){
        GameStartEvent.killEntitysOnWorld(Main.playedMap);
    }
}
