package de.jon4x.bungeesystem.listener;

import de.jon4x.bungeesystem.support.SupportManager;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

import java.util.Map;

public class SupportChatListener implements Listener {

    @EventHandler
    public void onChat(ChatEvent e) {
        ProxiedPlayer p = (ProxiedPlayer)e.getSender();
        if (e.getMessage().startsWith("/")) {
            return;
        }
        if (SupportManager.getInstance().getSupportPlayer().containsKey(p)) {
            e.setCancelled(true);
            ProxiedPlayer supportedPlayer = SupportManager.getInstance().getSupportPlayer().get(p);
            supportedPlayer.sendMessage("§8» §aSupport §8× §c" + p.getName() + " §8➟ §7" + e.getMessage());
            p.sendMessage("§8» §aSupport §8× §a" + p.getName() + " §8➟ §7" + e.getMessage());
        }
        if (SupportManager.getInstance().getSupportPlayer().containsValue(p)) {
            e.setCancelled(true);
            ProxiedPlayer supporter = (ProxiedPlayer) getKeyFromValue(SupportManager.getInstance().getSupportPlayer(), p);
            supporter.sendMessage("§8» §aSupport §8× §c" + p.getName() + " §8➟ §7" + e.getMessage());
            p.sendMessage("§8» §aSupport §8× §a" + p.getName() + " §8➟ §7" + e.getMessage());
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
