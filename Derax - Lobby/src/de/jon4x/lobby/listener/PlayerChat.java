package de.jon4x.lobby.listener;

import de.jon4x.lobby.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChat implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        if (Main.getInstance().getChatDisabled().contains(p.getUniqueId())) {
            e.setCancelled(true);
            e.getRecipients().remove(p);
            p.sendMessage(Main.getPrefix() + "§cDein Chat ist deaktiviert!");
        }
        for(Player all : e.getRecipients()) {
            if (Main.getInstance().getChatDisabled().contains(all.getUniqueId()))
                e.getRecipients().remove(all);
        }
    }

}
