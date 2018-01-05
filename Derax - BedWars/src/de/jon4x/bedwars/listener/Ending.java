package de.jon4x.bedwars.listener;

import de.dytanic.cloudnet.lib.server.ServerState;
import de.jon4x.bedwars.ScoreboardManager;
import de.jon4x.bedwars.manager.GameManager;
import de.jon4x.bedwars.manager.TabListManager;
import de.jon4x.bedwars.storage.Data;
import de.jon4x.coinapi.CoinAPI;
import net.claymc.gameapi.api.ActionbarAPI;
import net.claymc.gameapi.api.GameState;
import net.claymc.gameapi.api.TitleAPI;
import net.claymc.gameapi.main.Main;
import net.spigotplugins.gameapi.manager.StatsAPI;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R3.CraftServer;
import org.bukkit.entity.Player;

import java.util.UUID;

/**
 * Created by Pascal Falk on 04.08.2017.
 * Plugin by WeLoveSpigotPlugins
 * https://youtube.com/welovespigotplugins
 * Coded with IntelliJ
 */

public class Ending {

    static int cd;

    public static void startEnding(){
        Data.ga.gs = GameState.ENDING;
        ((CraftServer)Bukkit.getServer()).getServer().setMotd("ENDING;0;0");

        cd = 10;

        for(Player all : Bukkit.getOnlinePlayers()){
            TabListManager.setTablist(all);
            ScoreboardManager.setScoreboard(all);
            all.teleport(Data.spawn);
            all.setHealth(20);
            all.setFoodLevel(20);
            all.setFlying(false);
            all.setAllowFlight(false);
            all.getInventory().clear();
            all.getInventory().setArmorContents(null);

            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), (Runnable) () -> {
                for(Player other : Bukkit.getOnlinePlayers()){
                    other.showPlayer(all);
                }
            }, 5);

        }

        if(TeamAuswahl.getWinnerTeam() != null){
            for(Player all : TeamAuswahl.getWinnerTeam()){
                new StatsAPI().addInt(all.getUniqueId(), all.getName(), "BEDWARS", "WINS", 1);
                UUID uuid = all.getUniqueId();
                int coins = 50;
                CoinAPI.addCoins(uuid.toString(), coins);
                all.sendMessage(" ");
                all.sendMessage("§6Herzlichen Glückwunsch!");
                all.sendMessage("§a§l+ 50 Coins");
                all.sendMessage(" ");
            }
        }

        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), () -> {
            for(Player all : Bukkit.getOnlinePlayers()) {
                if (cd != 1 && cd != 0) {
                    new ActionbarAPI().sendActionbar(all, Data.gc.getPrefix() + "§7Die Runde restartet in §6" + cd + "§7 Sekunden.");
                }else{
                    new ActionbarAPI().sendActionbar(all, Data.gc.getPrefix() + "§7Die Runde restartet in §6einer§7 Sekunde.");
                }
            }

            if(cd == 5 && cd == 3 && cd == 2 && cd == 1){
                for(Player all : Bukkit.getOnlinePlayers()){
                    all.playSound(all.getLocation(), Sound.NOTE_BASS_GUITAR, 0.25f, 3);
                }
            }
            cd--;
            if(cd == 0){
                for(Player all : Bukkit.getOnlinePlayers()){
                    all.kickPlayer(Data.gc.getPrefix() + "§7Der Server startet nun neu.");
                }
                Bukkit.getServer().shutdown();
            }
        }, 20, 20);
    }

}
