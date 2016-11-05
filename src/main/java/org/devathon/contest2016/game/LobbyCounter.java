package org.devathon.contest2016.game;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.devathon.contest2016.DevathonPlugin;

/**
 * @author joethei
 * @version 0.1
 */
public class LobbyCounter extends BukkitRunnable{

    private int time = 60;

    @Override
    public void run() {
        if(DevathonPlugin.getGameStage() != GameStage.Lobby) {
            this.cancel();
        }
        for(Player players : Bukkit.getOnlinePlayers()) {
            players.setLevel(time);
            if(time >= 10) {
                players.playSound(players.getEyeLocation(), Sound.ENTITY_ARROW_HIT, 1.0F, 1.0F);
            }
            if(time == 0) {
                this.cancel();
            }
        }

        time--;
    }
}