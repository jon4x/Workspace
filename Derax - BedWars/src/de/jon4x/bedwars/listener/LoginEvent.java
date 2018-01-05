package de.jon4x.bedwars.listener;

import de.jon4x.bedwars.main.Main;
import de.jon4x.bedwars.storage.Data;
import net.claymc.gameapi.api.GameState;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

/**
 * Created by Pascal Falk on 07.08.2017.
 * Plugin by WeLoveSpigotPlugins
 * https://youtube.com/welovespigotplugins
 * Coded with IntelliJ
 */
public class LoginEvent implements Listener {
    public LoginEvent(Main Main)
    {
        this.pl = Main;
    }
    private Main pl;

    @EventHandler
    public void onLogin(PlayerLoginEvent e) {
        Player p = e.getPlayer();

        if (Data.ga.gs == GameState.INGAME) {
            e.allow();
        } else {
            if (Data.ga.gs == GameState.LOBBY) {
                int i = Bukkit.getMaxPlayers();
                if (!(i >= Bukkit.getOnlinePlayers().size())) {
                    return;
                }
                if (i == Bukkit.getOnlinePlayers().size()) {
                    if (!p.hasPermission("premium")) {
                        e.disallow(PlayerLoginEvent.Result.KICK_OTHER, "§cDu benötigst mindestens den §6Gold §cRang, um diesen Server betreten zu können!");
                    }
                    if (p.hasPermission("premium")) {
                        int q = 0;
                        for (Player all : Bukkit.getOnlinePlayers()) {

                            if (all.hasPermission("premium")) {
                                q++;
                                e.disallow(PlayerLoginEvent.Result.KICK_OTHER, "§7Der Server ist komplett mit §6Premium §7Spielern voll§8.");
                                if (q == Bukkit.getOnlinePlayers().size()) {
                                    return;
                                }
                            }
                        }
                        for (Player all : Bukkit.getOnlinePlayers()) {
                            if (!all.hasPermission("premium")) {

                                all.kickPlayer("§7Du wurdest von einem §6Premium §7gekickt!");
                                e.allow();
                                return;
                            }
                        }

                    } else {
                        p.sendMessage("§7Du kannst dem Spiel nicht beitreten, da du kein §6Premium §7besitzt. Kaufe dir im Shop §6Premium §7um vollen Servern beitreten zu können: §chttp://shop.derax.net/");
                    }
                }
            }
        }
    }
}
