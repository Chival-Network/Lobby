package au.chival.lobby.adminBoard;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.LinkedList;
import java.util.List;

import static au.chival.lobby.util.InventoryLib.makeItem;
import static au.chival.lobby.Main.spawn;

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

        // Change Time
        loreholder.add(ChatColor.GREEN + "" + player.getWorld().getTime());
        loreholder.add(ChatColor.AQUA + "Running " + ChatColor.GREEN + player.getWorld().getGameRuleValue("doDaylightCycle"));
        loreholder.add(ChatColor.AQUA + "Shift-Click to toggle");
        inventory.setItem(10 , makeItem(Material.WATCH, ChatColor.AQUA + "Change Time", loreholder, 1));
        loreholder.clear();
        //

        // setSpawm
        loreholder.add(ChatColor.AQUA + "Currently: " + ChatColor.GREEN + spawn.toString());
        inventory.setItem(11 , makeItem(Material.ARMOR_STAND, ChatColor.AQUA + "Set-Spawn", loreholder, 1));
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
                case 10:

                    if (event.getClick() == ClickType.SHIFT_LEFT || event.getClick() == ClickType.SHIFT_RIGHT) {
                        if (event.getWhoClicked().getWorld().getGameRuleValue("doDaylightCycle") == "true") {
                            int time = Math.toIntExact(event.getWhoClicked().getWorld().getTime());
                            time = time / 100;
                            Math.round(time);
                            time = time * 100;
                            event.getWhoClicked().getWorld().setTime(time);
                            event.getWhoClicked().getWorld().setGameRuleValue("doDaylightCycle", String.valueOf(false));
                        } else {
                            event.getWhoClicked().getWorld().setGameRuleValue("doDaylightCycle", String.valueOf(true));
                        }

                    }

                    if (event.getClick() == ClickType.LEFT) {
                        event.getWhoClicked().getWorld().setTime(event.getWhoClicked().getWorld().getTime() - 100);
                    } else {
                        event.getWhoClicked().getWorld().setTime(event.getWhoClicked().getWorld().getTime() + 100);
                    }
                    new AdminBoardGUI((Player) event.getWhoClicked());
                    return;
                case 11:
                    Player player = (Player) event.getWhoClicked();
                    player.chat("/setspawn");
                    new AdminBoardGUI((Player) event.getWhoClicked());
                    return;
                default:
                    return;
            }

        }
    }
}
