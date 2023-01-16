package au.chival.lobby.Cosmetics.Ride;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import static au.chival.lobby.Main.lobby;

public class RideListener implements Listener {

    @EventHandler
    public void onEntityClick(PlayerInteractEntityEvent event) {

        if (event.getPlayer().getWorld() != lobby) {
            return;
        }

        if (event.getPlayer().getItemInHand().getType() == Material.LEASH) {
            event.getRightClicked().setPassenger(event.getPlayer());
        }
    }
}