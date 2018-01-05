package de.jon4x.bungeesystem.commands;

import de.jon4x.bungeesystem.Main;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Command;

public class BroadcastCommand extends Command {

    public BroadcastCommand() {
        super("broadcast", "system.broadcast", "say");
    }

    @Override
    public void execute(final CommandSender sender, final String[] args) {
        if (sender.hasPermission("system.Broadcast")) {
            if (args.length == 0) {
                sender.sendMessage(Main.getPrefix() + "§7Bitte nutze §c/broadcast §c<message>");
                return;
            }
            String message = "";
            for (int i = 0; i < args.length; ++i) {
                message = String.valueOf(message) + args[i] + " ";
            }
            message = ChatColor.translateAlternateColorCodes('&', message);
            ProxyServer.getInstance().broadcast("");
            ProxyServer.getInstance().broadcast(String.valueOf("§8» §c§lDeraxNET §8× "  + message));
            ProxyServer.getInstance().broadcast("");
        }
    }
}
