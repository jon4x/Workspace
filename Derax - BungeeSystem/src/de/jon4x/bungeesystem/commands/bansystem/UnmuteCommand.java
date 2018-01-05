package de.jon4x.bungeesystem.commands.bansystem;

import de.jon4x.bungeesystem.Main;
import de.jon4x.bungeesystem.ban.MuteManager;
import de.jon4x.bungeesystem.utils.UUIDFetcher;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;

import java.util.UUID;

public class UnmuteCommand extends Command {

    public UnmuteCommand() {
        super("unmute", "system.unmute");
    }

    @Override
    public void execute(final CommandSender sender, final String[] args) {
        if (sender.hasPermission("system.unmute")) {
            if (args.length < 1) {
                sender.sendMessage(Main.banPrefix() + "§7Bitte §7nutze §c/unmute <player>");
                return;
            }
            if (!MuteManager.isMuted(UUIDFetcher.getUUID(args[0]).toString())) {
                sender.sendMessage(Main.banPrefix() + "§7Der §7Spieler §e" + args[0] + " §7ist §cnicht gemutet.");
                return;
            }
            sender.sendMessage(Main.banPrefix() + "§7Du §7hast §7erfolgreich §7den §7Spieler §e" + args[0] + " §7entmutet§7.");
            MuteManager.unmute(args[0], UUIDFetcher.getUUID(args[0]).toString(), sender.getName());
        }
    }
}
