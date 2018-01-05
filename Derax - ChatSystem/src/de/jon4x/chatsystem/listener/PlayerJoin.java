package de.jon4x.chatsystem.listener;

import de.jon4x.chatsystem.main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onJoin (PlayerJoinEvent e) {
        Player p = e.getPlayer();
        Bukkit.getScheduler().runTaskLaterAsynchronously(main.getInstance(), () -> setPrefix(p), 10);
    }

    public void setPrefix(Player p) {
        String team = "";

        if (p.hasPermission("admin"))
            team = "000Admin";
        else if (p.hasPermission("manager"))
            team = "001Manager";
        else if (p.hasPermission("dev"))
            team = "002Dev";
        else if (p.hasPermission("mod"))
            team = "003Mod";
        else if (p.hasPermission("sup"))
            team = "004Sup";
        else if (p.hasPermission("builder"))
            team = "005Build";
        else if (p.hasPermission("yt"))
            team = "006YT";
        else if (p.hasPermission("prem+"))
            team = "007Prem+";
        else if (p.hasPermission("prem"))
            team = "008Prem";
        else
            team = "009Spieler";

        main.getInstance().getSb().getTeam(team).addPlayer(p);
        p.setDisplayName(main.getInstance().getSb().getTeam(team).getPrefix() + p.getName());

        for (Player all : Bukkit.getOnlinePlayers()) {
            all.setScoreboard(main.getInstance().getSb());
        }

    }
}
