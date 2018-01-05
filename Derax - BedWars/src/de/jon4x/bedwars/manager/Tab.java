package de.jon4x.bedwars.manager;

import de.jon4x.bedwars.listener.TeamAuswahl;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;

/**
 * Created by Pascal Falk on 04.08.2017.
 * Plugin by WeLoveSpigotPlugins
 * https://youtube.com/welovespigotplugins
 * Coded with IntelliJ
 */
public class Tab {
    static Scoreboard scoreboard;

    public static void loadTablist(){
        scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();

        scoreboard.registerNewTeam("a").setPrefix("§d");
        scoreboard.registerNewTeam("b").setPrefix("§9");
        scoreboard.registerNewTeam("c").setPrefix("§4");
        scoreboard.registerNewTeam("d").setPrefix("§e");
        scoreboard.registerNewTeam("e").setPrefix("§a");
        scoreboard.registerNewTeam("f").setPrefix("§0");
        scoreboard.registerNewTeam("g").setPrefix("§7");
        scoreboard.registerNewTeam("h").setPrefix("§6");
        scoreboard.registerNewTeam("o").setPrefix("§7§o");


    }
    public static synchronized void setPrefix(Player p) {

        String team = "";
        if (TeamAuswahl.team_PINK.contains(p)) {
            team = "a";
        } else if (TeamAuswahl.team_BLAU.contains(p)) {
            team = "b";
        } else if (TeamAuswahl.team_ROT.contains(p)) {
            team = "c";
        } else if (TeamAuswahl.team_GELB.contains(p)) {
            team = "d";
        } else if (TeamAuswahl.team_GRÜN.contains(p)) {
            team = "e";
        } else if (TeamAuswahl.team_SCHWARZ.contains(p)) {
            team = "f";
        } else if (TeamAuswahl.team_GRAU.contains(p)) {
            team = "g";
        } else if(TeamAuswahl.team_ORANGE.contains(p)){
            team = "h";
        } else {
            team = "o";
        }

        scoreboard.getTeam(team).addPlayer(p);
        p.setDisplayName(scoreboard.getTeam(team).getPrefix() + p.getName());

        for(Player a : Bukkit.getOnlinePlayers()) {
            a.setScoreboard(scoreboard);
        }
    }
}
