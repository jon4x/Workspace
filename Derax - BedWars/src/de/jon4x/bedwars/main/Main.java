package de.jon4x.bedwars.main;

import de.dytanic.cloudnet.lib.server.ServerState;
import de.jon4x.bedwars.commands.Forcemap;
import de.jon4x.bedwars.commands.Setup;
import de.jon4x.bedwars.commands.Start;
import de.jon4x.bedwars.commands.Stats;
import de.jon4x.bedwars.listener.*;
import de.jon4x.bedwars.manager.GameManager;
import de.jon4x.bedwars.manager.Tab;
import de.jon4x.bedwars.shop.ClickSHOP;
import de.jon4x.bedwars.storage.Data;
import net.claymc.gameapi.api.ActionbarAPI;
import net.claymc.gameapi.api.GameAPI;
import net.claymc.gameapi.api.GameState;
import net.spigotplugins.gameapi.manager.StatsAPI;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.v1_8_R3.CraftServer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Pascal Falk on 03.08.2017.
 * Plugin by WeLoveSpigotPlugins
 * https://youtube.com/welovespigotplugins
 * Coded with IntelliJ
 */
public class Main extends JavaPlugin {

    public static String playedMap;
    public static HashMap<String, ArrayList<Location>> teamchests = new HashMap();
    public static HashMap<String, Inventory> teamchestsinventory = new HashMap();

    public static int cd;

    @Override
    public void onEnable() {
        JoinListener.running = false;
        cd = Bukkit.getScheduler().scheduleAsyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                if (Data.ga.gs == GameState.LOBBY) {
                    if (Data.mode.equalsIgnoreCase("8x1")) {
                        if (Bukkit.getOnlinePlayers().size() < 2) {
                            for (Player all : Bukkit.getOnlinePlayers()) {
                                int i = 2 - Bukkit.getOnlinePlayers().size();
                                switch (i) {
                                    default:
                                        new ActionbarAPI().sendActionbar(all, Data.gc.getPrefix() + "§7Warten auf §e" + i + "§7 weitere Spieler...");
                                        break;
                                    case 1:
                                        new ActionbarAPI().sendActionbar(all, Data.gc.getPrefix() + "§7Warten auf §e" + i + "§7 weiteren Spieler...");
                                        break;
                                }
                            }
                        }
                    }
                    if (Data.mode.equalsIgnoreCase("8x2")) {
                        if (Bukkit.getOnlinePlayers().size() < 4) {
                            for (Player all : Bukkit.getOnlinePlayers()) {
                                int i = 4 - Bukkit.getOnlinePlayers().size();
                                switch (i) {
                                    default:
                                        new ActionbarAPI().sendActionbar(all, Data.gc.getPrefix() + "§7Warten auf §e" + i + "§7 weitere Spieler...");
                                        break;
                                    case 1:
                                        new ActionbarAPI().sendActionbar(all, Data.gc.getPrefix() + "§7Warten auf §e" + i + "§7 weiteren Spieler...");
                                        break;
                                }
                            }
                        }
                    }
                    if (Data.mode.equalsIgnoreCase("4x2")) {
                        if (Bukkit.getOnlinePlayers().size() < 4) {
                            for (Player all : Bukkit.getOnlinePlayers()) {
                                int i = 4 - Bukkit.getOnlinePlayers().size();
                                switch (i) {
                                    default:
                                        new ActionbarAPI().sendActionbar(all, Data.gc.getPrefix() + "§7Warten auf §e" + i + "§7 weitere Spieler...");
                                        break;
                                    case 1:
                                        new ActionbarAPI().sendActionbar(all, Data.gc.getPrefix() + "§7Warten auf §e" + i + "§7 weiteren Spieler...");
                                        break;
                                }
                            }
                        }
                    }
                    if (Data.mode.equalsIgnoreCase("4x3")) {
                        if (Bukkit.getOnlinePlayers().size() < 5) {
                            for (Player all : Bukkit.getOnlinePlayers()) {
                                int i = 5 - Bukkit.getOnlinePlayers().size();
                                switch (i) {
                                    default:
                                        new ActionbarAPI().sendActionbar(all, Data.gc.getPrefix() + "§7Warten auf §e" + i + "§7 weitere Spieler...");
                                        break;
                                    case 1:
                                        new ActionbarAPI().sendActionbar(all, Data.gc.getPrefix() + "§7Warten auf §e" + i + "§7 weiteren Spieler...");
                                        break;
                                }
                            }
                        }
                    }
                    if (Data.mode.equalsIgnoreCase("2x1")) {
                        if (Bukkit.getOnlinePlayers().size() < 2) {
                            for (Player all : Bukkit.getOnlinePlayers()) {
                                int i = 2 - Bukkit.getOnlinePlayers().size();
                                switch (i) {
                                    default:
                                        new ActionbarAPI().sendActionbar(all, Data.gc.getPrefix() + "§7Warten auf §e" + i + "§7 weitere Spieler...");
                                        break;
                                    case 1:
                                        new ActionbarAPI().sendActionbar(all, Data.gc.getPrefix() + "§7Warten auf §e" + i + "§7 weiteren Spieler...");
                                        break;
                                }
                            }
                        }
                    }
                    if (Data.mode.equalsIgnoreCase("2x2")) {
                        if (Bukkit.getOnlinePlayers().size() < 2) {
                            for (Player all : Bukkit.getOnlinePlayers()) {
                                int i = 2 - Bukkit.getOnlinePlayers().size();
                                switch (i) {
                                    default:
                                        new ActionbarAPI().sendActionbar(all, Data.gc.getPrefix() + "§7Warten auf §e" + i + "§7 weitere Spieler...");
                                        break;
                                    case 1:
                                        new ActionbarAPI().sendActionbar(all, Data.gc.getPrefix() + "§7Warten auf §e" + i + "§7 weiteren Spieler...");
                                        break;
                                }
                            }
                        }
                    }
                }
            }
        }, 20, 20);

        new StatsAPI().createTable("BEDWARS");
        pickRandomMap();

        Data.ga.gs = GameState.LOBBY;
        GameManager.updateGameMode(ServerState.LOBBY);
        Tab.loadTablist();
        configureGameAPI();
        Data.mode = Bukkit.getServer().getServerName();

        if (!Data.mode.toLowerCase().equalsIgnoreCase("8x1") && !Data.mode.toLowerCase().equalsIgnoreCase("8x2") && !Data.mode.toLowerCase().equalsIgnoreCase("4x2") && !Data.mode.toLowerCase().equalsIgnoreCase("4x3")
                && !Data.mode.toLowerCase().equalsIgnoreCase("2x2") && !Data.mode.toLowerCase().equalsIgnoreCase("2x1")) {
            Bukkit.getConsoleSender().sendMessage(Data.gc.getPrefix() + "§cDer angegebene Modus wird nicht unterstützt! §7(§e" + Data.mode + "§7)");
            return;
        } else {
            Bukkit.getConsoleSender().sendMessage(Data.gc.getPrefix() + "§eDie BedWars-Variante §5" + Data.mode + "§e wurde geladen.");
        }
        getServer().getPluginManager().registerEvents(new QuitListener(), this);
        getServer().getPluginManager().registerEvents(new SpielVerlassen(), this);
        getServer().getPluginManager().registerEvents(new JoinListener(), this);
        getServer().getPluginManager().registerEvents(new TeamAuswahl(), this);
        getServer().getPluginManager().registerEvents(new Setup(), this);
        getServer().getPluginManager().registerEvents(new GameStartEvent(), this);
        getServer().getPluginManager().registerEvents(new GameProtection(), this);
        getServer().getPluginManager().registerEvents(new ClickSHOP(), this);
        getServer().getPluginManager().registerEvents(new Teleporter(), this);
        getServer().getPluginManager().registerEvents(new TNT(), this);
        getServer().getPluginManager().registerEvents(new MobilerShop(), this);
        getServer().getPluginManager().registerEvents(new Fallschirm(), this);
        getServer().getPluginManager().registerEvents(new Rettungsplattform(), this);
        getServer().getPluginManager().registerEvents(new DeathListener(), this);
        getServer().getPluginManager().registerEvents(new EntityDamage(), this);
        getServer().getPluginManager().registerEvents(new BedListener(), this);
        getServer().getPluginManager().registerEvents(new Chat(), this);
        getServer().getPluginManager().registerEvents(new SpectatorInventory(), this);
        getServer().getPluginManager().registerEvents(new TeamChest(), this);
        getServer().getPluginManager().registerEvents(new Voting(), this);
        getServer().getPluginManager().registerEvents(new LoginEvent(this), this);
        getServer().getPluginManager().registerEvents(new Protect(), this);

        getCommand("setup").setExecutor(new Setup());
        getCommand("start").setExecutor(new Start());
        getCommand("stats").setExecutor(new Stats());
        getCommand("forcemap").setExecutor(new Forcemap());

        loadHashMaps();

        Bukkit.getScheduler().scheduleAsyncRepeatingTask(this, () -> {
            if(Data.ga.gs == GameState.INGAME) {
                for (Player p : Bukkit.getOnlinePlayers()) {
                    if(p.getLocation().getY() < -25){
                        if(!DeathListener.spectator.contains(p)) {
                            damage(p);
                        }else{
                            Location loc = p.getLocation();
                            loc.setY(100);
                            p.teleport(loc);
                        }
                    }
                    if (p.getLocation().getBlock().getType() != Material.CARPET && p.getLocation().subtract(0.0, 1.0, 0.0).getBlock().getType() != Material.CARPET)
                        continue;
                    loadCarpets(p);
                }
            }
        },4L, 4L);
        ((CraftServer)Bukkit.getServer()).getServer().setMotd("LOBBY;" + Data.mode + ";" + playedMap);

        //Top5Wall.set();


    }

    private void loadCarpets(Player p) {
        Bukkit.getScheduler().scheduleSyncDelayedTask(this, () -> p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 60, 2)), 1);
    }
    private void damage(Player p){
        Bukkit.getScheduler().scheduleSyncDelayedTask(this, () -> p.damage(20),1L);
    }


    private void pickRandomMap() {
        File file = new File("plugins//BedWars//data.yml");
        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        List list = cfg.getStringList("Maps");
        if(list.isEmpty()){
            Bukkit.getConsoleSender().sendMessage("§4§lES WURDE KEINE MAP GELADEN, DA KEINE EINGERICHTET WURDE...");
        }else{
            int zahl = (int)((Math.random()) * list.size());
            playedMap = (String) list.get(zahl);
            World w = MapResetAPI.resetWorld(new File("backup_" + playedMap) , new File(playedMap) , playedMap);
        }
    }

    private void configureGameAPI() {
        GameAPI.gameConfiguration.setSubcolorcode("§e");
        GameAPI.gameConfiguration.setColorcode("§6");
        GameAPI.gameConfiguration.setPrefix("§8» §cBedWars §8× ");
        GameAPI.gameConfiguration.setRawgamename("BedWars");
    }

    @Override
    public void onDisable() {
        World w = MapResetAPI.resetWorld(new File("backup_" + playedMap) , new File(playedMap) , playedMap);
    }
    public static void removeInventoryItemsStack(PlayerInventory inv, Material type, int amount, ItemStack add) {
        int maxamount = 0;
        ItemStack[] arritemStack = inv.getContents();
        int n = arritemStack.length;
        int n2 = 0;
        while (n2 < n) {
            ItemStack is = arritemStack[n2];
            if (is != null && is.getType() == type) {
                maxamount += is.getAmount();
            }
            ++n2;
        }
        int amountofitems = maxamount / amount;
        if (add.getAmount() == 2) {
            if (amountofitems >= 33) {
                amountofitems = 32;
            }
        } else if (amountofitems >= 65) {
            amountofitems = 64;
        }
        int remove = amountofitems * amount;
        removeInventoryItems(inv, type, remove);
        int i = 0;
        while (i < amountofitems) {
            inv.addItem(new ItemStack[]{add});
            ++i;
        }
    }
    public static boolean removeInventoryItems(PlayerInventory inv, Material type, int amount) {
        boolean b = false;
        ItemStack[] arritemStack = inv.getContents();
        int n = arritemStack.length;
        int n2 = 0;
        while (n2 < n) {
            ItemStack is = arritemStack[n2];
            if (is != null && is.getType() == type) {
                b = true;
                int newamount = is.getAmount() - amount;
                if (newamount > 0) {
                    is.setAmount(newamount);
                    break;
                }
                inv.remove(is);
                amount = - newamount;
                if (amount == 0) break;
            }
            ++n2;
        }
        return b;
    }
    private void loadHashMaps() {
        ClickSHOP.bloecke_material.put(11, Material.CLAY_BRICK);
        ClickSHOP.bloecke_material.put(12, Material.CLAY_BRICK);
        ClickSHOP.bloecke_material.put(13, Material.IRON_INGOT);
        ClickSHOP.bloecke_material.put(14, Material.CLAY_BRICK);
        ClickSHOP.bloecke_material.put(15, Material.CLAY_BRICK);
        ClickSHOP.bloecke_price.put(11, 1);
        ClickSHOP.bloecke_price.put(12, 7);
        ClickSHOP.bloecke_price.put(13, 3);
        ClickSHOP.bloecke_price.put(14, 4);
        ClickSHOP.bloecke_price.put(15, 4);
        ClickSHOP.ruestung_material.put(9, Material.CLAY_BRICK);
        ClickSHOP.ruestung_material.put(10, Material.CLAY_BRICK);
        ClickSHOP.ruestung_material.put(11, Material.CLAY_BRICK);
        ClickSHOP.ruestung_material.put(14, Material.IRON_INGOT);
        ClickSHOP.ruestung_material.put(15, Material.IRON_INGOT);
        ClickSHOP.ruestung_material.put(16, Material.IRON_INGOT);
        ClickSHOP.ruestung_material.put(17, Material.IRON_INGOT);
        ClickSHOP.ruestung_price.put(9, 1);
        ClickSHOP.ruestung_price.put(10, 1);
        ClickSHOP.ruestung_price.put(11, 1);
        ClickSHOP.ruestung_price.put(14, 1);
        ClickSHOP.ruestung_price.put(15, 3);
        ClickSHOP.ruestung_price.put(16, 5);
        ClickSHOP.ruestung_price.put(17, 7);
        ClickSHOP.spitzhacken_material.put(11, Material.CLAY_BRICK);
        ClickSHOP.spitzhacken_material.put(13, Material.IRON_INGOT);
        ClickSHOP.spitzhacken_material.put(15, Material.GOLD_INGOT);
        ClickSHOP.spitzhacken_price.put(11, 4);
        ClickSHOP.spitzhacken_price.put(13, 2);
        ClickSHOP.spitzhacken_price.put(15, 1);
        ClickSHOP.schwerter_material.put(10, Material.CLAY_BRICK);
        ClickSHOP.schwerter_material.put(12, Material.IRON_INGOT);
        ClickSHOP.schwerter_material.put(13, Material.IRON_INGOT);
        ClickSHOP.schwerter_material.put(14, Material.IRON_INGOT);
        ClickSHOP.schwerter_material.put(16, Material.GOLD_INGOT);
        ClickSHOP.schwerter_price.put(10, 8);
        ClickSHOP.schwerter_price.put(12, 1);
        ClickSHOP.schwerter_price.put(13, 3);
        ClickSHOP.schwerter_price.put(14, 5);
        ClickSHOP.schwerter_price.put(16, 5);
        ClickSHOP.boegen_material.put(11, Material.GOLD_INGOT);
        ClickSHOP.boegen_material.put(12, Material.GOLD_INGOT);
        ClickSHOP.boegen_material.put(13, Material.GOLD_INGOT);
        ClickSHOP.boegen_material.put(15, Material.GOLD_INGOT);
        ClickSHOP.boegen_price.put(11, 3);
        ClickSHOP.boegen_price.put(12, 6);
        ClickSHOP.boegen_price.put(13, 9);
        ClickSHOP.boegen_price.put(15, 1);
        ClickSHOP.essen_material.put(11, Material.CLAY_BRICK);
        ClickSHOP.essen_material.put(12, Material.CLAY_BRICK);
        ClickSHOP.essen_material.put(13, Material.IRON_INGOT);
        ClickSHOP.essen_material.put(15, Material.IRON_INGOT);
        ClickSHOP.essen_price.put(11, 1);
        ClickSHOP.essen_price.put(12, 2);
        ClickSHOP.essen_price.put(13, 1);
        ClickSHOP.essen_price.put(15, 2);
        ClickSHOP.kisten_material.put(12, Material.IRON_INGOT);
        ClickSHOP.kisten_material.put(14, Material.GOLD_INGOT);
        ClickSHOP.kisten_price.put(12, 1);
        ClickSHOP.kisten_price.put(14, 1);
        ClickSHOP.traenke_material.put(9, Material.IRON_INGOT);
        ClickSHOP.traenke_material.put(11, Material.IRON_INGOT);
        ClickSHOP.traenke_material.put(13, Material.GOLD_INGOT);
        ClickSHOP.traenke_material.put(15, Material.GOLD_INGOT);
        ClickSHOP.traenke_material.put(17, Material.IRON_INGOT);
        ClickSHOP.traenke_price.put(9, 3);
        ClickSHOP.traenke_price.put(11, 7);
        ClickSHOP.traenke_price.put(13, 3);
        ClickSHOP.traenke_price.put(15, 3);
        ClickSHOP.traenke_price.put(17, 5);
        ClickSHOP.spezial_material.put(9, Material.CLAY_BRICK);
        ClickSHOP.spezial_material.put(10, Material.IRON_INGOT);
        ClickSHOP.spezial_material.put(11, Material.IRON_INGOT);
        ClickSHOP.spezial_material.put(12, Material.GOLD_INGOT);
        ClickSHOP.spezial_material.put(13, Material.IRON_INGOT);
        ClickSHOP.spezial_material.put(14, Material.GOLD_INGOT);
        ClickSHOP.spezial_material.put(15, Material.GOLD_INGOT);
        ClickSHOP.spezial_material.put(16, Material.GOLD_INGOT);
        ClickSHOP.spezial_material.put(17, Material.CLAY_BRICK);
        ClickSHOP.spezial_price.put(9, 4);
        ClickSHOP.spezial_price.put(10, 5);
        ClickSHOP.spezial_price.put(11, 7);
        ClickSHOP.spezial_price.put(12, 3);
        ClickSHOP.spezial_price.put(14, 3);
        ClickSHOP.spezial_price.put(15, 3);
        ClickSHOP.spezial_price.put(16, 13);
        ClickSHOP.spezial_price.put(17, 16);
        ClickSHOP.spezial_price.put(13, 3);
    }
    public static Location getSpawnLocation(Player p){
        if(TeamAuswahl.team_GRAU.contains(p)){
            return Data.ca.getLocation("spawns", Main.playedMap.toLowerCase() + ".grau");
        }
        if(TeamAuswahl.team_PINK.contains(p)){
            return Data.ca.getLocation("spawns", Main.playedMap.toLowerCase() + ".pink");
        }
        if(TeamAuswahl.team_ORANGE.contains(p)){
            return Data.ca.getLocation("spawns", Main.playedMap.toLowerCase() + ".orange");
        }
        if(TeamAuswahl.team_SCHWARZ.contains(p)){
            return Data.ca.getLocation("spawns", Main.playedMap.toLowerCase() + ".schwarz");
        }
        if(TeamAuswahl.team_GRÜN.contains(p)){
            return Data.ca.getLocation("spawns", Main.playedMap.toLowerCase() + ".gruen");
        }
        if(TeamAuswahl.team_GELB.contains(p)){
            return Data.ca.getLocation("spawns", Main.playedMap.toLowerCase() + ".gelb");
        }
        if(TeamAuswahl.team_ROT.contains(p)){
            return Data.ca.getLocation("spawns", Main.playedMap.toLowerCase() + ".rot");
        }
        if(TeamAuswahl.team_BLAU.contains(p)){
            return Data.ca.getLocation("spawns", Main.playedMap.toLowerCase() + ".blau");
        }
        return null;
    }


}
