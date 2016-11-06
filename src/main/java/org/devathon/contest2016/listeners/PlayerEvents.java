package org.devathon.contest2016.listeners;

import org.bukkit.event.Listener;

/**
 * @author joethei
 * @version 0.1
 */
public class PlayerEvents implements Listener {

    /*
    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        if(e.getPlayer().getInventory().getItemInMainHand().getType() == Material.STICK) {
            if(DevathonPlugin.conveyorBelt != null) {
                DevathonPlugin.conveyorBelt.despawn();
                DevathonPlugin.conveyorBelt = null;
                e.getPlayer().sendMessage("removed");
            }
            DevathonPlugin.conveyorBelt = new ConveyorBelt();
            DevathonPlugin.conveyorBelt.spawn(e.getPlayer().getLocation(), null);
            DevathonPlugin.conveyorBelt.addEntity(EntityType.ZOMBIE);
            e.getPlayer().sendMessage("created");
        }
        if(e.getPlayer().getInventory().getItemInMainHand().getType() == Material.BLAZE_ROD) {
            if(DevathonPlugin.conveyorBelt != null) {
                DevathonPlugin.conveyorBelt.despawn();
                DevathonPlugin.conveyorBelt = null;
                e.getPlayer().sendMessage("removed");
            }
        }
    }
    */

}