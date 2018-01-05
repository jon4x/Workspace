package de.jon4x.bungeesystem.commands.bansystem;

import de.jon4x.bungeesystem.Main;
import de.jon4x.bungeesystem.ban.BanManager;
import de.jon4x.bungeesystem.ban.MuteManager;
import de.jon4x.bungeesystem.utils.UUIDFetcher;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class CheckCommand extends Command {

    public CheckCommand() {
        super("check", "system.check");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (sender.hasPermission("system.check")) {
            if (args.length < 1) {
                sender.sendMessage(Main.banPrefix() + "§7Bitte nutze §c/check <name>");
                return;
            }
            ProxiedPlayer target = ProxyServer.getInstance().getPlayer(args[0]);

            String uuid;
            if (target == null)
                uuid = UUIDFetcher.getUUID(args[0]).toString();
            else
                uuid = target.getUniqueId().toString();

            sender.sendMessage(" ");
            sender.sendMessage("§7Spieler §8\u00bb §e" + args[0]);
            sender.sendMessage("");
            sender.sendMessage("§c§lBan Status §8\u00bb");
            if (BanManager.isBanned(uuid)) {
                sender.sendMessage("§8➥ §cGebannt");
                sender.sendMessage("§8➥ §e" + BanManager.getReason(uuid));
                sender.sendMessage("§8➥ §c" + BanManager.getRemainingTime(uuid));
                sender.sendMessage("§8➥ §e" + BanManager.getWhoBanned(uuid));
            }
            else
                sender.sendMessage("§8➥ §7Nicht Gebannt!");

            sender.sendMessage("");
            sender.sendMessage("§c§lMute Status §8\u00bb");
            if (MuteManager.isMuted(uuid)) {
                sender.sendMessage("§8➥ §cGemutet");
                sender.sendMessage("§8➥ §e" + MuteManager.getReason(uuid));
                sender.sendMessage("§8➥ §c" + MuteManager.getRemainingTime(uuid));
                sender.sendMessage("§8➥ §e" + MuteManager.getWhoMuted(uuid));
            }
            else
                sender.sendMessage("§8➥ §7Nicht Gemutet!");

            sender.sendMessage(" ");
        }
    }
}
