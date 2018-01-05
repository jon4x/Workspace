package de.jon4x.bungeesystem.commands.bansystem;

import de.jon4x.bungeesystem.Main;
import de.jon4x.bungeesystem.ban.MuteManager;
import de.jon4x.bungeesystem.ban.TeamManager;
import de.jon4x.bungeesystem.utils.UUIDFetcher;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class TempmuteCommand extends Command {

    public TempmuteCommand() {
        super("tempmute", "system.tempmute");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (sender.hasPermission("system.tempmute")) {
            if (args.length < 4) {
                sender.sendMessage(Main.banPrefix() + "§7Bitte §7nutze §c/tempmute <player> <time> <timeform> <reason>");
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
            final String timeUnit = args[2];
            String message = "";
            for (int i = 3; i < args.length; ++i) {
                message = String.valueOf(message) + args[i] + " ";
            }
            int time = 0;
            try {
                time = Integer.parseInt(args[1]);
            }
            catch (NumberFormatException e) {
                sender.sendMessage("Die eingegeben Zahl war keine Zahl :)");
                return;
            }
            ProxiedPlayer target = ProxyServer.getInstance().getPlayer(args[0]);

            String uuid;
            if (target == null)
                uuid = String.valueOf(UUIDFetcher.getUUID(args[0]));
            else
                uuid = target.getUniqueId().toString();

            if (timeUnit.equalsIgnoreCase("s")) {
                sender.sendMessage(Main.banPrefix() + "§7Du §7hast §7erfolgreich §7den §7Spieler §e" + args[0] + " §7f\u00fcr §c" + time + " §7Sekunde(n) §7gemutet.");
                if (target != null)
                    sendMessage(args[0], sender.getName(), message);
                MuteManager.mute(args[0], uuid, message, sender.getName(), time * 1);
                return;
            }
            if (timeUnit.equalsIgnoreCase("m")) {
                sender.sendMessage(Main.banPrefix() + "§7Du §7hast §7erfolgreich §7den §7Spieler §e" + args[0] + " §7f\u00fcr §c" + time + " §7Minute(n) §7gemutet.");
                if (target != null)
                    sendMessage(args[0], sender.getName(), message);
                MuteManager.mute(args[0], uuid, message, sender.getName(), time * 60);
                return;
            }
            if (timeUnit.equalsIgnoreCase("h")) {
                sender.sendMessage(Main.banPrefix() + "§7Du §7hast §7erfolgreich §7den §7Spieler §e" + args[0] + " §7f\u00fcr §c" + time + " §7Stunde(n) §7gemutet.");
                if (target != null)
                    sendMessage(args[0], sender.getName(), message);
                MuteManager.mute(args[0], uuid, message, sender.getName(), time * 60 * 60);
                return;
            }
            if (timeUnit.equalsIgnoreCase("t")) {
                sender.sendMessage(Main.banPrefix() + "§7Du §7hast §7erfolgreich §7den §7Spieler §e" + args[0] + " §7f\u00fcr §c" + time + " §7Tag(e) §7gemutet.");
                if (target != null)
                    sendMessage(args[0], sender.getName(), message);
                MuteManager.mute(args[0], uuid, message, sender.getName(), time * 60 * 60 * 24);
                return;
            }
            if (timeUnit.equalsIgnoreCase("w")) {
                sender.sendMessage(Main.banPrefix() + "§7Du §7hast §7erfolgreich §7den §7Spieler §e" + args[0] + " §7f\u00fcr §c" + time + " §7Woche(n) §7gemutet.");
                if (target != null)
                    sendMessage(args[0], sender.getName(), message);
                MuteManager.mute(args[0], uuid, message, sender.getName(), time * 60 * 60 * 24 * 7);
                return;
            }
            sender.sendMessage(Main.banPrefix() + "§cDu §cbenutzt §ceine §cfalsche §cZeitform.");
            sender.sendMessage(Main.banPrefix() + "§7< s | m | h | t | w >");
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
