package de.jon4x.lobby.sql;

import de.jon4x.lobby.Main;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.*;

public class MySQL {

    private static Connection con;

    public static void connect() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://" + Main.getHost() + "/" + Main.getDatenbank() + "?AutoreCONnect=true", Main.getUser(), Main.getPassword());
            createTable();
            Bukkit.getConsoleSender().sendMessage(Main.getPrefix() + "§aMySQL wurde erfolgreich verbunden!");
            reconnecter();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close() {
        if (isConnected()) {
            try {
                con.close();
                Bukkit.getConsoleSender().sendMessage(Main.getPrefix() + "§cMySQL wurde erfolgreich getrennt!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public static void createTable() {
        try {
            con.prepareStatement("CREATE TABLE IF NOT EXISTS settingsTable (uuid VARCHAR(100), doublejump INT(20), jumppad INT(20))").executeUpdate();
            con.prepareStatement("CREATE TABLE IF NOT EXISTS rewardTable (uuid VARCHAR(100), lastNormal INT(20), lastPrem INT(20))").executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet query(String qry) {
        ResultSet rs = null;
        try {
            Statement st = con.createStatement();
            rs = st.executeQuery(qry);
        }
        catch (SQLException e) {
            if (!isConnected()) {
                connect();
            }
            System.err.println(e);
        }
        return rs;
    }

    public static void Update(String qry) {
        try {
            Statement st = con.createStatement();
            st.executeUpdate(qry);
            st.close();
        }
        catch (SQLException e) {
            if (!isConnected()) {
                connect();
            }
            System.err.println(e);
        }
    }

    public static boolean isConnected() {
        return con != null;
    }

    public static void reconnecter() {
        Bukkit.getScheduler().runTaskLater(Main.getInstance(), () -> {
            close();
            connect();
        }, (60*20)*20 );
    }
}
