package de.jon4x.lobby.api;

import de.jon4x.lobby.Main;
import de.jon4x.lobby.sql.MySQL;
import org.bukkit.Bukkit;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

public class LobbySQL {

    /*
    SETTINGS
    MYSQL
     */

    public static void createPlayerSettings(String uuid) {
        if (!playerExistsSettings(uuid)) {
            MySQL.Update("INSERT INTO settingsTable(uuid, doublejump, jumppad) VALUES ('" + uuid + "', '0', '0')");
        }
    }

    public static boolean playerExistsSettings(String uuid) {
        try {
            ResultSet rs = MySQL.query("SELECT * FROM settingsTable WHERE uuid='" + uuid + "'");
            if (rs.next()) {
                return rs.getString("uuid") != null;
            }
        }
        catch (SQLException ex) {}
        return false;
    }

    public static Integer getDoubleJump(String uuid) {
        if (playerExistsSettings(uuid)) {
            try {
                ResultSet rs = MySQL.query("SELECT * FROM settingsTable WHERE uuid='" + uuid + "'");
                if (!rs.next()) {
                    return 0;
                }
                return rs.getInt("doublejump");
            }
            catch (SQLException ex) {
                return 0;
            }
        }
        createPlayerSettings(uuid);
        getDoubleJump(uuid);
        return 0;
    }

    public static void setDoubleJump(String uuid, int state) {
        if (playerExistsSettings(uuid)) {
            MySQL.Update("UPDATE settingsTable SET doublejump='" + state + "' WHERE uuid='" + uuid + "'");
        }
        else {
            createPlayerSettings(uuid);
            setDoubleJump(uuid, state);
        }
    }

    public static Integer getJumpPad(String uuid) {
        if (playerExistsSettings(uuid)) {
            try {
                ResultSet rs = MySQL.query("SELECT * FROM settingsTable WHERE uuid='" + uuid + "'");
                if (!rs.next()) {
                    return 0;
                }
                return rs.getInt("jumppad");
            }
            catch (SQLException ex) {
                return 0;
            }
        }
        createPlayerSettings(uuid);
        getJumpPad(uuid);
        return 0;
    }

    public static void setJumpPad(String uuid, int state) {
        if (playerExistsSettings(uuid)) {
            MySQL.Update("UPDATE settingsTable SET jumppad='" + state + "' WHERE uuid='" + uuid + "'");
        }
        else {
            createPlayerSettings(uuid);
            setJumpPad(uuid, state);
        }
    }


    /*
    REWARD
    MYSQL
     */

    public static void createPlayerReward(String uuid) {
        if (!playerExistsReward(uuid)) {
            MySQL.Update("INSERT INTO rewardTable(uuid, lastNormal, lastPrem) VALUES ('" + uuid + "', '0', '0')");
        }
    }

    public static boolean playerExistsReward(String uuid) {
        try {
            ResultSet rs = MySQL.query("SELECT * FROM rewardTable WHERE uuid='" + uuid + "'");
            if (rs.next()) {
                return rs.getString("uuid") != null;
            }
        }
        catch (SQLException ex) {}
        return false;
    }


    public static Integer getLastPremium(String uuid) {
        if (playerExistsReward(uuid)) {
            try {
                ResultSet rs = MySQL.query("SELECT * FROM rewardTable WHERE uuid='" + uuid + "'");
                if (!rs.next()) {
                    return 0;
                }
                return rs.getInt("lastPrem");
            }
            catch (SQLException ex) {
                return 0;
            }
        }
        createPlayerReward(uuid);
        getLastPremium(uuid);
        return 0;
    }

    public static void setLastPremium(String uuid, int LastUse) {
        if (playerExistsReward(uuid)) {
            MySQL.Update("UPDATE rewardTable SET lastPrem='" + LastUse + "' WHERE uuid='" + uuid + "'");
        }
        else {
            createPlayerReward(uuid);
            setLastPremium(uuid, LastUse);
        }
    }

    public static Integer getLastNormal(String uuid) {
        if (playerExistsReward(uuid)) {
            try {
                ResultSet rs = MySQL.query("SELECT * FROM rewardTable WHERE uuid='" + uuid + "'");
                if (!rs.next()) {
                    return 0;
                }
                return rs.getInt("lastNormal");
            }
            catch (SQLException ex) {
                return 0;
            }
        }
        createPlayerReward(uuid);
        getLastNormal(uuid);
        return 0;
    }

    public static void setLastNormal(String uuid, int LastUse) {
        if (playerExistsReward(uuid)) {
            MySQL.Update("UPDATE rewardTable SET lastNormal='" + LastUse + "' WHERE uuid='" + uuid + "'");
        }
        else {
            createPlayerReward(uuid);
            setLastNormal(uuid, LastUse);
        }
    }

    public static void resetReward() {
        Bukkit.getScheduler().runTaskLaterAsynchronously(Main.getInstance(), () -> {
            Calendar calendar = Calendar.getInstance();
            if (calendar.getTime().getHours() == 0 && calendar.getTime().getMinutes() == 0) {
                MySQL.Update("DELETE FROM rewardTable");
                Bukkit.getConsoleSender().sendMessage(Main.getPrefix() + "§arewards wurde zurückgesetzt! (00:00 Uhr)");
            }
            resetReward();
        }, 60*20);
    }
}
