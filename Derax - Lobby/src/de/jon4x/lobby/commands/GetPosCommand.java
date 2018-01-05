package de.jon4x.lobby.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GetPosCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            Location loc = p.getLocation();
            p.sendMessage("\n§8§l× §e§lDerzeitige Position §8§l×\n" + "§6X §8» §7" + loc.getX() + "\n§6Y §8» §7" + loc.getY() + "\n§6Z §8» §7" + loc.getZ() + "\n§6Yaw §8» §7" + loc.getYaw() + "\n§6Pitch §8» §7" + loc.getPitch() + "\n");
        }
        return false;
    }
}
