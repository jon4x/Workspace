package de.jon4x.bedwars.listener;

import de.jon4x.bedwars.storage.Data;
import net.claymc.gameapi.api.GameState;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * Created by Pascal Falk on 03.08.2017.
 * Plugin by WeLoveSpigotPlugins
 * https://youtube.com/welovespigotplugins
 * Coded with IntelliJ
 */
public class SpielVerlassen implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e){
        if(e.getItem() != null) {
            if (e.getItem().getType() == Material.MAGMA_CREAM) {
                if (Data.ga.gs == GameState.LOBBY || Data.ga.gs == GameState.INGAME || Data.ga.gs == GameState.ENDING) {
                    e.getPlayer().kickPlayer(Data.gc.getPrefix() + "§7Du hast das Spiel verlassen!");
                }
            }
        }
    }
}
