package de.jon4x.bedwars.manager;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;


/**
 * Created by Pascal Falk on 04.08.2017.
 * Plugin by WeLoveSpigotPlugins
 * https://youtube.com/welovespigotplugins
 * Coded with IntelliJ
 */
public class TabListManager {

    public static org.bukkit.scoreboard.Scoreboard board;

    public static Team getTeamNormal(org.bukkit.scoreboard.Scoreboard board, Player p) {

        if (p.hasPermission("admin")) {
            return board.getTeam("a");
        } else if (p.hasPermission("manager")) {
            return board.getTeam("b");
        } else if (p.hasPermission("dev")) {
            return board.getTeam("c");
        } else if (p.hasPermission("mod")) {
            return board.getTeam("d");
        } else if (p.hasPermission("sup")) {
            return board.getTeam("e");
        } else if (p.hasPermission("builder")) {
            return board.getTeam("f");
        } else if (p.hasPermission("yt")) {
            return board.getTeam("g");
        } else if (p.hasPermission("prem+")) {
            return board.getTeam("h");
        } else if (p.hasPermission("prem")) {
            return board.getTeam("i");
        } else {
            return board.getTeam("j");
        }
    }

    public static void setTablist(Player p) {

        board = Bukkit.getScoreboardManager().getNewScoreboard();

        Team Admin = board.registerNewTeam("a");
        Team Manager = board.registerNewTeam("b");
        Team Dev = board.registerNewTeam("c");
        Team Mod = board.registerNewTeam("d");
        Team Sup = board.registerNewTeam("e");
        Team Builder = board.registerNewTeam("f");
        Team YT = board.registerNewTeam("g");
        Team PremP = board.registerNewTeam("h");
        Team Prem = board.registerNewTeam("i");
        Team Spieler = board.registerNewTeam("j");

        Spieler.setPrefix("§7");
        Sup.setPrefix("§9Sup §8× §7");
        Manager.setPrefix("§cManager §8× §7");
        YT.setPrefix("§5");
        Builder.setPrefix("§eBuilder §8× §7");
        Mod.setPrefix("§9Mod §8× §7");
        Dev.setPrefix("§bDev §8× §7");
        Admin.setPrefix("§4Admin §8× §7");
        PremP.setPrefix("§e");
        Prem.setPrefix("§6");


        for (Player all : Bukkit.getOnlinePlayers()) {
            Team playerTeam = TabListManager.getTeamNormal(board, all);
            if (playerTeam.hasEntry(all.getName()))
                continue;
            playerTeam.addEntry(all.getName());
        }

        p.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
        p.setScoreboard(board);

    }

}

