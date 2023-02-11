package au.chival.lobby.commands;

import au.chival.lobby.util.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.List;

import static au.chival.lobby.Main.spawn;

public class SpawnCommand extends CommandBase {

    public SpawnCommand() {
        super("spawn", false, null);
    }

    @Override
    public void execute(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        if (args.length == 0) {
            player.teleport(spawn);
            player.sendMessage(tl("spawn-command.success"));
            return;
        }

        Player target = Bukkit.getPlayer(args[0]);

        if (!player.hasPermission("chival.lobby.spawn-other")) {
            player.sendMessage(tl("no-permission"));
        }

        if (target != null) {
            target.teleport(spawn);
            target.sendMessage(tl("spawn-command.success"));
            player.sendMessage(tl("spawn-command.success.other"));
        }
    }

    @Override
    public List<String> tabComplete(CommandSender sender, Command command, String[] args) {

        if (args.length == 1) {
            return null;
        }

        return Collections.EMPTY_LIST;
    }
}
