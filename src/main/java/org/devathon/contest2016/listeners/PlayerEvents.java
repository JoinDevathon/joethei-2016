package org.devathon.contest2016.listeners;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.devathon.contest2016.DevathonPlugin;
import org.devathon.contest2016.machines.ConveyorBelt;

/**
 * @author joethei
 * @version 1.0
 */
public class PlayerEvents implements Listener {

    //some old stuff from my first idea, should still work if registered

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        if (e.getPlayer().getInventory().getItemInMainHand().getType() == Material.STICK) {
            if (DevathonPlugin.conveyorBelt != null) {
                DevathonPlugin.conveyorBelt.despawn(false);
                DevathonPlugin.conveyorBelt = null;
                e.getPlayer().sendMessage("removed");
            }
            DevathonPlugin.conveyorBelt = new ConveyorBelt();
            DevathonPlugin.conveyorBelt.spawn(e.getPlayer().getLocation());
            DevathonPlugin.conveyorBelt.addEntity(EntityType.ZOMBIE);
            e.getPlayer().sendMessage("created");
        }
        if (e.getPlayer().getInventory().getItemInMainHand().getType() == Material.BLAZE_ROD) {
            if (DevathonPlugin.conveyorBelt != null) {
                DevathonPlugin.conveyorBelt.despawn(false);
                DevathonPlugin.conveyorBelt = null;
                e.getPlayer().sendMessage("removed");
            }
        }
    }


}