package me.invertmc.feudal;

import org.bukkit.plugin.java.JavaPlugin;

public final class Feudal extends JavaPlugin {

    @Override
    public void onEnable() {
        // Register command manager
        CommandManager commandManager = new CommandManager(this);
        getCommand("feudal").setExecutor(commandManager);
        getCommand("f").setExecutor(commandManager);
        getCommand("feudal").setTabCompleter(commandManager);
        getCommand("f").setTabCompleter(commandManager);

        getLogger().info("Feudal Has Been Enabled!");


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
