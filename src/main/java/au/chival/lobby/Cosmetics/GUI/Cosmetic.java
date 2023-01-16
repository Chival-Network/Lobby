package au.chival.lobby.Cosmetics.GUI;

import au.chival.lobby.Cosmetics.GUI.GUI;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Cosmetic implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String c, String[] args) {

            sender.sendMessage("Welcome Player!");

            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.RED + "You Cannot Do This!");
                return true;
            }
            Player player = (Player) sender;
            GUI menu = new GUI();
            menu.openInventory(player);

            return true;
    }
}



