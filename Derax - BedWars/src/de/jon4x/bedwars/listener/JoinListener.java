package de.jon4x.bedwars.listener;

import de.jon4x.bedwars.ScoreboardManager;
import de.jon4x.bedwars.manager.Tab;
import de.jon4x.bedwars.manager.TabListManager;
import de.jon4x.bedwars.storage.Data;
import net.claymc.gameapi.api.AddonAPI;
import net.claymc.gameapi.api.GameState;
import net.claymc.gameapi.api.ItemManager;
import net.claymc.gameapi.main.Main;
import net.spigotplugins.gameapi.manager.StatsAPI;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.ArrayList;

/**
 * Created by Pascal Falk on 03.08.2017.
 * Plugin by WeLoveSpigotPlugins
 * https://youtube.com/welovespigotplugins
 * Coded with IntelliJ
 */
public class JoinListener implements Listener {

    public static int run;
    public static boolean running;

    public static ArrayList<Player> alive = new ArrayList<>();

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        if(Data.ga.gs == GameState.LOBBY) {
            e.getPlayer().spigot().setCollidesWithEntities(true);
            for (Player all : Bukkit.getOnlinePlayers()) {
                TabListManager.setTablist(all);
            }
        }
        if(Data.ga.gs == GameState.INGAME){
            for(Player all : Bukkit.getOnlinePlayers()){
                Tab.setPrefix(all);
            }
        }

        new StatsAPI().createPlayer(e.getPlayer().getUniqueId(), e.getPlayer().getName(), "BEDWARS", "KILLS");
        new StatsAPI().createPlayer(e.getPlayer().getUniqueId(), e.getPlayer().getName(), "BEDWARS", "DEATHS");
        new StatsAPI().createPlayer(e.getPlayer().getUniqueId(), e.getPlayer().getName(), "BEDWARS", "WINS");
        new StatsAPI().createPlayer(e.getPlayer().getUniqueId(), e.getPlayer().getName(), "BEDWARS", "PLAYED");
        new StatsAPI().createPlayer(e.getPlayer().getUniqueId(), e.getPlayer().getName(), "BEDWARS", "BED");

        e.setJoinMessage(null);

        if (Data.ga.gs == GameState.INGAME) {
            DeathListener.setSpecator(e.getPlayer());
            e.getPlayer().setHealth(20);
            e.getPlayer().setFoodLevel(20);
            e.getPlayer().setAllowFlight(true);
            e.getPlayer().setFlying(true);
            for (Player all : Bukkit.getOnlinePlayers()) {
                if (DeathListener.spectator.contains(all)) {
                    continue;
                } else {
                    e.getPlayer().teleport(all);
                    e.getPlayer().setAllowFlight(true);
                    e.getPlayer().setFlying(true);
                    break;
                }
            }
            e.getPlayer().setAllowFlight(true);
            e.getPlayer().setFlying(true);
        }

        ScoreboardManager.setScoreboard(e.getPlayer());

        e.getPlayer().teleport(Data.spawn);


        e.getPlayer().teleport(Data.spawn);
        e.getPlayer().setGameMode(GameMode.ADVENTURE);

        e.getPlayer().setHealth(20);
        e.getPlayer().setFoodLevel(20);

        if (Data.ga.gs == GameState.LOBBY) {
            e.setJoinMessage(Data.sa.getJoinMessage(e.getPlayer().getName()));

            setJoinItems(e.getPlayer());
            Player p = e.getPlayer();
            p.playSound(p.getLocation(), Sound.LEVEL_UP, 10, 10);
            if (Data.ga.gs == GameState.LOBBY || Data.ga.gs == GameState.ENDING) {

            }
            if (Data.ga.gs == GameState.LOBBY) {
                if (Data.mode.equalsIgnoreCase("8x1")) {
                    if (Bukkit.getOnlinePlayers().size() < 2) {
                        return;
                    }
                }
                if (Data.mode.equalsIgnoreCase("4x2")) {
                    if (Bukkit.getOnlinePlayers().size() < 4) {
                        return;
                    }
                }
                if (Data.mode.equalsIgnoreCase("8x2")) {
                    if (Bukkit.getOnlinePlayers().size() < 4) {
                        return;
                    }
                }
                if (Data.mode.equalsIgnoreCase("4x3")) {
                    if (Bukkit.getOnlinePlayers().size() < 5) {
                        return;
                    }
                }
                if (Data.mode.equalsIgnoreCase("2x2")) {
                    if (Bukkit.getOnlinePlayers().size() < 2) {
                        return;
                    }
                }
                if (Data.mode.equalsIgnoreCase("2x1")) {
                    if (Bukkit.getOnlinePlayers().size() < 2) {
                        return;
                    }
                }
                if (!running) {
                    running = true;
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(30);
                    list.add(20);
                    list.add(10);
                    list.add(5);
                    list.add(4);
                    list.add(3);
                    list.add(2);
                    list.add(1);
                    Data.ga.startCountdown(30, list);
                }
            }

            if (Data.ga.gs == GameState.INGAME) {
                for (Player all : Bukkit.getOnlinePlayers()) {
                    Tab.setPrefix(all);
                }
            }
        }

    }

    private void setJoinItems(Player p){
        p.getInventory().clear();
        p.getInventory().setArmorContents(null);
        new AddonAPI().removePotionEffects(p);
        p.setHealth(20);
        p.setFoodLevel(20);
        p.getInventory().setItem(8, new ItemManager(Material.MAGMA_CREAM).setDisplayName("§8× §cSpiel verlassen §7(Rechtsklick)").build());
        p.getInventory().setItem(4, new ItemManager(Material.CHEST).setDisplayName("§8× §6Voting §7(Rechtsklick)").build());
        p.getInventory().setItem(0, new ItemManager(Material.BED).setDisplayName("§8× §bTeamauswahl §7(Rechtsklick)").build());
    }

    public static void addKill(Player p){
        Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                new StatsAPI().addInt(p.getUniqueId(), p.getName(), "BEDWARS", "KILLS", 1);
            }
        });
    }

    public static void addDeath(Player p){
        Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                new StatsAPI().addInt(p.getUniqueId(), p.getName(), "BEDWARS", "DEATHS", 1);
            }
        });
    }

    public static void addPlayed(Player p){
        Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                new StatsAPI().addInt(p.getUniqueId(), p.getName(), "BEDWARS", "PLAYED", 1);
            }
        });
    }

    public static void addWin(Player p){
        Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                new StatsAPI().addInt(p.getUniqueId(), p.getName(), "BEDWARS", "WINS", 1);
            }
        });
    }

    public static void addBed(Player p){
        Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                new StatsAPI().addInt(p.getUniqueId(), p.getName(), "BEDWARS", "BED", 1);
            }
        });
    }

}
