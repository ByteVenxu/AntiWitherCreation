package de.noahtrx.antiwithercreation;

import de.noahtrx.antiwithercreation.commands.AntiWitherCommand;
import de.noahtrx.antiwithercreation.listener.CreatureSpawnEventListener;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class AntiWitherCreation extends JavaPlugin {
    private static AntiWitherCreation instance;
    private File configFile;
    private FileConfiguration config;
    private static boolean isEnabled;

    public static void setIsEnabled(boolean value) {
        isEnabled = value;
    }
    public static AntiWitherCreation getInstance() {
        return AntiWitherCreation.instance;
    }

    @Override
    public void onEnable() {
        AntiWitherCreation.instance = this;
        try {
            loadConfig();

            this.getCommand("antiwither").setExecutor(new AntiWitherCommand());

            loadListener(Bukkit.getPluginManager());

            Bukkit.getConsoleSender().sendMessage("§8§m----------------------------------------------");
            Bukkit.getConsoleSender().sendMessage(" ");
            Bukkit.getConsoleSender().sendMessage("§6§lWeb: §chttps://noahtrx.de/discord ");
            Bukkit.getConsoleSender().sendMessage("§7Version: §8'§c1.1§8'");
            Bukkit.getConsoleSender().sendMessage("§cPlugin was coded by noahtrx");
            Bukkit.getConsoleSender().sendMessage(" ");
            Bukkit.getConsoleSender().sendMessage("§a§lAntiWitherCreation §ahas been activated");
            Bukkit.getConsoleSender().sendMessage(" ");
            Bukkit.getConsoleSender().sendMessage("§8§m----------------------------------------------");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void loadConfig() {
        configFile = new File(getDataFolder(), "config.yml");
        config = getConfig();
        if (!configFile.exists()) {
            saveDefaultConfig();
        }
        reloadConfig();
    }

    private void loadListener(final PluginManager pluginManager) {
        pluginManager.registerEvents((Listener) new CreatureSpawnEventListener(), (Plugin) this);
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("§8§m----------------------------------------------");
        Bukkit.getConsoleSender().sendMessage(" ");
        Bukkit.getConsoleSender().sendMessage("§6§lDiscord: §chttps://noahtrx.de/discord ");
        Bukkit.getConsoleSender().sendMessage("§7Version: §8'§c1.1§8'");
        Bukkit.getConsoleSender().sendMessage("§cPlugin was coded by noahtrx");
        Bukkit.getConsoleSender().sendMessage(" ");
        Bukkit.getConsoleSender().sendMessage("§a§lAntiWitherCreation §ahas been §cdeactivated");
        Bukkit.getConsoleSender().sendMessage(" ");
        Bukkit.getConsoleSender().sendMessage("§8§m----------------------------------------------");
    }
}
