package de.jon4x.bungeesystem.commands.bansystem;

import de.jon4x.bungeesystem.Main;
import de.jon4x.bungeesystem.ban.BanManager;
import de.jon4x.bungeesystem.utils.UUIDFetcher;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;

import java.util.UUID;

public class UnbanCommand extends Command {

    public UnbanCommand() {
        super("unban", "system.unban");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (sender.hasPermission("system.unban")) {
            if (args.length != 1) {
                sender.sendMessage(Main.getPrefix() + "§7Bitte §7benutze §c/unban §c<player>");
                return;
            }
            if (!BanManager.isBanned(UUIDFetcher.getUUID(args[0]).toString())) {
                sender.sendMessage(Main.getPrefix() + "§7Der §7Spieler §e" + args[0] + " §7ist §7nicht §7gebannt§7.");
                return;
            }
            sender.sendMessage(Main.getPrefix() + "§7Du §7hast §7erfolgreich §7den §7Spieler §e" + args[0] + " §7entbannt§7.");
            BanManager.unban(args[0], UUIDFetcher.getUUID(args[0]).toString(), sender.getName());
        }
    }
}
