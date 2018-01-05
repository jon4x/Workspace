package de.jon4x.bungeesystem.commands;

import de.jon4x.bungeesystem.Main;
import de.jon4x.bungeesystem.ban.TeamManager;
import de.jon4x.bungeesystem.utils.UUIDFetcher;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class TeamCommand extends Command {

    public TeamCommand() {
        super("team", "admin");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (sender.hasPermission("admin")) {
            if (args.length < 2) {
                sender.sendMessage(Main.getPrefix() + "§7Bitte nutze §c/team < add | remove > <player>");
                return;
            }
            if (args[0].equalsIgnoreCase("add")) {
                ProxiedPlayer target = ProxyServer.getInstance().getPlayer(args[1]);
                if (target == null) {
                    if (!TeamManager.isInTeam(UUIDFetcher.getUUID(args[1]).toString())) {
                        TeamManager.add(UUIDFetcher.getUUID(args[1]).toString());
                        sender.sendMessage(Main.getPrefix() + "§aDer Spieler §e" + args[1] + " §awurde zum Team hinzugefügt!");
                    }
                    else
                        sender.sendMessage(Main.getPrefix() + "§cDer Spieler §e" + args[1] + " §cist bereits im Team!");
                }
                else {
                    if (!TeamManager.isInTeam(target.getUniqueId().toString())) {
                        TeamManager.add(target.getUniqueId().toString());
                        sender.sendMessage(Main.getPrefix() + "§aDer Spieler §e" + target.getName() + " §awurde zum Team hinzugefügt!");
                    }
                    else
                        sender.sendMessage(Main.getPrefix() + "§cDer Spieler §e" + target.getName() + " §cist bereits im Team!");
                }
            }
            if (args[0].equalsIgnoreCase("remove")) {
                ProxiedPlayer target = ProxyServer.getInstance().getPlayer(args[1]);
                if (target == null) {
                    if (TeamManager.isInTeam(UUIDFetcher.getUUID(args[1]).toString())) {
                        TeamManager.remove(UUIDFetcher.getUUID(args[1]).toString());
                        sender.sendMessage(Main.getPrefix() + "§cDer Spieler §e" + args[1] + " §cwurde aus dem Team entfernt!");
                    }
                    else
                        sender.sendMessage(Main.getPrefix() + "§cDer Spieler §e" + args[1] + " §cist nicht im Team!");
                }
                else {
                    if (TeamManager.isInTeam(target.getUniqueId().toString())) {
                        TeamManager.remove(target.getUniqueId().toString());
                        sender.sendMessage(Main.getPrefix() + "§cDer Spieler §e" + target.getName() + " §cwurde aus dem Team entfernt!");
                    }
                    else
                        sender.sendMessage(Main.getPrefix() + "§cDer Spieler §e" + target.getName() + " §cist nicht im Team!");
                }
            }
            else {
                sender.sendMessage(Main.getPrefix() + "§7Bitte nutze §c/team < add | remove > <player>");
            }
        }
    }
}
