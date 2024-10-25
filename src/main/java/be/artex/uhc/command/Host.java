package be.artex.uhc.command;

import be.artex.uhc.utils.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class Host implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player))
            return false;

        Player player = (Player) sender;

        if (!(player.hasPermission("artuhc.host")))
            return false;

        if (args.length == 0) {
            help(player);
            return true;
        }

        switch (args[0].toLowerCase()) {
            case "config":
                // todo: make the config gui
                break;
            case "say":
                say(args, player.getName());
                break;

            default:
                help(player);
                break;
        }

        return true;
    }

    private static void say(String[] args, String playerName) {
        args[0] = "";

        String message = Arrays.toString(args).replace("[", "").replace("]", "").replace(",", "");

        Bukkit.broadcastMessage("\n + " + ChatColor.GOLD + "" + ChatColor.BOLD + "HOST " + playerName + ChatColor.GRAY + " :" + ChatColor.WHITE + message + "\n ");
    }

    private static void help(Player player) {
        player.sendMessage(StringUtils.line + "\n" +
                StringUtils.dot + ChatColor.GOLD + "help" + ChatColor.GRAY + "   : " + ChatColor.RESET + " Montre la liste de toute les commandes host.\n \n" +
                StringUtils.dot + ChatColor.GOLD + "say" + ChatColor.GRAY + "    : " + ChatColor.RESET + " Envoie un message host.\n \n" +
                StringUtils.dot + ChatColor.GOLD + "config" + ChatColor.GRAY + " : " + ChatColor.RESET + " Ouvre le menu pour configurer la partie.\n" +
                StringUtils.line);
    }

}
