package de.jon4x.bungeesystem.sql;

import java.sql.*;

public class MySQL
{
    private String HOST;
    private String DATABASE;
    private String USERNAME;
    private String PASSWORD;
    private Connection connection;

    public MySQL(String host, String database, String username, String password) {
        HOST = host;
        DATABASE = database;
        USERNAME = username;
        PASSWORD = password;
    }

    public void connect() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://" + this.HOST + "/" + this.DATABASE + "?autoReconnect=true", this.USERNAME, this.PASSWORD);
            System.out.println("[Proxy-System] MySQL erfolgreich verbunden.");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            connection.close();
            System.out.println("[Proxy-System] MySQL erfolgreich getrennt.");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTable() {
        update("CREATE TABLE IF NOT EXISTS `bans` (`uuid` VARCHAR(100), `ip` VARCHAR(100), `banned_by` VARCHAR(100), `reason` VARCHAR(100), `end` INT(100));");
        update("CREATE TABLE IF NOT EXISTS `mutes` (`uuid` VARCHAR(100), `muted_by` VARCHAR(100), `reason` VARCHAR(100), `end` INT(100));");
        update("CREATE TABLE IF NOT EXISTS `team` (`uuid` VARCHAR(100), `state` INT(100));");
    }

    public void update(String qry) {
        try {
            Statement st = this.connection.createStatement();
            st.executeUpdate(qry);
            st.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet query(String qry) {
        ResultSet rs = null;
        try {
            Statement st = this.connection.createStatement();
            rs = st.executeQuery(qry);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public boolean isConnected() {
        return this.connection != null;
    }

}
