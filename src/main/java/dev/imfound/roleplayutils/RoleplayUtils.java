package dev.imfound.roleplayutils;

import dev.imfound.roleplayutils.commands.Broadcast2Command;
import dev.imfound.roleplayutils.commands.WarningCommand;
import dev.imfound.roleplayutils.events.CreditsEvent;
import dev.imfound.roleplayutils.events.DamageEvent;
import dev.imfound.roleplayutils.events.DeathLoggerEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class RoleplayUtils extends JavaPlugin {

    static RoleplayUtils inst;

    @Override
    public void onEnable() {
        inst = this;
        long start = System.currentTimeMillis();
        System.out.println("  ROLEPLAYUTILS  ");
        System.out.println("");
        System.out.println("Loading config..");
        loadConfig();
        System.out.println("Config loaded!");
        System.out.println("Registering commands..");
        registerCommands();
        System.out.println("Commands registered!");
        System.out.println("Loading events..");
        loadEvents();
        System.out.println("Events loaded!");
        long finish = System.currentTimeMillis();
        long calc = finish - start;
        System.out.println("Plugin started in " + calc + "ms!");
        System.out.println("");
        System.out.println("  ROLEPLAYUTILS  ");
    }

    public void loadEvents() {
        getServer().getPluginManager().registerEvents(new CreditsEvent(), this);
        getServer().getPluginManager().registerEvents(new DeathLoggerEvent(), this);
        getServer().getPluginManager().registerEvents(new DamageEvent(), this);
    }

    public void registerCommands() {
        new Broadcast2Command();
        new WarningCommand();
    }


    public void loadConfig() {
        this.getConfig().options().copyDefaults(true);
        this.saveConfig();
        this.reloadConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static RoleplayUtils getInstance() {
        return inst;
    }
}
