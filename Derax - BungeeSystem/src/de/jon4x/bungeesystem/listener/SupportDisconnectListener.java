package de.jon4x.bungeesystem.listener;

import de.jon4x.bungeesystem.support.SupportManager;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PlayerDisconnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

import java.util.Map;

public class SupportDisconnectListener implements Listener {

    @EventHandler
    public void onPlayerDisconnect(final PlayerDisconnectEvent e) {
        ProxiedPlayer p = e.getPlayer();
        if (SupportManager.getInstance().getSupportPlayer().containsKey(p) && p.hasPermission("support")) {
            ProxiedPlayer SupportPlayer = SupportManager.getInstance().getSupportPlayer().get(p);
            SupportManager.getInstance().getSupportPlayer().remove(p);
            SupportManager.getInstance().getSupportPlayer().remove(SupportPlayer);
            SupportPlayer.sendMessage("§8» §aSupport §8× §cDer Supporter hat den Server verlassen, der Support wurde somit abgebrochen!");
        }
        else if (SupportManager.getInstance().getSupportPlayer().containsValue(p)) {
            ProxiedPlayer Supporter = (ProxiedPlayer) getKeyFromValue(SupportManager.getInstance().getSupportPlayer(), p);
            SupportManager.getInstance().getSupportPlayer().remove(p);
            SupportManager.getInstance().getSupportPlayer().remove(Supporter);
            Supporter.sendMessage("§8» §aSupport §8× §cDer Spieler hat den Server verlassen, der Support wurde somit abgebrochen!");
        }
        if (SupportManager.getInstance().getSupportQueue().contains(p)) {
            SupportManager.getInstance().getSupportQueue().remove(p);
        }
    }

    private Object getKeyFromValue(final Map hm, final Object value) {
        for (final Object o : hm.keySet()) {
            if (hm.get(o).equals(value)) {
                return o;
            }
        }
        return null;
    }

}
