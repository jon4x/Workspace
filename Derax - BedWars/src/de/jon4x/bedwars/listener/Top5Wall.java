package de.jon4x.bedwars.listener;

import net.spigotplugins.gameapi.manager.StatsAPI;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.SkullType;
import org.bukkit.block.BlockState;
import org.bukkit.block.Sign;
import org.bukkit.block.Skull;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pascal Falk on 05.08.2017.
 * Plugin by WeLoveSpigotPlugins
 * https://youtube.com/welovespigotplugins
 * Coded with IntelliJ
 */
public class Top5Wall {
    public static void set() {

        Location loc1 = new Location(Bukkit.getWorld("world"), -97D, 48D, 81D);
        Location loc2 = new Location(Bukkit.getWorld("world"), -97D, 48D, 80D);
        Location loc3 = new Location(Bukkit.getWorld("world"), -97D, 48D, 79D);
        Location loc4 = new Location(Bukkit.getWorld("world"), -97D, 48D, 78D);
        Location loc5 = new Location(Bukkit.getWorld("world"), -97D, 48D, 77D);

        List<Location> LOC = new ArrayList();
        LOC.add(loc1);
        LOC.add(loc2);
        LOC.add(loc3);
        LOC.add(loc4);
        LOC.add(loc5);
        for (int i = 0; i < LOC.size(); i++){
            int id = i + 1;
            String name = new StatsAPI().getNameRankByID("BEDWARS", "WINS", id);
            Skull skull = ( Skull ) LOC.get(i).getBlock().getState();
            skull.setSkullType( SkullType.PLAYER);
            skull.setOwner( name );
            skull.update();
            Location sloc = new Location(((Location)LOC.get(i)).getWorld(), ((Location)LOC.get(i)).getX() + 1, ((Location)LOC.get(i)).getBlockY() - 1, ((Location)LOC.get(i)).getZ());
            if ((sloc.getBlock().getState() instanceof Sign)){
                BlockState b = sloc.getBlock().getState();
                Sign Sign = (Sign)b;
                Sign.setLine(0, "Platz " + id);
                Sign.setLine(1, "§o" + name);
                Sign.setLine(2, "§e§m---------");
                Sign.setLine(3, "Siege: " + new StatsAPI().getInt(new StatsAPI().getUUIDRankByID("BEDWARS", "WINS", id), "BEDWARS", "WINS"));
                Sign.update();
            }
        }
    }
}
