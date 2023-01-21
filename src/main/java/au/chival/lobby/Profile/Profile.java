package au.chival.lobby.Profile;

import static au.chival.lobby.Main.plugin;

public class Profile {
    public Profile() {
        new ProfileCommand("profile");
        plugin.getServer().getPluginManager().registerEvents(new ProfileGui(), plugin);
    }
}
