package de.jon4x.bungeesystem.commands;

import de.jon4x.bungeesystem.support.SupportChannel;
import de.jon4x.bungeesystem.support.SupportManager;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PlayerDisconnectEvent;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.event.EventHandler;

public class SupportCommand extends Command {

    public SupportCommand() {
        super("support");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (sender instanceof ProxiedPlayer) {
            ProxiedPlayer p = (ProxiedPlayer) sender;
            if (p.hasPermission("system.support")) {

                if (args.length == 0) {
                    p.sendMessage("§8» §aSupport §8× §cDu kannst als §7Teammitglied nicht den Support benutzen.");
                    return;
                }

                if (args[0].equalsIgnoreCase("accept")) {

                    if (args.length == 1) {
                        p.sendMessage("§8» §aSystem §8× §7Bitte §7nutze §c/support accept <player>");
                        return;
                    }

                    ProxiedPlayer supportedPlayer = ProxyServer.getInstance().getPlayer(args[1]);

                    if (supportedPlayer == null) {
                        p.sendMessage("§8» §aSupport §8× §7Der §7Spieler §e" + args[1] + " §7ist nicht online§7.");
                        return;
                    }

                    if (!SupportManager.getInstance().getSupportQueue().contains(supportedPlayer)) {
                        p.sendMessage("§8» §aSupport §8× §7Der §7Spieler §e" + supportedPlayer.getName() + " §7befindet §7sich §7nicht §7in §7der §7Warteschlange.");
                        return;
                    }

                    if (SupportManager.getInstance().getSupportPlayer().containsKey(p)) {
                        p.sendMessage("§8» §aSupport §8× §7Du §7befindest §7dich §cbereits §7in §7einem §cSupport-Chat§7.");
                        return;
                    }

                    SupportManager.getInstance().getSupportQueue().remove(supportedPlayer);
                    SupportManager.getInstance().getSupportPlayer().put(p, supportedPlayer);

                    supportedPlayer.sendMessage("§8» §aSupport §8× §7Du §7wirst §7nun §7in §7einem §aprivaten §aChat §7betreut.\n§7Supporter §8\u00bb §e" + p.getName());


                } else {
                    if (!args[0].equalsIgnoreCase("finish")) {
                        return;
                    }
                    if (!SupportManager.getInstance().getSupportPlayer().containsKey(p)) {
                        p.sendMessage("§8» §aSupport §8× §7Du §7befindest §7dich §7in §ckeinem §cSupport-Chat§7.");
                        return;
                    }
                    ProxiedPlayer supportedPlayer = SupportManager.getInstance().getSupportPlayer().get(p);
                    SupportManager.getInstance().getSupportPlayer().remove(supportedPlayer);
                    SupportManager.getInstance().getSupportPlayer().remove(p);
                    p.sendMessage("§8» §aSupport §8× §7Der §aSupport-Chat §7wurde §7erfolgreich §7geschlossen.");
                    supportedPlayer.sendMessage("§8» §aSupport §8× §7Der §aSupport-Chat §7wurde §7geschlossen. ");
                }
            }
            else {
                if (args.length == 0) {
                    SupportChannel supportChannel = new SupportChannel(p);
                    supportChannel.sendToTeam();
                    SupportManager.getInstance().getSupportQueue().add(p);
                    p.sendMessage("§8» §aSupport §8× §7Du §7befindest §7dich §7nun §7in §7der §aWarteschlange§7. §7Bitte §7habe §7einen §aMoment §aGeduld§7.");
                }
            }
        }
    }

}
