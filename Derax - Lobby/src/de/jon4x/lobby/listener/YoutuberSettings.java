package de.jon4x.lobby.listener;

import de.jon4x.lobby.Main;
import de.jon4x.lobby.itemmanager.ItemManager;
import de.jon4x.lobby.methods.Inventories;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.HashMap;
import java.util.UUID;

public class YoutuberSettings implements Listener {

    private HashMap<UUID, Long> cooldown = new HashMap<>();

    @EventHandler
    public void onInteract (PlayerInteractEvent e) {
        Player p = e.getPlayer();
        ItemStack i = p.getItemInHand();
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
            if (ItemManager.get(i, Material.TNT, "§8× §5VIP-Einstellungen §7(Rechtsklick)")) {
                Inventories.openYTSettings(p);
            }
        }
        else {
            return;
        }
    }

    @EventHandler
    public void onYTSettingsClick (InventoryClickEvent e) {
        int cooldownTime = 2;
        Player p = (Player) e.getWhoClicked();
        ItemStack i = e.getCurrentItem();
        if (e.getClickedInventory() != null) {
            if (e.getClickedInventory().getName().equalsIgnoreCase("§8× §5§lVIP-Einstellungen §8»")) {
                if (i != null) {
                    if (i.getType() == Material.AIR)
                        return;

                    else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§9Schutzschild")) {
                        if (!p.hasPermission("shield.use")) {
                            p.closeInventory();
                            p.sendMessage(Main.getPrefix() + "§cDazu hast du keine Berechtigung");
                            p.playSound(p.getLocation(), Sound.ANVIL_LAND, 0.5f, 1.0f);
                            return;
                        }
                        if (cooldown.containsKey(p.getUniqueId())) {
                            long secondsLeft = ((cooldown.get(p.getUniqueId())/1000)+cooldownTime) - (System.currentTimeMillis()/1000);
                            if (secondsLeft > 0) {
                                p.sendMessage(Main.getPrefix() + "§cBitte habe einen moment Geduld!");
                                return;
                            }
                        }
                        cooldown.put(p.getUniqueId(), System.currentTimeMillis());
                        if (!Main.getInstance().getShieldList().contains(p.getUniqueId())) {
                            Main.getInstance().getShieldList().add(p.getUniqueId());
                            p.getOpenInventory().setItem(6 + 9 * 2, ItemManager.createItem(Material.INK_SACK, 1, 10, "§a✔ §8× §aAktiviert", null));
                            p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 0.5f, 2.0f);
                            Main.Shield.put(p.getName(), new BukkitRunnable() {
                                @Override
                                public void run() {

                                    for (int i = 0; i <= 10; i++)
                                        p.getWorld().playEffect(p.getLocation().subtract(0, 0.5, 0), Effect.SMOKE, i);

                                    for (final Entity entity : p.getNearbyEntities(2.5, 2.5, 2.5)) {
                                        if (entity instanceof Player) {
                                            Player target = (Player) entity;
                                            double ax = p.getLocation().getX();
                                            double ay = p.getLocation().getY();
                                            double az = p.getLocation().getZ();
                                            double bx = target.getLocation().getX();
                                            double by = target.getLocation().getY();
                                            double bz = target.getLocation().getZ();
                                            double x = bx - ax;
                                            double y = by - ay;
                                            double z = bz - az;
                                            Vector v = new Vector(x, y, z).normalize().multiply(1.0).setY(0.5);
                                            if (target.hasPermission("shield.use")) {
                                                continue;
                                            }
                                            target.setVelocity(v);
                                        }
                                    }
                                }
                            });
                            Main.Shield.get(p.getName()).runTaskTimer(Main.getInstance(), 0L, 2L);
                        }
                        else if (Main.getInstance().getShieldList().contains(p.getUniqueId())) {
                            Main.getInstance().getShieldList().remove(p.getUniqueId());
                            p.getOpenInventory().setItem(6 + 9 * 2, ItemManager.createItem(Material.INK_SACK, 1, 1, "§c✘ §8× §cDeaktiviert", null));
                            p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 0.5f, 2.0f);
                            Main.Shield.get(p.getName()).cancel();
                            Main.Shield.remove(p.getName());
                        }
                    }
                }
            }
        }
    }
}
