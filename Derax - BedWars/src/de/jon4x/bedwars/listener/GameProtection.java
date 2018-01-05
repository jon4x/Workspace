package de.jon4x.bedwars.listener;

import de.jon4x.bedwars.storage.Data;
import net.claymc.gameapi.api.GameState;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockCanBuildEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.*;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.projectiles.ProjectileSource;

/**
 * Created by Pascal Falk on 03.08.2017.
 * Plugin by WeLoveSpigotPlugins
 * https://youtube.com/welovespigotplugins
 * Coded with IntelliJ
 */
public class GameProtection implements Listener {

    @EventHandler
    public void onFood(FoodLevelChangeEvent e){
        if(Data.ga.gs == GameState.LOBBY || Data.ga.gs == GameState.ENDING){
            e.setCancelled(true);
        }else {
            if (DeathListener.spectator.contains(e.getEntity())) {
                e.setCancelled(true);
            } else {
                e.setCancelled(false);
            }
        }
    }
    @EventHandler
    public void onFood(EntityDamageEvent e){

        if(Data.ga.gs == GameState.LOBBY || Data.ga.gs == GameState.ENDING){
            e.setCancelled(true);
        }else {
            if (DeathListener.spectator.contains(e.getEntity())) {
                e.setCancelled(true);
            } else {
                if (e.getEntity() instanceof Villager) {
                    e.setCancelled(true);
                } else {
                    e.setCancelled(false);
                }
            }
        }
    }
    @EventHandler
    public void onSpawn(CreatureSpawnEvent e) {
        if (e.getSpawnReason().equals(CreatureSpawnEvent.SpawnReason.SPAWNER_EGG)) {
            e.setCancelled(false);
        } else {
            if(e.getEntity() instanceof Chicken){
                if(!e.getSpawnReason().equals(CreatureSpawnEvent.SpawnReason.NATURAL)){
                    e.setCancelled(false);
                    return;
                }
            }
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void onPickup(PlayerPickupItemEvent e){
        if(DeathListener.spectator.contains(e.getPlayer())){
            e.setCancelled(true);
        }
    }
    @EventHandler(priority = EventPriority.LOW)
    public void onBlockCanBuildEvent(BlockCanBuildEvent e){
        e.setBuildable(true);
    }

    @EventHandler
    public void onDamage(EntityDamageEvent e){
        if(e.getEntity() instanceof Villager){
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onCraft(CraftItemEvent e){
        e.setCancelled(true);
    }

    @EventHandler
    public void onInt(PlayerInteractEvent e){
        try {
            if (e.getClickedBlock().getType() == Material.BED_BLOCK) {
                if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                    e.setCancelled(true);
                    e.getPlayer().sendMessage(Data.gc.getPrefix() + "§cDu kannst dich nicht in das Bett legen!");
                }
            }
        }catch(Exception e1){

        }
    }
    @EventHandler
    public void onDrop(PlayerDropItemEvent e){
        if(Data.ga.gs == GameState.LOBBY || Data.ga.gs == GameState.ENDING){
            e.setCancelled(true);
        }
        if(Data.ga.gs == GameState.INGAME){
            if(DeathListener.spectator.contains(e.getPlayer())){
                e.setCancelled(true);
            }else{
                e.setCancelled(false);
            }
        }
    }
    @EventHandler
    public void onBuild(BlockPlaceEvent e){
        if(Data.ga.gs == GameState.LOBBY || Data.ga.gs == GameState.ENDING){
            if(e.getPlayer().getGameMode() == GameMode.CREATIVE){
                e.setCancelled(false);
            }else{
                e.setCancelled(true);
            }
        }
    }
    @EventHandler
    public void onClick(InventoryClickEvent e){
        if(Data.ga.gs == GameState.LOBBY || Data.ga.gs == GameState.ENDING){
            Player p = (Player) e.getWhoClicked();
            if(p.getGameMode() == GameMode.CREATIVE){
                e.setCancelled(false);
                return;
            }
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        if (DeathListener.spectator.contains(e.getPlayer())) {
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void entityDamage(EntityDamageByEntityEvent e){
        if(e.getDamager() instanceof Projectile && e.getEntity() instanceof Player){
            ProjectileSource shooter = ((Projectile) e.getDamager()).getShooter();
            if (!(shooter instanceof Player)) {
                return;
            }
            if (TeamAuswahl.getTeamArray((Player) e.getEntity()).contains(shooter)) {
                e.setCancelled(true);
            }
        }
    }
}
