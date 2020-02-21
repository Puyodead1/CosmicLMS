package me.puyodead1.cosmiclms.Commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.CommandHelp;
import co.aikar.commands.annotation.*;
import me.puyodead1.cosmiclms.Arena;
import me.puyodead1.cosmiclms.CosmicLMSUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandAlias("lmsadmin|lastmanstandingadmin|lmsa|lastmanstandinga")
@CommandPermission("cosmiclms.admin")
public class AdminCommands extends BaseCommand {

    @Subcommand("createarena")
    @Syntax("<arena name>")
    public static void onCreateArena(Player player, String[] args) {
        if (args.length == 0) {
            CosmicLMSUtils.sendPlayer(player, "&cNo arena name specified!");
        } else if (args.length == 1) {
            final String arenaName = args[0].toLowerCase();
            final Arena arena = new Arena(arenaName);
            CosmicLMSUtils.sendPlayer(player, "&aArena created! Set the center point and the bounds with setcenter and setbound.");
        }
    }

    @Subcommand("checklist")
    @Description("Checklist for arena setup")
    @Syntax("<arena name>")
    public void onChecklist(Player player, String[] args) {
        if (args.length == 0) {
            CosmicLMSUtils.sendPlayer(player, "&cNo arena name specified!");
        } else if(args.length == 1) {
            final String arenaName = args[0].toLowerCase();
            final Arena arena = new Arena(arenaName);
            String message = "&6Checklist for Arena: &e" + arena.getArenaName() + "\n";

            if (arena.hasCenter()) {
                message += "  &6- Center: &aSet\n";
            } else {
                message += "  &6- Center: &cNot Set\n";
            }

            message += "  &6- Bounds: &7(&6Min: " + (arena.hasMin() ? "&aSet&7)" : "&cNot Set&7)") + "&7(&6Max: " + (arena.hasMax() ? "&aSet&7)" : "&cNot Set&7)\n");

            CosmicLMSUtils.sendPlayer(player, message);
        }
    }

    @Subcommand("setcenter")
    @Syntax("<arena name>")
    @Description("Sets the specified arena center to your location")
    public static void onSetCenter(Player player, String[] args) {
        if (args.length == 0) {
            CosmicLMSUtils.sendPlayer(player, "&cNo arena name specified!");
        } else if (args.length == 1) {
            final String arenaName = args[0].toLowerCase();
            if (Arena.getArenas().containsKey(arenaName)) {
                // Arena exists
                final Arena arena = Arena.getArenas().get(arenaName);
                arena.setArenaCenter(player.getLocation());
                CosmicLMSUtils.sendPlayer(player, "&aCenter location for arena &e" + arena.getArenaName() + " &awas set to your location!");
            } else {
                // Arena is invalid and does not exist
                CosmicLMSUtils.sendPlayer(player, "&cThat Arena does not exist, check the name and try again!");
            }
        }
    }

    @HelpCommand
    public static void onHelp(CommandSender sender, CommandHelp help) {
        help.showHelp();
    }
}
