package de.jon4x.bungeesystem.support;

import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SupportManager {
    private static SupportManager instance;
    private List<ProxiedPlayer> supportQueue;
    private Map<ProxiedPlayer, ProxiedPlayer> supportPlayer;

    public SupportManager() {
        this.supportQueue = new ArrayList<>();
        this.supportPlayer = new HashMap<>();
    }

    public static SupportManager getInstance() {
        if (instance == null) {
            instance = new SupportManager();
        }
        return instance;
    }

    public List<ProxiedPlayer> getSupportQueue() {
        return this.supportQueue;
    }

    public Map<ProxiedPlayer, ProxiedPlayer> getSupportPlayer() {
        return this.supportPlayer;
    }

}
