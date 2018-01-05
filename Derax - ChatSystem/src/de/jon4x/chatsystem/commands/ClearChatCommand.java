package de.jon4x.chatsystem.commands;

import de.jon4x.chatsystem.main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClearChatCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("cc.use")) {

                for (int i = 0; i < 500; i++) {
                    Bukkit.broadcastMessage(" ");
                }

                Bukkit.broadcastMessage(main.getPrefix() + "§7Der chat wurde von " + p.getDisplayName() + " §7geleert!");

            } else
                p.sendMessage(main.getPrefix() + "§cDazu fehlen dir die Rechte!");
        } else
            sender.sendMessage("§cYou have to be a Player to execute this command!");

        return false;
    }
}
