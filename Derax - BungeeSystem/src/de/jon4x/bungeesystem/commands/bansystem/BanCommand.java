package de.jon4x.bungeesystem.commands.bansystem;

import de.jon4x.bungeesystem.Main;
import de.jon4x.bungeesystem.ban.BanManager;
import de.jon4x.bungeesystem.ban.TeamManager;
import de.jon4x.bungeesystem.utils.UUIDFetcher;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class BanCommand extends Command {

    public BanCommand() {
        super("ban", "system.ban");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (sender.hasPermission("system.ban")) {
            if (args.length < 2) {
                sender.sendMessage(Main.banPrefix() + "§7Bitte benutze §c/ban §c<player> §c<reason>");
                return;
            }

            if (TeamManager.isInTeam(UUIDFetcher.getUUID(args[0]).toString())) {
                sender.sendMessage(Main.banPrefix() + "§7Du kannst diesen Spieler nicht bannen!");
                sender.sendMessage(Main.banPrefix() + "§e" + args[0] + " §7ist ein Teammitglied!");
                return;
            }

            if (BanManager.isBanned(UUIDFetcher.getUUID(args[0]).toString())) {
                sender.sendMessage(Main.banPrefix() + "§7Der §7Spieler §e" + args[0] + " §7wurde §7bereits gebannt!");
                return;
            }

            String message = "";
            for (int i = 1; i < args.length; ++i) {
                message = String.valueOf(message) + args[i] + " ";
            }

            ProxiedPlayer target = ProxyServer.getInstance().getPlayer(args[0]);
            if (target == null) {
                BanManager.createPlayer(UUIDFetcher.getUUID(args[0]).toString(), null);
                sender.sendMessage(Main.banPrefix() + "§7Du §7hast §e" + args[0] + " §cpermanent §7gebannt!");
                BanManager.ban(args[0], UUIDFetcher.getUUID(args[0]).toString(), message, sender.getName(), -1, null);
            }
            else {
                sender.sendMessage(Main.banPrefix() + "§7Du §7hast §e" + args[0] + " §cpermanent §7gebannt!");
                BanManager.ban(args[0], target.getUniqueId().toString(), message, sender.getName(), -1, target.getAddress().getAddress().toString());
                target.disconnect(BanManager.getBannedMessage(target.getUniqueId().toString()));
            }
        }
    }
}
