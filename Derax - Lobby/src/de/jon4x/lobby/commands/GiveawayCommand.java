package de.jon4x.lobby.commands;

import de.jon4x.coinapi.CoinAPI;
import de.jon4x.lobby.Main;
import de.jon4x.lobby.methods.Scoreboard;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;

import java.util.Random;

public class GiveawayCommand implements CommandExecutor{

    private int taskID;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("giveaway.use")) {
                if (args.length == 1) {
                    if (Bukkit.getOnlinePlayers().size() >= 2) {

                        p.sendMessage(Main.getPrefix() + "§aDas Gewinnspiel wurde erfolgreich gestartet!");
                        Bukkit.broadcastMessage(Main.getPrefix() + "§a" + p.getName() + " §7hat ein neues Gewinnspiel über §6" + args[0]+ " Coins §7gestartet!");

                        taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
                            int count = 30;
                            @Override
                            public void run() {
                                switch (count) {
                                    case 30: case 20: case 10: case 3: case 2:
                                        Bukkit.broadcastMessage(Main.getPrefix() + "§7Das Gewinnspiel endet in §6" + count + " Sekunden§7.");
                                        break;
                                    case 1:
                                        Bukkit.broadcastMessage(Main.getPrefix() + "§7Das Gewinnspiel endet in §6" + count + " Sekunde§7.");
                                        break;
                                    case 0:
                                        Bukkit.broadcastMessage(Main.getPrefix() + "§7Das Gewinnspiel wurde beendet!");
                                        Bukkit.getScheduler().cancelTask(taskID);

                                        int random = new Random().nextInt(Bukkit.getOnlinePlayers().size());
                                        Player randomPlayer = (Player) Bukkit.getServer().getOnlinePlayers().toArray()[random];

                                        while (randomPlayer.getName() == p.getName()) {
                                            random = new Random().nextInt(Bukkit.getOnlinePlayers().size());
                                            randomPlayer = (Player) Bukkit.getServer().getOnlinePlayers().toArray()[random];
                                        }

                                        int coins = Integer.parseInt(args[0]);
                                        CoinAPI.addCoins(randomPlayer.getUniqueId().toString(), coins);
                                        Scoreboard.setScoreboard(randomPlayer);

                                        switch (coins) {
                                            case 1:
                                                Bukkit.broadcastMessage(Main.getPrefix() + "§7Der Spieler §a" + randomPlayer.getName() + " §7hat §6" + args[0] + " Coin§7 gewonnen!");
                                                break;
                                            default:
                                                Bukkit.broadcastMessage(Main.getPrefix() + "§7Der Spieler §a" + randomPlayer.getName() + " §7hat §6" + args[0] + " Coins§7 gewonnen!");
                                                break;
                                        }

                                        Firework f = randomPlayer.getWorld().spawn(randomPlayer.getLocation(), Firework.class);

                                        FireworkMeta fm = f.getFireworkMeta();
                                        fm.addEffect(FireworkEffect.builder().flicker(true).trail(true).with(FireworkEffect.Type.BALL).withColor(Color.AQUA).withColor(Color.BLUE).withColor(Color.LIME).build());
                                        fm.setPower(0);
                                        f.setFireworkMeta(fm);
                                        break;
                                }
                                count--;
                            }
                        }, 0, 20);

                    } else
                        p.sendMessage(Main.getPrefix() + "§cEs sind nicht genügend Spieler online!");
                } else
                    p.sendMessage(Main.getPrefix() + "§7Bitte nutze §c/gewinnspiel <coins>");
            } else
                p.sendMessage(Main.getPrefix() + "§cDazu fehlen dir die Rechte!");
        } else
            sender.sendMessage("§cYou have to be a player to execute this command!");

        return false;
    }
}
