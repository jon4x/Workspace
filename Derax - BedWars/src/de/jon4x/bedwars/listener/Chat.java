package de.jon4x.bedwars.listener;

import de.jon4x.bedwars.storage.Data;
import net.claymc.gameapi.api.GameState;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

/**
 * Created by Pascal Falk on 04.08.2017.
 * Plugin by WeLoveSpigotPlugins
 * https://youtube.com/welovespigotplugins
 * Coded with IntelliJ
 */
public class Chat implements Listener{

    @EventHandler
    public void onIngameChat(AsyncPlayerChatEvent e) {
        if(Data.ga.gs == GameState.INGAME) {
            Player p = e.getPlayer();
            if (DeathListener.spectator.contains(e.getPlayer())) {
                p.sendMessage(Data.gc.getPrefix() + "§cDu kannst als Spectator kein Chat verwenden!");
                e.setCancelled(true);
                return;
            }
            String msg = e.getMessage().replace("%", "%%");
            msg.replaceAll("%", "%%");
            e.setCancelled(true);
            if (Data.ga.gs != GameState.INGAME) return;
            if (msg.toLowerCase().startsWith("@a") || msg.toLowerCase().startsWith("@A")) {
                for (Player a : Bukkit.getOnlinePlayers()) {
                    a.sendMessage("§a§lALLE §8× " + p.getDisplayName() + " §8➟ §7" + msg.replace("@a ", "").replace("@A ", "")
                                                                                            .replace("@a", "").replace("@A", ""));
                }
                return;

            } else {
                for (Player a : TeamAuswahl.getTeamArray(e.getPlayer())) {
                    a.sendMessage("§a§lTEAM §8× §7" + p.getName() + "§8➟ §7" + msg.replace("@a", "").replace("@A", ""));
                }
            }
        }
    }

    @EventHandler
    public void onLobbyChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();

        if (Data.ga.gs == GameState.LOBBY || Data.ga.gs == GameState.ENDING) {
            String msg = e.getMessage().replaceAll("%", "%%");

            if (p.hasPermission("admin"))
                e.setFormat("§4Admin §8× §7" + p.getName() + " §8➟ §7" + e.getMessage());
            else if (p.hasPermission("manager"))
                e.setFormat("§cManager §8× §7" + p.getName() + " §8➟ §7" + e.getMessage());
            else if (p.hasPermission("dev"))
                e.setFormat("§bDeveloper §8× §7" + p.getName() + " §8➟ §7" + e.getMessage());
            else if (p.hasPermission("mod"))
                e.setFormat("§cModerator §8× §7" + p.getName() + " §8➟ §7" + e.getMessage());
            else if (p.hasPermission("sup"))
                e.setFormat("§9Supporter §8× §7" + p.getName() + " §8➟ §7" + e.getMessage());
            else if (p.hasPermission("builder"))
                e.setFormat("§aBuilder §8× §7" + p.getName() + " §8➟ §7" + e.getMessage());
            else if (p.hasPermission("yt"))
                e.setFormat("§5" + p.getName() + " §8➟ §7" + e.getMessage());
            else if (p.hasPermission("prem+"))
                e.setFormat("§e" + p.getName() + " §8➟ §7" + e.getMessage());
            else if (p.hasPermission("prem"))
                e.setFormat("§6" + p.getName() + " §8➟ §7" + e.getMessage());
            else
                e.setFormat("§7" + p.getName() + " §8➟ §7" + e.getMessage());
        }
    }

}
