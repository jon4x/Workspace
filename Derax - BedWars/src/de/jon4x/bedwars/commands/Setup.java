package de.jon4x.bedwars.commands;

import de.jon4x.bedwars.storage.Data;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Pascal Falk on 03.08.2017.
 * Plugin by WeLoveSpigotPlugins
 * https://youtube.com/welovespigotplugins
 * Coded with IntelliJ
 */
public class Setup implements CommandExecutor, Listener{


    public static HashMap<String, Integer> bed = new HashMap<>();
    public static HashMap<String, String> param = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender s, Command c, String sa, String[] args) {
        if(c.getName().equalsIgnoreCase("setup")){
            Player p = (Player) s;
            if(p.hasPermission("admin")) {
                if (args.length != 3) {
                    if (Data.mode.equalsIgnoreCase("8x1") || Data.mode.equalsIgnoreCase("8x2")) {
                        p.sendMessage("§e/setup setSpawn [MAPNAME] [Blau,Rot,Gelb,Gruen,Orange,Schwarz,Pink,Grau]");
                        p.sendMessage("§e/setup setBed [MAPNAME] [Blau,Rot,Gelb,Gruen,Orange,Schwarz,Pink,Grau]");
                    } else if (Data.mode.equalsIgnoreCase("4x2") || Data.mode.equalsIgnoreCase("4x3")) {
                        p.sendMessage("§e/setup setSpawn [MAPNAME] [Blau,Rot,Gelb,Gruen]");
                        p.sendMessage("§e/setup setBed [MAPNAME] [Blau,Rot,Gelb,Gruen]");
                    }
                    else {
                        p.sendMessage("§e/setup setSpawn [MAPNAME] [Blau,Rot]");
                        p.sendMessage("§e/setup setBed [MAPNAME] [Blau,Rot]");
                    }
                    p.sendMessage("§e/setup setSpawner [MAPNAME] [Bronze, Eisen, Gold]");
                }else{
                    if(args.length == 3 ){
                        if(args[0].equalsIgnoreCase("setspawn")){
                            File file = new File("plugins//BedWars//data.yml");
                            YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
                            List list = cfg.getStringList("Maps");
                            if(!list.contains(args[1])){
                                s.sendMessage("§5Eine neue Map wurde erkannt und angelegt.");
                                list.add(args[1]);
                                cfg.set("Maps", list);
                                try {
                                    cfg.save(file);
                                } catch (IOException e) {
                                }
                            }
                            Data.ca.setLocation("spawns", args[1].toLowerCase() + "." + args[2].toLowerCase(), p.getLocation());
                            p.sendMessage(Data.gc.getPrefix() + "§eDer Spawn wurde gesetzt.");
                        }
                        if(args[0].equalsIgnoreCase("setbed")){
                            p.sendMessage("§eSchlage den oberen Teil des Bettes");
                            param.put(p.getName(), args[1].toLowerCase() + "." + args[2].toLowerCase());
                            bed.put(p.getName(), 0);
                        }
                        if(args[0].equalsIgnoreCase("setspawner")){
                            File file = new File("plugins//BedWars//Spawner//" + args[2].toLowerCase() + ".yml");
                            YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
                            if(cfg.get(args[1].toLowerCase() + ".Anzahl") == null ){
                                cfg.set(args[1].toLowerCase() + ".Anzahl", 0);
                                try {
                                    cfg.save(file);
                                } catch (IOException e) {
                                }
                                int ca = cfg.getInt(args[1].toLowerCase() + ".Anzahl") ;
                                Data.ca.setCustonLocation(cfg, file, args[1].toLowerCase() + "." + ca, p.getLocation());
                                p.sendMessage(Data.gc.getPrefix() + "§aDu hast einen Spawner für die Map §6" + args[1] + "§a gesetzt!");
                            }else{
                                int ca = cfg.getInt(args[1].toLowerCase() + ".Anzahl") +1;
                                cfg.set(args[1].toLowerCase() + ".Anzahl", ca);
                                try {
                                    cfg.save(file);
                                } catch (IOException e) {
                                }
                                Data.ca.setCustonLocation(cfg, file, args[1].toLowerCase() + "." + ca, p.getLocation());
                                p.sendMessage(Data.gc.getPrefix() + "§aDu hast einen Spawner für die Map §6" + args[1] + "§a gesetzt!");
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    @EventHandler
    public void onBreak(BlockBreakEvent e){
        if(bed.containsKey(e.getPlayer().getName())){
            if(bed.get(e.getPlayer().getName()) == 0){
                Data.ca.setBlockLocation("beds", param.get(e.getPlayer().getName()) + ".oben", e.getBlock().getLocation());
                e.setCancelled(true);
                e.getPlayer().sendMessage("§eSchlage nun den unteren Teil");
                bed.put(e.getPlayer().getName(), 1);
                return;
            }
            if(bed.get(e.getPlayer().getName()) == 1){
                Data.ca.setBlockLocation("beds", param.get(e.getPlayer().getName()) + ".unten", e.getBlock().getLocation());
                e.setCancelled(true);
                e.getPlayer().sendMessage("§aDas Bett wurde eingerichtet!");
                bed.remove(e.getPlayer().getName());
                param.remove(e.getPlayer().getName());
                return;
            }
        }
    }
}
