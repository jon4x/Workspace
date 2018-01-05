package de.jon4x.bungeesystem.commands;

import de.jon4x.bungeesystem.Main;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;

public class PluginCommand extends Command {

    public PluginCommand() {
        super("plugins", null, "pl", "bukkit:pl", "bukkit:plugins");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        sender.sendMessage(Main.getPrefix() + "§7Das System wurde von §ejon4x §7programmiert!");
    }
}
