package de.jon4x.bungeesystem.commands;

import de.jon4x.bungeesystem.Main;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class TeamspeakCommand extends Command {

    public TeamspeakCommand() {
        super("teamspeak", null, "ts");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (sender instanceof ProxiedPlayer) {
            ProxiedPlayer p = (ProxiedPlayer) sender;
            p.sendMessage(Main.getPrefix() + "§7Unser Teamspeak §8\u00bb §aDerax.net");
        }
    }
}
