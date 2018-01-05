package de.jon4x.bedwars.listener;

import de.dytanic.cloudnet.bridge.CloudServer;
import de.dytanic.cloudnet.lib.server.ServerState;
import de.jon4x.bedwars.ScoreboardManager;
import de.jon4x.bedwars.main.Main;
import de.jon4x.bedwars.manager.GameManager;
import de.jon4x.bedwars.manager.Spawner;
import de.jon4x.bedwars.manager.Tab;
import de.jon4x.bedwars.storage.Data;
import net.claymc.gameapi.api.GameState;
import net.claymc.gameapi.events.StartCountdownEndingEvent;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Server;
import org.bukkit.craftbukkit.v1_8_R3.CraftServer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockCanBuildEvent;

/**
 * Created by Pascal Falk on 03.08.2017.
 * Plugin by WeLoveSpigotPlugins
 * https://youtube.com/welovespigotplugins
 * Coded with IntelliJ
 */

public class GameStartEvent implements Listener {

    @EventHandler
    public void onStart(StartCountdownEndingEvent e) {

        if(Voting.withGold.isEmpty() && Voting.withoutGold.isEmpty()) {
            Voting.gold = true;
        }
        else {
            if (Voting.withoutGold.isEmpty() && !Voting.withGold.isEmpty()){
                Voting.gold = true;
            }
            else {
                Voting.gold = false;
            }
            if (Voting.withGold.size() >= Voting.withoutGold.size()){
                Voting.gold = true;
            }
            else {
                Voting.gold = false;
            }
        }

        ((CraftServer) Bukkit.getServer()).getServer().setMotd("INGAME;0;0");

        Bukkit.getScheduler().cancelTask(JoinListener.run);


        Data.ga.gs = GameState.INGAME;
        GameManager.updateGameMode(ServerState.INGAME);

        Bukkit.broadcastMessage(Data.gc.getPrefix() + "§aAlle Spieler werden nun teleportiert!");

        selectTeams();

        for (Player all : Bukkit.getOnlinePlayers()) {
            JoinListener.addPlayed(all);
            all.getInventory().clear();
            all.setGameMode(GameMode.SURVIVAL);
            all.setHealth(20);
            all.setFoodLevel(30);
            all.sendMessage(Data.gc.getPrefix() + "§7Du wurdest dem Team " + TeamAuswahl.getTeam(all) + "§7 zugewiesen!");
        }

        Spawner.startSpawning();

        if (Data.mode.equalsIgnoreCase("8x1") || Data.mode.equalsIgnoreCase("8x2")) {

            if (TeamAuswahl.team_BLAU.isEmpty()) {
                GameManager.availableTeams.put("blau", false);
            } else {
                GameManager.availableTeams.put("blau", true);
            }
            if (TeamAuswahl.team_ROT.isEmpty()) {
                GameManager.availableTeams.put("rot", false);
            } else {
                GameManager.availableTeams.put("rot", true);
            }
            if (TeamAuswahl.team_GELB.isEmpty()) {
                GameManager.availableTeams.put("gelb", false);
            } else {
                GameManager.availableTeams.put("gelb", true);
            }
            if (TeamAuswahl.team_GRÜN.isEmpty()) {
                GameManager.availableTeams.put("gruen", false);
            } else {
                GameManager.availableTeams.put("gruen", true);
            }
            if (TeamAuswahl.team_GRAU.isEmpty()) {
                GameManager.availableTeams.put("grau", false);
            } else {
                GameManager.availableTeams.put("grau", true);
            }
            if (TeamAuswahl.team_ORANGE.isEmpty()) {
                GameManager.availableTeams.put("orange", false);
            } else {
                GameManager.availableTeams.put("orange", true);
            }
            if (TeamAuswahl.team_SCHWARZ.isEmpty()) {
                GameManager.availableTeams.put("schwarz", false);
            } else {
                GameManager.availableTeams.put("schwarz", true);
            }
            if (TeamAuswahl.team_PINK.isEmpty()) {
                GameManager.availableTeams.put("pink", false);
            } else {
                GameManager.availableTeams.put("pink", true);
            }
        }
        if (Data.mode.equalsIgnoreCase("4x2") || Data.mode.equalsIgnoreCase("4x3")) {

            if (TeamAuswahl.team_BLAU.isEmpty()) {
                GameManager.availableTeams.put("blau", false);
            } else {
                GameManager.availableTeams.put("blau", true);
            }
            if (TeamAuswahl.team_ROT.isEmpty()) {
                GameManager.availableTeams.put("rot", false);
            } else {
                GameManager.availableTeams.put("rot", true);
            }
            if (TeamAuswahl.team_GELB.isEmpty()) {
                GameManager.availableTeams.put("gelb", false);
            } else {
                GameManager.availableTeams.put("gelb", true);
            }
            if (TeamAuswahl.team_GRÜN.isEmpty()) {
                GameManager.availableTeams.put("gruen", false);
            } else {
                GameManager.availableTeams.put("gruen", true);
            }
        }
        if (Data.mode.equalsIgnoreCase("2x1") || Data.mode.equalsIgnoreCase("2x2")) {
            if (TeamAuswahl.team_BLAU.isEmpty()) {
                GameManager.availableTeams.put("blau", false);
            } else {
                GameManager.availableTeams.put("blau", true);
            }
            if (TeamAuswahl.team_ROT.isEmpty()) {
                GameManager.availableTeams.put("rot", false);
            } else {
                GameManager.availableTeams.put("rot", true);
            }
        }
        if (Data.mode.equalsIgnoreCase("8x1") || Data.mode.equalsIgnoreCase("8x2")) {
            for (Player all : Bukkit.getOnlinePlayers()) {
                if (TeamAuswahl.team_BLAU.contains(all)) {
                    all.teleport(Data.ca.getLocation("spawns", Main.playedMap.toLowerCase() + "." + "blau"));
                }
                if (TeamAuswahl.team_ROT.contains(all)) {
                    all.teleport(Data.ca.getLocation("spawns", Main.playedMap.toLowerCase() + "." + "rot"));
                }
                if (TeamAuswahl.team_GELB.contains(all)) {
                    all.teleport(Data.ca.getLocation("spawns", Main.playedMap.toLowerCase() + "." + "gelb"));
                }
                if (TeamAuswahl.team_GRÜN.contains(all)) {
                    all.teleport(Data.ca.getLocation("spawns", Main.playedMap.toLowerCase() + "." + "gruen"));
                }
                if (TeamAuswahl.team_GRAU.contains(all)) {
                    all.teleport(Data.ca.getLocation("spawns", Main.playedMap.toLowerCase() + "." + "grau"));
                }
                if (TeamAuswahl.team_ORANGE.contains(all)) {
                    all.teleport(Data.ca.getLocation("spawns", Main.playedMap.toLowerCase() + "." + "orange"));
                }
                if (TeamAuswahl.team_SCHWARZ.contains(all)) {
                    all.teleport(Data.ca.getLocation("spawns", Main.playedMap.toLowerCase() + "." + "schwarz"));
                }
                if (TeamAuswahl.team_PINK.contains(all)) {
                    all.teleport(Data.ca.getLocation("spawns", Main.playedMap.toLowerCase() + "." + "pink"));
                }
            }
        }
        if (Data.mode.equalsIgnoreCase("4x2") || Data.mode.equalsIgnoreCase("4x3")) {
            for (Player all : Bukkit.getOnlinePlayers()) {
                if (TeamAuswahl.team_BLAU.contains(all)) {
                    all.teleport(Data.ca.getLocation("spawns", Main.playedMap.toLowerCase() + "." + "blau"));
                }
                if (TeamAuswahl.team_ROT.contains(all)) {
                    all.teleport(Data.ca.getLocation("spawns", Main.playedMap.toLowerCase() + "." + "rot"));
                }
                if (TeamAuswahl.team_GELB.contains(all)) {
                    all.teleport(Data.ca.getLocation("spawns", Main.playedMap.toLowerCase() + "." + "gelb"));
                }
                if (TeamAuswahl.team_GRÜN.contains(all)) {
                    all.teleport(Data.ca.getLocation("spawns", Main.playedMap.toLowerCase() + "." + "gruen"));
                }
            }
        }
        if (Data.mode.equalsIgnoreCase("2x1") || Data.mode.equalsIgnoreCase("2x2")) {
            for (Player all : Bukkit.getOnlinePlayers()) {
                if (TeamAuswahl.team_BLAU.contains(all)) {
                    all.teleport(Data.ca.getLocation("spawns", Main.playedMap.toLowerCase() + "." + "blau"));
                }
                if (TeamAuswahl.team_ROT.contains(all)) {
                    all.teleport(Data.ca.getLocation("spawns", Main.playedMap.toLowerCase() + "." + "rot"));
                }
            }
        }

        for (Player all : Bukkit.getOnlinePlayers()) {
            ScoreboardManager.setScoreboard(all);
            JoinListener.alive.add(all);
        }

        Tab.loadTablist();

        for (Player all : Bukkit.getOnlinePlayers()) {
            Tab.setPrefix(all);
        }

    }



    private static String getEmptyTeams() {
        if (Data.mode.equalsIgnoreCase("8x1")) {
            if (TeamAuswahl.team_PINK.isEmpty()) {
                return "pink";
            }
            if (TeamAuswahl.team_GRAU.isEmpty()) {
                return "grau";
            }
            if (TeamAuswahl.team_SCHWARZ.isEmpty()) {
                return "schwarz";
            }
            if (TeamAuswahl.team_ORANGE.isEmpty()) {
                return "orange";
            }
            if (TeamAuswahl.team_GRÜN.isEmpty()) {
                return "gruen";
            }
            if (TeamAuswahl.team_BLAU.isEmpty()) {
                return "blau";
            }
            if (TeamAuswahl.team_GELB.isEmpty()) {
                return "gelb";
            }
            if (TeamAuswahl.team_ROT.isEmpty()) {
                return "rot";
            }
        }
        if (Data.mode.equalsIgnoreCase("8x2")) {
            if (TeamAuswahl.team_PINK.isEmpty() || TeamAuswahl.team_PINK.size() < 2) {
                return "pink";
            }
            if (TeamAuswahl.team_GRAU.isEmpty() || TeamAuswahl.team_PINK.size() < 2) {
                return "grau";
            }
            if (TeamAuswahl.team_SCHWARZ.isEmpty() || TeamAuswahl.team_PINK.size() < 2) {
                return "schwarz";
            }
            if (TeamAuswahl.team_ORANGE.isEmpty() || TeamAuswahl.team_PINK.size() < 2) {
                return "orange";
            }
            if (TeamAuswahl.team_GRÜN.isEmpty() || TeamAuswahl.team_PINK.size() < 2) {
                return "gruen";
            }
            if (TeamAuswahl.team_BLAU.isEmpty() || TeamAuswahl.team_PINK.size() < 2) {
                return "blau";
            }
            if (TeamAuswahl.team_GELB.isEmpty() || TeamAuswahl.team_PINK.size() < 2) {
                return "gelb";
            }
            if (TeamAuswahl.team_ROT.isEmpty() || TeamAuswahl.team_PINK.size() < 2) {
                return "rot";
            }
        }
        if (Data.mode.equalsIgnoreCase("4x2")) {

            if (TeamAuswahl.team_GRÜN.isEmpty() || TeamAuswahl.team_PINK.size() < 2) {
                return "gruen";
            }
            if (TeamAuswahl.team_BLAU.isEmpty() || TeamAuswahl.team_PINK.size() < 2) {
                return "blau";
            }
            if (TeamAuswahl.team_GELB.isEmpty() || TeamAuswahl.team_PINK.size() < 2) {
                return "gelb";
            }
            if (TeamAuswahl.team_ROT.isEmpty() || TeamAuswahl.team_PINK.size() < 2) {
                return "rot";
            }
        }
        if (Data.mode.equalsIgnoreCase("4x3")) {
            if (TeamAuswahl.team_GRÜN.isEmpty() || TeamAuswahl.team_PINK.size() < 3) {
                return "gruen";
            }
            if (TeamAuswahl.team_BLAU.isEmpty() || TeamAuswahl.team_PINK.size() < 3) {
                return "blau";
            }
            if (TeamAuswahl.team_GELB.isEmpty() || TeamAuswahl.team_PINK.size() < 3) {
                return "gelb";
            }
            if (TeamAuswahl.team_ROT.isEmpty() || TeamAuswahl.team_PINK.size() < 3) {
                return "rot";
            }
        }
        if (Data.mode.equalsIgnoreCase("2x2")) {

            if (TeamAuswahl.team_ROT.isEmpty() || TeamAuswahl.team_PINK.size() < 2) {
                return "rot";
            }
            if (TeamAuswahl.team_BLAU.isEmpty() || TeamAuswahl.team_PINK.size() < 2) {
                return "blau";
            }
        }
        if (Data.mode.equalsIgnoreCase("2x1")) {

            if (TeamAuswahl.team_ROT.isEmpty()) {
                return "rot";
            }
            if (TeamAuswahl.team_BLAU.isEmpty()) {
                return "blau";
            }
        }
        return null;
    }
    private void selectTeams() {
        if(TeamAuswahl.allInOneTeam()){
            return;
        }else{
            for(Player all : Bukkit.getOnlinePlayers()){
                if(!TeamAuswahl.isInTeam(all)){
                    TeamAuswahl.getFreeTeamForPlayer(all).add(all);
                }
            }
        }
    }
    public static void killEntitysOnWorld(String weltname){
        for(Entity ent : Bukkit.getWorld(weltname).getEntities()) {
            if(ent instanceof Player || ent instanceof Villager) {

            } else {
                ent.remove();
            }
        }
    }

    @EventHandler
    public void onBuild(BlockCanBuildEvent e){
        e.setBuildable(true);
    }
}
