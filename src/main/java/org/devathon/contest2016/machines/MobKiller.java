package org.devathon.contest2016.machines;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityInteractEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.metadata.FixedMetadataValue;
import org.devathon.contest2016.DevathonPlugin;
import org.devathon.contest2016.utils.ItemBuilder;

/**
 * @author joethei
 * @version 1.0
 */
public class MobKiller implements Machine, Listener {

    private Location location;

    public MobKiller() {
        registerEvents();
        Bukkit.addRecipe(getRecipe());
    }

    @Override
    public Recipe getRecipe() {
        ItemStack item = new ItemBuilder(Material.HOPPER).setName("Mob killer").setGlowing().make();

        ShapelessRecipe recipe = new ShapelessRecipe(item);

        recipe.addIngredient(Material.DIAMOND_SWORD);
        recipe.addIngredient(Material.HOPPER);

        return recipe;
    }

    @Override
    public void spawn(Location loc) {
        this.location = loc;
        loc.getBlock().setType(Material.HOPPER);
        loc.clone().add(0.0D, 1.0D, 0.0D).getBlock().setType(Material.IRON_PLATE);
        loc.getBlock().setMetadata("mobKiller", new FixedMetadataValue(DevathonPlugin.getInstance(), "mobKiller"));
    }

    @Override
    public void despawn(boolean drop) {
        Location temp = location.clone();
        temp.add(0.0D, 1.0D, 0.0D).getBlock().setType(Material.AIR);
        location.getBlock().setType(Material.AIR);
        if(drop) location.getWorld().dropItemNaturally(location, getRecipe().getResult());
    }

    @Override
    public void registerEvents() {
        Bukkit.getPluginManager().registerEvents(this, DevathonPlugin.getInstance());
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        if(e.getPlayer().getInventory().getItemInMainHand().getType() == Material.BLAZE_ROD && e.getClickedBlock() != null) despawn(true);
    }

    @EventHandler
    public void onEntityInteract(EntityInteractEvent e) {
        Location block = e.getBlock().getLocation().subtract(0.0D, 1.0D, 0.0D);
        if(e.getBlock().getType() == Material.IRON_PLATE) e.setCancelled(true);
        if(e.getBlock().getType() == Material.IRON_PLATE && block.getBlock().getType() == Material.HOPPER && block.getBlock().hasMetadata("mobKiller")) {
            if(e.getEntity() instanceof LivingEntity && !(e.getEntity() instanceof Player)) {
                LivingEntity entity = (LivingEntity) e.getEntity();
                entity.setHealth(0.0D);
            }
        }
    }
}