package au.chival.lobby;

import au.chival.lobby.Profile.Profile;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public static JavaPlugin plugin;
    public static World lobby;

    @Override
    public void onEnable() {
        plugin = this;

        //reg
        new Profile();

        //new Cosmetic();

    }

    @Override
    public void onDisable() {
    }
}
