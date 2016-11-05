package org.devathon.contest2016;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.devathon.contest2016.game.GameStage;
import org.devathon.contest2016.listeners.PlayerEvents;

public class DevathonPlugin extends JavaPlugin{

    private static DevathonPlugin instance;
    public static DevathonPlugin getInstance() {
        return instance;
    }

    private static GameStage gameStage;
    public static GameStage getGameStage() {
        return gameStage;
    }

    public void setGameStage(GameStage gameStage) {
        DevathonPlugin.gameStage = gameStage;
    }

    @Override
    public void onEnable() {
        instance = this;
        gameStage = GameStage.Lobby;
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new PlayerEvents(), this);
    }

    @Override
    public void onDisable() {

    }
}

