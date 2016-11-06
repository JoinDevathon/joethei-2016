package org.devathon.contest2016.utils;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * creates items in a easy way
 * @author joethei
 * @version 0.1
 */
public class ItemBuilder {

    private final ItemStack item;
    private final ItemMeta meta;

    public ItemBuilder(Material type) {
        item = new ItemStack(type);
        meta = item.getItemMeta();
    }

    public ItemBuilder setType(Material type) {
        make().setType(type);
        return this;
    }

    public ItemBuilder setAmount(int amount) {
        make().setAmount(amount);
        return this;
    }

    public ItemBuilder setName(String name) {
        getMeta().setDisplayName(name);
        make().setItemMeta(getMeta());
        return this;
    }

    public ItemBuilder lores(String[] lores) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, lores);
        getMeta().setLore(list);
        return this;
    }

    public ItemBuilder setGlowing() {
        getMeta().addEnchant(Enchantment.ARROW_DAMAGE, 10, false);
        return this;
    }

    public ItemMeta getMeta() {
        return meta;
    }

    public ItemStack make() {
        item.getItemMeta().addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_DESTROYS, ItemFlag.HIDE_UNBREAKABLE, ItemFlag.HIDE_ENCHANTS);
        return item;
    }

}
