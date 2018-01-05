package de.jon4x.lobby.listener;

import de.jon4x.lobby.api.LobbySQL;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;

public class DoubleJump implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        if ((p.getGameMode() != GameMode.CREATIVE || p.getGameMode() != GameMode.SPECTATOR) && (!p.isFlying())) {
            p.setFlying(false);
            if (LobbySQL.getDoubleJump(p.getUniqueId().toString()) == 1) {
                p.setAllowFlight(false);
                return;
            }
            if (p.isOnGround()) {
                p.setAllowFlight(true);
            }
        }
    }

    @EventHandler
    public void onToggleFlight(PlayerToggleFlightEvent e) {
        Player p = e.getPlayer();
        if (p.getGameMode() == GameMode.CREATIVE || p.getGameMode() == GameMode.SPECTATOR) {
            return;
        }
        if (LobbySQL.getDoubleJump(p.getUniqueId().toString()) == 1) {
            e.setCancelled(true);
            p.setAllowFlight(false);
            p.setFlying(false);
            return;
        }
        p.setVelocity(p.getLocation().getDirection().multiply(1.5).setY(1));
        e.setCancelled(true);
        p.setAllowFlight(false);
        p.setFlying(false);
        p.playEffect(p.getLocation(), Effect.SMOKE, 1);
        p.playSound(p.getLocation(), Sound.BAT_TAKEOFF, 0.2f, 1f);
    }

}
