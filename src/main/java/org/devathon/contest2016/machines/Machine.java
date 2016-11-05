package org.devathon.contest2016.machines;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.devathon.contest2016.utils.Cuboid;

/**
 * @author joethei
 * @version 0.1
 */
public interface Machine {

    public Cuboid getCuboid();
    public void spawn(Location loc);
    public void despawn();
    public void addEntity(EntityType type);
}