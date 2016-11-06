
package org.devathon.contest2016.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;

/**
 * @author joethei
 * @version 1.0
 */
public class Cuboid{

    private String worldName;
    private final Vector minPoint;
    private final Vector maxPoint;

    public Cuboid(Location min, Location max) {
        if(min != null && max != null) {
            if(min.getWorld() != null && max.getWorld() != null) {
                if(!min.getWorld().getUID().equals(max.getWorld().getUID())) {
                    throw new IllegalStateException("the two locations must be in the same world");
                }else {
                    this.worldName = min.getWorld().getName();

                    double minX = Math.min(min.getX(), max.getX());
                    double minY = Math.min(min.getY(), min.getX());
                    double minZ = Math.min(min.getZ(), max.getZ());

                    double maxX = Math.max(min.getX(), max.getX());
                    double maxY = Math.max(min.getY(), max.getY());
                    double maxZ = Math.max(min.getZ(), max.getZ());

                    this.minPoint = new Vector(minX, minY, minZ);
                    this.maxPoint = new Vector(maxX, maxY, maxZ);
                }

            }else {
                throw new NullPointerException("at least one world is null");
            }

        }else {
            throw new NullPointerException("at least one location is null");
        }
    }

    public boolean containsLocation(Location loc) {
        return loc != null && loc.getWorld().getName().equals(this.worldName) && loc.toVector().isInAABB(this.minPoint, this.maxPoint);
    }

    public List<Block> getBlocks() {
        List<Block> list = new ArrayList<>();
        if(getWorld() != null) {
            for(int x = this.minPoint.getBlockX(); x <= this.maxPoint.getBlockX(); x++) {
                for(int y = this.minPoint.getBlockY(); y <= this.maxPoint.getBlockY() && y <= getWorld().getMaxHeight(); y++) {
                    for(int z = this.maxPoint.getBlockZ(); z <= this.maxPoint.getBlockZ(); z++) {
                        list.add(getWorld().getBlockAt(x, y, z));
                    }
                }
            }
        }
        return list;
    }

    public Location getLowerLocation() {
        return this.minPoint.toLocation(getWorld());
    }

    public Location getUpperLocation() {
        return this.maxPoint.toLocation(getWorld());
    }

    public World getWorld() {
        return Bukkit.getWorld(this.worldName);
    }
}