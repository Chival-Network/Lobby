package au.chival.lobby.profile;

import au.chival.lobby.util.CommandBase;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ProfileCommand extends CommandBase {
    public ProfileCommand(String name) {
        super(name, false, null);
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
