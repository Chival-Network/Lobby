package au.chival.lobby.Cosmetics;

import au.chival.lobby.Cosmetics.GUI.ClickEventGUI;
import au.chival.lobby.Cosmetics.GUI.Cosmetic;
import au.chival.lobby.Cosmetics.Ride.RideListener;
import au.chival.lobby.Cosmetics.onJoin.onJoinEvent;
import org.bukkit.Bukkit;

import static au.chival.lobby.Main.plugin;

public class CosmeticsReg {
    public CosmeticsReg() {
        plugin.getCommand("cosmetic").setExecutor(new Cosmetic());
        Bukkit.getPluginManager().registerEvents(new ClickEventGUI(), plugin);
        Bukkit.getPluginManager().registerEvents(new onJoinEvent(), plugin);
        Bukkit.getPluginManager().registerEvents(new RideListener(),plugin);
    }
}
