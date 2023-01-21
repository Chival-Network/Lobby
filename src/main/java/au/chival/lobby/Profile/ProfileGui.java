package au.chival.lobby.Profile;

import net.luckperms.api.LuckPermsProvider;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import static au.chival.lobby.InventoryLib.makeItem;

public class ProfileGui implements Listener {

    public ProfileGui() {}

    public static String title;

    public ProfileGui(Player player) {
        title = ChatColor.GREEN + player.getName() + ChatColor.AQUA + "'s profile";
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

        player.openInventory(inventory);
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (event.getClickedInventory().getTitle() == title) {
            event.setCancelled(true);
            //
            switch (event.getSlot()) {
                case 8:
                    event.getWhoClicked().closeInventory();
                    return;
                case 13:
                    event.getWhoClicked().closeInventory();
                    event.setCancelled(true);
                    ((Player) event.getWhoClicked()).chat("/c");
                    return;
                default:
                    return;
            }
            //
        }
    }
}