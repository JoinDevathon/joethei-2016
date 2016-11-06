package org.devathon.contest2016.machines;

import org.bukkit.Location;
import org.bukkit.inventory.Recipe;

/**
 * @author joethei
 * @version 0.1
 */
public interface Machine {

    public Recipe getRecipe();
    public void spawn(Location loc);
    public void despawn(boolean drop);
    void registerEvents();
}