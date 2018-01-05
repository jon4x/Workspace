package de.jon4x.bedwars.shop;

import java.util.Arrays;
import java.util.HashMap;

import de.jon4x.bedwars.listener.TeamAuswahl;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;


public class SHOP implements Listener{

    public static void openHauptInv(Player p){
        Inventory inv = Bukkit.createInventory(null, 1*9, "§8\u00bb §cShop");

        inv.addItem(createItem(Material.SANDSTONE, "§8\u00bb §7Blöcke"));
        inv.addItem(createItem(Material.CHAINMAIL_CHESTPLATE, "§8\u00bb §7Rüstung"));
        inv.addItem(createItem(Material.IRON_PICKAXE, "§8\u00bb §7Spitzhacken"));
        inv.addItem(createItem(Material.WOOD_SWORD, "§8\u00bb §7Schwerter"));
        inv.addItem(createItem(Material.BOW, "§8\u00bb §7Bögen"));
        inv.addItem(createItem(Material.CAKE, "§8\u00bb §7Essen"));
        inv.addItem(createItem(Material.ENDER_CHEST, "§8\u00bb §7Kisten"));
        inv.addItem(createItem(Material.GLASS_BOTTLE, "§8\u00bb §7Tränke"));
        inv.addItem(createItem(Material.EMERALD, "§8\u00bb §7Spezial"));

        p.openInventory(inv);
    }

    public static void openBoegenInv(Player p){
        Inventory inv = getHauptInv("Bögen");

        HashMap<Enchantment, Integer> list = new HashMap<Enchantment, Integer>();

        list.put(Enchantment.ARROW_INFINITE, 1);

        ItemStack i = createItemenchant(Material.BOW, "§cBogen Level 1", "§6§l3 Gold", list);
        i.setDurability((short)0.25);
        inv.setItem(11, i);

        list.put(Enchantment.ARROW_DAMAGE, 1);

        i = createItemenchant(Material.BOW, "§cBogen Level 2", "§6§l6 Gold", list);
        i.setDurability((short)0.25);
        inv.setItem(12, i);

        list.clear();

        list.put(Enchantment.ARROW_DAMAGE, 2);
        list.put(Enchantment.ARROW_INFINITE, 1);

        i = createItemenchant(Material.BOW, "§cBogen Level 3", "§6§l9 Gold", list);
        i.setDurability((short)0.25);
        inv.setItem(13, i);

        inv.setItem(15, createItemamount(Material.ARROW, "§cPfeil", 1, "§6§l1 Gold"));


        p.openInventory(inv);
    }

    public static void openSpezialSHOP(Player p){
        Inventory inv = getHauptInv("Spezial");

        inv.addItem(createItemamount(Material.LADDER, "§cLeiter", 1, "§c§l4 Bronze"));
        inv.addItem(createItemamount(Material.FIREWORK, "§cTeleporter", 1, "§7§l5 Eisen"));
        inv.addItem(createItemamount(Material.ARMOR_STAND, "§cMobiler Shop", 1, "§7§l7 Eisen"));
        inv.addItem(createItemamount(Material.TNT, "§cTNT", 1, "§6§l3 Gold"));
        inv.addItem(createItemamount(Material.CARPET, "§cSpeed Teppich", 1, "§7§l3 Eisen"));

        inv.setItem(14, createItemamount(Material.EGG, "§cFallschirm", 1, "§6§l3 Gold"));
        inv.setItem(15, createItemamount(Material.BLAZE_ROD, "§cRettungsplattform", 1, "§6§l3 Gold"));
        inv.setItem(16, createItemamount(Material.ENDER_PEARL, "§cEnderperle", 1, "§6§l13 Gold"));
        inv.setItem(17, createItemamount(Material.WEB, "§cSpinnweben", 1, "§c§l16 Bronze"));



        p.openInventory(inv);
    }


    public static void openBloeckeInv(Player p){
        Inventory inv = getHauptInv("Blöcke");

        inv.setItem(11, createItemamount(Material.SANDSTONE, "§cSandstein", 2, "§c§l1 Bronze"));
        inv.setItem(12, createItemamount(Material.ENDER_STONE, "§cEndstein", 1, "§c§l7 Bronze"));
        inv.setItem(13, createItemamount(Material.IRON_BLOCK, "§cEisenblock", 1, "§7§l3 Eisen"));

        ItemStack item = new ItemStack(Material.STAINED_GLASS,1,getTeamColor(p));
        ItemMeta itemm = item.getItemMeta();
        itemm.setDisplayName("§cTeamGlass");
        itemm.setLore(Arrays.asList("§c§l4 Bronze"));
        item.setItemMeta(itemm);
        inv.setItem(14, item);

        inv.setItem(15, createItemamount(Material.GLOWSTONE, "§cGlowstone", 1, "§c§l4 Bronze"));


        p.openInventory(inv);
    }

    public static void openKistenInv(Player p){
        Inventory inv = getHauptInv("Kisten");

        inv.setItem(12, createItemamount(Material.CHEST, "§cKiste", 1, "§7§l1 Eisen"));
        inv.setItem(14, createItemamount(Material.ENDER_CHEST, "§cTeamKiste", 1, "§6§l1 Gold"));



        p.openInventory(inv);
    }

    public static void openTraenkeInv(Player p){
        Inventory inv = getHauptInv("Tränke");

        inv.setItem(9, createItemtraenke("§cTrank der Heilung 1", "§7§l3 Eisen", 8261));
        inv.setItem(11, createItemtraenke("§cTrank der Heilung 2", "§7§l7 Eisen", 8229));
        inv.setItem(13, createItemtraenke("§cTrank der Stärke", "§6§l3 Gold", 8201));
        inv.setItem(15, createItemtraenke("§cTrank der Regeneration", "§6§l3 Gold", 8193));
        inv.setItem(17, createItemtraenke("§cTrank der Sprungkraft", "§7§l5 Eisen", 8203));

        p.openInventory(inv);
    }

    public static void openEssenInv(Player p){
        Inventory inv = getHauptInv("Essen");

        inv.setItem(11, createItemamount(Material.APPLE, "§cApfel", 1, "§c§l1 Bronze"));
        inv.setItem(12, createItemamount(Material.COOKED_BEEF, "§cSteak", 1, "§c§l2 Bronze"));
        inv.setItem(13, createItemamount(Material.CAKE, "§cKuchen", 1, "§7§l1 Eisen"));

        inv.setItem(15, createItemamount(Material.GOLDEN_APPLE, "§cGoldener Apfel", 1, "§6§l2 Gold"));




        p.openInventory(inv);
    }

    public static void openSpitzhackenInv(Player p){
        Inventory inv = getHauptInv("Spitzhacken");

        inv.setItem(11, createItemamount(Material.WOOD_PICKAXE, "§cSpitzhacke Level 1", 1, "§c§l4 Bronze"));
        inv.setItem(13, createItemamount(Material.STONE_PICKAXE, "§cSpitzhacke Level 2", 1, "§7§l2 Eisen"));
        inv.setItem(15, createItemamount(Material.IRON_PICKAXE, "§cSpitzhacke Level 3", 1, "§6§l1 Gold"));




        p.openInventory(inv);
    }

    public static void openRuestungInv(Player p){
        Inventory inv = getHauptInv("Rüstung");

        inv.setItem(9, createItemarmor("§cLederhelm", "§c§l1 Bronze", Material.LEATHER_HELMET, p));
        inv.setItem(10, createItemarmor("§cLederhose", "§c§l1 Bronze", Material.LEATHER_LEGGINGS, p));
        inv.setItem(11, createItemarmor("§cLederschuhe", "§c§l1 Bronze", Material.LEATHER_BOOTS, p));

        inv.setItem(14, createItemamount(Material.CHAINMAIL_CHESTPLATE, "§cBrustplatte Level 1", 1, "§7§l1 Eisen"));

        HashMap<Enchantment, Integer> list = new HashMap<Enchantment, Integer>();

        list.put(Enchantment.PROTECTION_ENVIRONMENTAL, 1);

        inv.setItem(15, createItemenchant(Material.CHAINMAIL_CHESTPLATE, "§cBrustplatte Level 2", "§7§l3 Eisen", list));

        list.clear();

        list.put(Enchantment.PROTECTION_ENVIRONMENTAL, 2);

        inv.setItem(16, createItemenchant(Material.CHAINMAIL_CHESTPLATE, "§cBrustplatte Level 3", "§7§l5 Eisen", list));

        list.clear();

        list.put(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
        list.put(Enchantment.THORNS, 1);

        inv.setItem(17, createItemenchant(Material.CHAINMAIL_CHESTPLATE, "§cBrustplatte Level 4", "§7§l7 Eisen", list));


        p.openInventory(inv);
    }

    public static void openSchwerterInv(Player p){
        Inventory inv = getHauptInv("Schwerter");

        HashMap<Enchantment, Integer> list = new HashMap<Enchantment, Integer>();

        list.put(Enchantment.KNOCKBACK, 1);

        inv.setItem(10, createItemenchant(Material.STICK, "§cKnüppel", "§c§l8 Bronze", list));

        list.clear();

        inv.setItem(12, createItemamount(Material.WOOD_SWORD, "§cHolzschwert", 1, "§7§l1 Eisen"));

        list.clear();

        list.put(Enchantment.DAMAGE_ALL, 1);
        list.put(Enchantment.DURABILITY, 1);

        inv.setItem(13, createItemenchant(Material.WOOD_SWORD, "§cHolzschwert Level 1", "§7§l3 Eisen", list));

        list.clear();

        list.put(Enchantment.DAMAGE_ALL, 2);
        list.put(Enchantment.DURABILITY, 1);

        inv.setItem(14, createItemenchant(Material.WOOD_SWORD, "§cHolzschwert Level 2", "§7§l5 Eisen", list));

        list.clear();

        list.put(Enchantment.DAMAGE_ALL, 2);
        list.put(Enchantment.KNOCKBACK, 1);

        inv.setItem(16, createItemenchant(Material.IRON_SWORD, "§cEisenschwert", "§6§l5 Gold", list));


        p.openInventory(inv);
    }

    public static Inventory getHauptInv(String name){
        Inventory inv = Bukkit.createInventory(null, 2*9, "§8\u00bb §cShop §8- §c"+name);

        inv.addItem(createItem(Material.SANDSTONE, "§8\u00bb §7Blöcke"));
        inv.addItem(createItem(Material.CHAINMAIL_CHESTPLATE, "§8\u00bb §7Rüstung"));
        inv.addItem(createItem(Material.IRON_PICKAXE, "§8\u00bb §7Spitzhacken"));
        inv.addItem(createItem(Material.WOOD_SWORD, "§8\u00bb §7Schwerter"));
        inv.addItem(createItem(Material.BOW, "§8\u00bb §7Bögen"));
        inv.addItem(createItem(Material.CAKE, "§8\u00bb §7Essen"));
        inv.addItem(createItem(Material.ENDER_CHEST, "§8\u00bb §7Kisten"));
        inv.addItem(createItem(Material.GLASS_BOTTLE, "§8\u00bb §7Tränke"));
        inv.addItem(createItem(Material.EMERALD, "§8\u00bb §7Spezial"));

        return inv;
    }

    public static ItemStack createItem(Material m, String name){
        ItemStack item = new ItemStack(m);
        ItemMeta itemm = item.getItemMeta();
        itemm.setDisplayName(name);
        item.setItemMeta(itemm);
        return item;
    }

    public static ItemStack createItemamount(Material m, String name, int amount, String lore){
        ItemStack item = new ItemStack(m,amount);
        ItemMeta itemm = item.getItemMeta();
        itemm.setDisplayName(name);
        itemm.setLore(Arrays.asList(lore));
        item.setItemMeta(itemm);
        return item;
    }

    public static ItemStack createItemtraenke(String name, String lore, int shortID){
        ItemStack item = new ItemStack(Material.POTION,1,(short)shortID);
        ItemMeta itemm = item.getItemMeta();
        itemm.setDisplayName(name);
        itemm.setLore(Arrays.asList(lore));
        item.setItemMeta(itemm);
        return item;
    }

    public static ItemStack createItemarmor(String name, String lore, Material m, Player p){
        ItemStack item = new ItemStack(m);
        LeatherArmorMeta itemm = (LeatherArmorMeta) item.getItemMeta();
        itemm.setDisplayName(name);
        itemm.setLore(Arrays.asList(lore));
        itemm.setColor(getTeamColor_Armor(p));
        item.setItemMeta(itemm);
        return item;
    }

    public static ItemStack createItemenchant(Material m, String name, String lore, HashMap<Enchantment, Integer> list){
        ItemStack item = new ItemStack(m);
        ItemMeta itemm = item.getItemMeta();
        itemm.setDisplayName(name);
        itemm.setLore(Arrays.asList(lore));
        for(Enchantment e : list.keySet()){
            itemm.addEnchant(e, list.get(e), true);
        }
        item.setItemMeta(itemm);
        return item;
    }

    public static Short getTeamColor(Player p){
        short b = 0;

        if(TeamAuswahl.team_BLAU.contains(p)){
            b = 11;
        }else if(TeamAuswahl.team_ROT.contains(p)){
            b = 14;
        }else if(TeamAuswahl.team_GELB.contains(p)){
            b = 4;
        }else if(TeamAuswahl.team_GRÜN.contains(p)){
            b = 13;
        }else if(TeamAuswahl.team_SCHWARZ.contains(p)){
            b = 15;
        }else if(TeamAuswahl.team_ORANGE.contains(p)){
            b = 1;
        }else if(TeamAuswahl.team_PINK.contains(p)){
            b = 6;
        }else if(TeamAuswahl.team_GRAU.contains(p)){
            b = 7;
        }

        return b;
    }

    public static Color getTeamColor_Armor(Player p){
        Color c = null;

        if(TeamAuswahl.team_BLAU.contains(p)){
            c = Color.BLUE;
        }else if(TeamAuswahl.team_ROT.contains(p)){
            c = Color.RED;
        }else if(TeamAuswahl.team_GELB.contains(p)){
            c = Color.YELLOW;
        }else if(TeamAuswahl.team_GRÜN.contains(p)){
            c = Color.GREEN;
        }else if(TeamAuswahl.team_PINK.contains(p)){
            c = Color.FUCHSIA;
        }else if(TeamAuswahl.team_ORANGE.contains(p)){
            c = Color.ORANGE;
        }else if(TeamAuswahl.team_GRAU.contains(p)){
            c = Color.GRAY;
        }else if(TeamAuswahl.team_SCHWARZ.contains(p)){
            c = Color.BLACK;
        }

        return c;
    }
}