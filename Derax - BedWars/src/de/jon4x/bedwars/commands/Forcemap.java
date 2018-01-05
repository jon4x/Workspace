package de.jon4x.bedwars.commands;

import de.jon4x.bedwars.main.Main;
import de.jon4x.bedwars.storage.Data;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.v1_8_R3.CraftServer;
import org.bukkit.entity.Player;
import java.io.File;
import java.util.List;

/**
 * Created by Pascal Falk on 10.08.2017.
 * Plugin by WeLoveSpigotPlugins
 * https://youtube.com/welovespigotplugins
 * Coded with IntelliJ
 */
public class Forcemap implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command c, String aas, String[] args) {
        if(c.getName().equalsIgnoreCase("forcemap")){
            if(sender.hasPermission("vip")){
                Player p = (Player)sender;
                if(args.length == 0){
                    File file = new File("plugins//BedWars//data.yml");
                    YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
                    List list = cfg.getStringList("Maps");
                    if(list.isEmpty()){
                        p.sendMessage(Data.gc.getPrefix() + "§cDerzeit wurden keine Maps gefunden§8.");
                        return true;
                    }
                    p.sendMessage(Data.gc.getPrefix() + "§7Folgende §eKarten §7stehen dir zur Auswahl:");
                    for(int i = 0 ; i < list.size() ; i++){
                        p.sendMessage("§7» §6" + list.get(i));
                    }
                }
                if(args.length != 0 && args.length == 1){
                    File file = new File("plugins//BedWars//data.yml");
                    YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
                    List list = cfg.getStringList("Maps");
                    if(list.contains(args[0])){
                        if(Data.ga.getLeftStartTime() < 5){
                            p.sendMessage(Data.gc.getPrefix() + "§cDu kannst die §6Karte §cjetzt nicht mehr verändern.");
                            return true;
                        }
                        Main.playedMap = args[0];
                        ((CraftServer) Bukkit.getServer()).getServer().setMotd("LOBBY;" + Data.mode + ";" + Main.playedMap);
                        Bukkit.broadcastMessage(Data.gc.getPrefix() + "§7Die §6Karte §7wurde nun zu §e" + Main.playedMap + "§7 geändert.");
                    }else{
                        p.sendMessage(Data.gc.getPrefix() + "§cDiese Karte wurde nicht gefunden...");
                    }
                }else{
                    p.sendMessage(Data.gc.getPrefix() + "§7Bitte nutze §c/forcemap <map>");
                }

            }
        }
        return false;
    }
}
