package de.jon4x.bungeesystem;

import de.jon4x.bungeesystem.commands.*;
import de.jon4x.bungeesystem.commands.bansystem.*;
import de.jon4x.bungeesystem.listener.SupportChatListener;
import de.jon4x.bungeesystem.listener.SupportDisconnectListener;
import de.jon4x.bungeesystem.listener.bansystem.ChatListener;
import de.jon4x.bungeesystem.listener.bansystem.JoinListener;
import de.jon4x.bungeesystem.sql.MySQL;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.api.plugin.PluginManager;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Main extends Plugin {

    private static MySQL mySQL;
    private String host = "127.0.0.1", database = "bungee", user = "bungee", password = "4677c731a761a7aa94f7799ec5b34661";

    public static String getPrefix() {
        return "§8» §aSystem §8× ";
    }

    public static String banPrefix() {
        return "§8» §4BanSystem §8× ";
    }

    // Enable
    @Override
    public void onEnable() {
        // Start MySQL
        startSQL();

        // Define PluginManager
        PluginManager pm = getProxy().getPluginManager();
        // Register Commands
        registerCommands(pm);
        // Register Listener
        registerListener(pm);
    }

    // Disable
    @Override
    public void onDisable() {
        mySQL.disconnect();
    }

    // Register Commands
    private void registerCommands(PluginManager pluginManager) {
        pluginManager.registerCommand(this, new HelpCommand());
        pluginManager.registerCommand(this, new SupportCommand());
        pluginManager.registerCommand(this, new TeamCommand());
        pluginManager.registerCommand(this, new PingCommand());
        pluginManager.registerCommand(this, new WhereamiCommand());
        pluginManager.registerCommand(this, new BewerbenCommand());
        pluginManager.registerCommand(this, new BroadcastCommand());
        pluginManager.registerCommand(this, new RangCommand());
        pluginManager.registerCommand(this, new TeamspeakCommand());
        pluginManager.registerCommand(this, new PluginCommand());

        pluginManager.registerCommand(this, new TempbanCommand());
        pluginManager.registerCommand(this, new BanCommand());
        pluginManager.registerCommand(this, new TempmuteCommand());
        pluginManager.registerCommand(this, new MuteCommand());
        pluginManager.registerCommand(this, new UnmuteCommand());
        pluginManager.registerCommand(this, new UnbanCommand());
        pluginManager.registerCommand(this, new CheckCommand());
    }

    // Register Listener
    private void registerListener(PluginManager pluginManager) {
        pluginManager.registerListener(this, new SupportChatListener());
        pluginManager.registerListener(this, new SupportDisconnectListener());
        pluginManager.registerListener(this, new JoinListener());
        pluginManager.registerListener(this, new ChatListener());
    }

    // MySQL
    private void startSQL() {
        mySQL = new MySQL(host, database, user, password);
        mySQL.connect();
        mySQL.createTable();
    }

    public static MySQL getMySQL() {
        return mySQL;
    }
}
