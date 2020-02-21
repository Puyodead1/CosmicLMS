package me.puyodead1.cosmiclms;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CosmicLMSUtils {

    public static String Colorize(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    public static void sendConsole(String msg) {
        Bukkit.getConsoleSender().sendMessage(Colorize(msg));
    }

    public static void sendPlayer(Player player, String msg) {
        player.sendMessage(Colorize(msg));
    }

    public static void sendSender(CommandSender sender, String msg) { sender.sendMessage(Colorize(msg)); }
}
