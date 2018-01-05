package de.jon4x.bedwars.listener;

import de.jon4x.bedwars.storage.Data;
import net.claymc.gameapi.api.GameState;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pascal Falk on 04.08.2017.
 * Plugin by WeLoveSpigotPlugins
 * https://youtube.com/welovespigotplugins
 * Coded with IntelliJ
 */
public class TNT implements Listener {

    public ArrayList<Location> blocks = new ArrayList<Location>();

    @EventHandler
    public void onBreak(BlockPlaceEvent e){
        if(e.getBlock().getType() == Material.TNT){
            e.setCancelled(false);

            e.getBlock().setType(Material.AIR);

            e.getPlayer().getWorld().spawn(e.getBlock().getLocation(), TNTPrimed.class);
        }
    }

    @SuppressWarnings("deprecation")
    @EventHandler
    public void onTNT(EntityExplodeEvent e){
        List<Block> block = e.blockList();

        e.setCancelled(true);

        for(Block b : block){
            if(blocks.contains(b.getLocation())){
                b.getWorld().dropItem(b.getLocation(), new ItemStack(b.getType(),1,(short)b.getData()));
                b.setType(Material.AIR);
            }
        }

    }
    @EventHandler
    public void onBuild(BlockPlaceEvent e){
        if(Data.ga.gs == GameState.INGAME){
            if(e.getBlock().getType() == Material.SANDSTONE || e.getBlock().getType() == Material.ENDER_STONE || e.getBlock().getType() == Material.IRON_BLOCK || e.getBlock().getType() == Material.STAINED_GLASS || e.getBlock().getType() == Material.GLASS || e.getBlock().getType() == Material.GLOWSTONE || e.getBlock().getType() == Material.WEB || e.getBlock().getType() == Material.ENDER_CHEST || e.getBlock().getType() == Material.CHEST){
                blocks.add(e.getBlock().getLocation());
            }
        }
        if(Data.ga.gs == GameState.ENDING){
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void onBuild(BlockBreakEvent e){
        if(Data.ga.gs == GameState.INGAME) {
            if (blocks.contains(e.getBlock().getLocation())) {
                blocks.remove(e.getBlock().getLocation());
            }else {
                if (e.getBlock().getType() != Material.BED_BLOCK) {
                    e.setCancelled(true);
                }
            }
            if(e.getBlock().getType() == Material.WEB){
                e.setCancelled(true);
                e.getBlock().setType(Material.AIR);
            }
        }
        if(Data.ga.gs == GameState.ENDING){
            e.setCancelled(true);
        }

    }

}
