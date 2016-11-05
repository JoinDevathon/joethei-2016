package org.devathon.contest2016.machines;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.devathon.contest2016.utils.Cuboid;
import org.devathon.contest2016.utils.EntityModifier;

import java.util.ArrayList;
import java.util.List;

/**
 * @author joethei
 * @version 0.1
 */
public class ConveyorBelt implements Machine{

    private Cuboid cuboid;
    private List<Entity> entityList = new ArrayList<>();

    @Override
    public void spawn(Location loc) {
        cuboid = new Cuboid(loc, loc.add(5.0D, 1.0D, 5.0D));
        loc.getBlock().setType(Material.STONE);
        for(int i = 0; i < 5; i++)  {
            loc.add(i, 0.0, 0.0D).getBlock().setType(Material.STONE);
        }
    }

    @Override
    public void addEntity(EntityType type) {
        entityList.add(new EntityModifier(cuboid.getWorld().spawnEntity(cuboid.getLowerLocation(), type)).modify().setNoAI(true).setInvulnerable(true).setSilent(true).walkToLocation(cuboid.getUpperLocation(), 1.0F).build());
    }

    @Override
    public Cuboid getCuboid() {
        return cuboid;
    }

    @Override
    public void despawn() {
        for(Block block : cuboid.getBlocks()) {
            block.setType(Material.AIR);
        }
        entityList.forEach(Entity::remove);
    }
}