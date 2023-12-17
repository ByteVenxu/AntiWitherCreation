package de.noahtrx.antiwithercreation.commands;

import de.noahtrx.antiwithercreation.AntiWitherCreation;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class AntiWitherCommand implements CommandExecutor {
    public static boolean isEnabled;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        // Überprüfe, ob die Hauptklasse eine Instanz von AntiWitherCreation ist
        if (AntiWitherCreation.getInstance() != null) {
            FileConfiguration config = AntiWitherCreation.getInstance().getConfig();
            if (args.length == 0) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("messages.info")));
                player.sendTitle(
                        ChatColor.translateAlternateColorCodes('&', config.getString("titles.main.title")),
                        ChatColor.translateAlternateColorCodes('&', config.getString("titles.main.subtitle"))
                );
                return true;
            } else if (args[0].equalsIgnoreCase("enable")) {
                if (sender.hasPermission("antiwithercreation.enable")) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("messages.enable")));
                    AntiWitherCreation.setIsEnabled(true);
                } else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("messages.info")));
                    player.sendTitle(
                            ChatColor.translateAlternateColorCodes('&', config.getString("titles.main.title")),
                            ChatColor.translateAlternateColorCodes('&', config.getString("titles.main.subtitle"))
                    );
                }
            } else if (args[0].equalsIgnoreCase("disable")) {
                if (sender.hasPermission("antiwithercreation.disable")) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("messages.disable")));
                    AntiWitherCreation.setIsEnabled(false);
                } else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("messages.info")));
                    player.sendTitle(
                            ChatColor.translateAlternateColorCodes('&', config.getString("titles.main.title")),
                            ChatColor.translateAlternateColorCodes('&', config.getString("titles.main.subtitle"))
                    );
                }
            }
        }
        return true;
    }
}
