package au.chival.lobby.cosmetics.GUI;

import au.chival.lobby.cosmetics.Trails.Blood;
import au.chival.lobby.cosmetics.Trails.Snow;
import au.chival.lobby.cosmetics.Trails.Hearts;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;

import static au.chival.lobby.cosmetics.Trails.Manager.stopAll;

public class ClickEventGUI implements Listener {

    private GUI menu;
    private Hearts hearts = new Hearts();
    private Snow crit = new Snow();

    private Blood blood = new Blood();


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

        if (event.getSlot() == 22) {
            stopAll(((Player) event.getWhoClicked()).getPlayer());
        }

        if (event.getSlot() == 1) {
            crit.startSnow(player);
        }

        if (event.getSlot() == 2) {
            blood.startBlood(player);
        }

        if (event.getSlot() == 0) {
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

