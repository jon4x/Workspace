package de.jon4x.lobby.methods;

import de.jon4x.lobby.Main;
import de.jon4x.lobby.api.LobbySQL;
import de.jon4x.lobby.itemmanager.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;

public class Inventories {

    public static void openCompass(Player p) {
        Inventory teleporter = Bukkit.createInventory(null, 9*5, "§8× §6§lNavigator §8»");

        if (Main.getInstance().getTeleporter().contains(p.getUniqueId())) {
            teleporter.setItem(4, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            teleporter.setItem(3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            teleporter.setItem(5, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            teleporter.setItem(2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            teleporter.setItem(6, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            teleporter.setItem(1, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            teleporter.setItem(7, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            teleporter.setItem(0, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            teleporter.setItem(8, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            teleporter.setItem(9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            teleporter.setItem(17, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            teleporter.setItem(18, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            teleporter.setItem(26, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            teleporter.setItem(27, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            teleporter.setItem(35, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            teleporter.setItem(28, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            teleporter.setItem(34, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            teleporter.setItem(29, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            teleporter.setItem(33, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            teleporter.setItem(30, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            teleporter.setItem(32, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            teleporter.setItem(31, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            teleporter.setItem(38, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 1, " ", null));
            teleporter.setItem(42, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 1, " ", null));
            teleporter.setItem(37, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 1, " ", null));
            teleporter.setItem(43, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 1, " ", null));
            teleporter.setItem(36, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 1, " ", null));
            teleporter.setItem(44, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 1, " ", null));
            teleporter.setItem(10, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
            teleporter.setItem(16, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
            teleporter.setItem(11, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
            teleporter.setItem(15, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
            teleporter.setItem(4+9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
            teleporter.setItem(20, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
            teleporter.setItem(21, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
            teleporter.setItem(22, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
            teleporter.setItem(23, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
            teleporter.setItem(24, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                teleporter.setItem(1 + 9 * 2, ItemManager.createItem(Material.BARRIER, 1, 0, "§c§oBald..", null));
                teleporter.setItem(7 + 9 * 2, ItemManager.createItem(Material.BARRIER, 1, 0, "§c§oBald..", null));
                teleporter.setItem(3 + 9, ItemManager.createItem(Material.STICK, 1, 0, "§eKnockout", null));
                teleporter.setItem(5 + 9, ItemManager.createItem(Material.BED, 1, 0, "§eBedWars", null));
                teleporter.setItem(39, ItemManager.createItem(Material.STORAGE_MINECART, 1, 0, "§6Tägliche Belohnung", null));
                teleporter.setItem(40, ItemManager.createItem(Material.MAGMA_CREAM, 1, 0, "§b§lSpawn", null));
                teleporter.setItem(41, ItemManager.createItem(Material.NAME_TAG, 1, 0, "§6Community", null));
                p.playSound(p.getLocation(), Sound.GLASS, 0.35f, 1.0f);
            }, 3);
        }

        else {
            Main.getInstance().getTeleporter().add(p.getUniqueId());
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                teleporter.setItem(4, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 1);
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                teleporter.setItem(3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                teleporter.setItem(5, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 2);
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                teleporter.setItem(2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                teleporter.setItem(6, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 3);
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                teleporter.setItem(1, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                teleporter.setItem(7, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 4);
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                teleporter.setItem(0, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                teleporter.setItem(8, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 5);
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                teleporter.setItem(9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                teleporter.setItem(17, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                teleporter.setItem(10, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
                teleporter.setItem(16, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
                teleporter.setItem(11, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
                teleporter.setItem(15, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
                teleporter.setItem(4 + 9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 6);
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                teleporter.setItem(18, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                teleporter.setItem(26, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                teleporter.setItem(20, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
                teleporter.setItem(21, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
                teleporter.setItem(22, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
                teleporter.setItem(23, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
                teleporter.setItem(24, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 7);
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                teleporter.setItem(27, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                teleporter.setItem(35, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 8);
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                teleporter.setItem(28, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                teleporter.setItem(34, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 9);
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                teleporter.setItem(29, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                teleporter.setItem(33, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 10);
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                teleporter.setItem(30, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                teleporter.setItem(32, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 11);
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                teleporter.setItem(31, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 12);
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                teleporter.setItem(38, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 1, " ", null));
                teleporter.setItem(42, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 1, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 13);
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                teleporter.setItem(37, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 1, " ", null));
                teleporter.setItem(43, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 1, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 14);
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                teleporter.setItem(36, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 1, " ", null));
                teleporter.setItem(44, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 1, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 15);
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                teleporter.setItem(1 + 9 * 2, ItemManager.createItem(Material.BARRIER, 1, 0, "§c§oBald..", null));
                teleporter.setItem(7 + 9 * 2, ItemManager.createItem(Material.BARRIER, 1, 0, "§c§oBald..", null));
                teleporter.setItem(3 + 9, ItemManager.createItem(Material.STICK, 1, 0, "§eKnockout", null));
                teleporter.setItem(5 + 9, ItemManager.createItem(Material.BED, 1, 0, "§eBedWars", null));
                teleporter.setItem(39, ItemManager.createItem(Material.STORAGE_MINECART, 1, 0, "§6Tägliche Belohnung", null));
                teleporter.setItem(40, ItemManager.createItem(Material.MAGMA_CREAM, 1, 0, "§b§lSpawn", null));
                teleporter.setItem(41, ItemManager.createItem(Material.NAME_TAG, 1, 0, "§6Community", null));
                p.playSound(p.getLocation(), Sound.GLASS, 0.35f, 1.0f);
            }, 18);
        }
        p.openInventory(teleporter);
    }

    public static void openSettings(Player p) {
        Inventory settings = Bukkit.createInventory(null, 9*4, "§8× §a§lEinstellungen §8»");

        if (Main.getInstance().getSettings().contains(p.getUniqueId())) {
            settings.setItem(4, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            settings.setItem(3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            settings.setItem(5, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            settings.setItem(2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            settings.setItem(6, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            settings.setItem(1, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            settings.setItem(7, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            settings.setItem(0, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            settings.setItem(8, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            settings.setItem(0+9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            settings.setItem(8+9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            settings.setItem(1+9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
            settings.setItem(7+9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
            settings.setItem(3+9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
            settings.setItem(5+9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
            settings.setItem(0+9*2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            settings.setItem(8+9*2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            settings.setItem(1+9*2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
            settings.setItem(7+9*2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
            settings.setItem(3+9*2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
            settings.setItem(5+9*2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
            settings.setItem(0+9*3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            settings.setItem(8+9*3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            settings.setItem(1+9*3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            settings.setItem(7+9*3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            settings.setItem(2+9*3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            settings.setItem(6+9*3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            settings.setItem(3+9*3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            settings.setItem(5+9*3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            settings.setItem(4+9*3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                settings.setItem(4 + 9, ItemManager.createItem(Material.FIREBALL, 1, 0, "§eDoubleJump", null));
                settings.setItem(2 + 9, ItemManager.createItem(Material.SIGN, 1, 0, "§9Chat", null));
                settings.setItem(6 + 9, ItemManager.createItem(Material.IRON_PLATE, 1, 0, "§7JumpPads", null));

                // Chat
                if (Main.getInstance().getChatDisabled().contains(p.getUniqueId()))
                    settings.setItem(2 + 9 * 2, ItemManager.createItem(Material.INK_SACK, 1, 1, "§c✘ §8× §cDeaktiviert", null));
                else
                    settings.setItem(2 + 9 * 2, ItemManager.createItem(Material.INK_SACK, 1, 10, "§a✔ §8× §aAktiviert", null));

                // DoubleJump
                if (LobbySQL.getDoubleJump(p.getUniqueId().toString()) == 1)
                    settings.setItem(4 + 9 * 2, ItemManager.createItem(Material.INK_SACK, 1, 1, "§c✘ §8× §cDeaktiviert", null));
                else
                    settings.setItem(4 + 9 * 2, ItemManager.createItem(Material.INK_SACK, 1, 10, "§a✔ §8× §aAktiviert", null));

                // JumpPads
                if (LobbySQL.getJumpPad(p.getUniqueId().toString()) == 1)
                    settings.setItem(6 + 9 * 2, ItemManager.createItem(Material.INK_SACK, 1, 1, "§c✘ §8× §cDeaktiviert", null));
                else
                    settings.setItem(6 + 9 * 2, ItemManager.createItem(Material.INK_SACK, 1, 10, "§a✔ §8× §aAktiviert", null));

                p.playSound(p.getLocation(), Sound.GLASS, 0.35f, 1.0f);
            }, 3);
        }

        else {
            Main.getInstance().getSettings().add(p.getUniqueId());
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                settings.setItem(4, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 1);
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                settings.setItem(3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                settings.setItem(5, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 2);
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                settings.setItem(2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                settings.setItem(6, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 3);
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                settings.setItem(1, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                settings.setItem(7, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 4);
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                settings.setItem(0, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                settings.setItem(8, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 5);
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                settings.setItem(0 + 9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                settings.setItem(8 + 9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));

                settings.setItem(1 + 9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
                settings.setItem(7 + 9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
                settings.setItem(3 + 9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
                settings.setItem(5 + 9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 6);
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                settings.setItem(0 + 9 * 2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                settings.setItem(8 + 9 * 2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));

                settings.setItem(1 + 9 * 2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
                settings.setItem(7 + 9 * 2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
                settings.setItem(3 + 9 * 2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
                settings.setItem(5 + 9 * 2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 7);
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                settings.setItem(0 + 9 * 3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                settings.setItem(8 + 9 * 3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 8);
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                settings.setItem(1 + 9 * 3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                settings.setItem(7 + 9 * 3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 9);
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                settings.setItem(2 + 9 * 3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                settings.setItem(6 + 9 * 3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 10);
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                settings.setItem(3 + 9 * 3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                settings.setItem(5 + 9 * 3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 11);
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                settings.setItem(4 + 9 * 3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 12);
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                settings.setItem(4 + 9, ItemManager.createItem(Material.FIREBALL, 1, 0, "§eDoubleJump", null));
                settings.setItem(2 + 9, ItemManager.createItem(Material.SIGN, 1, 0, "§9Chat", null));
                settings.setItem(6 + 9, ItemManager.createItem(Material.IRON_PLATE, 1, 0, "§7JumpPads", null));

                // Chat
                if (Main.getInstance().getChatDisabled().contains(p.getUniqueId()))
                    settings.setItem(2 + 9 * 2, ItemManager.createItem(Material.INK_SACK, 1, 1, "§c✘ §8× §cDeaktiviert", null));
                else
                    settings.setItem(2 + 9 * 2, ItemManager.createItem(Material.INK_SACK, 1, 10, "§a✔ §8× §aAktiviert", null));

                // DoubleJump
                if (LobbySQL.getDoubleJump(p.getUniqueId().toString()) == 1)
                    settings.setItem(4 + 9 * 2, ItemManager.createItem(Material.INK_SACK, 1, 1, "§c✘ §8× §cDeaktiviert", null));
                else
                    settings.setItem(4 + 9 * 2, ItemManager.createItem(Material.INK_SACK, 1, 10, "§a✔ §8× §aAktiviert", null));

                // JumpPads
                if (LobbySQL.getJumpPad(p.getUniqueId().toString()) == 1)
                    settings.setItem(6 + 9 * 2, ItemManager.createItem(Material.INK_SACK, 1, 1, "§c✘ §8× §cDeaktiviert", null));
                else
                    settings.setItem(6 + 9 * 2, ItemManager.createItem(Material.INK_SACK, 1, 10, "§a✔ §8× §aAktiviert", null));

                p.playSound(p.getLocation(), Sound.GLASS, 0.35f, 1.0f);
            }, 15);
        }
        p.openInventory(settings);
    }

    public static void openYTSettings(Player p) {
        Inventory ytSettings = Bukkit.createInventory(null, 9*4, "§8× §5§lVIP-Einstellungen §8»");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§8\u27A5 §c§oIn arbeit..");
        if (Main.getInstance().getYtSettings().contains(p.getUniqueId())) {
            ytSettings.setItem(4, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            ytSettings.setItem(3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            ytSettings.setItem(5, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            ytSettings.setItem(2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            ytSettings.setItem(6, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            ytSettings.setItem(1, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            ytSettings.setItem(7, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            ytSettings.setItem(0, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            ytSettings.setItem(8, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            ytSettings.setItem(0 + 9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            ytSettings.setItem(8 + 9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            ytSettings.setItem(1 + 9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
            ytSettings.setItem(7 + 9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
            ytSettings.setItem(3 + 9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
            ytSettings.setItem(5 + 9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
            ytSettings.setItem(0 + 9 * 2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            ytSettings.setItem(8 + 9 * 2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            ytSettings.setItem(1 + 9 * 2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
            ytSettings.setItem(7 + 9 * 2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
            ytSettings.setItem(3 + 9 * 2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
            ytSettings.setItem(5 + 9 * 2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
            ytSettings.setItem(0 + 9 * 3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            ytSettings.setItem(8 + 9 * 3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            ytSettings.setItem(1 + 9 * 3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            ytSettings.setItem(7 + 9 * 3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            ytSettings.setItem(2 + 9 * 3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            ytSettings.setItem(6 + 9 * 3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            ytSettings.setItem(3 + 9 * 3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            ytSettings.setItem(5 + 9 * 3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            ytSettings.setItem(4 + 9 * 3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                ytSettings.setItem(4 + 9, ItemManager.createItem(Material.EXPLOSIVE_MINECART, 1, 0, "§cSilentlobby", lore));
                ytSettings.setItem(2 + 9, ItemManager.createItem(Material.NAME_TAG, 1, 0, "§5Nickname", lore));
                ytSettings.setItem(6 + 9, ItemManager.createItem(Material.ENDER_PEARL, 1, 0, "§9Schutzschild", null));
                ytSettings.setItem(4 + 9 * 2, ItemManager.createItem(Material.INK_SACK, 1, 1, "§c✘ §8× §cDeaktiviert", null));
                ytSettings.setItem(2 + 9 * 2, ItemManager.createItem(Material.INK_SACK, 1, 1, "§c✘ §8× §cDeaktiviert", null));
                if (Main.getInstance().getShieldList().contains(p.getUniqueId()))
                    ytSettings.setItem(6 + 9 * 2, ItemManager.createItem(Material.INK_SACK, 1, 10, "§a✔ §8× §aAktiviert", null));
                else
                    ytSettings.setItem(6 + 9 * 2, ItemManager.createItem(Material.INK_SACK, 1, 1, "§c✘ §8× §cDeaktiviert", null));
                p.playSound(p.getLocation(), Sound.GLASS, 0.35f, 1.0f);
            }, 3);
        }

        else {
            Main.getInstance().getYtSettings().add(p.getUniqueId());
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                ytSettings.setItem(4, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 1);
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                ytSettings.setItem(3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                ytSettings.setItem(5, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 2);
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                ytSettings.setItem(2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                ytSettings.setItem(6, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 3);
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                ytSettings.setItem(1, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                ytSettings.setItem(7, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 4);
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                ytSettings.setItem(0, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                ytSettings.setItem(8, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 5);
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                ytSettings.setItem(0 + 9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                ytSettings.setItem(8 + 9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));

                ytSettings.setItem(1 + 9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
                ytSettings.setItem(7 + 9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
                ytSettings.setItem(3 + 9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
                ytSettings.setItem(5 + 9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 6);
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                ytSettings.setItem(0 + 9 * 2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                ytSettings.setItem(8 + 9 * 2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));

                ytSettings.setItem(1 + 9 * 2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
                ytSettings.setItem(7 + 9 * 2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
                ytSettings.setItem(3 + 9 * 2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
                ytSettings.setItem(5 + 9 * 2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 7);
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                ytSettings.setItem(0 + 9 * 3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                ytSettings.setItem(8 + 9 * 3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 8);
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                ytSettings.setItem(1 + 9 * 3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                ytSettings.setItem(7 + 9 * 3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 9);
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                ytSettings.setItem(2 + 9 * 3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                ytSettings.setItem(6 + 9 * 3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 10);
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                ytSettings.setItem(3 + 9 * 3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                ytSettings.setItem(5 + 9 * 3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 11);
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                ytSettings.setItem(4 + 9 * 3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 12);
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                ytSettings.setItem(4 + 9, ItemManager.createItem(Material.EXPLOSIVE_MINECART, 1, 0, "§cSilentlobby", lore));
                ytSettings.setItem(2 + 9, ItemManager.createItem(Material.NAME_TAG, 1, 0, "§5Nickname", lore));
                ytSettings.setItem(6 + 9, ItemManager.createItem(Material.ENDER_PEARL, 1, 0, "§9Schutzschild", null));
                ytSettings.setItem(4 + 9 * 2, ItemManager.createItem(Material.INK_SACK, 1, 1, "§c✘ §8× §cDeaktiviert", null));
                ytSettings.setItem(2 + 9 * 2, ItemManager.createItem(Material.INK_SACK, 1, 1, "§c✘ §8× §cDeaktiviert", null));
                if (Main.getInstance().getShieldList().contains(p.getUniqueId()))
                    ytSettings.setItem(6 + 9 * 2, ItemManager.createItem(Material.INK_SACK, 1, 10, "§a✔ §8× §aAktiviert", null));
                else
                    ytSettings.setItem(6 + 9 * 2, ItemManager.createItem(Material.INK_SACK, 1, 1, "§c✘ §8× §cDeaktiviert", null));
                p.playSound(p.getLocation(), Sound.GLASS, 0.35f, 1.0f);
            }, 15);
        }
        p.openInventory(ytSettings);
    }

    public static void openProfil (Player p) {
        Inventory profil = Bukkit.createInventory(null, 9*3, "§8× §e§lProfil §8»");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§8\u27A5 §c§oIn arbeit..");
        if (Main.getInstance().getProfil().contains(p.getUniqueId())) {
            profil.setItem(4, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            profil.setItem(3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            profil.setItem(5, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            profil.setItem(2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            profil.setItem(6, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            profil.setItem(1, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            profil.setItem(7, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            profil.setItem(0, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            profil.setItem(8, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            profil.setItem(0 + 9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            profil.setItem(8 + 9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            profil.setItem(6 + 9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
            profil.setItem(4 + 9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
            profil.setItem(2 + 9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
            profil.setItem(0 + 9 * 2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            profil.setItem(8 + 9 * 2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            profil.setItem(1 + 9 * 2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            profil.setItem(7 + 9 * 2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            profil.setItem(2 + 9 * 2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            profil.setItem(6 + 9 * 2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            profil.setItem(3 + 9 * 2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            profil.setItem(5 + 9 * 2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            profil.setItem(4 + 9 * 2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                profil.setItem(1 + 9, ItemManager.createItem(Material.REDSTONE, 1, 0, "§cTrails", lore));
                profil.setItem(3 + 9, ItemManager.createItem(Material.LEATHER_CHESTPLATE, 1, 0, "§9Kleiderschrank", lore));
                profil.setItem(5 + 9, ItemManager.createItem(Material.PUMPKIN, 1, 0, "§eKöpfe", lore));
                profil.setItem(7 + 9, ItemManager.createItem(Material.GOLD_BOOTS, 1, 0, "§6Schuhe", lore));
                p.playSound(p.getLocation(), Sound.GLASS, 0.35f, 1.0f);
            }, 3);
        }
        else {
            Main.getInstance().getProfil().add(p.getUniqueId());
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                profil.setItem(4, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 1);
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                profil.setItem(3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                profil.setItem(5, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 2);
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                profil.setItem(2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                profil.setItem(6, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 3);
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                profil.setItem(1, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                profil.setItem(7, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 4);
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                profil.setItem(0, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                profil.setItem(8, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 5);
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                profil.setItem(0 + 9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                profil.setItem(8 + 9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                profil.setItem(6 + 9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
                profil.setItem(4 + 9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
                profil.setItem(2 + 9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 6);
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                profil.setItem(0 + 9 * 2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                profil.setItem(8 + 9 * 2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 7);
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                profil.setItem(1 + 9 * 2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                profil.setItem(7 + 9 * 2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 8);
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                profil.setItem(2 + 9 * 2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                profil.setItem(6 + 9 * 2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 9);
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                profil.setItem(3 + 9 * 2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                profil.setItem(5 + 9 * 2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 10);
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                profil.setItem(4 + 9 * 2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 11);
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                profil.setItem(1 + 9, ItemManager.createItem(Material.REDSTONE, 1, 0, "§cTrails", lore));
                profil.setItem(3 + 9, ItemManager.createItem(Material.LEATHER_CHESTPLATE, 1, 0, "§9Kleiderschrank", lore));
                profil.setItem(5 + 9, ItemManager.createItem(Material.PUMPKIN, 1, 0, "§eKöpfe", lore));
                profil.setItem(7 + 9, ItemManager.createItem(Material.GOLD_BOOTS, 1, 0, "§6Schuhe", lore));
                p.playSound(p.getLocation(), Sound.GLASS, 0.35f, 1.0f);
            }, 14);
        }
        p.openInventory(profil);
    }

    public static void openReward (Player p) {
        Inventory reward = Bukkit.createInventory(null, 9*3, "§8× §6§lTägliche Belohnung §8»");
        ArrayList<String> loreNormal = new ArrayList<>(); ArrayList<String> lorePremium = new ArrayList<>();
        loreNormal.add("§8\u27A5 §7100 Coins"); lorePremium.add("§8\u27A5 §7200 Coins");
        if (Main.getInstance().getReward().contains(p.getUniqueId())) {
            reward.setItem(4, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            reward.setItem(3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            reward.setItem(5, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            reward.setItem(2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            reward.setItem(6, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            reward.setItem(1, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            reward.setItem(7, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            reward.setItem(0, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            reward.setItem(8, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            reward.setItem(0 + 9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            reward.setItem(8 + 9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            reward.setItem(1 + 9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
            reward.setItem(3 + 9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
            reward.setItem(4 + 9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
            reward.setItem(5 + 9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
            reward.setItem(7 + 9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
            reward.setItem(0 + 9 * 2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            reward.setItem(8 + 9 * 2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            reward.setItem(1 + 9 * 2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            reward.setItem(7 + 9 * 2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            reward.setItem(2 + 9 * 2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            reward.setItem(6 + 9 * 2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            reward.setItem(3 + 9 * 2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            reward.setItem(5 + 9 * 2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            reward.setItem(4 + 9 * 2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {

                if (LobbySQL.getLastNormal(p.getUniqueId().toString()) < 1)
                    reward.setItem(2 + 9, ItemManager.createItem(Material.STORAGE_MINECART, 1, 0, "§8» §7Tägliche Belohnung", loreNormal));
                else if (LobbySQL.getLastNormal(p.getUniqueId().toString()) == 2)
                    reward.setItem(2 + 9, ItemManager.createItem(Material.MINECART, 1, 0, "§8» §7Tägliche Belohnung", loreNormal));
                else
                    reward.setItem(2 + 9, ItemManager.createItem(Material.BARRIER, 1, 0, "§8» §c§lDatenbank Fehler.", loreNormal));

                if (LobbySQL.getLastPremium(p.getUniqueId().toString()) < 1)
                    reward.setItem(6 + 9, ItemManager.createItem(Material.STORAGE_MINECART, 1, 0, "§8» §6Tägliche Premium-Belohnung", lorePremium));
                else if (LobbySQL.getLastPremium(p.getUniqueId().toString()) == 2)
                    reward.setItem(6 + 9, ItemManager.createItem(Material.MINECART, 1, 0, "§8» §6Tägliche Premium-Belohnung", lorePremium));
                else
                    reward.setItem(6 + 9, ItemManager.createItem(Material.BARRIER, 1, 0, "§8» §c§lDatenbank Fehler.", lorePremium));

                p.playSound(p.getLocation(), Sound.GLASS, 0.35f, 1.0f);
            }, 3);
        }
        else {
            Main.getInstance().getReward().add(p.getUniqueId());
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                reward.setItem(4, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 1);
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                reward.setItem(3, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                reward.setItem(5, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 2);
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                reward.setItem(2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                reward.setItem(6, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 3);
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                reward.setItem(1, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                reward.setItem(7, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 4);
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                reward.setItem(0, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                reward.setItem(8, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 5);
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                reward.setItem(0 + 9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                reward.setItem(8 + 9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                reward.setItem(1 + 9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
                reward.setItem(3 + 9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
                reward.setItem(4 + 9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
                reward.setItem(5 + 9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
                reward.setItem(7 + 9, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 7, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 6);
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                reward.setItem(0 + 9 * 2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                reward.setItem(8 + 9 * 2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 7);
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                reward.setItem(1 + 9 * 2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                reward.setItem(7 + 9 * 2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 8);
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                reward.setItem(2 + 9 * 2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                reward.setItem(6 + 9 * 2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 9);
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                reward.setItem(3 + 9 * 2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                reward.setItem(5 + 9 * 2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 10);
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                reward.setItem(4 + 9 * 2, ItemManager.createItem(Material.STAINED_GLASS_PANE, 1, 14, " ", null));
                p.playSound(p.getLocation(), Sound.CHICKEN_EGG_POP, 0.2f, 0.5f);
            }, 11);
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {

                if (LobbySQL.getLastNormal(p.getUniqueId().toString()) < 1)
                    reward.setItem(2 + 9, ItemManager.createItem(Material.STORAGE_MINECART, 1, 0, "§8» §7Tägliche Belohnung", loreNormal));
                else if (LobbySQL.getLastNormal(p.getUniqueId().toString()) == 2)
                    reward.setItem(2 + 9, ItemManager.createItem(Material.MINECART, 1, 0, "§8» §7Tägliche Belohnung", loreNormal));
                else
                    reward.setItem(2 + 9, ItemManager.createItem(Material.BARRIER, 1, 0, "§8» §c§lDatenbank Fehler.", loreNormal));

                if (LobbySQL.getLastPremium(p.getUniqueId().toString()) < 1)
                    reward.setItem(6 + 9, ItemManager.createItem(Material.STORAGE_MINECART, 1, 0, "§8» §6Tägliche Premium-Belohnung", lorePremium));
                else if (LobbySQL.getLastPremium(p.getUniqueId().toString()) == 2)
                    reward.setItem(6 + 9, ItemManager.createItem(Material.MINECART, 1, 0, "§8» §6Tägliche Premium-Belohnung", lorePremium));
                else
                    reward.setItem(6 + 9, ItemManager.createItem(Material.BARRIER, 1, 0, "§8» §c§lDatenbank Fehler.", lorePremium));

                p.playSound(p.getLocation(), Sound.GLASS, 0.35f, 1.0f);
            }, 14);
        }
        p.openInventory(reward);
    }
}
