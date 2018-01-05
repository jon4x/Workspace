package de.jon4x.bedwars.listener;

import de.jon4x.bedwars.main.Main;
import de.jon4x.bedwars.storage.Data;
import net.claymc.gameapi.api.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;

/**
 * Created by Pascal Falk on 06.08.2017.
 * Plugin by WeLoveSpigotPlugins
 * https://youtube.com/welovespigotplugins
 * Coded with IntelliJ
 */
public class TeamChest implements Listener {


    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getClickedBlock() != null && e.getClickedBlock().getType() == Material.ENDER_CHEST) {
            if (Main.teamchests.containsKey(TeamAuswahl.getRawTeam(p))) {
                ArrayList<Location> list = Main.teamchests.get(TeamAuswahl.getRawTeam(p));
                if (list.contains((Object)e.getClickedBlock().getLocation())) {
                    p.openInventory(Main.teamchestsinventory.get(TeamAuswahl.getRawTeam(p)));
                } else {
                    e.setCancelled(true);
                    p.sendMessage(Data.gc.getPrefix() + "\u00a7cDiese Kiste geh\u00f6rt nicht deinem Team\u00a78.");
                }
            } else {
                e.setCancelled(true);
                p.sendMessage(Data.gc.getPrefix() + "\u00a7cDiese Kiste geh\u00f6rt nicht deinem Team\u00a78.");
            }
        }
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e){
        if(e.getBlock().getType() == Material.ENDER_CHEST){
            e.setCancelled(true);
            e.getBlock().setType(Material.AIR);
            Bukkit.getWorld(e.getBlock().getWorld().getName()).dropItemNaturally(e.getBlock().getLocation(), new ItemManager(Material.ENDER_CHEST).build());
        }
    }
}
