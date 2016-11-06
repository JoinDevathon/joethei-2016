package org.devathon.contest2016;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.devathon.contest2016.listeners.BlockEvents;
import org.devathon.contest2016.machines.ConveyorBelt;
import org.devathon.contest2016.machines.MobKiller;
import org.devathon.contest2016.machines.MobSorter;

import java.util.ArrayList;

/**
 * the place where everything starts
 * @author joethei
 * @version 1.0
 */

public class DevathonPlugin extends JavaPlugin{

    private static DevathonPlugin instance;
    public static DevathonPlugin getInstance() {
        return instance;
    }

    public static ConveyorBelt conveyorBelt;

    private static ArrayList<MobSorter> sorterList = new ArrayList<>();
    public static ArrayList<MobSorter> getMobSorters() {
        return sorterList;
    }
    public static MobSorter getMobSorter(ItemStack item) {
        for(MobSorter sorter : sorterList) {
            if(item.getItemMeta().getDisplayName().equals(sorter.getName() + " Sorter")) return sorter;
        }
        return null;
    }

    private static MobKiller mobKiller;
    public static MobKiller getMobKiller() {
        return mobKiller;
    }
    public static void setMobKiller(MobKiller mobKiller) {
        DevathonPlugin.mobKiller = mobKiller;
    }

    @Override
    public void onEnable() {
        instance = this;
        PluginManager pm = Bukkit.getPluginManager();

        new MobSorter("Creeper", EntityType.CREEPER, Material.SULPHUR);
        new MobSorter("Zombie", EntityType.ZOMBIE, Material.ROTTEN_FLESH);
        new MobSorter("Skeleton", EntityType.SKELETON, Material.BONE);

        setMobKiller(new MobKiller());

        pm.registerEvents(new BlockEvents(), this);
        //pm.registerEvents(new PlayerEvents(), this);
    }

    @Override
    public void onDisable() {

    }
}

