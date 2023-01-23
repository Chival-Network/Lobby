package au.chival.lobby.profile;

import au.chival.lobby.adminBoard.AdminBoardGUI;
import net.luckperms.api.LuckPermsProvider;
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

public class ProfileGui implements Listener {

    public ProfileGui() {}

    static String title;

    public ProfileGui(Player player) {
        title = (ChatColor.GREEN + player.getName() + ChatColor.AQUA + "'s profile");
        Inventory inventory = Bukkit.createInventory(player, 45, title);
        List<String> loreholder = new LinkedList<>();
        ItemStack filler = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
        for (int i = 0; i < 45; i++) {inventory.setItem(i, filler);}

        // Exit
        loreholder.add(ChatColor.RED + "Close this menu");
        inventory.setItem(8 , makeItem(Material.BARRIER, ChatColor.RED + "Exit", loreholder, 1));
        loreholder.clear();
        //

        // Info
        loreholder.add(ChatColor.AQUA + "Rank: " + ChatColor.GREEN + LuckPermsProvider.get().getUserManager().getUser(player.getUniqueId()).getPrimaryGroup());
        loreholder.add(ChatColor.AQUA + "Prefix: " + LuckPermsProvider.get().getUserManager().getUser(player.getUniqueId()).getCachedData().getMetaData().getPrefix());
        loreholder.add(ChatColor.AQUA + "Suffix: " + LuckPermsProvider.get().getUserManager().getUser(player.getUniqueId()).getCachedData().getMetaData().getSuffix());
        inventory.setItem(10 , makeItem(Material.SKULL_ITEM, ChatColor.AQUA + "Info", loreholder, 1, player.getName()));
        loreholder.clear();
        //

        // Cosmetics
        loreholder.add(ChatColor.AQUA + "Opens cosmetic menu");
        inventory.setItem(13 , makeItem(Material.RED_ROSE, ChatColor.AQUA + "Cosmetics", loreholder, 1));
        loreholder.clear();
        //

        // AdminBoard
        if (player.hasPermission("chival.lobby.adminboard")) {
            inventory.setItem(7, makeItem(Material.REDSTONE, ChatColor.AQUA + "Admin Board", loreholder, 1));
            loreholder.clear();
        }
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
                case 7:
                    event.getWhoClicked().closeInventory();
                    new AdminBoardGUI((Player) event.getWhoClicked());
                    return;
                case 13:
                    event.getWhoClicked().closeInventory();
                    event.setCancelled(true);
                    ((Player) event.getWhoClicked()).chat("/c");
                    return;
                default:
                    return;
            }

        }
    }
}