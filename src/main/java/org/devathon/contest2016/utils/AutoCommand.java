package org.devathon.contest2016.utils;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_10_R1.CraftServer;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author joethei
 * @version 1.0
 */
public abstract class AutoCommand<P extends JavaPlugin> extends Command {

    private static String path = Bukkit.getServer().getClass().getPackage().getName();
    private static String version = path.substring(path.lastIndexOf(".") + 1, path.length());

    private final P plugin;
    private final String command;

    public AutoCommand(P plugin, String command, String description, String... aliases) {
        super(command);
        this.plugin = plugin;
        this.command = command;

        super.setDescription(description);
        List<String> list = new ArrayList<>();
        Collections.addAll(list, aliases);
        super.setAliases(list);
        this.register();
    }

    private void register() {
        try {
            Field field = CraftServer.class.getDeclaredField("commandMap");
            field.setAccessible(true);

            CommandMap map = (CommandMap) field.get(Bukkit.getServer());
            map.register(this.plugin.getName(), this);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public abstract boolean execute(CommandSender sender, String label, String[] args);

    public abstract List<String> tabComplete(CommandSender sender, String label, String[] args);

    public P getPlugin() {
        return this.plugin;
    }
}