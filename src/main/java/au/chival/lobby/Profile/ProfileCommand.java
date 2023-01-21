package au.chival.lobby.Profile;

import au.chival.lobby.CommandBase;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ProfileCommand extends CommandBase {
    public ProfileCommand(String name) {
        super(name, false, "chival.lobby.profile");
    }

    @Override
    public void execute(CommandSender sender, Command command, String label, String[] args) {
        if (args.length > 0) {
            sender.sendMessage(tl("invalid-args"));
            return;
        }

        Player player = (Player) sender;

        new ProfileGui(player);
    }
}
