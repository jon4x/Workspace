package de.jon4x.bedwars.commands;

import de.jon4x.bedwars.storage.Data;
import net.claymc.gameapi.main.Main;
import net.spigotplugins.gameapi.manager.StatsAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Stats implements CommandExecutor {
    static int pos = 0;
    @Override
    public boolean onCommand(CommandSender s, Command c, String sa, String[] args) {
        if(c.getName().equalsIgnoreCase("stats")){
            if(args.length == 0){
                Player p = (Player)s;
                s.sendMessage("§7§m------------------------------");
                s.sendMessage("§aName§8 \u00bb §7" + s.getName());
                s.sendMessage("§aK/D§8 \u00bb §7" + getKD(p));
                s.sendMessage("§aGewonnene Spiele§8 \u00bb §7" + new StatsAPI().getInt(p.getUniqueId(), "BEDWARS", "WINS"));
                s.sendMessage("§aGespielte Spiele§8 \u00bb §7" + new StatsAPI().getInt(p.getUniqueId(), "BEDWARS", "PLAYED"));
                s.sendMessage("§aRang§8 \u00bb §7" + getRanking(p));
                s.sendMessage("§7§m------------------------------");
            }
            else if(args.length == 1) {
                Player target = Bukkit.getPlayerExact(args[0]);
                if (target != null) {
                    s.sendMessage("§7§m------------------------------");
                    s.sendMessage("§aName§8 \u00bb §7" + target.getName());
                    s.sendMessage("§aK/D§8 \u00bb §7" + getKD(target));
                    s.sendMessage("§aGewonnene Spiele§8 \u00bb §7" + new StatsAPI().getInt(target.getUniqueId(), "BEDWARS", "WINS"));
                    s.sendMessage("§aGespielte Spiele§8 \u00bb §7" + new StatsAPI().getInt(target.getUniqueId(), "BEDWARS", "PLAYED"));
                    s.sendMessage("§aRang §8\u00bb §7" + getRanking(target));
                    s.sendMessage("§7§m------------------------------");
                }
            }
            else{
                s.sendMessage(Data.gc.getPrefix() + "§7Bitte nutze §c/stats <Player>");
            }
        }
        return false;
    }

    public static int getRanking(Player p){
        int pos = new StatsAPI().getRankingFromUUID(p.getUniqueId(), "BEDWARS", "WINS");
        return pos;
    }

    public static double getKD(Player p){

        double kills = new StatsAPI().getRankingFromUUID(p.getUniqueId(), "BEDWARS", "KILLS");
        double deaths = new StatsAPI().getRankingFromUUID(p.getUniqueId(), "BEDWARS", "DEATHS");

        return (kills/deaths);
    }
}
