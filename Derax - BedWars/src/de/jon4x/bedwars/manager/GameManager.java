package de.jon4x.bedwars.manager;

import de.dytanic.cloudnet.bridge.CloudServer;
import de.dytanic.cloudnet.lib.server.ServerState;

import java.util.HashMap;

/**
 * Created by Pascal Falk on 04.08.2017.
 * Plugin by WeLoveSpigotPlugins
 * https://youtube.com/welovespigotplugins
 * Coded with IntelliJ
 */
public class GameManager {

    public static HashMap<String, Boolean> availableTeams = new HashMap<>();

    public static void updateGameMode(ServerState serverState)
    {
        CloudServer.getInstance().setServerState(serverState); //The ServerState can changed to ingame without a new server auto startup
        CloudServer.getInstance().update(); //Update the ServerInfo of CloudNet. Alternative is the setXXXXandUpdate(); method for the auto invokation
    }

}
