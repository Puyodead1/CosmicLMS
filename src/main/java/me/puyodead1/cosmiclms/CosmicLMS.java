package me.puyodead1.cosmiclms;

import co.aikar.commands.BukkitCommandManager;
import me.puyodead1.cosmiclms.Commands.AdminCommands;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class CosmicLMS extends JavaPlugin {

    public static CosmicLMS plugin;

    private final String PREFIX = "&7[&dCosmicLMS&7] ";

    @Override
    public void onEnable() {
        plugin = this;

        CosmicLMSUtils.sendConsole(PREFIX + "&b=============================================================");

        // Ensure worldedit is installed
        if(!Bukkit.getPluginManager().getPlugin("WorldEdit").isEnabled()) {
            CosmicLMSUtils.sendConsole("&cEssentials not enabled or not installed! Plugin will be disabled!");
            Bukkit.getPluginManager().disablePlugin(this);
        }

        initConfig();
        initEvents();
        initCommands();

        CosmicLMSUtils.sendConsole(PREFIX + "&d========================");
        CosmicLMSUtils.sendConsole(PREFIX + "&bAuthor: &ePuyodead1");
        CosmicLMSUtils.sendConsole(PREFIX + "&b" + getDescription().getName() + " Version: &e" +getDescription().getVersion());
        CosmicLMSUtils.sendConsole(PREFIX + "&bWorldEdit Version: &e" + getServer().getPluginManager().getPlugin("WorldEdit").getDescription().getVersion());
        CosmicLMSUtils.sendConsole(PREFIX + "&bMinecraft Version: &e" + getServer().getVersion());
        CosmicLMSUtils.sendConsole(PREFIX + "&b=============================================================");
    }

    @Override
    public void onDisable() {
        plugin = null;
    }

    public void initConfig() {
        final long STARTED = System.currentTimeMillis();

        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        CosmicLMSUtils.sendConsole(PREFIX + "&bLoaded Configuration &e(took " + (System.currentTimeMillis() - STARTED) + "ms)");
    }

    public void initEvents() {
        final long STARTED = System.currentTimeMillis();
        final PluginManager pm = Bukkit.getPluginManager();

        CosmicLMSUtils.sendConsole(PREFIX + "&bLoaded Events &e(took " + (System.currentTimeMillis() - STARTED) + "ms)");
    }

    public void initCommands() {
        final long STARTED = System.currentTimeMillis();

        BukkitCommandManager commandManager = new BukkitCommandManager(this);
        commandManager.registerCommand(new AdminCommands());

        CosmicLMSUtils.sendConsole(PREFIX + "&bLoaded Commands &e(took " + (System.currentTimeMillis() - STARTED) + "ms)");
    }
}
