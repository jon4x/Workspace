package de.jon4x.lobby.commands;

import de.jon4x.coinapi.CoinAPI;
import de.jon4x.lobby.Main;
import de.jon4x.lobby.methods.Scoreboard;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GetCoinsCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (command.getName().equalsIgnoreCase("getcoins")) {
                if (args.length == 0) {
                    int coins = CoinAPI.getCoins(p.getUniqueId().toString());
                    Scoreboard.setScoreboard(p);
                    switch (coins) {
                        case 1:
                            p.sendMessage(Main.getPrefix() + "§7Du besitzt §6" + coins + "§6 Coin");
                            break;
                        default:
                            p.sendMessage(Main.getPrefix() + "§7Du besitzt §6" + coins + "§6 Coins");
                            break;
                    }
                } else if (args.length == 1) {
                    Player target = Bukkit.getPlayerExact(args[0]);
                    if (target != null) {
                        if (target == p) {
                            int coins = CoinAPI.getCoins(p.getUniqueId().toString());
                            switch (coins) {
                                case 1:
                                    p.sendMessage(Main.getPrefix() + "§7Du besitzt §6" + coins + "§6 Coin");
                                    break;
                                default:
                                    p.sendMessage(Main.getPrefix() + "§7Du besitzt §6" + coins + "§6 Coins");
                                    break;
                            }
                        } else {
                            int coins = CoinAPI.getCoins(target.getUniqueId().toString());
                            switch (coins) {
                                case 1:
                                    p.sendMessage(Main.getPrefix() + "§7Der Spieler " + target.getDisplayName() + "§7 besitz §6" + coins + "§6 Coin");
                                    break;
                                default:
                                    p.sendMessage(Main.getPrefix() + "§7Der Spieler " + target.getDisplayName() + "§7 besitz §6" + coins + "§6 Coins");
                                    break;
                            }
                        }
                    } else
                        p.sendMessage(Main.getPrefix() + "§cDieser Spieler existiert nicht, oder ist nicht online!");
                } else
                    p.sendMessage(Main.getPrefix() + "§7Bitte nutze §c/getcoins <player>");
            }
        } else
            sender.sendMessage("§cYou have to be a player to execute this command!");
        return false;
    }
}
