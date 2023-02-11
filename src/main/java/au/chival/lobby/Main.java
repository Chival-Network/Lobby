package au.chival.lobby;

import au.chival.lobby.adminBoard.AdminBoardReg;
import au.chival.lobby.commands.SetSpawn;
import au.chival.lobby.commands.SpawnCommand;
import au.chival.lobby.cosmetics.CosmeticsReg;
import au.chival.lobby.events.JoinEvent;
import au.chival.lobby.events.JoinItems;
import au.chival.lobby.events.LobbyFlags;
import au.chival.lobby.profile.ProfileReg;
import au.chival.lobby.util.CheakOnlineServer;
import au.chival.lobby.serverSelector.ServerSelectorReg;
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

        this.getServer().getMessenger().registerOutgoingPluginChannel(plugin, "BungeeCord");

        this.saveDefaultConfig();

        if (getConfig().get("spawn") == null) {
            getConfig().set("spawn", new Location(Bukkit.getWorld("world"), 0, 64, 0, 0, 0));
        }

        spawn = (Location) getConfig().get("spawn");


        //reg
        new CheakOnlineServer();
        new ProfileReg();
        new CosmeticsReg();
        new SetSpawn();
        new AdminBoardReg();
        new ServerSelectorReg();

        //reg-cmd
        new SpawnCommand();

        //event
        getServer().getPluginManager().registerEvents(new JoinEvent(), plugin);
        getServer().getPluginManager().registerEvents(new LobbyFlags(), plugin);
        getServer().getPluginManager().registerEvents(new JoinItems(), plugin);

    }

    @Override
    public void onDisable() {
        getConfig().set("spawn", spawn);
        this.saveConfig();
    }
}
