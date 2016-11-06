package org.devathon.contest2016.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.entity.EntityTargetEvent;

/**
 * entity events for old idea, should still work if registered.
 * @author joethei
 * @version 1.0
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