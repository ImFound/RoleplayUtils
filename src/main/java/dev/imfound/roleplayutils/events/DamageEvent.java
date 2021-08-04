package dev.imfound.roleplayutils.events;

import dev.imfound.roleplayutils.utils.Config;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class DamageEvent implements Listener {

    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent e) {
        if(e.getDamager() instanceof Player) {
            if(Config.VANILLA_PVP) {
                e.setCancelled(false);
            } else {
                e.setCancelled(true);
            }
        } else {
            if(Config.PLUGINS_PVP) {
                e.setCancelled(false);
            } else {
                e.setCancelled(true);
            }
        }
    }

}
