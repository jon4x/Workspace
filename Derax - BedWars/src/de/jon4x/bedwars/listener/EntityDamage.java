package de.jon4x.bedwars.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

/**
 * Created by Pascal Falk on 04.08.2017.
 * Plugin by WeLoveSpigotPlugins
 * https://youtube.com/welovespigotplugins
 * Coded with IntelliJ
 */
public class EntityDamage implements Listener {

    @EventHandler(ignoreCancelled = true)
    public void onEntity(EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
            if(DeathListener.spectator.contains(e.getDamager())){
                e.setCancelled(true);
                return;
            }
            if(DeathListener.spectator.contains(e.getEntity())){
                e.setCancelled(true);
                return;
            }
            Player p = (Player) e.getEntity();
            Player k = (Player) e.getDamager();
            if(TeamAuswahl.team_GRAU.contains(p) && TeamAuswahl.team_GRAU.contains(k)){
                e.setCancelled(true);
            }
            if(TeamAuswahl.team_SCHWARZ.contains(p) && TeamAuswahl.team_SCHWARZ.contains(k)){
                e.setCancelled(true);
            }
            if(TeamAuswahl.team_GRÜN.contains(p) && TeamAuswahl.team_GRÜN.contains(k)){
                e.setCancelled(true);
            }
            if(TeamAuswahl.team_GELB.contains(p) && TeamAuswahl.team_GELB.contains(k)){
                e.setCancelled(true);
            }
            if(TeamAuswahl.team_ROT.contains(p) && TeamAuswahl.team_ROT.contains(k)){
                e.setCancelled(true);
            }
            if(TeamAuswahl.team_PINK.contains(p) && TeamAuswahl.team_PINK.contains(k)){
                e.setCancelled(true);
            }
            if(TeamAuswahl.team_ORANGE.contains(p) && TeamAuswahl.team_ORANGE.contains(k)){
                e.setCancelled(true);
            }
            if(TeamAuswahl.team_BLAU.contains(p) && TeamAuswahl.team_BLAU.contains(k)){
                e.setCancelled(true);
            }
        }
    }
}
