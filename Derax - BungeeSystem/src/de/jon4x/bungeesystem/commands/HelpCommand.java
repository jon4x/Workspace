package de.jon4x.bungeesystem.commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class HelpCommand extends Command {

    public HelpCommand() {
        super("help", null, "bukkit:help", "?", "bukkit:?");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (sender instanceof ProxiedPlayer) {
            ProxiedPlayer p = (ProxiedPlayer) sender;
            p.sendMessage(" ");
            p.sendMessage("§e§lDie wichtigsten Befehle!");
            p.sendMessage("§8\u00bb §a/hub §8× §7Sende dich zur Lobby");
            p.sendMessage("§8\u00bb §a/report §8× §7Reporte einen Spieler");
            p.sendMessage("§8\u00bb §a/support §8× §7Zeige Info zu Support");
            p.sendMessage("§8\u00bb §c/party §8× §7Zeige alle Party Commands");
            p.sendMessage("§8\u00bb §a/bewerben §8× §7Bewirb dich");
            p.sendMessage("§8\u00bb §a/ping §8× §7Zeige deinen Ping");
            p.sendMessage("§8\u00bb §a/whereami §8× §7Zeige deinen Server");
            p.sendMessage(" ");
        }
    }
}
