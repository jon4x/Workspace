package de.jon4x.bungeesystem.listener.bansystem;

import de.jon4x.bungeesystem.Main;
import de.jon4x.bungeesystem.ban.BanManager;
import de.jon4x.bungeesystem.ban.MuteManager;
import de.jon4x.bungeesystem.ban.TeamManager;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.LoginEvent;
import net.md_5.bungee.api.event.ServerConnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

import java.util.UUID;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(LoginEvent e) {
        String ip = e.getConnection().getAddress().getAddress().toString();
        String uuid = e.getConnection().getUniqueId().toString();
        BanManager.updateIP(uuid, ip);
        if (BanManager.isBanned(uuid)) {
            final long currentm = System.currentTimeMillis();
            final long current = currentm / 1000L;
            final long end = BanManager.getEnd(uuid);
            if (end > current || end == -1L) {
                e.setCancelled(true);
                e.setCancelReason(BanManager.getBannedMessage(uuid));
            }
            else {
                e.setCancelled(false);
                BanManager.unban(e.getConnection().getName(), uuid, "CONSOLE");
            }
        }
        else if (BanManager.IPisBanned(ip)) {
            final long currentm = System.currentTimeMillis();
            final long current = currentm / 1000L;
            final long end = BanManager.getEndByIP(uuid);
            if (end > current || end == -1L) {
                e.setCancelled(true);
                e.setCancelReason(BanManager.getBannedMessageByIP(uuid));
                for (ProxiedPlayer all : ProxyServer.getInstance().getPlayers()) {
                    if (all.hasPermission("system.support")) {
                        all.sendMessage(Main.banPrefix() + "§7Der Spieler §e" + BanManager.getNameByIP(ip) + "§7 hat versucht mit einem zweiten Account das Netzwerk zu betreten!");
                    }
                }
            }
            else {
                e.setCancelled(false);
                BanManager.unbanByIP(ip, "CONSOLE");
            }
        }
    }

    @EventHandler
    public void onServerConnect(ServerConnectEvent e) {
        ProxiedPlayer p = e.getPlayer();
        String ip = p.getAddress().getAddress().toString();
        UUID uuid = p.getUniqueId();
        BanManager.createPlayer(uuid.toString(), ip);
        MuteManager.createPlayer(uuid.toString());
    }
}
