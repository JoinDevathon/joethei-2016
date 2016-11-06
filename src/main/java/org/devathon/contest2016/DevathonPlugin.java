package org.devathon.contest2016;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.devathon.contest2016.listeners.EntityEvents;
import org.devathon.contest2016.listeners.PlayerEvents;

public class DevathonPlugin extends JavaPlugin{

    private static DevathonPlugin instance;
    public static DevathonPlugin getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new PlayerEvents(), this);
        pm.registerEvents(new EntityEvents(), this);
    }

    @Override
    public void onDisable() {

    }
}

