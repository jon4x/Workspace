package de.jon4x.bungeesystem.commands.bansystem;

import de.jon4x.bungeesystem.Main;
import de.jon4x.bungeesystem.ban.BanManager;
import de.jon4x.bungeesystem.ban.TeamManager;
import de.jon4x.bungeesystem.utils.UUIDFetcher;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class TempbanCommand extends Command {

    public TempbanCommand() {
        super("tempban", "system.tempban");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (sender.hasPermission("system.tempban")) {
            if (args.length < 4) {
                sender.sendMessage(Main.banPrefix() + "§7Bitte §7benutze §c/tempban §c<player> §c<time> §c<timeform> §c<reason>");
                return;
            }
            if (TeamManager.isInTeam(UUIDFetcher.getUUID(args[0]).toString())) {
                sender.sendMessage(Main.banPrefix() + "§7Du kannst diesen Spieler nicht bannen!");
                sender.sendMessage(Main.banPrefix() + "§e" + args[0] + " §7ist ein Teammitglied!");
                return;
            }
            if (BanManager.isBanned(UUIDFetcher.getUUID(args[0]).toString())) {
                sender.sendMessage(Main.banPrefix() + "§7Der §7Spieler §e" + args[0] + " §7wurde §7bereits §7gebannt§7.");
                return;
            }
            String timeUnit = args[2];
            ProxiedPlayer target = ProxyServer.getInstance().getPlayer(args[0]);

            String ip, uuid;
            if (target == null) {
                ip = null;
                uuid = UUIDFetcher.getUUID(args[0]).toString();
            }
            else {
                ip = target.getAddress().getAddress().toString();
                uuid = target.getUniqueId().toString();
            }

            String message = "";
            for (int i = 3; i < args.length; ++i) {
                message = String.valueOf(message) + args[i] + " ";
            }
            int time = Integer.parseInt(args[1]);
            if (timeUnit.equalsIgnoreCase("s")) {
                sender.sendMessage(Main.banPrefix() + "§7Du §7hast §7den §7Spieler §e" + args[0] + " §7f\u00fcr §c" + time + " §cSekunde(n) §7gebannt.");
                BanManager.ban(args[0], uuid, message, sender.getName(), time * 1, ip);
                if (target != null)
                    target.disconnect(BanManager.getBannedMessage(target.getUniqueId().toString()));
                return;
            }
            if (timeUnit.equalsIgnoreCase("m")) {
                sender.sendMessage(Main.banPrefix() + "§7Du §7hast §7den §7Spieler §e" + args[0] + " §7f\u00fcr §c" + time + " §cMinute(n) §7gebannt.");
                BanManager.ban(args[0], uuid, message, sender.getName(), time * 60, ip);
                if (target != null)
                    target.disconnect(BanManager.getBannedMessage(target.getUniqueId().toString()));
                return;
            }
            if (timeUnit.equalsIgnoreCase("h")) {
                sender.sendMessage(Main.banPrefix() + "§7Du §7hast §7den §7Spieler §e" + args[0] + " §7f\u00fcr §c" + time + " §cStunde(n) §7gebannt.");
                BanManager.ban(args[0], uuid, message, sender.getName(), time * 60 * 60, ip);
                if (target != null)
                    target.disconnect(BanManager.getBannedMessage(target.getUniqueId().toString()));
                return;
            }
            if (timeUnit.equalsIgnoreCase("t")) {
                sender.sendMessage(Main.banPrefix() + "§7Du §7hast §7den §7Spieler §e" + args[0] + " §7f\u00fcr §c" + time + " §cTag(e) §7gebannt.");
                BanManager.ban(args[0], uuid, message, sender.getName(), time * 60 * 60 * 24, ip);
                if (target != null)
                    target.disconnect(BanManager.getBannedMessage(target.getUniqueId().toString()));
                return;
            }
            if (timeUnit.equalsIgnoreCase("w")) {
                sender.sendMessage(Main.banPrefix() + "§7Du §7hast §7den §7Spieler §e" + args[0] + " §7f\u00fcr §c" + time + " §cWoche(n) §7gebannt.");
                BanManager.ban(args[0], uuid, message, sender.getName(), time * 60 * 60 * 24 * 7, ip);
                if (target != null)
                    target.disconnect(BanManager.getBannedMessage(target.getUniqueId().toString()));
                return;
            }
            sender.sendMessage(Main.banPrefix() + "§cDu benutzt eine falsche Zeitform!");
            sender.sendMessage(Main.banPrefix() + " §7< s | m | h | t | w >");
        }
    }
}
