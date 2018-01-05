package de.jon4x.bungeesystem.commands.bansystem;

import de.jon4x.bungeesystem.Main;
import de.jon4x.bungeesystem.ban.MuteManager;
import de.jon4x.bungeesystem.ban.TeamManager;
import de.jon4x.bungeesystem.utils.UUIDFetcher;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class MuteCommand extends Command{

    public MuteCommand() {
        super("mute", "system.mute");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (sender.hasPermission("system.mute")) {
            if (args.length < 2) {
                sender.sendMessage(Main.banPrefix() + "§7Bitte §7benutze §c/mute <Spieler> <Grund>");
                return;
            }

            if (TeamManager.isInTeam(UUIDFetcher.getUUID(args[0]).toString())) {
                sender.sendMessage(Main.banPrefix() + "§7Du kannst diesen Spieler nicht muten!");
                sender.sendMessage(Main.banPrefix() + "§e" + args[0] + " §7ist ein Teammitglied!");
                return;
            }

            if (MuteManager.isMuted(args[0])) {
                sender.sendMessage(Main.banPrefix() + "§7Der §7Spieler §e" + args[0] + " §7ist §7bereits gemutet§7.");
                return;
            }

            String message = "";
            for (int i = 1; i < args.length; ++i) {
                message = String.valueOf(message) + args[i] + " ";
            }

            ProxiedPlayer target = ProxyServer.getInstance().getPlayer(args[0]);

            String uuid;
            if (target == null)
                uuid = UUIDFetcher.getUUID(args[0]).toString();
            else
                uuid = target.getUniqueId().toString();

            sender.sendMessage(Main.banPrefix() + "§7Du §7hast §7erfolgreich §7den §7Spieler §e" + args[0] + " §7permanent §7gemutet.");
            if (target != null)
                sendMessage(args[0], sender.getName(), message);
            MuteManager.mute(args[0], uuid, message, sender.getName(), -1);
        }
    }

    private void sendMessage(final String mp, final String p, final String message) {
        final ProxiedPlayer target = ProxyServer.getInstance().getPlayer(mp);
        if (target != null) {
            target.sendMessage("§r");
            target.sendMessage("§7§m-----------§r§c System §8\u00bb §eMute §7§m-----------");
            target.sendMessage("§7Du wurdest von §e" + p + " §7gemutet.");
            target.sendMessage("§7Grund §8\u00bb §e" + message);
            target.sendMessage("§7§m-----------§r§c System §8\u00bb §eMute §7§m-----------");
            target.sendMessage("§r");
        }
    }

}
