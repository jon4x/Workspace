package de.jon4x.bungeesystem.ban;

import de.jon4x.bungeesystem.Main;
import de.jon4x.bungeesystem.utils.NameFetcher;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class MuteManager {

    public static void createPlayer(String uuid) {
        if (!isInDatabase(uuid)) {
            Main.getMySQL().update("INSERT INTO `mutes` (`uuid`, `muted_by`, `reason`, `end`) VALUES ('" + uuid + "', '/', '/', '0');");
        }
    }

    private static boolean isInDatabase(String uuid) {
        try {
            ResultSet rs = Main.getMySQL().query("SELECT * FROM `mutes` WHERE `uuid` = '" + uuid + "';");
            if (rs.next()) {
                return true;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean isMuted(String uuid) {
        try {
            if (isInDatabase(uuid)) {
                ResultSet rs = Main.getMySQL().query("SELECT `end` FROM `mutes` WHERE `uuid` = '" + uuid + "';");
                if (rs.next()) {
                    int end = rs.getInt("end");
                    return end != 0;
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void mute(String name, String uuid, String reason, String mutedBy, int seconds) {
        if (!isMuted(uuid)) {
            long currentm = System.currentTimeMillis();
            long current = currentm / 1000L;
            long end = current + seconds;
            if (seconds == -1) {
                end = -1L;
            }
            Main.getMySQL().update("UPDATE `mutes` SET `muted_by` = '" + mutedBy + "' WHERE `uuid` = '" + uuid + "';");
            Main.getMySQL().update("UPDATE `mutes` SET `reason` = '" + reason + "' WHERE `uuid` = '" + uuid + "';");
            Main.getMySQL().update("UPDATE `mutes` SET `end` = '" + end + "' WHERE `uuid` = '" + uuid + "';");
            for (ProxiedPlayer players : ProxyServer.getInstance().getPlayers()) {
                if (players.hasPermission("BanSystem.mute")) {
                    players.sendMessage("§r");
                    players.sendMessage("§7§m-----------§r§c System §8\u00bb §eMute §7§m-----------");
                    players.sendMessage("§7Spieler §8\u00bb §e" + name);
                    players.sendMessage("§7Mutedauer §8\u00bb §e" + getRemainingTime(uuid));
                    players.sendMessage("§7Grund §8\u00bb §e" + getReason(uuid));
                    players.sendMessage("§7Gemutet von §8\u00bb §c" + mutedBy);
                    players.sendMessage("§7§m-----------§r§c System §8\u00bb §7§m-----------");
                    players.sendMessage("§r");
                }
            }
        }
    }

    public static void unmute(String name, String uuid, String unmutedBy) {
        if (isMuted(uuid)) {
            Main.getMySQL().update("UPDATE `mutes` SET `muted_by` = '/' WHERE `uuid` = '" + uuid + "';");
            Main.getMySQL().update("UPDATE `mutes` SET `reason` = '/' WHERE `uuid` = '" + uuid + "';");
            Main.getMySQL().update("UPDATE `mutes` SET `end` = '0' WHERE `uuid` = '" + uuid + "';");
            for (ProxiedPlayer players : ProxyServer.getInstance().getPlayers()) {
                if (players.hasPermission("BanSystem.unmute")) {
                    players.sendMessage("§r");
                    players.sendMessage(Main.banPrefix() + "§7Spieler §e" + name + " §7wurde von §e" + unmutedBy + " §7entmutet!");
                    players.sendMessage("§r");
                }
            }
        }
    }

    public static String getReason(String uuid) {
        String reason = "";
        try {
            if (isMuted(uuid)) {
                ResultSet rs = Main.getMySQL().query("SELECT `reason` FROM `mutes` WHERE `uuid` = '" + uuid + "';");
                if (rs.next()) {
                    return rs.getString("reason");
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return reason;
    }

    public static String getWhoMuted(String uuid) {
        String whoBanned = "";
        try {
            if (isMuted(uuid)) {
                ResultSet rs = Main.getMySQL().query("SELECT `muted_by` FROM `mutes` WHERE `uuid` = '" + uuid + "';");
                if (rs.next()) {
                    return rs.getString("muted_by");
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return whoBanned;
    }

    public static int getEnd(String uuid) {
        int end = -1;
        try {
            if (isMuted(uuid)) {
                ResultSet rs = Main.getMySQL().query("SELECT `end` FROM `mutes` WHERE `uuid` = '" + uuid + "';");
                if (rs.next()) {
                    return rs.getInt("end");
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return end;
    }

    public static String getRemainingTime(String uuid) {
        String remainingTime = "";
        if (isMuted(uuid)) {
            long currentm = System.currentTimeMillis();
            long current = currentm / 1000L;
            int end = getEnd(uuid);
            long difference = end - current;
            if (end == -1) {
                return "§4Permanent";
            }
            int minutes = 0;
            int hours = 0;
            int days = 0;
            while (difference >= 60L) {
                difference -= 60L;
                ++minutes;
            }
            while (minutes >= 60) {
                minutes -= 60;
                ++hours;
            }
            while (hours >= 24) {
                hours -= 24;
                ++days;
            }
            remainingTime = days + " Tag(e), " + hours + " Stunde(n), " + minutes + " Minute(n)";
        }
        return remainingTime;
    }
}
