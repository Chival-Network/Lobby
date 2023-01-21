package au.chival.lobby.Cosmetics.GUI;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class Cosmetic implements CommandExecutor {



    public static HashMap<UUID, String> Trail = new HashMap<>();

    public boolean onCommand(CommandSender sender, Command command, String c, String[] args) {


            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.RED + "You Cannot Do This!");
                return true;
            }
            Player player = (Player) sender;
            GUI menu = new GUI();
            menu.register();
            menu.openInventory(player);

            return true;
    }
}



