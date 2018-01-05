package de.jon4x.bedwars.listener;

import org.apache.commons.io.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;

import java.io.File;
import java.io.IOException;

/**
 * Created by Pascal Falk on 04.08.2017.
 * Plugin by WeLoveSpigotPlugins
 * https://youtube.com/welovespigotplugins
 * Coded with IntelliJ
 */
public class MapResetAPI {
    public static World resetWorld (File backup, File toReset , String worldname) {
        Bukkit.getServer().unloadWorld(worldname, true);
        try {
            FileUtils.deleteDirectory(toReset);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(!toReset.exists()) {
            try {
                FileUtils.copyDirectory(backup , toReset);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        World w  = Bukkit.createWorld(new WorldCreator(worldname));
        return w;
    }
}
