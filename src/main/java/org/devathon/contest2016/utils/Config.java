package org.devathon.contest2016.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

/**
 * handles the file that saves block locations
 * @author joethei
 * @version 1.0
 */
public class Config {

    private static final File file = new File("plugins/Devathon", "blocks.yml");
    private static final FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);


    public static void write(String path, Location location) {
        cfg.set(path + ".World", location.getWorld().getName());
        cfg.set(path + ".X", location.getX());
        cfg.set(path + ".Y", location.getY());
        cfg.set(path + ".Z", location.getZ());
        cfg.set(path + ".Yaw", (double) location.getYaw());
        cfg.set(path + ".Pitch", (double) location.getPitch());

        try {
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Location readLocation(String path) {
        String world = cfg.getString(path + ".World");
        double x = cfg.getDouble(path + ".X");
        double y = cfg.getDouble(path + ".Y");
        double z = cfg.getDouble(path + ".Z");
        float yaw = (float) cfg.getDouble(path + ".Yaw");
        float pitch = (float) cfg.getDouble(path + ".Pitch");

        return new Location(Bukkit.getWorld(world), x, y, z, yaw, pitch);
    }

    public static boolean isExsisting(String path) {
        return cfg.contains(path);
    }

}