package org.devathon.contest2016.machines;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.metadata.FixedMetadataValue;
import org.devathon.contest2016.DevathonPlugin;
import org.devathon.contest2016.utils.ItemBuilder;
import org.devathon.contest2016.utils.ItemModel;

/**
 * @author joethei
 * @version 0.1
 */
public class MobSorter implements Machine, Listener {

    private String name;
    private EntityType type;
    private Material material;

    private Location location;
    private ItemModel itemModel;

    public String getName() {
        return name;
    }

    public MobSorter(String name, EntityType type, Material material) {
        this.name = name;
        this.type = type;
        this.material = material;
        registerEvents();
        Bukkit.addRecipe(getRecipe());
        DevathonPlugin.getMobSorters().add(this);
    }

    @Override
    public Recipe getRecipe() {
        ItemStack item = new ItemBuilder(Material.PISTON_BASE).setName(name + " Sorter").setGlowing().make();

        ShapelessRecipe recipe = new ShapelessRecipe(item);

        recipe.addIngredient(material);
        recipe.addIngredient(Material.PISTON_BASE);

        return recipe;
    }

    @Override
    public void spawn(Location loc, BlockFace face) {
        this.location = loc;
        loc.getBlock().setType(Material.BEDROCK);
        loc.getBlock().setMetadata("Type", new FixedMetadataValue(DevathonPlugin.getInstance(), name));
        loc.add(0.0D, 1.0D, 0.0D).getBlock().setType(Material.GOLD_PLATE);
        itemModel = new ItemModel(loc, new ItemStack(material), 2);
    }

    @Override
    public void despawn() {
        location.getBlock().setType(Material.AIR);
        itemModel.remove();
    }

    @Override
    public void registerEvents() {
        Bukkit.getPluginManager().registerEvents(this, DevathonPlugin.getInstance());
    }

    @EventHandler
    public void onEntityInteract(EntityInteractEvent e) {
        Location block = e.getBlock().getLocation().subtract(0.0D, 1.0D, 0.0D);
        if(e.getBlock().getType() == Material.GOLD_PLATE && block.getBlock().getType() == Material.BEDROCK && block.getBlock().hasMetadata("Type")) {
            if(e.getEntity().getType() == this.type) {
                e.getBlock().setType(Material.AIR);
                block.getBlock().setType(Material.AIR);
                for(Player player : Bukkit.getOnlinePlayers()) {
                    player.playSound(block.getBlock().getLocation(), Sound.BLOCK_PISTON_CONTRACT, 1.0F, 1.0F);
                }
                Bukkit.getScheduler().scheduleSyncDelayedTask(DevathonPlugin.getInstance(), () -> {
                    block.getBlock().setType(Material.BEDROCK);
                    e.getBlock().setType(Material.GOLD_PLATE);
                    for(Player player : Bukkit.getOnlinePlayers()) {
                        player.playSound(block.getBlock().getLocation(), Sound.BLOCK_PISTON_EXTEND, 1.0F, 1.0F);
                    }
                }, 2 * 20L);
            }
        }
    }
}