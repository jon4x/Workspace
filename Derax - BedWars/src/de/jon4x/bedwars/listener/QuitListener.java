package de.jon4x.bedwars.listener;

import de.jon4x.bedwars.ScoreboardManager;
import de.jon4x.bedwars.commands.Start;
import de.jon4x.bedwars.manager.GameManager;
import de.jon4x.bedwars.storage.Data;
import net.claymc.gameapi.api.GameAPI;
import net.claymc.gameapi.api.GameState;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * Created by Pascal Falk on 03.08.2017.
 * Plugin by WeLoveSpigotPlugins
 * https://youtube.com/welovespigotplugins
 * Coded with IntelliJ
 */
public class QuitListener implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent e){

        e.setQuitMessage(null);
        Player p = e.getPlayer();

        if(Data.ga.gs == GameState.INGAME){

            if(DeathListener.spectator.contains(e.getPlayer())){
                return;
            }

            if (!DeathListener.spectator.contains(e.getPlayer())){
                JoinListener.addDeath(p);
            }

            if (TeamAuswahl.getTeamArray(p).size() == 1 || TeamAuswahl.getTeamArray(p).isEmpty()) {

                for (Player all : Bukkit.getOnlinePlayers()) {
                    all.sendMessage(Data.gc.getPrefix() + "§7Das Team " + TeamAuswahl.getTeam(p) + "§7 ist ausgeschieden!");
                }

                TeamAuswahl.getTeamArray(p).clear();
                GameManager.availableTeams.put(TeamAuswahl.getRawTeam(p), false);

                for (Player all : Bukkit.getOnlinePlayers()) {
                    ScoreboardManager.setScoreboard(all);
                }

            } else
                TeamAuswahl.getTeamArray(p).remove(p);

            if (TeamAuswahl.oneTeamLeft()) {
                Ending.startEnding();
                Bukkit.getScheduler().scheduleAsyncDelayedTask(net.claymc.gameapi.main.Main.getInstance(), new Runnable() {
                    @Override
                    public void run() {
                        Bukkit.broadcastMessage(Data.gc.getPrefix() + "§7Das Spiel ist nun vorbei!");
                    }
                },4);
                new GameAPI().stopStartingCD();
            }
        }

        removeFromTeam(e.getPlayer());

        if(Data.ga.gs == GameState.LOBBY) {
            if(Voting.withoutGold.contains(e.getPlayer())){
                Voting.withoutGold.remove(e.getPlayer());
            }
            if(Voting.withGold.contains(e.getPlayer())){
                Voting.withGold.remove(e.getPlayer());
            }

            if (Data.mode.equalsIgnoreCase("8x1")) {
                if (Bukkit.getOnlinePlayers().size() == 2) {
                    Data.ga.stopStartingCD();
                    Start.started = false;
                    JoinListener.running = false;
                }
            }
            if (Data.mode.equalsIgnoreCase("2x1") || Data.mode.equalsIgnoreCase("2x2")) {
                if (Bukkit.getOnlinePlayers().size() == 2) {
                    Data.ga.stopStartingCD();
                    Start.started = false;
                    JoinListener.running = false;
                }
            }
            else {
                if (Bukkit.getOnlinePlayers().size() == 4) {
                    Data.ga.stopStartingCD();
                    JoinListener.running = false;
                    Start.started = false;
                }
            }
        }
    }

    private void removeFromTeam(Player p) {
        TeamAuswahl.team_GRAU.remove(p);
        TeamAuswahl.team_PINK.remove(p);
        TeamAuswahl.team_SCHWARZ.remove(p);
        TeamAuswahl.team_ORANGE.remove(p);
        TeamAuswahl.team_GRÜN.remove(p);
        TeamAuswahl.team_GELB.remove(p);
        TeamAuswahl.team_ROT.remove(p);
        TeamAuswahl.team_BLAU.remove(p);
    }
}
