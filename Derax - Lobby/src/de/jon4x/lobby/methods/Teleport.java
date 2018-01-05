package de.jon4x.lobby.methods;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Teleport {

    public static void doTeleport (Location loc, Player p) {
        p.closeInventory();
        p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20, 5));
        p.teleport(loc);
        p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, 0.3F, 1.5F);
        p.playEffect(p.getLocation(), Effect.ENDER_SIGNAL, 1);
    }

}
