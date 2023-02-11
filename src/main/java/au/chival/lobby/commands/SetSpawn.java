package au.chival.lobby.commands;

import au.chival.lobby.util.CommandBase;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.List;

import static au.chival.lobby.Main.spawn;

public class SetSpawn extends CommandBase {

    public SetSpawn() {
        super("setspawn", false, "chival.lobby.setspawn");
    }

    @Override
    public void execute(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;

        if (args.length == 0) {

            spawn = player.getLocation();

            sender.sendMessage(ChatColor.GREEN + "Set Spawn");

            player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
        }

    }

    @Override
    public List<String> tabComplete(CommandSender sender, Command command, String[] args) {
        return Collections.EMPTY_LIST;
    }
}
