package au.chival.lobby.Profile;

import static au.chival.lobby.Main.plugin;

public class ProfileReg {
    public ProfileReg() {
        new ProfileCommand("profile");
        plugin.getServer().getPluginManager().registerEvents(new ProfileGui(), plugin);
    }
}
