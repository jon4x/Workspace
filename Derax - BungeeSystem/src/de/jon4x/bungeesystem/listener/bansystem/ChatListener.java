package de.jon4x.bungeesystem.listener.bansystem;

import de.jon4x.bungeesystem.ban.MuteManager;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class ChatListener implements Listener {

    @EventHandler
    public void onChat(ChatEvent e) {
        ProxiedPlayer p = (ProxiedPlayer) e.getSender();
        String uuid = p.getUniqueId().toString();
        if (MuteManager.isMuted(uuid)) {
            final long currentm = System.currentTimeMillis();
            final long current = currentm / 1000L;
            final long end = MuteManager.getEnd(p.getName());
            if (end > current || end != -1L) {
                MuteManager.unmute(p.getName(), p.getUniqueId().toString(), "CONSOLE");
                e.setCancelled(false);
            } else if (!e.getMessage().startsWith("/")) {
                e.setCancelled(true);
                p.sendMessage("§r");
                p.sendMessage("§7§m-----------§r§c System §8\u00bb §eMute §7§m-----------");
                p.sendMessage("§cDu wurdest aus dem Chat gebannt!");
                p.sendMessage("§r");
                p.sendMessage("§7Grund §8\u00bb §e" + MuteManager.getReason(uuid));
                p.sendMessage("§7Gemutet bis §8\u00bb §e" + MuteManager.getRemainingTime(uuid));
                p.sendMessage("§r");
                p.sendMessage("§7Gemutet von §c" + MuteManager.getWhoMuted(uuid));
                p.sendMessage("§7§m-----------§r§c System §8\u00bb §eMute §7§m-----------");
                p.sendMessage("§r");
            }
        }
    }
}
