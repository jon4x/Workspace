package de.jon4x.bungeesystem.support;

import net.md_5.bungee.api.connection.*;
import net.md_5.bungee.api.*;
import net.md_5.bungee.api.chat.*;

public class SupportChannel
{
    private ProxiedPlayer player;

    public SupportChannel(ProxiedPlayer player) {
        this.player = player;
    }

    public void sendToTeam() {
        for (final ProxiedPlayer p : ProxyServer.getInstance().getPlayers()) {
            if (p.hasPermission("support.chat")) {
                TextComponent tc = new TextComponent();
                tc.setColor(ChatColor.GREEN);
                tc.setText("[ANNEHMEN]");
                tc.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§cKlicken um zu supporten.").create()));
                tc.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/support accept " + this.player.getName()));
                TextComponent realTc = new TextComponent("§8» §aSupport §8× §7Der §7Spieler §e" + this.player.getName() + " §7benötigt §aHilfe.\n");
                realTc.addExtra(tc);
                p.sendMessage(realTc);
            }
        }
    }

}
