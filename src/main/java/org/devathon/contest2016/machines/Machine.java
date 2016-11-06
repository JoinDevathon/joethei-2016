package org.devathon.contest2016.machines;

import org.bukkit.Location;
import org.bukkit.block.BlockFace;
import org.bukkit.inventory.Recipe;

/**
 * @author joethei
 * @version 0.1
 */
public interface Machine {

    public Recipe getRecipe();
    public void spawn(Location loc, BlockFace face);
    public void despawn();
    void registerEvents();
}