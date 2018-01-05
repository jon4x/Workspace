package de.jon4x.bungeesystem.ban;

import de.jon4x.bungeesystem.Main;
import de.jon4x.bungeesystem.utils.NameFetcher;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BanManager {

    public static void createPlayer(String uuid, String ip) {
        if (!isInDatabase(uuid)) {
            Main.getMySQL().update("INSERT INTO `bans` (`uuid`, `ip`, `banned_by`, `reason`, `end`) VALUES ('" + uuid + "', '" + ip + "', '/', '/', '0');");
        }
    }

    private static boolean isInDatabase(String uuid) {
        try {
            ResultSet rs = Main.getMySQL().query("SELECT * FROM `bans` WHERE `uuid` = '" + uuid + "';");
            if (rs.next()) {
                return true;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static boolean isIpDatabase(String ip) {
        try {
            ResultSet rs = Main.getMySQL().query("SELECT * FROM `bans` WHERE `ip` = '" + ip + "';");
            if (rs.next()) {
                return true;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean isBanned(String uuid) {
        try {
            if (isInDatabase(uuid)) {
                ResultSet rs = Main.getMySQL().query("SELECT `end` FROM `bans` WHERE `uuid` = '" + uuid + "';");
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

    public static boolean IPisBanned(String ip) {
        try {
            if (isIpDatabase(ip)) {
                ResultSet rs = Main.getMySQL().query("SELECT `end` FROM `bans` WHERE `ip` = '" + ip + "';");
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

    public static void ban(String name, String uuid, String reason, String whoBanned, int seconds, String ip) {
        if (!isInDatabase(uuid)) {
            createPlayer(uuid, ip);
        }
        if (!isBanned(uuid)) {
            long currentm = System.currentTimeMillis();
            long current = currentm / 1000L;
            long end = current + seconds;
            if (seconds == -1) {
                end = -1L;
            }
            Main.getMySQL().update("UPDATE `bans` SET `banned_by` = '" + whoBanned + "' WHERE `uuid` = '" + uuid + "';");
            Main.getMySQL().update("UPDATE `bans` SET `reason` = '" + reason + "' WHERE `uuid` = '" + uuid + "';");
            Main.getMySQL().update("UPDATE `bans` SET `end` = '" + end + "' WHERE `uuid` = '" + uuid + "';");
            Main.getMySQL().update("UPDATE `bans` SET `ip` = '" + ip + "' WHERE `uuid` = '" + uuid + "';");
            for (ProxiedPlayer players : ProxyServer.getInstance().getPlayers()) {
                if (players.hasPermission("system.ban")) {
                    players.sendMessage("§r");
                    players.sendMessage("§7§m-----------§r§c System §8\u00bb §eBan §7§m-----------");
                    players.sendMessage("§7Spieler §8\u00bb §e" + name);
                    players.sendMessage("§7Bandauer §8\u00bb §e" + getRemainingTime(uuid));
                    players.sendMessage("§7Grund §8\u00bb §e" + getReason(uuid));
                    players.sendMessage("§7Gebannt von §8\u00bb §c" + whoBanned);
                    players.sendMessage("§7§m-----------§r§c System §8\u00bb §eBan §7§m-----------");
                    players.sendMessage("§r");
                }
            }
        }
    }

    public static void unban(String name, String uuid, String whoUnbanned) {
        if (isBanned(uuid)) {
            Main.getMySQL().update("DELETE FROM `bans` WHERE `uuid` = '" + uuid + "';");
            for (ProxiedPlayer players : ProxyServer.getInstance().getPlayers()) {
                if (players.hasPermission("system.unban")) {
                    players.sendMessage("§r");
                    players.sendMessage(Main.banPrefix() + "§7Spieler §e" + name + " §7wurde von §e" + whoUnbanned + " §7entbannt!");
                    players.sendMessage("§r");
                }
            }
        }
    }

    public static void unbanByIP(String ip, String whoUnbanned) {
        if (IPisBanned(ip)) {
            Main.getMySQL().update("DELETE FROM `bans` WHERE `ip` = '" + ip + "';");
            for (ProxiedPlayer players : ProxyServer.getInstance().getPlayers()) {
                if (players.hasPermission("system.unban")) {
                    players.sendMessage("§r");
                    players.sendMessage(Main.banPrefix() + "§7Spieler §e" + getNameByIP(ip) + " §7wurde von §e" + whoUnbanned + " §7entbannt!");
                    players.sendMessage("§r");
                }
            }
        }
    }

    public static String getReason(String uuid) {
        String reason = "";
        try {
            if (isBanned(uuid)) {
                ResultSet rs = Main.getMySQL().query("SELECT `reason` FROM `bans` WHERE `uuid` = '" + uuid + "';");
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

    public static String getReasonByIP(String ip) {
        String reason = "";
        try {
            if (IPisBanned(ip)) {
                ResultSet rs = Main.getMySQL().query("SELECT `reason` FROM `bans` WHERE `ip` = '" + ip + "';");
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

    public static String getWhoBanned(String uuid) {
        String whoBanned = "";
        try {
            if (isBanned(uuid)) {
                ResultSet rs = Main.getMySQL().query("SELECT `banned_by` FROM `bans` WHERE `uuid` = '" + uuid + "';");
                if (rs.next()) {
                    return rs.getString("banned_by");
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return whoBanned;
    }

    public static void updateIP(String uuid, String ip) {
        Main.getMySQL().update("UPDATE `bans` SET `ip` = '" + ip + "' WHERE `uuid` = '" + uuid + "';");
    }

    public static String getNameByIP (String ip) {
        try {
            ResultSet rs = Main.getMySQL().query("SELECT `uuid` FROM `bans` WHERE `ip` = '" + ip + "';");
            if (rs.next()) {
                String uuid = rs.getString("uuid");
                return NameFetcher.getName(uuid);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String getWhoBannedByIP(String ip) {
        String whoBanned = "";
        try {
            if (IPisBanned(ip)) {
                ResultSet rs = Main.getMySQL().query("SELECT `banned_by` FROM `bans` WHERE `ip` = '" + ip + "';");
                if (rs.next()) {
                    return rs.getString("banned_by");
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
            if (isBanned(uuid)) {
                ResultSet rs = Main.getMySQL().query("SELECT `end` FROM `bans` WHERE `uuid` = '" + uuid + "';");
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

    public static int getEndByIP(String ip) {
        int end = -1;
        try {
            if (IPisBanned(ip)) {
                ResultSet rs = Main.getMySQL().query("SELECT `end` FROM `bans` WHERE `ip` = '" + ip + "';");
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
        if (isBanned(uuid)) {
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
            remainingTime = days + " Tag(e), " + hours + " Stunde(n), " + minutes + " Minute(n) ";
        }
        return remainingTime;
    }
    private static String getRemainingTimeByIP(String ip) {
        String remainingTime = "";
        if (IPisBanned(ip)) {
            long currentm = System.currentTimeMillis();
            long current = currentm / 1000L;
            int end = getEndByIP(ip);
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
            remainingTime = days + " Tag(e), " + hours + " Stunde(n), " + minutes + " Minute(n) ";
        }
        return remainingTime;
    }

    public static String getBannedMessage(String uuid) {
        String banMessage = "";
        if (isBanned(uuid)) {
            if (getEnd(uuid) != -1) {
                banMessage = "§cDu wurdest von §c§lDeraxNET gebannt!\n§cDu bist noch §e" + getRemainingTime(uuid) + "§cvon dem Netzwerk gebannt!\n§cGrund §7\u00bb §e" + getReason(uuid) + "\n§cGebannt von §7\u00bb §e" + getWhoBanned(uuid) + "\n\n §7Zu unrecht gebannt? Dann schreibe einen Entbannungsantrag im Forum!\n§8➥ §ahttp://derax.net/forum";
            }
            else {
                banMessage = "§cDu wurdest von §c§lDeraxNET gebannt!\n§cDu wurdest §4PERMANET von dem Netzwerk gebannt!\n§cGrund §7\u00bb §e" + getReason(uuid) + "\n§cGebannt von §7\u00bb §e" + getWhoBanned(uuid) + "\n\n §7Zu unrecht gebannt? Dann schreibe einen Entbannungsantrag im Forum!\n§8➥ §ahttp://derax.net/forum";
            }
        }
        return banMessage;
    }

    public static String getBannedMessageByIP(String ip) {
        String banMessage = "";
        if (IPisBanned(ip)) {
            if (getEndByIP(ip) != -1) {
                banMessage = "§cDu wurdest von §c§lDeraxNET gebannt!\n§cDu bist noch §e" + getRemainingTimeByIP(ip) + "§cvon dem Netzwerk gebannt!\n§cGrund §7\u00bb §e" + getReasonByIP(ip) + "\n§cGebannt von §7\u00bb §e" + getWhoBannedByIP(ip) + "\n\n §7Zu unrecht gebannt? Dann schreibe einen Entbannungsantrag im Forum!\n§8➥ §ahttp://derax.net/forum";
            }
            else {
                banMessage = "§cDu wurdest von §c§lDeraxNET gebannt!\n§cDu wurdest §4PERMANET von dem Netzwerk gebannt!\n§cGrund §7\u00bb §e" + getReasonByIP(ip) + "\n§cGebannt von §7\u00bb §e" + getWhoBannedByIP(ip) + "\n\n §7Zu unrecht gebannt? Dann schreibe einen Entbannungsantrag im Forum!\n§8➥ §ahttp://derax.net/forum";
            }
        }
        return banMessage;
    }
}

