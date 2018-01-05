package de.jon4x.bedwars.manager;

import de.jon4x.bedwars.storage.Data;
import de.jon4x.bedwars.listener.Voting;
import net.claymc.gameapi.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Pascal Falk on 03.08.2017.
 * Plugin by WeLoveSpigotPlugins
 * https://youtube.com/welovespigotplugins
 * Coded with IntelliJ
 */
public class Spawner {

    private static int run;
    private static ArrayList<Location> bronze = new ArrayList<>();
    private static ArrayList<Location> eisen = new ArrayList<>();
    private static ArrayList<Location> gold = new ArrayList<>();
    private static int eisenspawner;
    private static int goldspawner;

    public static void startSpawning(){
        eisenspawner = 24;
        goldspawner = 51;
        {
            File file = new File("plugins//BedWars//Spawner//bronze.yml");
            YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
            for (int i = 0; i < cfg.getInt(de.jon4x.bedwars.main.Main.playedMap.toLowerCase() + ".Anzahl") + 1; i++) {
                bronze.add(Data.ca.getCustonLocation(file, cfg, de.jon4x.bedwars.main.Main.playedMap.toLowerCase() + "." + i));
            }
        }
        {
            File file = new File("plugins//BedWars//Spawner//eisen.yml");
            YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
            for (int i = 0; i < cfg.getInt(de.jon4x.bedwars.main.Main.playedMap.toLowerCase() + ".Anzahl") + 1; i++) {
                eisen.add(Data.ca.getCustonLocation(file, cfg, de.jon4x.bedwars.main.Main.playedMap.toLowerCase() + "." + i));
            }
        }
        {
            File file = new File("plugins//BedWars//Spawner//gold.yml");
            YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
            for (int i = 0; i < cfg.getInt(de.jon4x.bedwars.main.Main.playedMap.toLowerCase() + ".Anzahl") + 1; i++) {
                gold.add(Data.ca.getCustonLocation(file, cfg, de.jon4x.bedwars.main.Main.playedMap.toLowerCase() + "." + i));
            }
        }
        run = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                eisenspawner--;
                if(eisenspawner == 0){
                    eisenspawner = 24;
                    for(int i = 0 ; i < eisen.size() ; i++){
                        ItemStack a = new ItemStack(Material.IRON_INGOT);
                        ItemMeta am = a.getItemMeta();
                        am.setDisplayName("§7§lEisen");
                        a.setItemMeta(am);
                        Bukkit.getWorld(eisen.get(i).getWorld().getName()).dropItem(eisen.get(i), a);
                        Bukkit.getWorld(eisen.get(i).getWorld().getName()).playEffect(eisen.get(i), Effect.CLOUD, 1);

                    }
                }
                goldspawner--;
                if(goldspawner == 0){
                    if(Voting.gold) {
                        for (int i = 0; i < gold.size(); i++) {
                            ItemStack a = new ItemStack(Material.GOLD_INGOT);
                            ItemMeta am = a.getItemMeta();
                            am.setDisplayName("§6§lGold");
                            a.setItemMeta(am);
                            Bukkit.getWorld(gold.get(i).getWorld().getName()).dropItem(gold.get(i), a);
                        }
                    }
                    goldspawner = 51;
                }
                for(int i = 0 ; i < bronze.size() ; i++){
                    ItemStack a = new ItemStack(Material.CLAY_BRICK);
                    ItemMeta am = a.getItemMeta();
                    am.setDisplayName("§c§lBronze");
                    a.setItemMeta(am);
                    Bukkit.getWorld(bronze.get(i).getWorld().getName()).dropItem(bronze.get(i), a);
                }
            }
        }, 10, 10);

    }

    public static void stopSpawning(){
        if(Bukkit.getScheduler().isCurrentlyRunning(run)){
            Bukkit.getScheduler().cancelTask(run);
        }
    }
}
