package au.chival.lobby.Cosmetics.GUI;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public class ClickEventGUI implements Listener {

    private GUI menu;
    public ClickEventGUI() {
        menu = new GUI();
    }
    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (!event.getInventory().equals(menu.getInventory()))
            return;

        if (event.getCurrentItem() == null) return;
        if (event.getCurrentItem().getItemMeta() == null) return;
        if (event.getCurrentItem().getItemMeta().getDisplayName() == null) return;

        event.setCancelled(true);

        Player player = (Player) event.getWhoClicked();

        if (event.getSlot() == 3) {
            //particle
        }

        if (event.getSlot() == 8) {
            player.closeInventory();
        }


        if (event.getView().getType() == InventoryType.PLAYER)
            return;




        ParticleData particle = new ParticleData(player.getUniqueId());

        if (particle.hasID()) {
            particle.endTask();
            particle.removeID();

        }

    }
}