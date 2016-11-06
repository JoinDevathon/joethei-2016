package org.devathon.contest2016.utils;

import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.EulerAngle;

/**
 * @author joethei
 * @version 1.0
 */
public class ItemModel {

    private Location location;
    private ItemStack item;
    private int size;
    private ArmorStand armorStand;
    private boolean isRemoved;

    public ItemModel(Location location, ItemStack item, int size) {
        this.location = location;
        this.item = item;
        if(!isValid(item, size)) size = 2;
        this.size = size;
        this.isRemoved = false;
        spawn(location, item, size);
    }

    public void setSize(int size) {
        this.size = size;
        if(!this.isRemoved) {
            armorStand.remove();
            spawn(location, item, size);
        }
    }

    public void remove() {
        if(!isRemoved) {
            armorStand.remove();
            isRemoved = true;
        }
    }

    public Location getLocation() {
        return location;
    }

    public ItemStack getItem() {
        return item;
    }

    public int getSize() {
        return size;
    }

    public boolean isRemoved() {
        return isRemoved;
    }

    private void spawn(Location location, ItemStack item, int size) {
        if(!isValid(item, size)) return;
        EulerAngle angle = new EulerAngle(0, 0, 0);

        if(item.getType().isBlock()) {
            if(size == 1) {
                location.add(.2, -.445, 0);
                location.setPitch(45);
                angle = new EulerAngle(-.6, 0, 0);
            }
            if(size == 2) {
                location.add(.6, -.65, 0);
                location.setPitch(45);
                angle = new EulerAngle(-.25, 0, 0);
            }
            if(size == 3) {
                location.add(0, -.7, 0);
            }
        }else {
            if(size == 1) {
                location.add(.2, -.5, -.1);
                angle = new EulerAngle(-.35, 0, 0);
            }
            if(size == 2) {
                location.add(.7, -.8, -.1);
                angle = new EulerAngle(0, 1, 0);
            }
        }

        armorStand = (ArmorStand) location.getWorld().spawnEntity(location, EntityType.ARMOR_STAND);
        armorStand.setVisible(false);
        armorStand.setAI(true);
        armorStand.setGravity(false);
        armorStand.setCanPickupItems(false);

        armorStand.setSmall(size == 1);
        armorStand.setRightArmPose(angle);
        armorStand.setItemInHand(item);
    }

    private boolean isValid(ItemStack item, int size) {
        if(item.getType().isBlock()) {
            return size == 1 || size == 2 || size == 3;
        }else {
            return size == 1 || size == 2;
        }
    }
}