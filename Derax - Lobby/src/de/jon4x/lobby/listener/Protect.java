package de.jon4x.lobby.listener;

import de.jon4x.lobby.Main;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.*;
import org.bukkit.event.entity.*;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.*;
import org.bukkit.event.weather.WeatherChangeEvent;

public class Protect implements Listener {

    @EventHandler
    public void onBreak (BlockBreakEvent e) {
        Player p = e.getPlayer();
        if (Main.getInstance().getBuildList().contains(p.getUniqueId())) {
            e.setCancelled(false);
        } else
            e.setCancelled(true);
    }

    @EventHandler
    public void onPlace (BlockPlaceEvent e) {
        Player p = e.getPlayer();
        if (Main.getInstance().getBuildList().contains(p.getUniqueId())) {
            e.setCancelled(false);
        } else
            e.setCancelled(true);
    }

    @EventHandler
    public void onPickup (PlayerPickupItemEvent e) {
        Player p = e.getPlayer();
        if (Main.getInstance().getBuildList().contains(p.getUniqueId())) {
            e.setCancelled(false);
        } else
            e.setCancelled(true);
    }

    @EventHandler
    public void onDrop (PlayerDropItemEvent e) {
        Player p = e.getPlayer();
        if (Main.getInstance().getBuildList().contains(p.getUniqueId())) {
            e.setCancelled(false);
        } else
            e.setCancelled(true);
    }

    @EventHandler
    public void onInvInteract (InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (Main.getInstance().getBuildList().contains(p.getUniqueId())) {
            e.setCancelled(false);
        } else
            e.setCancelled(true);
    }

    @EventHandler
    public void onEat (PlayerItemConsumeEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onHunger (FoodLevelChangeEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onMobInteract (EntityDamageByEntityEvent e) {
        Player p = (Player) e.getDamager();
        if (Main.getInstance().getBuildList().contains(p.getUniqueId())) {
            e.setCancelled(false);
        } else {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onDamage (EntityDamageEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onExplode (EntityExplodeEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onBlockExplode (BlockExplodeEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onMobSpawn (CreatureSpawnEvent e) {
        if (e.getCreatureType() == CreatureType.VILLAGER) {
            e.setCancelled(false);
        } else {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onWeather(WeatherChangeEvent e) {
        if (e.getWorld().getName().equalsIgnoreCase("world")) {
            e.getWorld().setThundering(false);
        }
        e.setCancelled(true);
    }


    @EventHandler
    public void onProjectile (ProjectileLaunchEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onDecay (LeavesDecayEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onSpread (BlockSpreadEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onBead (PlayerBedEnterEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onInteractAt(PlayerInteractAtEntityEvent e) {
        Player p = e.getPlayer();
        if (!Main.getInstance().getBuildList().contains(p.getUniqueId())) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Block B = e.getClickedBlock();
        Player p = e.getPlayer();
        if (Main.getInstance().getBuildList().contains(p.getUniqueId())) {
            e.setCancelled(false);
            return;
        }
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK && (B.getType() == Material.STONE_BUTTON || B.getType() == Material.WOOD_BUTTON || B.getType() == Material.ARMOR_STAND || B.getType() == Material.ITEM_FRAME || B.getType() == Material.ENDER_CHEST || B.getType() == Material.SPRUCE_DOOR || B.getType() == Material.FURNACE || B.getType() == Material.WORKBENCH || B.getType() == Material.DAYLIGHT_DETECTOR || B.getType() == Material.LEVER || B.getType() == Material.TRAPPED_CHEST || B.getType() == Material.CHEST || B.getType() == Material.NOTE_BLOCK || B.getType() == Material.ANVIL || B.getType() == Material.ENCHANTMENT_TABLE || B.getType() == Material.TRAP_DOOR)) {
            e.setCancelled(true);
        }
        else if (e.getAction() == Action.PHYSICAL && (B.getType() == Material.IRON_PLATE || B.getType() == Material.GOLD_PLATE || B.getType() == Material.STONE_PLATE || B.getType() == Material.WOOD_PLATE)) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onTrampleSoil (PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (e.getAction() == Action.PHYSICAL) {
            if (e.getClickedBlock().getType() == Material.SOIL) {
                if (p != null) {
                    e.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    public void onItemDespawn(ItemDespawnEvent e) {
        e.setCancelled(true);
    }
}
