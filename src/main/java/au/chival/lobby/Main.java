package au.chival.lobby;

import au.chival.lobby.Cosmetics.GUI.ClickEventGUI;
import au.chival.lobby.Cosmetics.GUI.Cosmetic;
import au.chival.lobby.Cosmetics.GUI.GUI;
import au.chival.lobby.Cosmetics.Ride.RideListener;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public static Plugin plugin;
    public static World lobby;

    @Override
    public void onEnable() {
        GUI menu = new GUI();
        menu.register();
       // PluginManager pm = this.getServer().getPluginManager();
       // this.getCommand("cosmetic").setExecutor(new Cosmetic());

        plugin = this;
        reg();

        lobby = Bukkit.getWorld("world");
    }

    public void reg() {

        this.getCommand("cosmetic").setExecutor(new Cosmetic());

        Bukkit.getPluginManager().registerEvents(new ClickEventGUI(), this);
        Bukkit.getPluginManager().registerEvents(new RideListener(),this);

    }

    @Override
    public void onDisable() {
    }
}
