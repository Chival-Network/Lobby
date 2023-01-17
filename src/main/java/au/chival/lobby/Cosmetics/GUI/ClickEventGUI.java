package au.chival.lobby.Cosmetics.GUI;

import au.chival.lobby.Cosmetics.Trails.Crit;
import au.chival.lobby.Cosmetics.Trails.Hearts;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;

import static au.chival.lobby.Cosmetics.Trails.Manager.stopAll;

public class ClickEventGUI implements Listener {

    private GUI menu;
    private Hearts hearts = new Hearts();
    private Crit crit = new Crit();


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

        if (event.getSlot() == 0) {
            stopAll(((Player) event.getWhoClicked()).getPlayer());
        }

        if (event.getSlot() == 1) {
            crit.startCrit(player);
        }

        if (event.getSlot() == 3) {
            //Trail.put(event.getWhoClicked().getUniqueId(), "Heart");
            hearts.startHearts(player);



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

