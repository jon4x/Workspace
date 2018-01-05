package de.jon4x.lobby.methods;

import de.jon4x.coinapi.CoinAPI;
import net.minecraft.server.v1_8_R3.ScoreboardObjective;
import net.minecraft.server.v1_8_R3.*;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class Scoreboard {

    public static void setScoreboard(Player p) {

        // New Scoreboard
        net.minecraft.server.v1_8_R3.Scoreboard sb = new net.minecraft.server.v1_8_R3.Scoreboard();
        ScoreboardObjective obj = sb.registerObjective("Lobby", IScoreboardCriteria.b);
        obj.setDisplayName("§7» §c§lDeraxNET §7«");

        // Packets Obj
        PacketPlayOutScoreboardObjective removePacket = new PacketPlayOutScoreboardObjective(obj, 1);
        PacketPlayOutScoreboardObjective createPacket = new PacketPlayOutScoreboardObjective(obj, 0);
        PacketPlayOutScoreboardDisplayObjective display = new PacketPlayOutScoreboardDisplayObjective(1, obj);

        // Get Coins
        String coins = String.valueOf(CoinAPI.getCoins(p.getUniqueId().toString()));

        // Scores
        ScoreboardScore score1 = new ScoreboardScore(sb, obj, "§r "); score1.setScore(1);
        ScoreboardScore score2 = new ScoreboardScore(sb, obj, "§8\u27A5 §ewww.Derax.net"); score2.setScore(2);
        ScoreboardScore score3 = new ScoreboardScore(sb, obj, "§f§lWebsite:"); score3.setScore(3);
        ScoreboardScore score4 = new ScoreboardScore(sb, obj, "§r  "); score4.setScore(4);
        ScoreboardScore score5 = new ScoreboardScore(sb, obj, "§8\u27A5 §b@DeraxNET"); score5.setScore(5);
        ScoreboardScore score6 = new ScoreboardScore(sb, obj, "§f§lTwitter:"); score6.setScore(6);
        ScoreboardScore score7 = new ScoreboardScore(sb, obj, "§r   "); score7.setScore(7);
        ScoreboardScore score8 = new ScoreboardScore(sb, obj, "§8\u27A5 §6" + coins); score8.setScore(8);
        ScoreboardScore score9 = new ScoreboardScore(sb, obj, "§f§lCoins:"); score9.setScore(9);
        ScoreboardScore score10 = new ScoreboardScore(sb, obj, "§r     "); score10.setScore(10);
        ScoreboardScore score11 = new ScoreboardScore(sb, obj, "§8\u27A5 " + getRang(p)); score11.setScore(11);
        ScoreboardScore score12 = new ScoreboardScore(sb, obj, "§f§lRang:"); score12.setScore(12);
        ScoreboardScore score13 = new ScoreboardScore(sb, obj, "§r       "); score13.setScore(13);

        // Send Obj Packets
        sendPacket(p, removePacket);
        sendPacket(p, createPacket);
        sendPacket(p, display);

        // Packets Score & Send Score Packets
        PacketPlayOutScoreboardScore pScore1 = new PacketPlayOutScoreboardScore(score1); sendPacket(p, pScore1);
        PacketPlayOutScoreboardScore pScore2 = new PacketPlayOutScoreboardScore(score2); sendPacket(p, pScore2);
        PacketPlayOutScoreboardScore pScore3 = new PacketPlayOutScoreboardScore(score3); sendPacket(p, pScore3);
        PacketPlayOutScoreboardScore pScore4 = new PacketPlayOutScoreboardScore(score4); sendPacket(p, pScore4);
        PacketPlayOutScoreboardScore pScore5 = new PacketPlayOutScoreboardScore(score5); sendPacket(p, pScore5);
        PacketPlayOutScoreboardScore pScore6 = new PacketPlayOutScoreboardScore(score6); sendPacket(p, pScore6);
        PacketPlayOutScoreboardScore pScore7 = new PacketPlayOutScoreboardScore(score7); sendPacket(p, pScore7);
        PacketPlayOutScoreboardScore pScore8 = new PacketPlayOutScoreboardScore(score8); sendPacket(p, pScore8);
        PacketPlayOutScoreboardScore pScore9 = new PacketPlayOutScoreboardScore(score9); sendPacket(p, pScore9);
        PacketPlayOutScoreboardScore pScore10 = new PacketPlayOutScoreboardScore(score10); sendPacket(p, pScore10);
        PacketPlayOutScoreboardScore pScore11 = new PacketPlayOutScoreboardScore(score11); sendPacket(p, pScore11);
        PacketPlayOutScoreboardScore pScore12 = new PacketPlayOutScoreboardScore(score12); sendPacket(p, pScore12);
        PacketPlayOutScoreboardScore pScore13 = new PacketPlayOutScoreboardScore(score13); sendPacket(p, pScore13);

    }

    public static String getRang(Player p) {
        String rang;
        if (p.hasPermission("admin"))
            rang = "§4Admin";
        else if (p.hasPermission("manager"))
            rang = "§cManager";
        else if (p.hasPermission("dev"))
            rang = "§bDeveloper";
        else if (p.hasPermission("mod"))
            rang = "§cModerator";
        else if (p.hasPermission("sup"))
            rang = "§9Supporter";
        else if (p.hasPermission("builder"))
            rang = "§aBuilder";
        else if (p.hasPermission("yt"))
            rang = "§5YouTuber";
        else if (p.hasPermission("prem+"))
            rang = "§ePremium+";
        else if (p.hasPermission("prem"))
            rang = "§6Premium";
        else
            rang = "§7Spieler";
        return rang;
    }

    private static void sendPacket(final Player p, final Packet packet) {
        ((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
    }
}
