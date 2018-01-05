package de.jon4x.bedwars.commands;

import de.jon4x.bedwars.storage.Data;
import net.claymc.gameapi.api.GameState;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Pascal Falk on 03.08.2017.
 * Plugin by WeLoveSpigotPlugins
 * https://youtube.com/welovespigotplugins
 * Coded with IntelliJ
 */
public class Start implements CommandExecutor {
    public static boolean started;
    @Override
    public boolean onCommand(CommandSender s, Command c, String sa, String[] args) {
        if(c.getName().equalsIgnoreCase("start")){
            if(s.hasPermission("vip")){
                Player p = (Player)s;
                if(Data.ga.gs == GameState.LOBBY){
                    if(Data.ga.getLeftStartTime() > 10){
                        if(!started){
                            Data.ga.setLeftStartTime(10);
                            if(Data.mode.equalsIgnoreCase("8x1") || Data.mode.equalsIgnoreCase("2x1") || Data.mode.equalsIgnoreCase("2x2")){
                                if(Bukkit.getOnlinePlayers().size() > 1){
                                    started = true;
                                    Data.ga.setLeftStartTime(10);
                                    p.sendMessage(Data.gc.getPrefix() + "§aDu hast das Spiel gestartet!");
                                }else{
                                    p.sendMessage(Data.gc.getPrefix() + "§cEs sind zu wenige Spieler online, um das Spiel zu starten...");
                                }
                            }
                            else {
                                if (Bukkit.getOnlinePlayers().size() > 3) {
                                    started = true;
                                    Data.ga.setLeftStartTime(10);
                                    p.sendMessage(Data.gc.getPrefix() + "§aDu hast das Spiel gestartet!");
                                }else{
                                    p.sendMessage(Data.gc.getPrefix() + "§cEs sind zu wenige Spieler online, um das Spiel zu starten...");
                                }
                            }
                            }else{
                            p.sendMessage(Data.gc .getPrefix() + "§cDas Spiel wurde bereits gestartet...");
                        }
                    }else{
                        p.sendMessage(Data.gc.getPrefix() + "§cDie restliche Wartezeit ist zu kurz, um das Spiel zu starten...");
                    }
                }else{
                    p.sendMessage(Data.gc.getPrefix() + "§cDas Spiel läuft bereits...");
                }
            }else{
                s.sendMessage(Data.gc.getPrefix() + "§7Du hast keine §6Rechte §7diesen Command auszuführen§8.");
            }
        }
        return true;
    }
}
