package au.chival.lobby.Cosmetics.onJoin;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.LinkedList;

import static au.chival.lobby.Cosmetics.Trails.Manager.currentParticles;

public class onJoinEvent implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        currentParticles.put(event.getPlayer(), new LinkedList<>());
    }
}
