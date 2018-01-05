package de.jon4x.lobby.commands;

import net.minecraft.server.v1_8_R3.Entity;
import net.minecraft.server.v1_8_R3.NBTTagCompound;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftEntity;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;


public class SpawnVillagerCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            spawnVillager(p.getLocation());
        } else
            sender.sendMessage("§cYou have to be a Player to execute this command!");
        return false;
    }

    public static void spawnVillager(Location location) {
        Villager v = (Villager) location.getWorld().spawnCreature(location, CreatureType.VILLAGER);
        v.setCustomName("§7» §6§lTägliche Belohnung §7«");
        v.setCustomNameVisible(true);
        v.setProfession(Villager.Profession.LIBRARIAN);
        freezeEntity(v);
    }

    public static void freezeEntity(org.bukkit.entity.Entity entity) {
        Entity nmsEn = ((CraftEntity) entity).getHandle();
        NBTTagCompound compound = new NBTTagCompound();
        nmsEn.c(compound);
        compound.setByte("NoAI", (byte) 1);
        nmsEn.f(compound);
    }
}
