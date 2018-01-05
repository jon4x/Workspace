package de.jon4x.bungeesystem.ban;

import de.jon4x.bungeesystem.Main;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TeamManager {

    public static void createPlayer(String uuid) {
        if (!isInDatabase(uuid)) {
            Main.getMySQL().update("INSERT INTO `team` (`uuid`, `state`) VALUES ('" + uuid + "', '0');");
        }
    }

    private static boolean isInDatabase(String uuid) {
        try {
            ResultSet rs = Main.getMySQL().query("SELECT * FROM `team` WHERE `uuid` = '" + uuid + "';");
            if (rs.next()) {
                return true;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean isInTeam(String uuid) {
        try {
            if (isInDatabase(uuid)) {
                ResultSet rs = Main.getMySQL().query("SELECT `state` FROM `team` WHERE `uuid` = '" + uuid + "';");
                if (rs.next()) {
                    int state = rs.getInt("state");
                    return state == 1;
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void add(String uuid) {
        if (!isInDatabase(uuid)) {
            createPlayer(uuid);
        }
        if (!isInTeam(uuid)) {
            Main.getMySQL().update("UPDATE `team` SET `state` = '" + 1 + "' WHERE `uuid` = '" + uuid + "';");
        }
    }

    public static void remove(String uuid) {
        if (!isInDatabase(uuid)) {
            createPlayer(uuid);
        }
        if (isInTeam(uuid)) {
            Main.getMySQL().update("DELETE FROM `team` WHERE `uuid` = '" + uuid + "';");
        }
    }

}
