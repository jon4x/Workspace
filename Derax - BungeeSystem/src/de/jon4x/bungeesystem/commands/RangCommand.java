package de.jon4x.bungeesystem.commands;

import de.jon4x.bungeesystem.Main;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class RangCommand extends Command {

    public RangCommand() {
        super("rang", "system.admin");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (sender.hasPermission("system.admin")) {
            if (args.length < 3) {
                sender.sendMessage("§7Bitte nutze §c/rang <player> group <group> [days]");
                return;
            }
            if (args.length == 3) {
                String target = args[0], group = args[2];
                TextComponent tc = new TextComponent();
                tc.setColor(ChatColor.GREEN);
                tc.setText("[RICHTIG]");
                tc.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§cKlicken um Rang zu vergeben.").create()));
                tc.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/cperms user " + target + " group set " + group + " lifetime"));
                TextComponent realTc = new TextComponent("§7Der §7Spieler §e" + target + " §7soll in die Gruppe §c" + group + "\n\n§7Stimmt das? ");
                realTc.addExtra(tc);
                sender.sendMessage(realTc);
                return;
            }
            if (args.length == 4) {
                String target = args[0], group = args[2], days = args[3];
                TextComponent tc = new TextComponent();
                tc.setColor(ChatColor.GREEN);
                tc.setText("[RICHTIG]");
                tc.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§cKlicken um Rang zu vergeben.").create()));
                tc.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/cperms user " + target + " group set " + group + " " + days));
                TextComponent realTc = new TextComponent("§7Der §7Spieler §e" + target + " §7soll in die Gruppe §c" + group + " §7für §a" + days + " Tage\n\n§7Stimmt das? ");
                realTc.addExtra(tc);
                sender.sendMessage(realTc);
                return;
            }
        }
    }
}
