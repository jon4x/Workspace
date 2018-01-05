package de.jon4x.bedwars;

import de.jon4x.bedwars.listener.TeamAuswahl;
import de.jon4x.bedwars.listener.Voting;
import de.jon4x.bedwars.main.Main;
import de.jon4x.bedwars.manager.GameManager;
import de.jon4x.bedwars.storage.Data;
import net.claymc.gameapi.api.GameState;
import net.minecraft.server.v1_8_R3.*;
import net.spigotplugins.gameapi.manager.StatsAPI;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

/**
 * Created by Pascal Falk on 03.08.2017.
 * Plugin by WeLoveSpigotPlugins
 * https://youtube.com/welovespigotplugins
 * Coded with IntelliJ
 */

public class ScoreboardManager {

    public static void setScoreboard(Player p) {

        if (Data.ga.gs == GameState.LOBBY) {
            Scoreboard scoreboard = new Scoreboard();
            ScoreboardObjective obj = scoreboard.registerObjective("zagd", IScoreboardCriteria.b);
            obj.setDisplayName("§7» §c§lDeraxNET §7«");
            PacketPlayOutScoreboardObjective createPacket = new PacketPlayOutScoreboardObjective(obj, 0);
            PacketPlayOutScoreboardDisplayObjective display = new PacketPlayOutScoreboardDisplayObjective(1, obj);

            ScoreboardScore s1 = new ScoreboardScore(scoreboard, obj, "§7§2              ");
            ScoreboardScore s2 = new ScoreboardScore(scoreboard, obj, "§f§lTeam:");
            ScoreboardScore s3 = new ScoreboardScore(scoreboard, obj, "§8\u27A5 " + TeamAuswahl.getTeam(p));
            ScoreboardScore s4 = new ScoreboardScore(scoreboard, obj, "§7§0 ");
            ScoreboardScore s5 = new ScoreboardScore(scoreboard, obj, "§f§lMap:");
            ScoreboardScore s6 = new ScoreboardScore(scoreboard, obj, "§8\u27A5 §6" + Main.playedMap);
            ScoreboardScore s7 = new ScoreboardScore(scoreboard, obj, "§7§9 ");
            ScoreboardScore s8 = new ScoreboardScore(scoreboard, obj, "§f§lRang:");
            ScoreboardScore s9 = new ScoreboardScore(scoreboard, obj, "§8\u27A5 §e" + new StatsAPI().getRankingFromUUID(p.getUniqueId(), "BEDWARS", "WINS"));
            ScoreboardScore s10 = new ScoreboardScore(scoreboard, obj, "§8§9§6");

            s1.setScore(10);
            s2.setScore(9);
            s3.setScore(8);
            s4.setScore(7);
            s5.setScore(6);
            s6.setScore(5);
            s7.setScore(4);
            s8.setScore(3);
            s9.setScore(2);
            s10.setScore(1);

            PacketPlayOutScoreboardObjective removePacket = new PacketPlayOutScoreboardObjective(obj, 1);
            PacketPlayOutScoreboardScore pa1 = new PacketPlayOutScoreboardScore(s1);
            PacketPlayOutScoreboardScore pa2 = new PacketPlayOutScoreboardScore(s2);
            PacketPlayOutScoreboardScore pa3 = new PacketPlayOutScoreboardScore(s3);
            PacketPlayOutScoreboardScore pa4 = new PacketPlayOutScoreboardScore(s4);
            PacketPlayOutScoreboardScore pa5 = new PacketPlayOutScoreboardScore(s5);
            PacketPlayOutScoreboardScore pa6 = new PacketPlayOutScoreboardScore(s6);
            PacketPlayOutScoreboardScore pa7 = new PacketPlayOutScoreboardScore(s7);
            PacketPlayOutScoreboardScore pa8 = new PacketPlayOutScoreboardScore(s8);
            PacketPlayOutScoreboardScore pa9 = new PacketPlayOutScoreboardScore(s9);
            PacketPlayOutScoreboardScore pa10 = new PacketPlayOutScoreboardScore(s10);


            sendPacket(removePacket, p);
            sendPacket(createPacket, p);
            sendPacket(display, p);

            sendPacket(pa1, p);
            sendPacket(pa2, p);
            sendPacket(pa3, p);
            sendPacket(pa4, p);
            sendPacket(pa5, p);
            sendPacket(pa6, p);
            sendPacket(pa7, p);
            sendPacket(pa8, p);
            sendPacket(pa9, p);
            sendPacket(pa10, p);

        }
        if (Data.ga.gs == GameState.INGAME) {
            if (Data.mode.equalsIgnoreCase("8x1") || Data.mode.equalsIgnoreCase("8x2")) {
                Scoreboard scoreboard = new Scoreboard();
                ScoreboardObjective obj = scoreboard.registerObjective("zagd", IScoreboardCriteria.b);
                obj.setDisplayName("§7» §c§lDeraxNET §7«");
                PacketPlayOutScoreboardObjective createPacket = new PacketPlayOutScoreboardObjective(obj, 0);
                PacketPlayOutScoreboardDisplayObjective display = new PacketPlayOutScoreboardDisplayObjective(1, obj);


                ScoreboardScore s1 = new ScoreboardScore(scoreboard, obj, "§7§2              ");
                ScoreboardScore s2 = new ScoreboardScore(scoreboard, obj, "§f§lTeams:");
                ScoreboardScore s3 = new ScoreboardScore(scoreboard, obj, "§8× §9Blau §7»" + getTeam("blau"));
                ScoreboardScore s4 = new ScoreboardScore(scoreboard, obj, "§8× §4Rot §7»" + getTeam("rot"));
                ScoreboardScore s5 = new ScoreboardScore(scoreboard, obj, "§8× §eGelb §7»" + getTeam("gelb"));
                ScoreboardScore s6 = new ScoreboardScore(scoreboard, obj, "§8× §aGrün §7»" + getTeam("gruen"));
                ScoreboardScore s7 = new ScoreboardScore(scoreboard, obj, "§8× §6Orange §7»" + getTeam("orange"));
                ScoreboardScore s8 = new ScoreboardScore(scoreboard, obj, "§8× §0Schwarz §7»" + getTeam("schwarz"));
                ScoreboardScore s9 = new ScoreboardScore(scoreboard, obj, "§8× §dPink §7»" + getTeam("pink"));
                ScoreboardScore s10 = new ScoreboardScore(scoreboard, obj, "§8× §7Grau §7»" + getTeam("grau"));
                ScoreboardScore s11 = new ScoreboardScore(scoreboard, obj, "§7§1              ");
                ScoreboardScore s12 = new ScoreboardScore(scoreboard, obj, "§8× §6Gold §7»" + getGoldVoting());
                ScoreboardScore s13 = new ScoreboardScore(scoreboard, obj, "§8  §6 ");

                s1.setScore(13);
                s2.setScore(12);
                s3.setScore(11);
                s4.setScore(10);
                s5.setScore(9);
                s6.setScore(8);
                s7.setScore(7);
                s8.setScore(6);
                s9.setScore(5);
                s10.setScore(4);
                s11.setScore(3);
                s12.setScore(2);
                s13.setScore(1);

                PacketPlayOutScoreboardObjective removePacket = new PacketPlayOutScoreboardObjective(obj, 1);
                PacketPlayOutScoreboardScore pa1 = new PacketPlayOutScoreboardScore(s1);
                PacketPlayOutScoreboardScore pa2 = new PacketPlayOutScoreboardScore(s2);
                PacketPlayOutScoreboardScore pa3 = new PacketPlayOutScoreboardScore(s3);
                PacketPlayOutScoreboardScore pa4 = new PacketPlayOutScoreboardScore(s4);
                PacketPlayOutScoreboardScore pa5 = new PacketPlayOutScoreboardScore(s5);
                PacketPlayOutScoreboardScore pa6 = new PacketPlayOutScoreboardScore(s6);
                PacketPlayOutScoreboardScore pa7 = new PacketPlayOutScoreboardScore(s7);
                PacketPlayOutScoreboardScore pa8 = new PacketPlayOutScoreboardScore(s8);
                PacketPlayOutScoreboardScore pa9 = new PacketPlayOutScoreboardScore(s9);
                PacketPlayOutScoreboardScore pa10 = new PacketPlayOutScoreboardScore(s10);
                PacketPlayOutScoreboardScore pa11 = new PacketPlayOutScoreboardScore(s11);
                PacketPlayOutScoreboardScore pa12 = new PacketPlayOutScoreboardScore(s12);
                PacketPlayOutScoreboardScore pa13 = new PacketPlayOutScoreboardScore(s13);


                sendPacket(removePacket, p);
                sendPacket(createPacket, p);
                sendPacket(display, p);

                sendPacket(pa1, p);
                sendPacket(pa2, p);
                sendPacket(pa3, p);
                sendPacket(pa4, p);
                sendPacket(pa5, p);
                sendPacket(pa6, p);
                sendPacket(pa7, p);
                sendPacket(pa8, p);
                sendPacket(pa9, p);
                sendPacket(pa10, p);
                sendPacket(pa11, p);
                sendPacket(pa12, p);
                sendPacket(pa13, p);

            }
            if (Data.mode.equalsIgnoreCase("4x2") || Data.mode.equalsIgnoreCase("4x3")) {
                Scoreboard scoreboard = new Scoreboard();
                ScoreboardObjective obj = scoreboard.registerObjective("zagd", IScoreboardCriteria.b);
                obj.setDisplayName("§7» §c§lDeraxNET §7«");
                PacketPlayOutScoreboardObjective createPacket = new PacketPlayOutScoreboardObjective(obj, 0);
                PacketPlayOutScoreboardDisplayObjective display = new PacketPlayOutScoreboardDisplayObjective(1, obj);

                ScoreboardScore s1 = new ScoreboardScore(scoreboard, obj, "§7§2              ");
                ScoreboardScore s2 = new ScoreboardScore(scoreboard, obj, "§f§lTeams:");
                ScoreboardScore s3 = new ScoreboardScore(scoreboard, obj, "§8× §9Blau §7»" + getTeam("blau"));
                ScoreboardScore s4 = new ScoreboardScore(scoreboard, obj, "§8× §4Rot §7»" + getTeam("rot"));
                ScoreboardScore s5 = new ScoreboardScore(scoreboard, obj, "§8× §eGelb §7»" + getTeam("gelb"));
                ScoreboardScore s6 = new ScoreboardScore(scoreboard, obj, "§8× §aGrün §7»" + getTeam("gruen"));
                ScoreboardScore s7 = new ScoreboardScore(scoreboard, obj, "§7§1         ");
                ScoreboardScore s8 = new ScoreboardScore(scoreboard, obj, "§8× §6Gold §7»" + getGoldVoting());
                ScoreboardScore s9 = new ScoreboardScore(scoreboard, obj, "§7§l    ");

                s1.setScore(9);
                s2.setScore(8);
                s3.setScore(7);
                s4.setScore(6);
                s5.setScore(5);
                s6.setScore(4);
                s7.setScore(3);
                s8.setScore(2);
                s9.setScore(1);

                PacketPlayOutScoreboardObjective removePacket = new PacketPlayOutScoreboardObjective(obj, 1);
                PacketPlayOutScoreboardScore pa1 = new PacketPlayOutScoreboardScore(s1);
                PacketPlayOutScoreboardScore pa2 = new PacketPlayOutScoreboardScore(s2);
                PacketPlayOutScoreboardScore pa3 = new PacketPlayOutScoreboardScore(s3);
                PacketPlayOutScoreboardScore pa4 = new PacketPlayOutScoreboardScore(s4);
                PacketPlayOutScoreboardScore pa5 = new PacketPlayOutScoreboardScore(s5);
                PacketPlayOutScoreboardScore pa6 = new PacketPlayOutScoreboardScore(s6);
                PacketPlayOutScoreboardScore pa7 = new PacketPlayOutScoreboardScore(s7);
                PacketPlayOutScoreboardScore pa8 = new PacketPlayOutScoreboardScore(s8);
                PacketPlayOutScoreboardScore pa9 = new PacketPlayOutScoreboardScore(s9);



                sendPacket(removePacket, p);
                sendPacket(createPacket, p);
                sendPacket(display, p);

                sendPacket(pa1, p);
                sendPacket(pa2, p);
                sendPacket(pa3, p);
                sendPacket(pa4, p);
                sendPacket(pa5, p);
                sendPacket(pa6, p);
                sendPacket(pa7, p);
                sendPacket(pa8, p);
                sendPacket(pa9, p);

            }
            if (Data.mode.equalsIgnoreCase("2x2") || Data.mode.equalsIgnoreCase("2x1")) {
                Scoreboard scoreboard = new Scoreboard();
                ScoreboardObjective obj = scoreboard.registerObjective("zagd", IScoreboardCriteria.b);
                obj.setDisplayName("§7» §c§lDeraxNET §7«");
                PacketPlayOutScoreboardObjective createPacket = new PacketPlayOutScoreboardObjective(obj, 0);
                PacketPlayOutScoreboardDisplayObjective display = new PacketPlayOutScoreboardDisplayObjective(1, obj);

                ScoreboardScore s1 = new ScoreboardScore(scoreboard, obj, "§7§2              ");
                ScoreboardScore s2 = new ScoreboardScore(scoreboard, obj, "§f§lTeams:");
                ScoreboardScore s3 = new ScoreboardScore(scoreboard, obj, "§8× §9Blau §7»" + getTeam("blau"));
                ScoreboardScore s4 = new ScoreboardScore(scoreboard, obj, "§8× §4Rot §7»" + getTeam("rot"));
                ScoreboardScore s5 = new ScoreboardScore(scoreboard, obj, "§7§1              ");
                ScoreboardScore s6 = new ScoreboardScore(scoreboard, obj, "§8× §6Gold §7»" + getGoldVoting());
                ScoreboardScore s7 = new ScoreboardScore(scoreboard, obj, "§7§l        ");

                s1.setScore(7);
                s2.setScore(6);
                s3.setScore(5);
                s4.setScore(4);
                s5.setScore(3);
                s6.setScore(2);
                s7.setScore(1);

                PacketPlayOutScoreboardObjective removePacket = new PacketPlayOutScoreboardObjective(obj, 1);
                PacketPlayOutScoreboardScore pa1 = new PacketPlayOutScoreboardScore(s1);
                PacketPlayOutScoreboardScore pa2 = new PacketPlayOutScoreboardScore(s2);
                PacketPlayOutScoreboardScore pa3 = new PacketPlayOutScoreboardScore(s3);
                PacketPlayOutScoreboardScore pa4 = new PacketPlayOutScoreboardScore(s4);
                PacketPlayOutScoreboardScore pa5 = new PacketPlayOutScoreboardScore(s5);
                PacketPlayOutScoreboardScore pa6 = new PacketPlayOutScoreboardScore(s6);
                PacketPlayOutScoreboardScore pa7 = new PacketPlayOutScoreboardScore(s7);



                sendPacket(removePacket, p);
                sendPacket(createPacket, p);
                sendPacket(display, p);

                sendPacket(pa1, p);
                sendPacket(pa2, p);
                sendPacket(pa3, p);
                sendPacket(pa4, p);
                sendPacket(pa5, p);
                sendPacket(pa6, p);
                sendPacket(pa7, p);


            }

        }
        if (Data.ga.gs == GameState.ENDING) {
            Scoreboard scoreboard = new Scoreboard();
            ScoreboardObjective obj = scoreboard.registerObjective("zagd", IScoreboardCriteria.b);
            obj.setDisplayName("  ");
            PacketPlayOutScoreboardObjective createPacket = new PacketPlayOutScoreboardObjective(obj, 0);
            PacketPlayOutScoreboardDisplayObjective display = new PacketPlayOutScoreboardDisplayObjective(1, obj);

            ScoreboardScore s1 = new ScoreboardScore(scoreboard, obj, " ");
            ScoreboardScore s2 = new ScoreboardScore(scoreboard, obj, "  ");
            ScoreboardScore s3 = new ScoreboardScore(scoreboard, obj, "   ");

            s1.setScore(3);
            s2.setScore(2);
            s3.setScore(1);

            PacketPlayOutScoreboardObjective removePacket = new PacketPlayOutScoreboardObjective(obj, 1);
            PacketPlayOutScoreboardScore pa1 = new PacketPlayOutScoreboardScore(s1);
            PacketPlayOutScoreboardScore pa2 = new PacketPlayOutScoreboardScore(s2);
            PacketPlayOutScoreboardScore pa3 = new PacketPlayOutScoreboardScore(s3);



            sendPacket(removePacket, p);
            sendPacket(createPacket, p);
            sendPacket(display, p);

            sendPacket(pa1, p);
            sendPacket(pa2, p);
            sendPacket(pa3, p);


        }
    }

    private static void sendPacket(Packet packet, Player p) {
        ((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
    }

    private static synchronized String getTeam(String team){
        if(GameManager.availableTeams.get(team)){
            return " §a✔";
        }else{
            return " §c✖";
        }
    }

    private static synchronized String getGoldVoting() {
        if(Voting.gold){
            return " §a✔";
        }
        else{
            return " §c✖";
        }
    }

}
