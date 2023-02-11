package au.chival.lobby.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Collections;

import static au.chival.lobby.util.InventoryLib.makeItem;
import static au.chival.lobby.Main.spawn;

public class JoinEvent implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {

        ItemStack serverSelector = makeItem(Material.COMPASS, ChatColor.DARK_AQUA + "Server Selector", Collections.EMPTY_LIST, 1);

        event.getPlayer().getInventory().clear();

        event.getPlayer().getInventory().setItem(0, serverSelector);

        event.getPlayer().teleport(spawn);
    }
}
