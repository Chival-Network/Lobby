package au.chival.lobby.adminBoard;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.LinkedList;
import java.util.List;

import static au.chival.lobby.InventoryLib.makeItem;

public class AdminBoardGUI implements Listener {

    public AdminBoardGUI() {}

    static String title;

    public AdminBoardGUI(Player player) {
        title = ChatColor.AQUA + "Admin Board";
        Inventory inventory = Bukkit.createInventory(player, 45, title);
        List<String> loreholder = new LinkedList<>();
        ItemStack filler = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
        for (int i = 0; i < 45; i++) {inventory.setItem(i, filler);}

        // Exit
        loreholder.add(ChatColor.RED + "Close this menu");
        inventory.setItem(8 , makeItem(Material.BARRIER, ChatColor.RED + "Exit", loreholder, 1));
        loreholder.clear();
        //

        player.openInventory(inventory);
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {

        if (event.getClickedInventory() == null) {return;}

        if (event.getClickedInventory().getTitle() == title) {

            event.setCancelled(true);

            switch (event.getSlot()) {
                case 8:
                    event.getWhoClicked().closeInventory();
                    return;
                default:
                    return;
            }

        }
    }
}
