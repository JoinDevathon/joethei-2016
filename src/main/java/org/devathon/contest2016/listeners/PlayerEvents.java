package org.devathon.contest2016.listeners;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.devathon.contest2016.machines.ConveyorBelt;

/**
 * @author joethei
 * @version 0.1
 */
public class PlayerEvents implements Listener {

    private ConveyorBelt conveyorBelt;

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        if(e.getPlayer().getInventory().getItemInMainHand().getType() == Material.STICK) {
            e.getPlayer().sendMessage("created");
            conveyorBelt = new ConveyorBelt();
            e.getPlayer().sendMessage(e.getPlayer().getLocation().toString());
            e.getPlayer().sendMessage(e.getPlayer().getLocation().add(0.0D, 0.0D, 0.D).toString());
            conveyorBelt.spawn(e.getPlayer().getLocation().add(0.0D, 0.0D, 0.D));
            conveyorBelt.addEntity(EntityType.ZOMBIE);
        }
        if(e.getPlayer().getInventory().getItemInMainHand().getType() == Material.BLAZE_ROD) {
            if(conveyorBelt != null) {
                conveyorBelt.despawn();
            }
        }
    }
}