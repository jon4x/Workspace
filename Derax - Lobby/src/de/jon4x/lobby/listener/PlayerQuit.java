package de.jon4x.lobby.listener;

import de.jon4x.lobby.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener {

    @EventHandler
    public void QuitMessage(PlayerQuitEvent e) {
        Player p = e.getPlayer();

        if (Main.Shield.containsKey(p.getName()))
            Main.Shield.get(p.getName()).cancel();

        if (Main.getInstance().getBuildList().contains(p.getUniqueId()))
            Main.getInstance().getBuildList().remove(p.getUniqueId());
        if (Main.getInstance().getTeleporter().contains(p.getUniqueId()))
            Main.getInstance().getTeleporter().remove(p.getUniqueId());
        if (Main.getInstance().getSettings().contains(p.getUniqueId()))
            Main.getInstance().getSettings().remove(p.getUniqueId());
        if (Main.getInstance().getYtSettings().contains(p.getUniqueId()))
            Main.getInstance().getYtSettings().remove(p.getUniqueId());
        if (Main.getInstance().getChatDisabled().contains(p.getUniqueId()))
            Main.getInstance().getChatDisabled().remove(p.getUniqueId());
        if (Main.getInstance().getProfil().contains(p.getUniqueId()))
            Main.getInstance().getProfil().remove(p.getUniqueId());
        if (Main.getInstance().getShieldList().contains(p.getUniqueId()))
            Main.getInstance().getShieldList().remove(p.getUniqueId());
        if (Main.getInstance().getHideAll().contains(p.getUniqueId()))
            Main.getInstance().getHideAll().add(p.getUniqueId());
        if (Main.getInstance().getHideVIP().contains(p.getUniqueId()))
            Main.getInstance().getHideVIP().remove(p.getUniqueId());

        e.setQuitMessage(null);
    }
}
