package au.chival.lobby;

import au.chival.lobby.Commands.SetSpawn;
import au.chival.lobby.Cosmetics.CosmeticsReg;
import au.chival.lobby.Events.JoinEvent;
import au.chival.lobby.Profile.ProfileReg;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public static JavaPlugin plugin;
    public static World lobby;

    @Override
    public void onEnable() {
        plugin = this;

        //reg
        new ProfileReg();
        new CosmeticsReg();
        new SetSpawn();
        //event
        getServer().getPluginManager().registerEvents(new JoinEvent(), plugin);

    }

    @Override
    public void onDisable() {
    }
}
