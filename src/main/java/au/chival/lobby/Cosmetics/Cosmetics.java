package au.chival.lobby.Cosmetics;

import au.chival.lobby.Cosmetics.GUI.ClickEventGUI;
import au.chival.lobby.Cosmetics.GUI.Cosmetic;
import au.chival.lobby.Cosmetics.GUI.GUI;
import au.chival.lobby.Cosmetics.Ride.RideListener;
import au.chival.lobby.Cosmetics.onJoin.onJoinEvent;

import static au.chival.lobby.Main.plugin;

public class Cosmetics {

    public Cosmetics() {

        GUI menu = new GUI();
        menu.register();

        //cmd
        plugin.getCommand("cosmetics").setExecutor(new Cosmetic());
        //listener
        plugin.getServer().getPluginManager().registerEvents(new onJoinEvent(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new ClickEventGUI(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new RideListener(),plugin);
    }
}
