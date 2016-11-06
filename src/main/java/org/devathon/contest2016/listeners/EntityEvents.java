package org.devathon.contest2016.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.entity.EntityTargetEvent;

/**
 * @author joethei
 * @version 0.1
 */
public class EntityEvents implements Listener {

    @EventHandler
    public void onEntityChangeBlock(EntityChangeBlockEvent e) {
        System.out.println(e.getBlock().toString());
    }

    @EventHandler
    public void onEntityTarget(EntityTargetEvent e) {

    }
}