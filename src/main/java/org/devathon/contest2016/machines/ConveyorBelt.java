package org.devathon.contest2016.machines;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ShapedRecipe;
import org.devathon.contest2016.utils.Cuboid;
import org.devathon.contest2016.utils.EntityModifier;

import java.util.ArrayList;
import java.util.List;

/**
 * @author joethei
 * @version 0.5
 */
public class ConveyorBelt implements Machine{

    private Cuboid cuboid;
    private List<Entity> entityList = new ArrayList<>();

    @Override
    public ShapedRecipe getRecipe() {
        return null;
    }

    @Override
    public void spawn(Location loc) {
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
    public void despawn(boolean drop) {
        for(Block block : getCuboid().getBlocks()) {
            block.setType(Material.AIR);
        }
        entityList.forEach(Entity::remove);
    }

}