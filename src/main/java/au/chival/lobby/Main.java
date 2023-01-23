package au.chival.lobby;

import au.chival.lobby.adminBoard.AdminBoardReg;
import au.chival.lobby.commands.SetSpawn;
import au.chival.lobby.cosmetics.CosmeticsReg;
import au.chival.lobby.events.JoinEvent;
import au.chival.lobby.events.LobbyFlags;
import au.chival.lobby.profile.ProfileReg;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public static JavaPlugin plugin;
    public static World lobby;
    public static Location spawn;

    @Override
    public void onEnable() {
        plugin = this;

        this.saveDefaultConfig();

        spawn = null;
        SetSpawn.loadSpawnLocation();

        //reg
        new ProfileReg();
        new CosmeticsReg();
        new SetSpawn();
        new AdminBoardReg();
        //event
        getServer().getPluginManager().registerEvents(new JoinEvent(), plugin);
        getServer().getPluginManager().registerEvents(new LobbyFlags(), plugin);

    }

    @Override
    public void onDisable() {
    }
}
