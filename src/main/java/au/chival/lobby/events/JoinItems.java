package au.chival.lobby.events;

import au.chival.lobby.serverSelector.ServerSelectorGUI;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Objects;

public class JoinItems implements Listener {
    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if (event.getItem() != null) {
            if (Objects.equals(event.getItem().getItemMeta().getDisplayName(), ChatColor.DARK_AQUA + "Server Selector")) {
                new ServerSelectorGUI(event.getPlayer());
            }
        }
    }
}
