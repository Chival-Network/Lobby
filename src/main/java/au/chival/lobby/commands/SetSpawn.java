package au.chival.lobby.commands;

import au.chival.lobby.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.List;

import static au.chival.lobby.Main.plugin;
import static au.chival.lobby.Main.spawn;

public class SetSpawn extends CommandBase {

    public static void loadSpawnLocation() {

        if (plugin.getConfig().get("spawn.world") == null) {
            System.out.println("world was null");
            return;
        }

        spawn.setX(plugin.getConfig().getInt("spawn.x") + 0.5);
        spawn.setY(plugin.getConfig().getInt("spawn.y"));
        spawn.setZ(plugin.getConfig().getInt("spawn.z") + 0.5);
        spawn.setYaw(plugin.getConfig().getInt("spawn.yaw"));
        spawn.setPitch(plugin.getConfig().getInt("spawn.pitch"));
        spawn.setWorld(Bukkit.getWorld(plugin.getConfig().getString("spawn.world")));
    }

    public SetSpawn() {
        super("setspawn", false, "chival.lobby.setspawn");
    }

    @Override
    public void execute(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;

        if (args.length == 0) {
            int x = (int) (player.getLocation().getX());
            int y = (int) player.getLocation().getY();
            int z = (int) (player.getLocation().getZ());
            int yaw = (int) player.getLocation().getYaw();
            int pitch = (int) player.getLocation().getPitch();
            String world = player.getLocation().getWorld().getName();

            plugin.getConfig().set("spawn.x", x);
            plugin.getConfig().set("spawn.y", y);
            plugin.getConfig().set("spawn.z", z);
            plugin.getConfig().set("spawn.yaw", yaw);
            plugin.getConfig().set("spawn.pitch", pitch);
            plugin.getConfig().set("spawn.world", world);

            plugin.saveConfig();

            loadSpawnLocation();

            player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
        }

    }

    @Override
    public List<String> tabComplete(CommandSender sender, Command command, String[] args) {
        return Collections.EMPTY_LIST;
    }
}
