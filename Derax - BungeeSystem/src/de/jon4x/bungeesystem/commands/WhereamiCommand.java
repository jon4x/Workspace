package de.jon4x.bungeesystem.commands;

import de.jon4x.bungeesystem.Main;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class WhereamiCommand extends Command {

    public WhereamiCommand() {
        super("whereami");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (sender instanceof ProxiedPlayer) {
            ProxiedPlayer p = (ProxiedPlayer) sender;
            p.sendMessage(Main.getPrefix() + "§7Du befindest dich auf §8\u00bb §a" + p.getServer().getInfo().getName());
        }
    }
}
