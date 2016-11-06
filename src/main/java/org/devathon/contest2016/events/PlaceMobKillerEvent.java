package org.devathon.contest2016.events;

import org.bukkit.event.block.BlockPlaceEvent;
import org.devathon.contest2016.DevathonPlugin;
import org.devathon.contest2016.machines.MobKiller;

/**
 * @author joethei
 * @version 1.0
 */
public class PlaceMobKillerEvent extends BlockPlaceEvent{

    private MobKiller mobKiller;
    public MobKiller getMobKiller() {
        return mobKiller;
    }

    public PlaceMobKillerEvent(BlockPlaceEvent event) {
        super(event.getBlock(), event.getBlockReplacedState(), event.getBlockAgainst(), event.getItemInHand(), event.getPlayer(), event.canBuild());
        mobKiller = DevathonPlugin.getMobKiller();
    }
}