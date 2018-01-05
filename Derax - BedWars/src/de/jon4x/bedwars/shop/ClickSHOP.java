package de.jon4x.bedwars.shop;

import java.util.HashMap;
import java.util.Map;

import de.jon4x.bedwars.listener.DeathListener;
import de.jon4x.bedwars.main.Main;
import de.jon4x.bedwars.storage.Data;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;


public class ClickSHOP implements Listener{

    public static HashMap<Integer, Material> bloecke_material = new HashMap<Integer, Material>();
    public static HashMap<Integer, Integer> bloecke_price = new HashMap<Integer, Integer>();

    public static HashMap<Integer, Material> ruestung_material = new HashMap<Integer, Material>();
    public static HashMap<Integer, Integer> ruestung_price = new HashMap<Integer, Integer>();

    public static HashMap<Integer, Material> spitzhacken_material = new HashMap<Integer, Material>();
    public static HashMap<Integer, Integer> spitzhacken_price = new HashMap<Integer, Integer>();

    public static HashMap<Integer, Material> schwerter_material = new HashMap<Integer, Material>();
    public static HashMap<Integer, Integer> schwerter_price = new HashMap<Integer, Integer>();

    public static HashMap<Integer, Material> boegen_material = new HashMap<Integer, Material>();
    public static HashMap<Integer, Integer> boegen_price = new HashMap<Integer, Integer>();

    public static HashMap<Integer, Material> essen_material = new HashMap<Integer, Material>();
    public static HashMap<Integer, Integer> essen_price = new HashMap<Integer, Integer>();

    public static HashMap<Integer, Material> kisten_material = new HashMap<Integer, Material>();
    public static HashMap<Integer, Integer> kisten_price = new HashMap<Integer, Integer>();

    public static HashMap<Integer, Material> traenke_material = new HashMap<Integer, Material>();
    public static HashMap<Integer, Integer> traenke_price = new HashMap<Integer, Integer>();

    public static HashMap<Integer, Material> spezial_material = new HashMap<Integer, Material>();
    public static HashMap<Integer, Integer> spezial_price = new HashMap<Integer, Integer>();

    @EventHandler
    public void onInteract(PlayerInteractEntityEvent e){
        Player p = e.getPlayer();
        if(e.getRightClicked().getType() == EntityType.VILLAGER){
            if(DeathListener.spectator.contains(e.getPlayer())){
                e.setCancelled(true);
                return;
            }
            e.setCancelled(true);
            SHOP.openHauptInv(p);
        }
    }

    @SuppressWarnings("deprecation")
    @EventHandler
    public void onClick(InventoryClickEvent e){
        Player p = (Player)e.getWhoClicked();
        if(e.getInventory().getName().contains("§8\u00bb §cShop")){
            if(e.getClickedInventory() != p.getInventory()){
                e.setCancelled(true);

                if(e.getCurrentItem() == null){
                    return;
                }

                if(e.getCurrentItem().getType() != Material.AIR){
                    String s = "";

                    try {
                        s = e.getCurrentItem().getItemMeta().getDisplayName();


                        if(s.equalsIgnoreCase("§8\u00bb §7Blöcke")){
                            SHOP.openBloeckeInv(p);
                        }

                        if(s.equalsIgnoreCase("§8\u00bb §7Spitzhacken")){
                            SHOP.openSpitzhackenInv(p);
                        }

                        if(s.equalsIgnoreCase("§8\u00bb §7Schwerter")){
                            SHOP.openSchwerterInv(p);
                        }

                        if(s.equalsIgnoreCase("§8\u00bb §7Bögen")){
                            SHOP.openBoegenInv(p);
                        }

                        if(s.equalsIgnoreCase("§8\u00bb §7Essen")){
                            SHOP.openEssenInv(p);
                        }

                        if(s.equalsIgnoreCase("§8\u00bb §7Kisten")){
                            SHOP.openKistenInv(p);
                        }

                        if(s.equalsIgnoreCase("§8\u00bb §7Tränke")){
                            SHOP.openTraenkeInv(p);
                        }

                        if(s.equalsIgnoreCase("§8\u00bb §7Rüstung")){
                            SHOP.openRuestungInv(p);
                        }

                        if(s.equalsIgnoreCase("§8\u00bb §7Spezial")){
                            SHOP.openSpezialSHOP(p);
                        }

                    } catch (Exception e2) {
                        // TODO: handle exception
                    }

                }

            }

            if(e.getInventory().getName().contains("§8\u00bb §cShop §8-")){
                if(e.getClickedInventory() != p.getInventory()){
                    e.setCancelled(true);

                    String s = "";

                    try {
                        s = e.getCurrentItem().getItemMeta().getDisplayName();
                    } catch (Exception e2) {
                        // TODO: handle exception
                    }

                    HashMap<Integer, Material> list1 = new HashMap<Integer, Material>();
                    HashMap<Integer, Integer> list2 = new HashMap<Integer, Integer>();

                    if(e.getInventory().getName().contains("Blöcke")){
                        list1 = bloecke_material;
                        list2 = bloecke_price;
                    }else if(e.getInventory().getName().contains("Rüstung")){
                        list1 = ruestung_material;
                        list2 = ruestung_price;
                    }else if(e.getInventory().getName().contains("Spitzhacken")){
                        list1 = spitzhacken_material;
                        list2 = spitzhacken_price;
                    }else if(e.getInventory().getName().contains("Schwerter")){
                        list1 = schwerter_material;
                        list2 = schwerter_price;
                    }else if(e.getInventory().getName().contains("Bögen")){
                        list1 = boegen_material;
                        list2 = boegen_price;
                    }else if(e.getInventory().getName().contains("Essen")){
                        list1 = essen_material;
                        list2 = essen_price;
                    }else if(e.getInventory().getName().contains("Kisten")){
                        list1 = kisten_material;
                        list2 = kisten_price;
                    }else if(e.getInventory().getName().contains("Tränke")){
                        list1 = traenke_material;
                        list2 = traenke_price;
                    }else if(e.getInventory().getName().contains("Spezial")){
                        list1 = spezial_material;
                        list2 = spezial_price;
                    }

                    if(s.contains("§c")){
                        if(e.getAction() == InventoryAction.MOVE_TO_OTHER_INVENTORY){
                            int price = 0;
                            Material waehrung = null;

                            if(list2.containsKey(e.getSlot())){
                                price = list2.get(e.getSlot());
                            }else{
                                p.sendMessage(Data.gc.getPrefix() + "§cEs ist ein Fehler aufgetreten!");
                                e.getView().close();
                                return;
                            }

                            if(list1.containsKey(e.getSlot())){
                                waehrung = list1.get(e.getSlot());
                            }else{
                                p.sendMessage(Data.gc.getPrefix() +"§cEs ist ein Fehler aufgetreten!");
                                e.getView().close();
                                return;
                            }


                            int amount = e.getCurrentItem().getAmount();
                            Material m = e.getCurrentItem().getType();
                            short nebenID = e.getCurrentItem().getData().getData();

                            p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1, 1);

                            ItemStack add = new ItemStack(m,amount,nebenID);
                            if(e.getCurrentItem().getType() == Material.LEATHER_HELMET || e.getCurrentItem().getType() == Material.LEATHER_CHESTPLATE
                                    || e.getCurrentItem().getType() == Material.LEATHER_LEGGINGS || e.getCurrentItem().getType() == Material.LEATHER_BOOTS){
                                LeatherArmorMeta itemm = (LeatherArmorMeta)add.getItemMeta();
                                LeatherArmorMeta im2 = (LeatherArmorMeta)e.getCurrentItem().getItemMeta();

                                itemm.setColor(im2.getColor());

                                Map<Enchantment, Integer> enchanments = e.getCurrentItem().getItemMeta().getEnchants();

                                for(Enchantment ench : enchanments.keySet()){
                                    itemm.addEnchant(ench, enchanments.get(ench), true);
                                }
                                add.setItemMeta(itemm);

                                Main.removeInventoryItemsStack(p.getInventory(), waehrung, price, add);
                            }else{
                                ItemMeta itemm = add.getItemMeta();

                                Map<Enchantment, Integer> enchanments = e.getCurrentItem().getItemMeta().getEnchants();

                                for(Enchantment ench : enchanments.keySet()){
                                    itemm.addEnchant(ench, enchanments.get(ench), true);
                                }
                                add.setItemMeta(itemm);

                                Main.removeInventoryItemsStack(p.getInventory(), waehrung, price, add);

                            }


                        }else{

                            int price = 0;
                            Material waehrung = null;

                            if(list2.containsKey(e.getSlot())){
                                price = list2.get(e.getSlot());
                            }else{
                                p.sendMessage(Data.gc.getPrefix() +"§cEs ist ein Fehler aufgetreten!");
                                e.getView().close();
                                return;
                            }

                            if(list1.containsKey(e.getSlot())){
                                waehrung = list1.get(e.getSlot());
                            }else{
                                p.sendMessage(Data.gc.getPrefix() +"§cEs ist ein Fehler aufgetreten!");
                                e.getView().close();
                                return;
                            }

                            int amount = e.getCurrentItem().getAmount();
                            Material m = e.getCurrentItem().getType();
                            short nebenID = e.getCurrentItem().getData().getData();


                            if(p.getInventory().contains(waehrung, price)){

                                p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1, 1);

                                Main.removeInventoryItems(p.getInventory(), waehrung, price);

                                if(e.getCurrentItem().getType() == Material.LEATHER_HELMET || e.getCurrentItem().getType() == Material.LEATHER_CHESTPLATE
                                        || e.getCurrentItem().getType() == Material.LEATHER_LEGGINGS || e.getCurrentItem().getType() == Material.LEATHER_BOOTS){

                                    ItemStack item = new ItemStack(m,amount,nebenID);
                                    LeatherArmorMeta itemm = (LeatherArmorMeta) item.getItemMeta();

                                    LeatherArmorMeta im2 = (LeatherArmorMeta)e.getCurrentItem().getItemMeta();

                                    itemm.setColor(im2.getColor());

                                    Map<Enchantment, Integer> enchanments = e.getCurrentItem().getItemMeta().getEnchants();

                                    for(Enchantment ench : enchanments.keySet()){
                                        itemm.addEnchant(ench, enchanments.get(ench), true);
                                    }
                                    item.setItemMeta(itemm);
                                    p.getInventory().addItem(item);

                                }else{
                                    ItemStack item = new ItemStack(m,amount,nebenID);
                                    ItemMeta itemm = item.getItemMeta();

                                    Map<Enchantment, Integer> enchanments = e.getCurrentItem().getItemMeta().getEnchants();

                                    for(Enchantment ench : enchanments.keySet()){
                                        itemm.addEnchant(ench, enchanments.get(ench), true);
                                    }
                                    item.setItemMeta(itemm);
                                    p.getInventory().addItem(item);
                                }

                            }else{
                                p.sendMessage(Data.gc.getPrefix() +"§cDu hast zu wenig Ressourcen!");
                            }




                        }
                    }

                }
            }

            if(e.getInventory().getName().equalsIgnoreCase("§8\u00bb §cShop §8- §cBlöcke")){
                if(e.getClickedInventory() != p.getInventory()){
                    e.setCancelled(true);

                    if(e.getCurrentItem().getType() != Material.AIR && e.getSlot() >= 11 && e.getSlot() <= 15){
                        if(e.getAction() == InventoryAction.MOVE_TO_OTHER_INVENTORY){
                            int price = 0;
                            Material waehrung = null;

                            if(bloecke_price.containsKey(e.getSlot())){
                                price = bloecke_price.get(e.getSlot());
                            }else{
                                p.sendMessage(Data.gc.getPrefix() +"§cEs ist ein Fehler aufgetreten!");
                                e.getView().close();
                                return;
                            }

                            if(bloecke_material.containsKey(e.getSlot())){
                                waehrung = bloecke_material.get(e.getSlot());
                            }else{
                                p.sendMessage(Data.gc.getPrefix() +"§cEs ist ein Fehler aufgetreten!");
                                e.getView().close();
                                return;
                            }


                            int amount = e.getCurrentItem().getAmount();
                            Material m = e.getCurrentItem().getType();
                            short nebenID = e.getCurrentItem().getData().getData();

                            ItemStack add = new ItemStack(m,amount,nebenID);
                            if(e.getCurrentItem().getType() == Material.LEATHER_HELMET || e.getCurrentItem().getType() == Material.LEATHER_CHESTPLATE
                                    || e.getCurrentItem().getType() == Material.LEATHER_LEGGINGS || e.getCurrentItem().getType() == Material.LEATHER_BOOTS){
                                LeatherArmorMeta itemm = (LeatherArmorMeta)add.getItemMeta();
                                LeatherArmorMeta im2 = (LeatherArmorMeta)e.getCurrentItem().getItemMeta();

                                itemm.setColor(im2.getColor());

                                Map<Enchantment, Integer> enchanments = e.getCurrentItem().getItemMeta().getEnchants();

                                for(Enchantment ench : enchanments.keySet()){
                                    itemm.addEnchant(ench, enchanments.get(ench), true);
                                }
                                add.setItemMeta(itemm);

                                Main.removeInventoryItemsStack(p.getInventory(), waehrung, price, add);
                            }else{
                                ItemMeta itemm = add.getItemMeta();

                                Map<Enchantment, Integer> enchanments = e.getCurrentItem().getItemMeta().getEnchants();

                                for(Enchantment ench : enchanments.keySet()){
                                    itemm.addEnchant(ench, enchanments.get(ench), true);
                                }
                                add.setItemMeta(itemm);

                                Main.removeInventoryItemsStack(p.getInventory(), waehrung, price, add);

                            }


                        }else{

                            int price = 0;
                            Material waehrung = null;

                            if(bloecke_price.containsKey(e.getSlot())){
                                price = bloecke_price.get(e.getSlot());
                            }else{
                                p.sendMessage(Data.gc.getPrefix() +"§cEs ist ein Fehler aufgetreten!");
                                e.getView().close();
                                return;
                            }

                            if(bloecke_material.containsKey(e.getSlot())){
                                waehrung = bloecke_material.get(e.getSlot());
                            }else{
                                p.sendMessage(Data.gc.getPrefix() +"§cEs ist ein Fehler aufgetreten!");
                                e.getView().close();
                                return;
                            }

                            int amount = e.getCurrentItem().getAmount();
                            Material m = e.getCurrentItem().getType();
                            short nebenID = e.getCurrentItem().getData().getData();


                            if(p.getInventory().contains(waehrung, price)){
                                Main.removeInventoryItems(p.getInventory(), waehrung, price);

                                if(e.getCurrentItem().getType() == Material.LEATHER_HELMET || e.getCurrentItem().getType() == Material.LEATHER_CHESTPLATE
                                        || e.getCurrentItem().getType() == Material.LEATHER_LEGGINGS || e.getCurrentItem().getType() == Material.LEATHER_BOOTS){

                                    ItemStack item = new ItemStack(m,amount,nebenID);
                                    LeatherArmorMeta itemm = (LeatherArmorMeta) item.getItemMeta();

                                    LeatherArmorMeta im2 = (LeatherArmorMeta)e.getCurrentItem().getItemMeta();

                                    itemm.setColor(im2.getColor());

                                    Map<Enchantment, Integer> enchanments = e.getCurrentItem().getItemMeta().getEnchants();

                                    for(Enchantment ench : enchanments.keySet()){
                                        itemm.addEnchant(ench, enchanments.get(ench), true);
                                    }
                                    item.setItemMeta(itemm);
                                    p.getInventory().addItem(item);

                                }else{
                                    ItemStack item = new ItemStack(m,amount,nebenID);
                                    ItemMeta itemm = item.getItemMeta();

                                    Map<Enchantment, Integer> enchanments = e.getCurrentItem().getItemMeta().getEnchants();

                                    for(Enchantment ench : enchanments.keySet()){
                                        itemm.addEnchant(ench, enchanments.get(ench), true);
                                    }
                                    item.setItemMeta(itemm);
                                    p.getInventory().addItem(item);
                                }

                            }else{
                                //p.sendMessage(Data.gc.getPrefix() +"§cDu hast zu wenig Ressourcen!");
                            }

                        }
                    }

                }
            }

        }
    }

}