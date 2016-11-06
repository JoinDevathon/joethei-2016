package org.devathon.contest2016.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.devathon.contest2016.events.PlaceMobKillerEvent;
import org.devathon.contest2016.events.PlaceMobSorterEvent;

/**
 * @author joethei
 * @version 1.0
 */
public class BlockEvents implements Listener{

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
        if(e.isCancelled() || e instanceof PlaceMobKillerEvent || e instanceof PlaceMobSorterEvent) return;
        if(e.getBlock().getType() == Material.PISTON_BASE) Bukkit.getPluginManager().callEvent(new PlaceMobSorterEvent(e));
        if(e.getBlock().getType() == Material.HOPPER) Bukkit.getPluginManager().callEvent(new PlaceMobKillerEvent(e));

    }

    @EventHandler
    public void onMobSorterPlace(PlaceMobSorterEvent e) {
        e.setCancelled(true);
        e.getMobSorter().spawn(e.getBlock().getLocation());
    }

    @EventHandler
    public void onMobKillerPlace(PlaceMobKillerEvent e) {
        e.setCancelled(true);
        e.getMobKiller().spawn(e.getBlock().getLocation());
    }
}