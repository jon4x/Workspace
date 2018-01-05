package de.jon4x.bungeesystem.commands;

import de.jon4x.bungeesystem.Main;
import de.jon4x.bungeesystem.ban.TeamManager;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class BewerbenCommand extends Command {

    public BewerbenCommand() {
        super("bewerben", null, "apply");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (sender instanceof ProxiedPlayer) {
            ProxiedPlayer p = (ProxiedPlayer) sender;
            if (TeamManager.isInTeam(p.getUniqueId().toString())) {
                p.sendMessage(Main.getPrefix() + "§cDu bist bereits ein Teammitglied!");
            }
            else {
                p.sendMessage(Main.getPrefix() + "§7Du kannst dich in unserem Forum §ahttp://derax.net/forum §7bewerben!");
            }
        }
    }
}
