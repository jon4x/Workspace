package de.jon4x.lobby.commands;

import de.jon4x.lobby.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            if (args.length == 0) {
                sender.sendMessage(Main.getPrefix() + "§7Bitte nutze §c/gm <mode> <player>");
            }
            else if (args.length < 3){

                String modeArg = args[0];
                String playerArg = sender.getName();

                if (args.length == 2) {
                    playerArg = args[1];
                }

                Player p = Bukkit.getPlayerExact(playerArg);

                if (p != null) {
                    int value = -1;

                    try {
                        value = Integer.parseInt(modeArg);
                    } catch (NumberFormatException var9) {
                    }

                    GameMode mode = GameMode.getByValue(value);

                    if (mode != null) {
                        if (mode != p.getGameMode()) {
                            p.setGameMode(mode);
                            p.sendMessage(Main.getPrefix() + "§7Dein Spielmodus wurde auf §a" + mode.toString() + " §7geändert!");
                        } else
                            sender.sendMessage(Main.getPrefix() + "§cSpielmodus konnte nicht gesetzt werden.\n§7Spieler befindet sich bereits im Spielmodus §c" + p.getGameMode().toString());
                    } else
                        sender.sendMessage(Main.getPrefix() + "§cUngültiger Spielmodus!");
                } else
                    sender.sendMessage(Main.getPrefix() + "§7Spieler §c" + playerArg + " §7konnte nicht gefunden werden!");
            }
            else {
                sender.sendMessage(Main.getPrefix() + "§7Bitte nutze §c/gm <mode> <player>");
            }
        }
        else
            sender.sendMessage(Main.getPrefix() + "§cYou have to be a player to execute this command!");
        return false;
    }


}
