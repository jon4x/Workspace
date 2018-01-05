package de.jon4x.lobby.commands;

import de.jon4x.lobby.Main;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.UUID;

public class BuildCommand implements CommandExecutor {

    HashMap<UUID, ItemStack[]> inv = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (!Main.getInstance().getBuildList().contains(p.getUniqueId())) {
                Main.getInstance().getBuildList().add(p.getUniqueId());
                inv.put(p.getUniqueId(), p.getInventory().getContents());
                p.getInventory().clear();
                p.setGameMode(GameMode.CREATIVE);
                p.sendMessage(Main.getPrefix() + "§aSie können nun bauen!");
            }
            else {
                Main.getInstance().getBuildList().remove(p.getUniqueId());
                p.getInventory().clear();
                ItemStack[] itemStacks = inv.get(p.getUniqueId());
                p.getInventory().setContents(itemStacks);
                p.setGameMode(GameMode.ADVENTURE);
                p.sendMessage(Main.getPrefix() + "§cSie können nicht länger bauen!");
                inv.remove(p.getUniqueId());
            }
        } else
            sender.sendMessage(Main.getPrefix() + "§cYou have to be a Player to execute this command!");
        return false;
    }
}
