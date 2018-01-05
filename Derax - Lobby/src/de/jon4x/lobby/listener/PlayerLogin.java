package de.jon4x.lobby.listener;

import de.jon4x.lobby.sql.MySQL;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;

public class PlayerLogin implements Listener {

    @EventHandler
    public void onLogin (AsyncPlayerPreLoginEvent e) {
        if (MySQL.isConnected() == false) {
            String kick  =  "\n§7Es konnte keine Verbindung zur MySQL-Datenbank hergestellt werden!\n" +
                            "§7Bitte wende dich an einen §4Administrator §7oder einen §bDeveloper\n\n" +
                            "§7TeamSpeak §8\u00bb §cDerax.net";
            e.disallow(AsyncPlayerPreLoginEvent.Result.KICK_FULL, kick);
        }
    }
}
