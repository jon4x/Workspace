package de.jon4x.bedwars.listener;

import de.jon4x.bedwars.ScoreboardManager;
import de.jon4x.bedwars.main.Main;
import de.jon4x.bedwars.manager.GameManager;
import de.jon4x.bedwars.storage.Data;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

/**
 * Created by Pascal Falk on 04.08.2017.
 * Plugin by WeLoveSpigotPlugins
 * https://youtube.com/welovespigotplugins
 * Coded with IntelliJ
 */
public class BedListener implements Listener {

    @EventHandler
    public void onBreak(BlockBreakEvent e){
        if(e.getBlock().getType() == Material.BED_BLOCK){
            e.setCancelled(true);
            e.getBlock().getDrops().clear();
            if(Data.mode.equalsIgnoreCase("8x1") || Data.mode.equalsIgnoreCase("8x2")) {
                if (Data.ca.getBlockLocation("beds", Main.playedMap.toLowerCase() + ".blau.oben").equals(e.getBlock().getLocation()) || Data.ca.getBlockLocation("beds", Main.playedMap.toLowerCase() + ".blau.unten").equals(e.getBlock().getLocation())) {
                    handle(Data.ca.getBlockLocation("beds", Main.playedMap.toLowerCase() + ".blau.oben"), Data.ca.getBlockLocation("beds", Main.playedMap.toLowerCase() + ".blau.unten"), "§bBlau", "blau", e.getPlayer());
                }
                if (Data.ca.getBlockLocation("beds", Main.playedMap.toLowerCase() + ".rot.oben").equals(e.getBlock().getLocation()) || Data.ca.getBlockLocation("beds", Main.playedMap.toLowerCase() + ".rot.unten").equals(e.getBlock().getLocation())) {
                    handle(Data.ca.getBlockLocation("beds", Main.playedMap.toLowerCase() + ".rot.oben"), Data.ca.getBlockLocation("beds", Main.playedMap.toLowerCase() + ".rot.unten"), "§4Rot", "rot", e.getPlayer());
                }
                if (Data.ca.getBlockLocation("beds", Main.playedMap.toLowerCase() + ".gelb.oben").equals(e.getBlock().getLocation()) || Data.ca.getBlockLocation("beds", Main.playedMap.toLowerCase() + ".gelb.unten").equals(e.getBlock().getLocation())) {
                    handle(Data.ca.getBlockLocation("beds", Main.playedMap.toLowerCase() + ".gelb.oben"), Data.ca.getBlockLocation("beds", Main.playedMap.toLowerCase() + ".gelb.unten"), "§eGelb", "gelb", e.getPlayer());
                }
                if (Data.ca.getBlockLocation("beds", Main.playedMap.toLowerCase() + ".gruen.oben").equals(e.getBlock().getLocation()) || Data.ca.getBlockLocation("beds", Main.playedMap.toLowerCase() + ".gruen.unten").equals(e.getBlock().getLocation())) {
                    handle(Data.ca.getBlockLocation("beds", Main.playedMap.toLowerCase() + ".gruen.oben"), Data.ca.getBlockLocation("beds", Main.playedMap.toLowerCase() + ".gruen.unten"), "§aGrün", "gruen", e.getPlayer());
                }
                if (Data.ca.getBlockLocation("beds", Main.playedMap.toLowerCase() + ".orange.oben").equals(e.getBlock().getLocation()) || Data.ca.getBlockLocation("beds", Main.playedMap.toLowerCase() + ".orange.unten").equals(e.getBlock().getLocation())) {
                    handle(Data.ca.getBlockLocation("beds", Main.playedMap.toLowerCase() + ".orange.oben"), Data.ca.getBlockLocation("beds", Main.playedMap.toLowerCase() + ".orange.unten"), "§6Orange", "orange", e.getPlayer());
                }
                if (Data.ca.getBlockLocation("beds", Main.playedMap.toLowerCase() + ".schwarz.oben").equals(e.getBlock().getLocation()) || Data.ca.getBlockLocation("beds", Main.playedMap.toLowerCase() + ".schwarz.unten").equals(e.getBlock().getLocation())) {
                    handle(Data.ca.getBlockLocation("beds", Main.playedMap.toLowerCase() + ".schwarz.oben"), Data.ca.getBlockLocation("beds", Main.playedMap.toLowerCase() + ".schwarz.unten"), "§0Schwarz", "schwarz", e.getPlayer());
                }
                if (Data.ca.getBlockLocation("beds", Main.playedMap.toLowerCase() + ".pink.oben").equals(e.getBlock().getLocation()) || Data.ca.getBlockLocation("beds", Main.playedMap.toLowerCase() + ".pink.unten").equals(e.getBlock().getLocation())) {
                    handle(Data.ca.getBlockLocation("beds", Main.playedMap.toLowerCase() + ".pink.oben"), Data.ca.getBlockLocation("beds", Main.playedMap.toLowerCase() + ".pink.unten"), "§dPink", "pink", e.getPlayer());
                }
                if (Data.ca.getBlockLocation("beds", Main.playedMap.toLowerCase() + ".grau.oben").equals(e.getBlock().getLocation()) || Data.ca.getBlockLocation("beds", Main.playedMap.toLowerCase() + ".grau.unten").equals(e.getBlock().getLocation())) {
                    handle(Data.ca.getBlockLocation("beds", Main.playedMap.toLowerCase() + ".grau.oben"), Data.ca.getBlockLocation("beds", Main.playedMap.toLowerCase() + ".grau.unten"), "§7Grau", "grau", e.getPlayer());
                }
            }
            if(Data.mode.equalsIgnoreCase("4x2") || Data.mode.equalsIgnoreCase("4x3")){
                if (Data.ca.getBlockLocation("beds", Main.playedMap.toLowerCase() + ".blau.oben").equals(e.getBlock().getLocation()) || Data.ca.getBlockLocation("beds", Main.playedMap.toLowerCase() + ".blau.unten").equals(e.getBlock().getLocation())) {
                    handle(Data.ca.getBlockLocation("beds", Main.playedMap.toLowerCase() + ".blau.oben"), Data.ca.getBlockLocation("beds", Main.playedMap.toLowerCase() + ".blau.unten"), "§bBlau", "blau", e.getPlayer());
                }
                if (Data.ca.getBlockLocation("beds", Main.playedMap.toLowerCase() + ".rot.oben").equals(e.getBlock().getLocation()) || Data.ca.getBlockLocation("beds", Main.playedMap.toLowerCase() + ".rot.unten").equals(e.getBlock().getLocation())) {
                    handle(Data.ca.getBlockLocation("beds", Main.playedMap.toLowerCase() + ".rot.oben"), Data.ca.getBlockLocation("beds", Main.playedMap.toLowerCase() + ".rot.unten"), "§4Rot", "rot", e.getPlayer());
                }
                if (Data.ca.getBlockLocation("beds", Main.playedMap.toLowerCase() + ".gelb.oben").equals(e.getBlock().getLocation()) || Data.ca.getBlockLocation("beds", Main.playedMap.toLowerCase() + ".gelb.unten").equals(e.getBlock().getLocation())) {
                    handle(Data.ca.getBlockLocation("beds", Main.playedMap.toLowerCase() + ".gelb.oben"), Data.ca.getBlockLocation("beds", Main.playedMap.toLowerCase() + ".gelb.unten"), "§eGelb", "gelb", e.getPlayer());
                }
                if (Data.ca.getBlockLocation("beds", Main.playedMap.toLowerCase() + ".gruen.oben").equals(e.getBlock().getLocation()) || Data.ca.getBlockLocation("beds", Main.playedMap.toLowerCase() + ".gruen.unten").equals(e.getBlock().getLocation())) {
                    handle(Data.ca.getBlockLocation("beds", Main.playedMap.toLowerCase() + ".gruen.oben"), Data.ca.getBlockLocation("beds", Main.playedMap.toLowerCase() + ".gruen.unten"), "§aGrün", "gruen", e.getPlayer());
                }
            }
            if(Data.mode.equalsIgnoreCase("2x2") || Data.mode.equalsIgnoreCase("2x1")){
                if (Data.ca.getBlockLocation("beds", Main.playedMap.toLowerCase() + ".blau.oben").equals(e.getBlock().getLocation()) || Data.ca.getBlockLocation("beds", Main.playedMap.toLowerCase() + ".blau.unten").equals(e.getBlock().getLocation())) {
                    handle(Data.ca.getBlockLocation("beds", Main.playedMap.toLowerCase() + ".blau.oben"), Data.ca.getBlockLocation("beds", Main.playedMap.toLowerCase() + ".blau.unten"), "§bBlau", "blau", e.getPlayer());
                }
                if (Data.ca.getBlockLocation("beds", Main.playedMap.toLowerCase() + ".rot.oben").equals(e.getBlock().getLocation()) || Data.ca.getBlockLocation("beds", Main.playedMap.toLowerCase() + ".rot.unten").equals(e.getBlock().getLocation())) {
                    handle(Data.ca.getBlockLocation("beds", Main.playedMap.toLowerCase() + ".rot.oben"), Data.ca.getBlockLocation("beds", Main.playedMap.toLowerCase() + ".rot.unten"), "§4Rot", "rot", e.getPlayer());
                }
            }
        }
    }

    private void handle(Location l1, Location l2, String Notteam, String rawTeam, Player p){

        if(!TeamAuswahl.getRawTeam(p).equalsIgnoreCase(rawTeam)){

            l1.getBlock().setType(Material.AIR);
            l2.getBlock().setType(Material.AIR);

            Bukkit.broadcastMessage(Data.gc.getPrefix() + "§7Das Bett von Team " + Notteam + " §7wurde von " + TeamAuswahl.getTeamColor(p) + p.getName() + " §7abgebaut!");
            JoinListener.addBed(p);
            GameManager.availableTeams.put(rawTeam, false);

            for(Player all : Bukkit.getOnlinePlayers()){
                ScoreboardManager.setScoreboard(all);
            }

            for(Entity ent : Bukkit.getWorld(l1.getWorld().getName()).getEntities()) {
                if(ent instanceof Player) {

                } else {
                    if (ent.getLocation().distance(l2) < 3) {
                        if (ent.getType() == EntityType.DROPPED_ITEM) {
                            Item e = (Item) ent;
                            if (e.getItemStack().getType() == Material.BED || e.getItemStack().getType() == Material.BED_BLOCK) {
                                ent.remove();
                            }
                        }
                    }
                }
            }

            for(Player all : Bukkit.getOnlinePlayers()){
                all.playSound(all.getLocation(), Sound.WITHER_DEATH, 1, 1);
            }
            GameManager.availableTeams.put(rawTeam, false);
        }
        else {
            p.getPlayer().sendMessage(Data.gc.getPrefix() + "§7Du darfst dein eigenes §6Bett §7nicht zerstören.");
        }
    }
}
