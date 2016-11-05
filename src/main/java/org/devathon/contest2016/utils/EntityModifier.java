package org.devathon.contest2016.utils;

import net.minecraft.server.v1_10_R1.EntityLiving;
import net.minecraft.server.v1_10_R1.NBTTagCompound;
import org.bukkit.EntityEffect;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_10_R1.entity.CraftCreature;
import org.bukkit.craftbukkit.v1_10_R1.entity.CraftEntity;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.devathon.contest2016.DevathonPlugin;

import java.lang.reflect.Field;

/**
 * @author joethei
 * @version 0.1
 */
public class EntityModifier {
    private static Entity entity;
    private static CraftEntity craftEntity;
    private static net.minecraft.server.v1_10_R1.Entity nmsEntity;
    private static Plugin plugin = DevathonPlugin.getInstance();
    private static Player player;


    public EntityModifier(Entity entity) {
        EntityModifier.entity = entity;
        craftEntity = (CraftEntity) entity;
        nmsEntity = craftEntity.getHandle();
    }

    public Builder modify() {
        return new Builder();
    }


    public static final class Builder{
        public Builder setDisplayName(String name) {
            entity.setCustomName(name);
            entity.setCustomNameVisible(true);
            return this;
        }

        public Builder playEffect(EntityEffect effect) {
            entity.playEffect(effect);
            return this;
        }

        public void teleport(Location location) {
            entity.teleport(location);
        }

        public Builder die() {
            EntityModifier.nmsEntity.die();
            return this;
        }

        public Builder setNoAI(boolean noAI) {
            NBTTagCompound tag = new NBTTagCompound();
            nmsEntity.c(tag);
            tag.setBoolean("NoAI", noAI);
            EntityLiving living = (EntityLiving) nmsEntity;
            living.a(tag);
            return this;
        }

        public Builder setSilent(boolean silent) {
            NBTTagCompound tag = new NBTTagCompound();
            nmsEntity.c(tag);
            tag.setBoolean("Silent", silent);
            EntityLiving living = (EntityLiving) nmsEntity;
            living.a(tag);
            return this;
        }

        public Builder setCanPickUpLoot(boolean canPickupLoot) {
            NBTTagCompound tag = new NBTTagCompound();
            nmsEntity.c(tag);
            tag.setBoolean("CanPickUpLoot", canPickupLoot);
            EntityLiving living = (EntityLiving) nmsEntity;
            living.a(tag);
            return this;
        }

        public Builder setInvulnerable(boolean invulnerable) {
            try {
                Field field = net.minecraft.server.v1_10_R1.Entity.class.getDeclaredField("invulnerable");
                field.setAccessible(true);
                field.setBoolean(nmsEntity, invulnerable);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
            return this;
        }

        public Builder walkToLocation(Location location, float speed) {
            ((CraftCreature) entity).getHandle().getNavigation().a(location.getX(), location.getY(), location.getZ(), speed);
            return this;
        }

        public Entity build() {
            return entity;
        }
    }
}