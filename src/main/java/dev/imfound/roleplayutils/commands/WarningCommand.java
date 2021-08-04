package dev.imfound.roleplayutils.commands;

import dev.imfound.roleplayutils.utils.Config;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class WarningCommand extends Command {

    public WarningCommand() {
        super(Config.WARNING_COMMAND, "command for warning", "/" + Config.WARNING_COMMAND, new ArrayList<>());
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
        if(cmd.equalsIgnoreCase(Config.WARNING_COMMAND)) {
            if(sender instanceof Player) {
                Player p = (Player) sender;
                if(p.hasPermission(Config.WARNING_PERMISSION)) {
                    if(args.length == 0) {
                        p.sendMessage(Config.WARNING_PREFIX + Config.WARNING_USE);
                    } else {
                        if(Bukkit.getPlayer(args[0]) == null) {
                            p.sendMessage(Config.WARNING_PREFIX + Config.WARNING_NOT_ONLINE);
                            return true;
                        }
                        Bukkit.getPlayer(args[0]).sendTitle(Config.WARNING_TITLE, Config.WARNING_SUBTITLE, 20, 50, 20);
                        p.sendMessage(Config.WARNING_PREFIX + Config.WARNING_MESSAGE.replace("<player>", args[0]));
                        Bukkit.getPlayer(args[0]).sendMessage(Config.WARNING_PREFIX + Config.WARNING_MESSAGE_PLAYER.replace("<player>", args[0]));
                    }
                } else {
                    p.sendMessage(Config.NOPERMS);
                }
            }
        }
        return false;
    }
}
