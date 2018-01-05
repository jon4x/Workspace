package de.jon4x.bungeesystem.commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class PingCommand extends Command {

    public PingCommand() {
        super("ping");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (sender instanceof ProxiedPlayer) {
            ProxiedPlayer p = (ProxiedPlayer) sender;
            if (args.length == 1) {
                ProxiedPlayer target = ProxyServer.getInstance().getPlayer(args[0]);
                if (target != null) {
                    p.sendMessage("§8» §aPing §8× §7Ping von §e" + args[0] + " §8\u00bb §a" + target.getPing() + "§ams");
                }
                else
                    p.sendMessage("§8» §aPing §8× §cDer Spieler §e" + args[0] + " §ckonnte nicht gefunden werden!");
            }
            else {
                p.sendMessage("§8» §aPing §8× §7Dein Ping §8\u00bb §a" + p.getPing() + "§ams");
            }
        }
    }
}
