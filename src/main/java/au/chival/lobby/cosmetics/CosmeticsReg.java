package au.chival.lobby.cosmetics;

import au.chival.lobby.cosmetics.GUI.ClickEventGUI;
import au.chival.lobby.cosmetics.GUI.Cosmetic;
import au.chival.lobby.cosmetics.Ride.RideListener;
import au.chival.lobby.cosmetics.onJoin.onJoinEvent;
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
