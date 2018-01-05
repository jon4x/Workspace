package de.jon4x.bungeesystem.utils;

import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.UUID;

public class UUIDFetcher {

    public static UUID getUUID(String playername) {
        String output = callURL("https://api.mojang.com/users/profiles/minecraft/" + playername);

        StringBuilder result = new StringBuilder();

        readData(output, result);

        String u = result.toString();

        String uuid = "";

        for(int i = 0; i <= 31; i++) {
            uuid = uuid + u.charAt(i);
            if(i == 7 || i == 11 || i == 15 || i == 19) {
                uuid = uuid + "-";
            }
        }

        return UUID.fromString(uuid);
    }

    private static void readData(String toRead, StringBuilder result) {
        int i = 7;

        while(i < 200) {
            if(toRead.charAt(i) == ('\"'))
                break;

            result.append(String.valueOf(toRead.charAt(i)));
            i++;
        }
    }


    private static String callURL(String URL) {
        StringBuilder sb = new StringBuilder();
        URLConnection urlConn;
        InputStreamReader in = null;
        try {
            URL url = new URL(URL);
            urlConn = url.openConnection();

            if (urlConn != null) urlConn.setReadTimeout(60 * 1000);

            if (urlConn != null && urlConn.getInputStream() != null) {
                in = new InputStreamReader(urlConn.getInputStream(), Charset.defaultCharset());
                BufferedReader bufferedReader = new BufferedReader(in);

                if (bufferedReader != null) {
                    int cp;

                    while ((cp = bufferedReader.read()) != -1) {
                        sb.append((char) cp);
                    }

                    bufferedReader.close();
                }
            }

            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sb.toString();
    }
}
