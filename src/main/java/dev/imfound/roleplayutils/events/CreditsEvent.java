package dev.imfound.roleplayutils.events;

import dev.imfound.roleplayutils.RoleplayUtils;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;



public class CreditsEvent implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onCredit(PlayerCommandPreprocessEvent e) {
        if(e.getMessage().equalsIgnoreCase("/roleplayutils")) {
            e.setCancelled(true);
            if(e.getPlayer().hasPermission("roleplayutils.admin")) {
                RoleplayUtils.getInstance().getConfig().options().copyDefaults(true);
                RoleplayUtils.getInstance().saveConfig();
                RoleplayUtils.getInstance().reloadConfig();
                e.getPlayer().sendMessage("§c§lROLEPLAYUTILS §8» §fPlugin reloaded!");
            } else {
                TextComponent rputils = new TextComponent("§4› §cUsing §4RoleplayUtils §4by §cImFound§4 (DEV) & DanielDark1 (IDEAS)");
                rputils.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://imfound.dev"));
                rputils.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§4Yummy\n" +
                        "§cYummy\n" +
                        "§3@RoundStudios").create()));
                e.getPlayer().spigot().sendMessage(rputils);
            }
        }
    }

}
