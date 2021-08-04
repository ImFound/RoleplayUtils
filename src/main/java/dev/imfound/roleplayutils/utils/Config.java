package dev.imfound.roleplayutils.utils;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.sun.security.jgss.InquireSecContextPermission;
import dev.imfound.roleplayutils.RoleplayUtils;
import org.bukkit.ChatColor;

import javax.management.relation.Role;

public class Config {

    public static String getString(String s) {
        return ChatColor.translateAlternateColorCodes('&', RoleplayUtils.getInstance().getConfig().getString(s));
    }

    public static Integer getInt(String s) {
        return RoleplayUtils.getInstance().getConfig().getInt(s);
    }

    public static Boolean getBoolean(String s) {
        return RoleplayUtils.getInstance().getConfig().getBoolean(s);
    }

    //MESSAGES
    public static String DEATHLOGGER_MESSAGE = getString(".PvP.deathlogger.message");
    public static String BROADCAST_MESSAGE = getString(".Broadcasts.broadcast");
    public static String WARNING_PREFIX = getString(".Warning.prefix");
    public static String WARNING_MESSAGE = getString(".Warning.message");
    public static String WARNING_MESSAGE_PLAYER = getString(".Warning.message-player");
    // TITLES
    public static String WARNING_TITLE = getString(".Warning.title");
    public static String WARNING_SUBTITLE = getString(".Warning.title-subtitle");
    //COMMANDS
    public static String BROADCAST_COMMAND = getString(".Broadcasts.command");
    public static String WARNING_COMMAND = getString(".Warning.command");
    //PERMISSSIONS
    public static String DEATHLOGGER_PERMISSION = getString(".PvP.deathlogger.permission");
    public static String BROADCAST_PERMISSION = getString(".Broadcasts.permission");
    public static String WARNING_PERMISSION = getString(".Warning.permission");
    //COOLDOWNS
    public static Boolean BROADCAST_COOLDOWN_BOOL = getBoolean(".Broadcasts.cooldown.enabled");
    public static Integer BROADCAST_COOLDOWN = getInt(".Broadcasts.cooldown.delay-in-seconds");
    public static String BROADCAST_COOLDOWN_MESSAGE = getString(".Broadcasts.cooldown.message");
    //PVP
    public static Boolean PLUGINS_PVP = getBoolean(".PvP.only-plugins-pvp");
    public static Boolean VANILLA_PVP = getBoolean(".PvP.vanilla-pvp");
    //BOOLEANS
    public static Boolean DEATHLOGGER_ENABLED = getBoolean(".PvP.deathlogger.enabled");
    public static Boolean DEATHLOGGER_CONSOLE_LOG = getBoolean(".PvP.log-in-console");
    //BROADCAST
    public static String BROADCAST_USE = getString(".Broadcasts.use");
    //GENERAL
    public static String NOPERMS = getString(".noperms");
    //WARNING
    public static String WARNING_USE = getString(".Warning.use");
    public static String WARNING_NOT_ONLINE = getString(".Warning.not-online");
}
