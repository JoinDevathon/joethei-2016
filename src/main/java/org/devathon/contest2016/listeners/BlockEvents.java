package org.devathon.contest2016.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.devathon.contest2016.events.PlaceMobSorterEvent;

/**
 * @author joethei
 * @version 1.0
 */
public class BlockEvents implements Listener{

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
        if(e.isCancelled() || e instanceof PlaceMobSorterEvent) return;
        if(e.getBlock().getType() == Material.PISTON_BASE) {
            Bukkit.getPluginManager().callEvent(new PlaceMobSorterEvent(e));
        }
    }

    @EventHandler
    public void onMobSorterPlace(PlaceMobSorterEvent e) {
        e.setCancelled(true);
        e.getMobsorter().spawn(e.getBlock().getLocation(), e.getBlock().getFace(e.getBlockAgainst()));
    }
}