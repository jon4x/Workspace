package de.jon4x.lobby.commands;

import de.jon4x.coinapi.CoinAPI;
import de.jon4x.lobby.Main;
import de.jon4x.lobby.methods.Scoreboard;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RemoveCoinsCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (command.getName().equalsIgnoreCase("rmcoins")) {
                if (args.length == 1) {
                    int coins = Integer.parseInt(args[0]);
                    if (CoinAPI.getCoins(p.getUniqueId().toString()) < coins) {
                        p.sendMessage(Main.getPrefix() + "§cDafür hast du zu wenige Coins!");
                        return true;
                    }
                    CoinAPI.removeCoins(p.getUniqueId().toString(), coins);
                    Scoreboard.setScoreboard(p);
                    switch (coins) {
                        case 1:
                            p.sendMessage(Main.getPrefix() + "§7Dir wurde §6" + coins + "§6 Coin §7abezogen!");
                            break;
                        default:
                            p.sendMessage(Main.getPrefix() + "§7Dir wurden §6" + coins + "§6 Coins §7abgezogen!");
                            break;
                    }
                } else if (args.length == 2) {
                    Player target = Bukkit.getPlayerExact(args[0]);
                    if (target != null) {
                        if (target == p) {
                            int coins = Integer.parseInt(args[1]);
                            if (CoinAPI.getCoins(p.getUniqueId().toString()) < coins) {
                                p.sendMessage(Main.getPrefix() + "§cDafür hast du zu wenige Coins!");
                                return true;
                            }
                            CoinAPI.removeCoins(p.getUniqueId().toString(), coins);
                            Scoreboard.setScoreboard(p);
                            switch (coins) {
                                case 1:
                                    p.sendMessage(Main.getPrefix() + "§7Dir wurde §6" + coins + "§6 Coin §7abgezogen!");
                                    break;
                                default:
                                    p.sendMessage(Main.getPrefix() + "§7Dir wurden §6" + coins + "§6 Coins §7abgezogen!");
                                    break;
                            }
                        } else {
                            int coins = Integer.parseInt(args[1]);
                            if (CoinAPI.getCoins(target.getUniqueId().toString()) < coins) {
                                p.sendMessage(Main.getPrefix() + "§cDer Spieler " + target.getDisplayName() + " hat dufür zu wenige Coins!");
                                return true;
                            }
                            CoinAPI.removeCoins(target.getUniqueId().toString(), coins);
                            Scoreboard.setScoreboard(target);
                            switch (coins) {
                                case 1:
                                    p.sendMessage(Main.getPrefix() + "§7Du hast " + target.getDisplayName() + " §6" + coins + "§6 Coin §7abgezogen!");
                                    target.sendMessage("§7Dir wurde §6" + coins + "§6 Coin von " + p.getDisplayName() + " §7abgezogen!");
                                    break;
                                default:
                                    p.sendMessage(Main.getPrefix() + "§7Du hast " + target.getDisplayName() + " §6" + coins + "§6 Coins §7abgezogen!");
                                    target.sendMessage("§7Dir wurden §6" + coins + "§6 Coins von " + p.getDisplayName() + " §7abgezogen!");
                                    break;
                            }
                        }
                    } else
                        p.sendMessage(Main.getPrefix() + "§cDieser Spieler existiert nicht, oder ist nicht online!");
                } else
                    p.sendMessage(Main.getPrefix() + "§7Bitte nutze §c/rmcoins <player> <coins>");
            }
        } else
            sender.sendMessage("§cYou have to be a player to execute this command!");
        return false;
    }
}
