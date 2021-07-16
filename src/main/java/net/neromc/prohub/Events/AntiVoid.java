package net.neromc.prohub.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class AntiVoid implements Listener {

    @EventHandler
    public void AntiVoid(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            if (e.getCause().equals(EntityDamageEvent.DamageCause.VOID)){
                e.setCancelled(true);
                e.getEntity().teleport(((Player) e.getEntity()).getBedSpawnLocation());
            }
        }
    }
}
