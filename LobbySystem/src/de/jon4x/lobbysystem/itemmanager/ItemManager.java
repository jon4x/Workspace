package de.jon4x.lobbysystem.itemmanager;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;

/**
 * Erstellt am 18 Jan 2018 - 08:56
 * Copyright (c) Jonas Laux. Alle Rechte vorbehalten.
 * Projekt >> LobbySystem
 */

public class ItemManager {

    public static boolean get (ItemStack I, Material material, String displayName) {
        return I != null && I.hasItemMeta() && I.getItemMeta().hasDisplayName() && I.getItemMeta().getDisplayName().equalsIgnoreCase(displayName) && I.getType() == material;
    }

    public static ItemStack createSkull (Material material, int amount, String playerName, String displayName, ArrayList<String> lore) {
        ItemStack I = new ItemStack(material, amount, (short)3);
        SkullMeta skullMeta = (SkullMeta) I.getItemMeta();
        skullMeta.setDisplayName(displayName);
        skullMeta.setOwner(playerName);
        skullMeta.setLore(lore);
        I.setItemMeta(skullMeta);
        return I;
    }

    public static ItemStack createItem (Material material, int amount, int meta, String displayName, ArrayList<String> lore) {
        ItemStack I = new ItemStack(material, amount, (short)meta);
        ItemMeta itemMeta = I.getItemMeta();
        itemMeta.setDisplayName(displayName);
        itemMeta.setLore(lore);
        I.setItemMeta(itemMeta);
        return I;
    }

    public static ItemStack createDyedLeatherArmor (Material material, Color color, int amount, String displayName, ArrayList<String> lore) {
        ItemStack I = new ItemStack(material, amount, (short)0);
        LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) I.getItemMeta();
        leatherArmorMeta.setDisplayName(displayName);
        leatherArmorMeta.setLore(lore);
        leatherArmorMeta.setColor(color);
        return I;
    }

}