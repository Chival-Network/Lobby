package au.chival.lobby.cosmetics.onJoin;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.LinkedList;

import static au.chival.lobby.cosmetics.Trails.Manager.currentParticles;

public class onJoinEvent implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        currentParticles.put(event.getPlayer(), new LinkedList<>());
    }
}
