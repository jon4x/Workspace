package de.jon4x.chatsystem.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChat implements Listener {


    @EventHandler
    public void onChat (AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
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
