package de.jon4x.bedwars.storage;

import net.claymc.gameapi.api.ConfigAPI;
import net.claymc.gameapi.api.GameAPI;
import net.claymc.gameapi.api.GameConfiguration;
import net.claymc.gameapi.api.StringAPI;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import sun.security.krb5.Config;

/**
 * Created by Pascal Falk on 03.08.2017.
 * Plugin by WeLoveSpigotPlugins
 * https://youtube.com/welovespigotplugins
 * Coded with IntelliJ
 */
public class Data {

    public static Location spawn = new Location(Bukkit.getWorld("world"), 112.5, 122, 41.54, 0, 0);

    public static String mode;

    public static GameAPI ga = new GameAPI();
    public static ConfigAPI ca = new ConfigAPI();
    public static StringAPI sa = new StringAPI();
    public static GameConfiguration gc = GameAPI.gameConfiguration;

}
