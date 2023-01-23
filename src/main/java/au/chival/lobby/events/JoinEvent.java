package au.chival.lobby.events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import static au.chival.lobby.Main.spawn;

public class JoinEvent implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.getPlayer().teleport(new Location(Bukkit.getWorld("Hub2"), -2492.5, 108, -534.5, -90, 0));
    }
}
