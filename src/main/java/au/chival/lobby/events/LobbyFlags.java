package au.chival.lobby.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class LobbyFlags implements Listener {

    @EventHandler(priority = EventPriority.LOWEST)
    public void onBlockBreak(BlockBreakEvent event) {
        event.setCancelled(true);
        if (event.getPlayer().hasPermission("chival.lobby.build")) {
            event.setCancelled(false);
        }
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onBlockPlace(BlockPlaceEvent event) {
        event.setCancelled(true);
        if (event.getPlayer().hasPermission("chival.lobby.build")) {
            event.setCancelled(false);
        }
    }

    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onHunger(FoodLevelChangeEvent event) {
        event.setCancelled(true);
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onInventoryMove(InventoryClickEvent event) {
        event.setCancelled(true);
        if (event.getWhoClicked().hasPermission("chival.lobby.build")) {
            event.setCancelled(false);
        }
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent event) {
        event.setCancelled(true);
        if (event.getPlayer().hasPermission("chival.lobby.build")) {
            event.setCancelled(false);
        }
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getAction().equals(Action.PHYSICAL)) {
            if (event.getClickedBlock().getTypeId() == 60) {
                event.setCancelled(true);
            }
        }
    }
}
