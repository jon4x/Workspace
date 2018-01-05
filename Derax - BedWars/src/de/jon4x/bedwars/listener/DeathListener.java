package de.jon4x.bedwars.listener;

import de.jon4x.bedwars.ScoreboardManager;
import de.jon4x.bedwars.manager.GameManager;
import de.jon4x.bedwars.storage.Data;
import de.jon4x.coinapi.CoinAPI;
import net.claymc.gameapi.api.GameAPI;
import net.claymc.gameapi.api.GameState;
import net.claymc.gameapi.api.ItemManager;
import net.claymc.gameapi.api.TitleAPI;
import net.claymc.gameapi.main.Main;
import net.minecraft.server.v1_8_R3.PacketPlayInClientCommand;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.ArrayList;

public class DeathListener implements Listener {

    public static ArrayList<Player> spectator = new ArrayList<>();

    @EventHandler
    public void onDeath(PlayerDeathEvent e){

        e.getDrops().clear();
        e.setDeathMessage(null);

        Player p = e.getEntity();
        Player k = e.getEntity().getKiller();

        if(Data.ga.gs == GameState.INGAME){
            if(k == null){
                e.setDeathMessage(Data.gc.getPrefix() + TeamAuswahl.getTeamColor(p) + p.getName() + "§7 ist gestorben.");
            }else{
                e.setDeathMessage(Data.gc.getPrefix() + TeamAuswahl.getTeamColor(p) + p.getName() + "§7 wurde von " + TeamAuswahl.getTeamColor(k) + k.getName() + "§7 getötet.");
            }
            if(GameManager.availableTeams.get(TeamAuswahl.getRawTeam(p))){

                respawn(p);

                p.teleport(de.jon4x.bedwars.main.Main.getSpawnLocation(p));

            }else{
                p.sendMessage(Data.gc.getPrefix() + "§7Du bist aus dem §6Spiel §7ausgeschieden§8.");

                setSpecator(p);

                Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), () -> setSpecator(p),10);

                JoinListener.addKill(k);
                CoinAPI.addCoins(k.getUniqueId().toString(), 10);
                k.sendMessage(" ");
                k.sendMessage("§a§l+ 10 Coins");
                k.sendMessage(" ");

                JoinListener.addDeath(p);

                if (TeamAuswahl.getTeamArray(p).isEmpty()) {
                    TeamAuswahl.getTeamArray(p).remove(p);
                }
                else {
                    if (TeamAuswahl.getTeamArray(p).size() == 1) {
                        for (Player all : Bukkit.getOnlinePlayers()) {
                            all.sendMessage(Data.gc.getPrefix() + "§7Das Team " + TeamAuswahl.getTeam(p) + "§7 ist ausgeschieden!");
                        }
                        TeamAuswahl.getTeamArray(p).clear();
                        GameManager.availableTeams.put(TeamAuswahl.getRawTeam(p), false);
                        for (Player all : Bukkit.getOnlinePlayers()) {
                            ScoreboardManager.setScoreboard(all);
                        }
                        setSpecator(p);
                        JoinListener.alive.remove(p);
                    } else {
                        TeamAuswahl.getTeamArray(p).remove(p);
                    }
                }
            }
        }
        if(TeamAuswahl.oneTeamLeft()){
            Bukkit.broadcastMessage(Data.gc.getPrefix() + "§7Das Spiel ist nun vorbei!");
            new GameAPI().stopStartingCD();
            Ending.startEnding();
        }
    }

    public static void setSpecator(Player p) {
        spectator.add(p);
        p.setGameMode(GameMode.ADVENTURE);
        for(Player all : Bukkit.getOnlinePlayers()){
            all.hidePlayer(p);
        }
        p.setAllowFlight(true);
        p.setFlying(true);
        p.getInventory().clear();
        p.setFoodLevel(20);
        p.setHealth(20);
        p.spigot().setCollidesWithEntities(false);
        p.getInventory().clear();
        p.getInventory().setArmorContents(null);

        p.getInventory().setItem(0, new ItemManager(Material.COMPASS).setDisplayName("§8× §6Teleporter §7(Rechtsklick)").build());
        p.getInventory().setItem(8, new ItemManager(Material.MAGMA_CREAM).setDisplayName("§8× §cSpiel verlassen §7(Rechtsklick)").build());

        p.updateInventory();
    }

    private void respawn(Player p) {
        ((CraftPlayer)p).getHandle().playerConnection.a(new PacketPlayInClientCommand(PacketPlayInClientCommand.EnumClientCommand.PERFORM_RESPAWN));
    }
}
