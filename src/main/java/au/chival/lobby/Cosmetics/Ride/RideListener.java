package au.chival.lobby.Cosmetics.Ride;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class RideListener implements Listener {

    @EventHandler
    public void onEntityClick(PlayerInteractEntityEvent event) {
        event.getPlayer().sendMessage("This IS the Ride Listener");
        if (event.getPlayer().getItemInHand().getType() == Material.LEASH) {
            event.getRightClicked().setPassenger(event.getPlayer());
        }

    }
}