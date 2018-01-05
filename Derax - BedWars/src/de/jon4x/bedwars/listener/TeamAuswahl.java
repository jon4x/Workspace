package de.jon4x.bedwars.listener;

import com.sun.javafx.iio.ios.IosDescriptor;
import de.jon4x.bedwars.ScoreboardManager;
import de.jon4x.bedwars.storage.Data;
import net.claymc.gameapi.api.GameState;
import net.claymc.gameapi.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Pascal Falk on 03.08.2017.
 * Plugin by WeLoveSpigotPlugins
 * https://youtube.com/welovespigotplugins
 * Coded with IntelliJ
 */
public class TeamAuswahl implements Listener {

    public static ArrayList<Player> team_BLAU = new ArrayList<>();
    public static ArrayList<Player> team_ROT = new ArrayList<>();
    public static ArrayList<Player> team_GELB = new ArrayList<>();
    public static ArrayList<Player> team_GRÜN = new ArrayList<>();
    public static ArrayList<Player> team_ORANGE = new ArrayList<>();
    public static ArrayList<Player> team_SCHWARZ = new ArrayList<>();
    public static ArrayList<Player> team_PINK = new ArrayList<>();
    public static ArrayList<Player> team_GRAU = new ArrayList<>();


    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        try {
            if (Data.ga.gs == GameState.LOBBY) {
                if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK) || e.getAction().equals(Action.RIGHT_CLICK_AIR)) {
                    if (e.getItem().getType() == Material.BED) {
                        if (Data.mode.equalsIgnoreCase("8x1") || Data.mode.equalsIgnoreCase("8x2")) {
                            Inventory inv = Bukkit.createInventory(null, 9, "§8× §9§lTeamauswahl §8»");
                            e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.CHEST_OPEN, (float) 0.5, (float) 0.5);
                            e.getPlayer().openInventory(inv);
                            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                                {
                                    ItemStack team = new ItemStack(Material.WOOL, 1, (short) 11);
                                    ItemMeta teammeta = team.getItemMeta();
                                    teammeta.setDisplayName("§9Team Blau");
                                    if (!team_BLAU.isEmpty()) {
                                        ArrayList<String> list = new ArrayList<>();
                                        list.add("§7§m--------------------");
                                        for (int i = 0; i < team_BLAU.size(); i++) {
                                            list.add("§7» §9" + team_BLAU.get(i).getName());
                                        }
                                        teammeta.setLore(list);
                                    }
                                    team.setItemMeta(teammeta);
                                    inv.setItem(0, team);
                                }
                                {
                                    ItemStack team = new ItemStack(Material.WOOL, 1, (short) 14);
                                    ItemMeta teammeta = team.getItemMeta();
                                    teammeta.setDisplayName("§4Team Rot");
                                    if (!team_ROT.isEmpty()) {
                                        ArrayList<String> list = new ArrayList<>();
                                        list.add("§7§m--------------------");
                                        for (int i = 0; i < team_ROT.size(); i++) {
                                            list.add("§7» §4" + team_ROT.get(i).getName());
                                        }
                                        teammeta.setLore(list);
                                    }
                                    team.setItemMeta(teammeta);
                                    inv.setItem(1, team);

                                }
                                {
                                    ItemStack team = new ItemStack(Material.WOOL, 1, (short) 4);
                                    ItemMeta teammeta = team.getItemMeta();
                                    teammeta.setDisplayName("§eTeam Gelb");
                                    if (!team_GELB.isEmpty()) {
                                        ArrayList<String> list = new ArrayList<>();
                                        list.add("§7§m--------------------");
                                        for (int i = 0; i < team_GELB.size(); i++) {
                                            list.add("§7 §e" + team_GELB.get(i).getName());
                                        }
                                        teammeta.setLore(list);
                                    }
                                    team.setItemMeta(teammeta);
                                    inv.setItem(2, team);

                                }
                                {
                                    ItemStack team = new ItemStack(Material.WOOL, 1, (short) 13);
                                    ItemMeta teammeta = team.getItemMeta();
                                    teammeta.setDisplayName("§aTeam Grün");
                                    if (!team_GRÜN.isEmpty()) {
                                        ArrayList<String> list = new ArrayList<>();
                                        list.add("§7§m--------------------");
                                        for (int i = 0; i < team_GRÜN.size(); i++) {
                                            list.add("§7 §a" + team_GRÜN.get(i).getName());
                                        }
                                        teammeta.setLore(list);
                                    }
                                    team.setItemMeta(teammeta);
                                    inv.setItem(3, team);

                                }
                                {
                                    ItemStack team = new ItemStack(Material.WOOL, 1, (short) 1);
                                    ItemMeta teammeta = team.getItemMeta();
                                    teammeta.setDisplayName("§6Team Orange");
                                    if (!team_ORANGE.isEmpty()) {
                                        ArrayList<String> list = new ArrayList<>();
                                        list.add("§7§m--------------------");
                                        for (int i = 0; i < team_ORANGE.size(); i++) {
                                            list.add("§7 §6" + team_ORANGE.get(i).getName());
                                        }
                                        teammeta.setLore(list);
                                    }
                                    team.setItemMeta(teammeta);
                                    inv.setItem(4, team);

                                }
                                {
                                    ItemStack team = new ItemStack(Material.WOOL, 1, (short) 15);
                                    ItemMeta teammeta = team.getItemMeta();
                                    teammeta.setDisplayName("§0Team Schwarz");
                                    if (!team_SCHWARZ.isEmpty()) {
                                        ArrayList<String> list = new ArrayList<>();
                                        list.add("§7§m--------------------");
                                        for (int i = 0; i < team_SCHWARZ.size(); i++) {
                                            list.add("§7» §0" + team_SCHWARZ.get(i).getName());
                                        }
                                        teammeta.setLore(list);
                                    }
                                    team.setItemMeta(teammeta);
                                    inv.setItem(5, team);

                                }
                                {
                                    ItemStack team = new ItemStack(Material.WOOL, 1, (short) 6);
                                    ItemMeta teammeta = team.getItemMeta();
                                    teammeta.setDisplayName("§dTeam Pink");
                                    if (!team_PINK.isEmpty()) {
                                        ArrayList<String> list = new ArrayList<>();
                                        list.add("§7§m--------------------");
                                        for (int i = 0; i < team_PINK.size(); i++) {
                                            list.add("§7» §d" + team_PINK.get(i).getName());
                                        }
                                        teammeta.setLore(list);
                                    }
                                    team.setItemMeta(teammeta);
                                    inv.setItem(6, team);

                                }
                                {
                                    ItemStack team = new ItemStack(Material.WOOL, 1, (short) 8);
                                    ItemMeta teammeta = team.getItemMeta();
                                    teammeta.setDisplayName("§7Team Grau");
                                    if (!team_GRAU.isEmpty()) {
                                        ArrayList<String> list = new ArrayList<>();
                                        list.add("§7§m--------------------");
                                        for (int i = 0; i < team_GRAU.size(); i++) {
                                            list.add("§7» §7" + team_GRAU.get(i).getName());
                                        }
                                        teammeta.setLore(list);
                                    }
                                    team.setItemMeta(teammeta);
                                    inv.setItem(7, team);

                                }
                            });
                        }
                        if (Data.mode.equalsIgnoreCase("4x2") || Data.mode.equalsIgnoreCase("4x3")) {
                            Inventory inv = Bukkit.createInventory(null, 9, "§8× §9§lTeamauswahl §8»");
                            e.getPlayer().openInventory(inv);
                            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                                {
                                    ItemStack team = new ItemStack(Material.WOOL, 1, (short) 11);
                                    ItemMeta teammeta = team.getItemMeta();
                                    teammeta.setDisplayName("§9Team Blau");
                                    if (!team_BLAU.isEmpty()) {
                                        ArrayList<String> list = new ArrayList<>();
                                        list.add("§7§m--------------------");
                                        for (int i = 0; i < team_BLAU.size(); i++) {
                                            list.add("§7» §9" + team_BLAU.get(i).getName());
                                        }
                                        teammeta.setLore(list);
                                    }
                                    team.setItemMeta(teammeta);
                                    inv.setItem(0, team);
                                }
                                {
                                    ItemStack team = new ItemStack(Material.WOOL, 1, (short) 14);
                                    ItemMeta teammeta = team.getItemMeta();
                                    teammeta.setDisplayName("§4Team Rot");
                                    if (!team_ROT.isEmpty()) {
                                        ArrayList<String> list = new ArrayList<>();
                                        list.add("§7§m--------------------");
                                        for (int i = 0; i < team_ROT.size(); i++) {
                                            list.add("§7» §4" + team_ROT.get(i).getName());
                                        }
                                        teammeta.setLore(list);
                                    }
                                    team.setItemMeta(teammeta);
                                    inv.setItem(1, team);

                                }
                                {
                                    ItemStack team = new ItemStack(Material.WOOL, 1, (short) 4);
                                    ItemMeta teammeta = team.getItemMeta();
                                    teammeta.setDisplayName("§eTeam Gelb");
                                    if (!team_GELB.isEmpty()) {
                                        ArrayList<String> list = new ArrayList<>();
                                        list.add("§7§m--------------------");
                                        for (int i = 0; i < team_GELB.size(); i++) {
                                            list.add("§7 §e" + team_GELB.get(i).getName());
                                        }
                                        teammeta.setLore(list);
                                    }
                                    team.setItemMeta(teammeta);
                                    inv.setItem(2, team);

                                }
                                {
                                    ItemStack team = new ItemStack(Material.WOOL, 1, (short) 13);
                                    ItemMeta teammeta = team.getItemMeta();
                                    teammeta.setDisplayName("§aTeam Grün");
                                    if (!team_GRÜN.isEmpty()) {
                                        ArrayList<String> list = new ArrayList<>();
                                        list.add("§7§m--------------------");
                                        for (int i = 0; i < team_GRÜN.size(); i++) {
                                            list.add("§7 §a" + team_GRÜN.get(i).getName());
                                        }
                                        teammeta.setLore(list);
                                    }
                                    team.setItemMeta(teammeta);
                                    inv.setItem(3, team);

                                }
                            });
                        }
                        if (Data.mode.equalsIgnoreCase("2x2") || Data.mode.equalsIgnoreCase("2x1")) {
                            Inventory inv = Bukkit.createInventory(null, 9, "§8× §9§lTeamauswahl §8»");
                            e.getPlayer().openInventory(inv);
                            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), () -> {
                                {
                                    ItemStack team = new ItemStack(Material.WOOL, 1, (short) 11);
                                    ItemMeta teammeta = team.getItemMeta();
                                    teammeta.setDisplayName("§9Team Blau");
                                    if (!team_BLAU.isEmpty()) {
                                        ArrayList<String> list = new ArrayList<>();
                                        list.add("§7§m--------------------");
                                        for (int i = 0; i < team_BLAU.size(); i++) {
                                            list.add("§7» §9" + team_BLAU.get(i).getName());
                                        }
                                        teammeta.setLore(list);
                                    }
                                    team.setItemMeta(teammeta);
                                    inv.setItem(0, team);
                                }
                                {
                                    ItemStack team = new ItemStack(Material.WOOL, 1, (short) 14);
                                    ItemMeta teammeta = team.getItemMeta();
                                    teammeta.setDisplayName("§4Team Rot");
                                    if (!team_ROT.isEmpty()) {
                                        ArrayList<String> list = new ArrayList<>();
                                        list.add("§7§m--------------------");
                                        for (int i = 0; i < team_ROT.size(); i++) {
                                            list.add("§7» §4" + team_ROT.get(i).getName());
                                        }
                                        teammeta.setLore(list);
                                    }
                                    team.setItemMeta(teammeta);
                                    inv.setItem(1, team);

                                }
                            });
                        }
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        try {
            Player p = (Player) e.getWhoClicked();
            if (Data.ga.gs == GameState.LOBBY) {
                if (e.getInventory().getName().equalsIgnoreCase("§8× §9§lTeamauswahl §8»")) {
                    e.setCancelled(true);
                    if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§9Team Blau")) {
                        if (allowPlayerToEnterTeam(team_BLAU, p)) {
                            removeFromAllTeams(p);
                            team_BLAU.add(p);
                            p.sendMessage(Data.gc.getPrefix() + "§7Du bist Team §9Blau §7beigetreten!");
                            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
                            p.closeInventory();
                            ScoreboardManager.setScoreboard(p);
                            return;
                        }
                    }
                    if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§4Team Rot")) {
                        if (allowPlayerToEnterTeam(team_ROT, p)) {
                            removeFromAllTeams(p);
                            team_ROT.add(p);
                            p.sendMessage(Data.gc.getPrefix() + "§7Du bist Team §4Rot §7beigetreten!");
                            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
                            p.closeInventory();
                            ScoreboardManager.setScoreboard(p);
                            return;
                        }
                    }
                    if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eTeam Gelb")) {
                        if (allowPlayerToEnterTeam(team_GELB, p)) {
                            removeFromAllTeams(p);
                            team_GELB.add(p);
                            p.sendMessage(Data.gc.getPrefix() + "§7Du bist Team §eGelb §7beigetreten!");
                            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
                            p.closeInventory();
                            ScoreboardManager.setScoreboard(p);
                            return;
                        }
                    }
                    if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aTeam Grün")) {
                        if (allowPlayerToEnterTeam(team_GRÜN, p)) {
                            removeFromAllTeams(p);
                            team_GRÜN.add(p);
                            p.sendMessage(Data.gc.getPrefix() + "§7Du bist Team §aGrün §7beigetreten!");
                            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
                            p.closeInventory();
                            ScoreboardManager.setScoreboard(p);
                            return;
                        }
                    }
                    if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Team Orange")) {
                        if (allowPlayerToEnterTeam(team_ORANGE, p)) {
                            removeFromAllTeams(p);
                            team_ORANGE.add(p);
                            p.sendMessage(Data.gc.getPrefix() + "§7Du bist Team §6Orange §7beigetreten!");
                            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
                            p.closeInventory();
                            ScoreboardManager.setScoreboard(p);
                            return;
                        }
                    }
                    if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§0Team Schwarz")) {
                        if (allowPlayerToEnterTeam(team_SCHWARZ, p)) {
                            removeFromAllTeams(p);
                            team_SCHWARZ.add(p);
                            p.sendMessage(Data.gc.getPrefix() + "§7Du bist Team §0Schwarz §7beigetreten!");
                            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
                            p.closeInventory();
                            ScoreboardManager.setScoreboard(p);
                            return;
                        }
                    }
                    if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§dTeam Pink")) {
                        if (allowPlayerToEnterTeam(team_PINK, p)) {
                            removeFromAllTeams(p);
                            team_PINK.add(p);
                            p.sendMessage(Data.gc.getPrefix() + "§7Du bist Team §dPink §7beigetreten!");
                            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
                            p.closeInventory();
                            ScoreboardManager.setScoreboard(p);
                            return;
                        }
                    }
                    if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Team Grau")) {
                        if (allowPlayerToEnterTeam(team_GRAU, p)) {
                            removeFromAllTeams(p);
                            team_GRAU.add(p);
                            p.sendMessage(Data.gc.getPrefix() + "§7Du bist Team §7Grau §7beigetreten!");
                            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
                            p.closeInventory();
                            ScoreboardManager.setScoreboard(p);
                            return;
                        }
                    }
                }
            }
        } catch (Exception e1) {
        }
    }

    public void removeFromAllTeams(Player p) {
        team_GRAU.remove(p);
        team_PINK.remove(p);
        team_SCHWARZ.remove(p);
        team_ORANGE.remove(p);
        team_GRÜN.remove(p);
        team_BLAU.remove(p);
        team_GELB.remove(p);
        team_ROT.remove(p);
    }

    public static String getTeam(Player p) {
        if (team_PINK.contains(p)) {
            return "§dPink";
        }
        if (team_GRAU.contains(p)) {
            return "§7Grau";
        }
        if (team_SCHWARZ.contains(p)) {
            return "§0Schwarz";
        }
        if (team_ORANGE.contains(p)) {
            return "§6Orange";
        }
        if (team_GRÜN.contains(p)) {
            return "§aGrün";
        }
        if (team_BLAU.contains(p)) {
            return "§9Blau";
        }
        if (team_GELB.contains(p)) {
            return "§eGelb";
        }
        if (team_ROT.contains(p)) {
            return "§4Rot";
        } else {
            return "§4✖";
        }
    }

    public static String getRawTeam(Player p) {
        if (team_PINK.contains(p)) {
            return "pink";
        }
        if (team_GRAU.contains(p)) {
            return "grau";
        }
        if (team_SCHWARZ.contains(p)) {
            return "schwarz";
        }
        if (team_ORANGE.contains(p)) {
            return "orange";
        }
        if (team_GRÜN.contains(p)) {
            return "gruen";
        }
        if (team_BLAU.contains(p)) {
            return "blau";
        }
        if (team_GELB.contains(p)) {
            return "gelb";
        }
        if (team_ROT.contains(p)) {
            return "rot";
        } else {
            return "";
        }
    }

    public static boolean allInOneTeam() {
        boolean fail = false;
        for (Player all : Bukkit.getOnlinePlayers()) {
            if (team_PINK.contains(all)) {
                continue;
            }
            if (team_GRAU.contains(all)) {
                continue;
            }
            if (team_SCHWARZ.contains(all)) {
                continue;
            }
            if (team_ORANGE.contains(all)) {
                continue;
            }
            if (team_GRÜN.contains(all)) {
                continue;
            }
            if (team_BLAU.contains(all)) {
                continue;
            }
            if (team_GELB.contains(all)) {
                continue;
            }
            if (team_ROT.contains(all)) {
                continue;
            }
            fail = true;
            break;
        }
        if (fail) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean isInTeam(Player all) {
        if (team_PINK.contains(all)) {
            return true;
        }
        if (team_GRAU.contains(all)) {
            return true;
        }
        if (team_SCHWARZ.contains(all)) {
            return true;
        }
        if (team_ORANGE.contains(all)) {
            return true;
        }
        if (team_GRÜN.contains(all)) {
            return true;
        }
        if (team_BLAU.contains(all)) {
            return true;
        }
        if (team_GELB.contains(all)) {
            return true;
        }
        if (team_ROT.contains(all)) {
            return true;
        }
        return false;
    }
    public static ArrayList<Player> getTeamArray(Player all) {
        if (team_PINK.contains(all)) {
            return team_PINK;
        }
        if (team_GRAU.contains(all)) {
            return team_GRAU;
        }
        if (team_SCHWARZ.contains(all)) {
            return team_SCHWARZ;
        }
        if (team_ORANGE.contains(all)) {
            return team_ORANGE;
        }
        if (team_GRÜN.contains(all)) {
            return team_GRÜN;
        }
        if (team_BLAU.contains(all)) {
            return team_BLAU;
        }
        if (team_GELB.contains(all)) {
            return team_GELB;
        }
        if (team_ROT.contains(all)) {
            return team_ROT;
        }
        return null;
    }

    public static ArrayList<Player> getFreeTeamForPlayer(Player all) {
        if (Data.mode.equalsIgnoreCase("8x1")) {
            if (team_PINK.isEmpty()) {
                return team_PINK;
            }
            if (team_GRAU.isEmpty()) {
                return team_GRAU;
            }
            if (team_SCHWARZ.isEmpty()) {
                return team_SCHWARZ;
            }
            if (team_ORANGE.isEmpty()) {
                return team_ORANGE;
            }
            if (team_GRÜN.isEmpty()) {
                return team_GRÜN;
            }
            if (team_BLAU.isEmpty()) {
                return team_BLAU;
            }
            if (team_GELB.isEmpty()) {
                return team_GELB;
            }
            if (team_ROT.isEmpty()) {
                return team_ROT;
            }
        }
        if (Data.mode.equalsIgnoreCase("8x2")) {
            if (team_PINK.isEmpty() || team_PINK.size() < 2) {
                return team_PINK;
            }
            if (team_GRAU.isEmpty() || team_GRAU.size() < 2) {
                return team_GRAU;
            }
            if (team_SCHWARZ.isEmpty() || team_SCHWARZ.size() < 2) {
                return team_SCHWARZ;
            }
            if (team_ORANGE.isEmpty() || team_ORANGE.size() < 2) {
                return team_ORANGE;
            }
            if (team_GRÜN.isEmpty() || team_GRÜN.size() < 2) {
                return team_GRÜN;
            }
            if (team_BLAU.isEmpty() || team_BLAU.size() < 2) {
                return team_BLAU;
            }
            if (team_GELB.isEmpty() || team_GELB.size() < 2) {
                return team_GELB;
            }
            if (team_ROT.isEmpty() || team_ROT.size() < 2) {
                return team_ROT;
            }

        }
        if (Data.mode.equalsIgnoreCase("4x2")) {
            if (team_GRÜN.isEmpty() || team_GRÜN.size() < 2) {
                return team_GRÜN;
            }
            else if (team_BLAU.isEmpty() || team_BLAU.size() < 2) {
                return team_BLAU;
            }
            else if (team_GELB.isEmpty() || team_GELB.size() < 2) {
                return team_GELB;
            }
            else if (team_ROT.isEmpty() || team_ROT.size() < 2) {
                return team_ROT;
            }
        }
        if (Data.mode.equalsIgnoreCase("4x3")) {
            if (team_GRÜN.isEmpty() || team_GRÜN.size() < 3) {
                return team_GRÜN;
            }
            if (team_BLAU.isEmpty() || team_BLAU.size() < 3) {
                return team_BLAU;
            }
            if (team_GELB.isEmpty() || team_GELB.size() < 3) {
                return team_GELB;
            }
            if (team_ROT.isEmpty() || team_ROT.size() < 3) {
                return team_ROT;
            }
        }
        if (Data.mode.equalsIgnoreCase("2x2")) {
            if (Bukkit.getOnlinePlayers().size() > 2) {
                if (team_BLAU.isEmpty() || team_BLAU.size() < 2) {
                    return team_BLAU;
                }
                else if (team_ROT.isEmpty() || team_ROT.size() < 2) {
                    return team_ROT;
                }
            } else {
                if (team_BLAU.isEmpty()) {
                    return team_BLAU;
                }
                else if (team_ROT.isEmpty()) {
                    return team_ROT;
                }
            }
        }
        if (Data.mode.equalsIgnoreCase("2x1")) {
            if (team_ROT.isEmpty()) {
                return team_ROT;
            }
            if (team_BLAU.isEmpty()) {
                return team_BLAU;
            }
        }
        if (Bukkit.getOnlinePlayers().size() > 16) {
            Bukkit.broadcastMessage(Data.gc.getPrefix() + "§cDieser Server wird aufgrund einer Fehlkonfiguartion neugestartet...");
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), () -> Bukkit.shutdown(), 40);
        }
        return null;
    }

    public boolean allowPlayerToEnterTeam(ArrayList<Player> list, Player p) {
        if (!go(list, p)) {
            return false;
        } else {
            if (Data.mode.equalsIgnoreCase("8x1")) {
                if (list.isEmpty()) {
                    return true;
                } else {
                    p.sendMessage(Data.gc.getPrefix() + "§cDieses Team ist bereits voll!");
                    return false;
                }
            }
            if (Data.mode.equalsIgnoreCase("8x2")) {
                if (list.size() < 2) {
                    return true;
                } else {
                    p.sendMessage(Data.gc.getPrefix() + "§cDieses Team ist bereits voll!");
                    return false;
                }
            }
            if (Data.mode.equalsIgnoreCase("4x2")) {
                if (list.size() < 2) {
                    return true;
                } else {
                    p.sendMessage(Data.gc.getPrefix() + "§cDieses Team ist bereits voll!");
                    return false;
                }
            }
            if (Data.mode.equalsIgnoreCase("4x3")) {
                if (list.size() < 3) {
                    return true;
                } else {
                    p.sendMessage(Data.gc.getPrefix() + "§cDieses Team ist bereits voll!");
                    return false;
                }
            }
            if (Data.mode.equalsIgnoreCase("2x2")) {
                if (list.size() < 2) {
                    return true;
                } else {
                    p.sendMessage(Data.gc.getPrefix() + "§cDieses Team ist bereits voll!");
                    return false;
                }
            }
            if (Data.mode.equalsIgnoreCase("2x1")) {
                if (list.isEmpty()) {
                    return true;
                } else {
                    p.sendMessage(Data.gc.getPrefix() + "§cDieses Team ist bereits voll!");
                    return false;
                }
            }
            return false;
        }
    }
    private boolean go(ArrayList<Player> list, Player p){
        if(list.contains(p)){
            p.sendMessage(Data.gc.getPrefix() + "§cDu bist bereits in diesem Team!");
            return false;
        }else{
            return true;
        }
    }
    public static boolean oneTeamLeft(){
        int s = 0;
        if (!team_PINK.isEmpty()) {
            s++;
        }
        if (!team_GRAU.isEmpty()) {
            s++;
        }
        if (!team_SCHWARZ.isEmpty()) {
            s++;
        }
        if (!team_ORANGE.isEmpty()) {
            s++;
        }
        if (!team_GRÜN.isEmpty()) {
            s++;
        }
        if (!team_BLAU.isEmpty()) {
            s++;
        }
        if (!team_GELB.isEmpty()) {
            s++;
        }
        if (!team_ROT.isEmpty()) {
            s++;
        }
        if(s == 1){
            return true;
        }else{
            return false;
        }
    }
    public static ArrayList<Player> getWinnerTeam(){
        if(Data.mode.equalsIgnoreCase("8x1") || Data.mode.equalsIgnoreCase("8x2")){
            if(!team_PINK.isEmpty()){
                return team_PINK;
            }
            if(!team_GRAU.isEmpty()){
                return team_GRAU;
            }
            if(!team_SCHWARZ.isEmpty()){
                return team_SCHWARZ;
            }
            if(!team_ORANGE.isEmpty()){
                return team_ORANGE;
            }
            if(!team_GRÜN.isEmpty()){
                return team_GRÜN;
            }
            if(!team_BLAU.isEmpty()){
                return team_BLAU;
            }
            if(!team_GELB.isEmpty()){
                return team_GELB;
            }
            if(!team_ROT.isEmpty()){
                return team_ROT;
            }
            }
        if(Data.mode.equalsIgnoreCase("4x2") || Data.mode.equalsIgnoreCase("4x3")){
            if(!team_GRÜN.isEmpty()){
                return team_GRÜN;
            }
            if(!team_BLAU.isEmpty()){
                return team_BLAU;
            }
            if(!team_GELB.isEmpty()){
                return team_GELB;
            }
            if(!team_ROT.isEmpty()){
                return team_ROT;
            }
        }
        if(Data.mode.equalsIgnoreCase("2x2") || Data.mode.equalsIgnoreCase("2x1")){
            if(!team_ROT.isEmpty()){
                return team_ROT;
            }
            if(!team_BLAU.isEmpty()){
                return team_BLAU;
            }
        }
        return null;
    }
    public static String getTeamColor(Player p){
        if(team_ROT.contains(p)){
            return "§4";
        }
        if(team_GELB.contains(p)){
            return "§e";
        }
        if(team_BLAU.contains(p)){
            return "§9";
        }
        if(team_GRÜN.contains(p)){
            return "§a";
        }
        if(team_ORANGE.contains(p)){
            return "§6";
        }
        if(team_SCHWARZ.contains(p)){
            return "§0";
        }
        if(team_GRAU.contains(p)){
            return "§7";
        }
        if(team_PINK.contains(p)){
            return "§d";
        }
        return null;
    }
}
