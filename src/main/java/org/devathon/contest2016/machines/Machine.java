package org.devathon.contest2016.machines;

import org.bukkit.Location;
import org.bukkit.inventory.Recipe;

/**
 * @author joethei
 * @version 1.0
 */
public interface Machine {

    Recipe getRecipe();
    void spawn(Location loc);
    void despawn(boolean drop);
    void registerEvents();
}