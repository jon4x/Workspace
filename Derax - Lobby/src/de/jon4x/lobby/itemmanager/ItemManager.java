package de.jon4x.lobby.itemmanager;

import org.bukkit.inventory.*;
import org.bukkit.*;
import java.util.*;
import org.bukkit.inventory.meta.*;

public class ItemManager {

    public static boolean get(ItemStack I, Material Material, String Displayname) {
        return I != null && I.hasItemMeta() && I.getItemMeta().hasDisplayName() && I.getItemMeta().getDisplayName().equalsIgnoreCase(Displayname) && I.getType() == Material;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static ItemStack createSkull(Material Material, int Amount, String Playername, String Displayname, ArrayList<String> Lore) {
        ItemStack I = new ItemStack(Material, Amount, (short)3);
        SkullMeta Im = (SkullMeta)I.getItemMeta();
        Im.setDisplayName(Displayname);
        Im.setOwner(Playername);
        Im.setLore(Lore);
        I.setItemMeta(Im);
        return I;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static ItemStack createItem(Material Material, int Amount, int Meta, String Displayname, ArrayList<String> Lore) {
        ItemStack I = new ItemStack(Material, Amount, (short)Meta);
        ItemMeta Im = I.getItemMeta();
        Im.setDisplayName(Displayname);
        Im.setLore(Lore);
        I.setItemMeta(Im);
        return I;
    }

}
