package org.devathon.contest2016.machines;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.util.Vector;
import org.devathon.contest2016.utils.Cuboid;
import org.devathon.contest2016.utils.EntityModifier;

import java.util.ArrayList;
import java.util.List;

/**
 * @author joethei
 * @version 1.0
 */
public class ConveyorBelt implements Machine{

    private Cuboid cuboid;
    private List<Entity> entityList = new ArrayList<>();

    @Override
    public ShapedRecipe getRecipe() {
        return null;
    }

    @Override
    public void spawn(Location loc, BlockFace face) {
        Location temp = loc.clone();
        loc.getBlock().setType(Material.WOOL);
        for(double i = 0.0D; i < 50.0D; i++)
            loc.add(1.0D, 0.0D, 0.0D).getBlock().setType(Material.STONE);
        cuboid = new Cuboid(temp, loc);
        cuboid.getUpperLocation().getBlock().setType(Material.DIAMOND_BLOCK);
    }

    @Override
    public void registerEvents() {

    }

    public void addEntity(EntityType type) {
        Entity entity = new EntityModifier(cuboid.getWorld().spawnEntity(cuboid.getLowerLocation().add(0.0D, 2.0D, 0.0D), type))
                .modify().setInvulnerable(true).setDisplayName("Test Mob").build();

        entityList.add(entity);
    }

    public Cuboid getCuboid() {
        return cuboid;
    }

    @Override
    public void despawn() {
        for(Block block : getCuboid().getBlocks()) {
            block.setType(Material.AIR);
        }
        entityList.forEach(Entity::remove);
    }

    private Vector calculateVector(Location from, Location to) {
        double dX = from.getX() - to.getX();
        double dY = from.getY() - to.getY();
        double dZ = from.getZ() - to.getZ();

        double yaw = Math.atan2(dZ, dX);
        double pitch = Math.atan2(Math.sqrt(dZ * dZ + dX * dX), dY) + Math.PI;

        double x = Math.sin(pitch) * Math.cos(yaw);
        double y = Math.sin(pitch) * Math.sin(yaw);
        double z = Math.cos(pitch);

        return new Vector(x, z, y);
    }

}