package dev.imfound.roleplayutils.commands;

import dev.imfound.roleplayutils.utils.Config;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Broadcast2Command extends Command {

    public HashMap<String, Long> cooldowns = new HashMap<String, Long>();

    public Broadcast2Command() {
        super(Config.BROADCAST_COMMAND.toLowerCase(), "broadcast command", "/" + Config.BROADCAST_COMMAND.toLowerCase(), new ArrayList<>());
        load();
    }

    private void load() {
        try {
            final Field bukkitCommandMap;
            bukkitCommandMap = Bukkit.getServer().getClass().getDeclaredField("commandMap");
            bukkitCommandMap.setAccessible(true);
            CommandMap commandMap = (CommandMap) bukkitCommandMap.get(Bukkit.getServer());
            commandMap.register(this.getName(), this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean execute(CommandSender sender, String cmd, String[] args) {
        if (sender instanceof Player && cmd.equalsIgnoreCase(Config.BROADCAST_COMMAND)) {
            Player p = (Player) sender;
            if (p.hasPermission(Config.BROADCAST_PERMISSION)) {
                if (args.length == 0) {
                    p.sendMessage(Config.BROADCAST_USE);
                } else {
                    if(Config.BROADCAST_COOLDOWN_BOOL) {
                        int cooldownTime = Config.BROADCAST_COOLDOWN;
                        if(cooldowns.containsKey(p.getName())) {
                            long secondsLeft = ((cooldowns.get(sender.getName())/1000)+cooldownTime) - (System.currentTimeMillis()/1000);
                            if(secondsLeft>0) {
                                p.sendMessage(Config.BROADCAST_COOLDOWN_MESSAGE.replace("<seconds>", secondsLeft + ""));
                                return true;
                            }
                        }
                        cooldowns.put(p.getName(), System.currentTimeMillis());
                    }
                    for (Player ps : Bukkit.getOnlinePlayers()) {
                        ps.sendMessage(Config.BROADCAST_MESSAGE.replace("<message>", ChatColor.translateAlternateColorCodes('&', String.join(" ", args))));
                    }
                }
            } else {
                p.sendMessage(Config.NOPERMS);
            }
        }
        return false;
    }
}
