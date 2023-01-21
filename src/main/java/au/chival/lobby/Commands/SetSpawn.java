package au.chival.lobby.Commands;

import au.chival.lobby.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.WorldCreator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawn extends CommandBase {
    public SetSpawn() {
        super("tptohub1", false, "chival.lobby.setspawn");
    }

    @Override
    public void execute(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;
        Bukkit.createWorld(new WorldCreator("Hub1"));
        player.teleport(new Location(Bukkit.getWorld("Hub1"), -2000, 250, -500));

    }
}
