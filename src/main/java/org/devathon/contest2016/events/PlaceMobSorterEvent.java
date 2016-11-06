package org.devathon.contest2016.events;

import org.bukkit.event.block.BlockPlaceEvent;
import org.devathon.contest2016.DevathonPlugin;
import org.devathon.contest2016.machines.MobSorter;

/**
 * @author joethei
 * @version 1.0
 */
public class PlaceMobSorterEvent extends BlockPlaceEvent{

    private MobSorter mobSorter;
    public MobSorter getMobSorter() {
        return mobSorter;
    }

    public PlaceMobSorterEvent(BlockPlaceEvent event) {
        super(event.getBlock(), event.getBlockReplacedState(), event.getBlockAgainst(), event.getItemInHand(), event.getPlayer(), event.canBuild());
        mobSorter = DevathonPlugin.getMobSorter(event.getItemInHand());
    }

}