package org.devathon.contest2016.machines;

import org.bukkit.Location;
import org.bukkit.block.BlockFace;
import org.bukkit.inventory.ShapedRecipe;

/**
 * @author joethei
 * @version 0.1
 */
public class ConveyorBelt implements Machine{
    @Override
    public ShapedRecipe getRecipe() {
        return null;
    }

    @Override
    public void spawn(Location loc, BlockFace face) {

    }

    @Override
    public void despawn() {

    }

    @Override
    public void registerEvents() {

    }
    /*

    private Cuboid cuboid;
    private List<Entity> entityList = new ArrayList<>();

    private Entity targetEntity;
    public Entity getTargetEntity() {
        return targetEntity;

    }

    @Override
    public void spawn(Location loc) {
        Location temp = loc.clone();
        loc.getBlock().setType(Material.WOOL);
        for(double i = 0.0D; i < 10.0D; i++)
            loc.add(1.0D, 0.0D, 0.0D).getBlock().setType(Material.STONE);
        cuboid = new Cuboid(temp, loc);
        cuboid.getUpperLocation().getBlock().setType(Material.DIAMOND_BLOCK);
    }

    @Override
    public void addEntity(EntityType type) {
        entityList.add(new EntityModifier(cuboid.getWorld().spawnEntity(cuboid.getLowerLocation().add(0.0D, 2.0D, 0.0D), type))
                .modify().setInvulnerable(true).setDisplayName("Test Mob").setSilent(true).walkToLocation(cuboid.getUpperLocation(), 0.3F).build());
        targetEntity = new EntityModifier(cuboid.getWorld().spawnEntity(cuboid.getUpperLocation().add(0.0D, 2.0D, 0.0D), EntityType.VILLAGER)).modify().setNoAI(true).setSilent(true).setInvulnerable(true).setGlowing(true).build();
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
        targetEntity.remove();
    }
    */
}