package de.jon4x.bedwars.listener;

import de.jon4x.bedwars.storage.Data;
import net.claymc.gameapi.main.Main;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;

/**
 * Created by Pascal Falk on 04.08.2017.
 * Plugin by WeLoveSpigotPlugins
 * https://youtube.com/welovespigotplugins
 * Coded with IntelliJ
 */
public class Teleporter implements Listener {

    private int taskID;

    public static ArrayList<Player> nomove = new ArrayList<Player>();

    @EventHandler
    public void onInteract(PlayerInteractEvent e){
        Player p = e.getPlayer();
        if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK){
            if(e.getMaterial() == Material.FIREWORK){

                e.setCancelled(true);

                if(nomove.contains(p)){
                    return;
                }

                nomove.add(p);

                Location loc = p.getLocation();

                p.sendMessage(Data.gc.getPrefix() + "§7Du wirst in §65 Sekunden §7zu deinem Spawn teleportiert!");
                for(int i = 0 ; i < 10 ; i++){
                    for(Player all : Bukkit.getOnlinePlayers()){
                        all.playEffect(p.getLocation(), Effect.ENDER_SIGNAL, 1);
                    }
                }
                p.playSound(p.getLocation(), Sound.NOTE_BASS, 1, 1);

                taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
                    int count = 5;
                    @Override
                    public void run() {
                        switch (count) {
                            case 2: case 3: case 4: case 5:
                                if(p.getLocation().getBlockX() != loc.getBlockX() || p.getLocation().getBlockY() != loc.getBlockY() || p.getLocation().getBlockZ() != loc.getBlockZ()){
                                    nomove.remove(p);
                                    p.sendMessage(Data.gc.getPrefix()+"§cDer Teleport-Vorgang wurde beendet, da du dich bewegt hast!");
                                }

                                if(nomove.contains(p)) {
                                    p.playSound(p.getLocation(), Sound.NOTE_BASS, 1, 1);
                                    p.sendMessage(Data.gc.getPrefix() + "§7Du wirst in §6" + count + " Sekunden §7zu deinem Spawn teleportiert!");
                                    for (Player all : Bukkit.getOnlinePlayers()) {
                                        all.playEffect(p.getLocation(), Effect.ENDER_SIGNAL, 1);
                                    }
                                    if (p.getLocation().getBlockX() != loc.getBlockX() || p.getLocation().getBlockY() != loc.getBlockY() || p.getLocation().getBlockZ() != loc.getBlockZ()) {
                                        nomove.remove(p);
                                        p.sendMessage(Data.gc.getPrefix() + "§cDer Teleport-Vorgang wurde beendet, da du dich bewegt hast!");
                                    }
                                }
                                break;
                            case 1:
                                if(p.getLocation().getBlockX() != loc.getBlockX() || p.getLocation().getBlockY() != loc.getBlockY() || p.getLocation().getBlockZ() != loc.getBlockZ()){
                                    nomove.remove(p);
                                    p.sendMessage(Data.gc.getPrefix()+"§cDer Teleport-Vorgang wurde beendet, da du dich bewegt hast!");
                                }

                                if(nomove.contains(p)) {
                                    p.playSound(p.getLocation(), Sound.NOTE_BASS, 1, 1);
                                    p.sendMessage(Data.gc.getPrefix() + "§7Du wirst in §64 Sekunden §7zu deinem Spawn teleportiert!");
                                    for (Player all : Bukkit.getOnlinePlayers()) {
                                        all.playEffect(p.getLocation(), Effect.ENDER_SIGNAL, 1);
                                    }
                                    if (p.getLocation().getBlockX() != loc.getBlockX() || p.getLocation().getBlockY() != loc.getBlockY() || p.getLocation().getBlockZ() != loc.getBlockZ()) {
                                        nomove.remove(p);
                                        p.sendMessage(Data.gc.getPrefix() + "§cDer Teleport-Vorgang wurde beendet, da du dich bewegt hast!");
                                    }
                                }
                                break;
                            case 0:
                                p.teleport(de.jon4x.bedwars.main.Main.getSpawnLocation(p));
                                nomove.remove(p);
                                p.playSound(p.getLocation(), Sound.NOTE_BASS, 1, 1);
                                de.jon4x.bedwars.main.Main.removeInventoryItems(p.getInventory(), Material.FIREWORK, 1);
                                p.sendMessage(Data.gc.getPrefix() + "§aDu wurdest zu deiner Insel teleportiert!");
                                Bukkit.getScheduler().cancelTask(taskID);
                        }
                        count--;
                    }
                }, 0, 20);
            }
        }
    }

    @SuppressWarnings("deprecation")
    public static void teamglass(ArrayList<Player> list, Player p, byte data){
        if(!list.contains(p)){
            p.getLocation().subtract(0.00, 1.00, 0.00).getBlock().setType(Material.AIR);
            p.getWorld().spawnFallingBlock(p.getLocation().subtract(0.00, 1.00, 0.00), Material.STAINED_GLASS, data);
        }
    }
}
