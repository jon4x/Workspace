package de.jon4x.chatsystem;

import de.jon4x.chatsystem.commands.ClearChatCommand;
import de.jon4x.chatsystem.listener.PlayerChat;
import de.jon4x.chatsystem.listener.PlayerJoin;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;

public class main extends JavaPlugin {

    private static main instance;
    private static String prefix = "§8» §6ChatSystem §8× ";
    private Scoreboard sb;

    @Override
    public void onEnable() {
        instance = this;
        sb = Bukkit.getScoreboardManager().getNewScoreboard();
        Bukkit.getConsoleSender().sendMessage(getPrefix() + "§aPlugin wurde erfolgreich gestartet!");

        // Commands
        getCommand("clearchat").setExecutor(new ClearChatCommand());

        // Events
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new PlayerChat(), this);
        pm.registerEvents(new PlayerJoin(), this);

        // Scoreboard
        sb.registerNewTeam("000Admin"); sb.registerNewTeam("001Manager"); sb.registerNewTeam("002Dev"); sb.registerNewTeam("003Mod"); sb.registerNewTeam("004Sup");
        sb.registerNewTeam("005Build"); sb.registerNewTeam("006YT"); sb.registerNewTeam("007Prem+"); sb.registerNewTeam("008Prem"); sb.registerNewTeam("009Spieler");

        sb.getTeam("000Admin").setPrefix("§4Admin §8× §7");
        sb.getTeam("001Manager").setPrefix("§cManager §8× §7");
        sb.getTeam("002Dev").setPrefix("§bDev §8× §7");
        sb.getTeam("003Mod").setPrefix("§cMod §8× §7");
        sb.getTeam("004Sup").setPrefix("§9Sup §8× §7");
        sb.getTeam("005Build").setPrefix("§aB §8× §7");
        sb.getTeam("006YT").setPrefix("§5");
        sb.getTeam("007Prem+").setPrefix("§e");
        sb.getTeam("008Prem").setPrefix("§6");
        sb.getTeam("009Spieler").setPrefix("§7");
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(getPrefix() + "§aPlugin wurde erfolgreich beendet!");
    }

    public static main getInstance() {
        return instance;
    }

    public static String getPrefix() {
        return prefix;
    }

    public Scoreboard getSb() {
        return sb;
    }
}
