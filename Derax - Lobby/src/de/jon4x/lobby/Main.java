package de.jon4x.lobby;

import com.google.common.collect.Sets;
import de.jon4x.lobby.api.LobbySQL;
import de.jon4x.lobby.commands.*;
import de.jon4x.lobby.listener.*;
import de.jon4x.lobby.sql.MySQL;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.block.Biome;
import org.bukkit.entity.*;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.*;

public class Main extends JavaPlugin {

    private static Main instance;
    private Set<UUID> BuildList, ShieldList, HideAll, HideVIP;
    private Set<UUID> chatDisabled;
    private Set<UUID> Teleporter, Settings, ytSettings, Profil, Reward;
    private Location Spawn;
    private Location Knockout;
    private Location BedWars;
    private Location Community;
    private Location Daily;
    private Villager Villager;
    private static String host, datenbank, user, password;
    public static Map<String, BukkitRunnable> Shield;
    private static String prefix = "§8» §6Lobby §8× ";

    public static String getPrefix() {
        return prefix;
    }

    @Override
    public void onEnable() {
        instance = this;
        // Locations
        Daily = new Location(getServer().getWorld("world"), 85.5, 21, 109.5, 269.5f, 0.65f);
        Community = new Location(getServer().getWorld("world"), -161.5, 4, 295.5, 89.5f, -4.65f);
        BedWars = new Location(getServer().getWorld("world"), -40.5, 4, 286.5, 10.84f, 2.55f);
        Knockout = new Location(getServer().getWorld("world"), -64.5, 4, 263.5, 118.5f, -1.05f);
        Spawn = new Location(getServer().getWorld("world"), 3.5, 13.0, -3.5, -3.5f, 3.3f);
        // HashMaps
        Shield = new HashMap<>();
        // MySQL
        host = getConfig().getString("config.mysql.host"); datenbank = getConfig().getString("config.mysql.database"); user = getConfig().getString("config.mysql.user"); password = getConfig().getString("config.mysql.password");
        // HashSets
        ShieldList = Sets.newHashSet(); Reward = Sets.newHashSet(); Profil = Sets.newHashSet(); chatDisabled = Sets.newHashSet(); ytSettings = Sets.newHashSet(); Settings = Sets.newHashSet();
        Teleporter = Sets.newHashSet(); BuildList = Sets.newHashSet(); HideAll = Sets.newHashSet(); HideVIP = Sets.newHashSet();

        getServer().getWorld("world").setBiome(10000, 10000, Biome.BEACH);
        getServer().getWorld("world").setTime(13000);
        getServer().getWorld("world").setThundering(false);

        loadConfig();
        resetReward();
        MySQL.connect();
        Bukkit.getConsoleSender().sendMessage(getPrefix() + "§aPlugin wurde erfolgreich gestartet!");


        // Register Commands
        getCommand("giveaway").setExecutor(new GiveawayCommand());
        getCommand("spawnvillager").setExecutor(new SpawnVillagerCommand());
        getCommand("getpos").setExecutor(new GetPosCommand());
        getCommand("gm").setExecutor(new GamemodeCommand());
        getCommand("build").setExecutor(new BuildCommand());
        getCommand("addcoins").setExecutor(new AddCoinsCommand());
        getCommand("getcoins").setExecutor(new GetCoinsCommand());
        getCommand("rmcoins").setExecutor(new RemoveCoinsCommand());

        // Register Events
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new JumpPads(), this);
        pm.registerEvents(new DoubleJump(), this);
        pm.registerEvents(new YoutuberSettings(), this);
        pm.registerEvents(new PlayerLogin(), this);
        pm.registerEvents(new DailyReward(), this);
        pm.registerEvents(new PlayerChat(), this);
        pm.registerEvents(new Settings(), this);
        pm.registerEvents(new Profil(), this);
        pm.registerEvents(new Teleporter(), this);
        pm.registerEvents(new Gadgets(), this);
        pm.registerEvents(new HidePlayers(), this);
        pm.registerEvents(new PlayerQuit(), this);
        pm.registerEvents(new PlayerJoin(), this);
        pm.registerEvents(new Protect(), this);

    }

    @Override
    public void onDisable() {
        getVillager().remove();
        Main.Shield.get("BuilderArea").cancel();
        Bukkit.getConsoleSender().sendMessage(getPrefix() + "§cPlugin wurde erfolgreich beendet!");
    }

    private void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

    private void resetReward() {
        Bukkit.getScheduler().scheduleAsyncDelayedTask(this, () -> {
            Calendar c = Calendar.getInstance();
            if (c.getTime().getHours() == 0
                    && c.getTime().getMinutes() == 0) {
                MySQL.query("DELETE from rewardTable");
            }
            resetReward();
        }, 1200);
    }


    public static Main getInstance() {
        return instance;
    }

    public Set<UUID> getBuildList() {
        return BuildList;
    }

    public Location getSpawn() {
        return Spawn;
    }

    public Set<UUID> getTeleporter() {
        return Teleporter;
    }

    public Set<UUID> getSettings() {
        return Settings;
    }

    public Set<UUID> getYtSettings() {
        return ytSettings;
    }

    public static String getHost() {
        return host;
    }

    public static String getDatenbank() {
        return datenbank;
    }

    public static String getUser() {
        return user;
    }

    public static String getPassword() {
        return password;
    }

    public Set<UUID> getChatDisabled() {
        return chatDisabled;
    }

    public Location getKnockout() {
        return Knockout;
    }

    public Location getBedWars() {
        return BedWars;
    }

    public Location getDaily() {
        return Daily;
    }

    public Location getCommunity() {
        return Community;
    }

    public Set<UUID> getProfil() {
        return Profil;
    }

    public Set<UUID> getReward() {
        return Reward;
    }

    public Set<UUID> getShieldList() {
        return ShieldList;
    }

    public Set<UUID> getHideAll() {
        return HideAll;
    }

    public Set<UUID> getHideVIP() {
        return HideVIP;
    }

    public Villager getVillager() {
        return Villager;
    }

    public void setVillager(Villager Villager) {
        this.Villager = Villager;
    }
}

