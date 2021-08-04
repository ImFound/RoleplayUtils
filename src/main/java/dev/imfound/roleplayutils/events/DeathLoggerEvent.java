package dev.imfound.roleplayutils.events;

import dev.imfound.roleplayutils.utils.Config;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class DeathLoggerEvent implements Listener {

    @EventHandler
    public void onDeath(EntityDeathEvent e) {
        if(e.getEntity() instanceof Player) {
            if(e.getEntity().getKiller() != null) {
                Player victim = (Player) e.getEntity();
                Player killer = e.getEntity().getKiller();
                for(Player p : Bukkit.getOnlinePlayers()) {
                    if(p.hasPermission(Config.DEATHLOGGER_PERMISSION)) {
                        p.sendMessage(Config.DEATHLOGGER_MESSAGE.replace("<killer>", killer.getName()).replace("<player>", victim.getName()));
                    }
                }
                Bukkit.getLogger().warning(Config.DEATHLOGGER_MESSAGE.replace("<killer>", killer.getName()).replace("<player>", victim.getName()));
            }
        }
    }

}
