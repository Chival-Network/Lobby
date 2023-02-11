package au.chival.lobby.serverSelector;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
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

import static au.chival.lobby.util.InventoryLib.makeItem;
import static au.chival.lobby.Main.plugin;
import static au.chival.lobby.util.CheakOnlineServer.onlineServers;

public class ServerSelectorGUI implements Listener {

    public ServerSelectorGUI() {}

    static String title;

    public ServerSelectorGUI(Player player) {
        title = ChatColor.AQUA + "Server Selector";
        Inventory inventory = Bukkit.createInventory(player, 45, title);
        List<String> loreholder = new LinkedList<>();
        ItemStack filler = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
        for (int i = 0; i < 45; i++) {inventory.setItem(i, filler);}

        // Exit
        loreholder.add(ChatColor.RED + "Close this menu");
        inventory.setItem(8 , makeItem(Material.BARRIER, ChatColor.RED + "Exit", loreholder, 1));
        loreholder.clear();
        //

        // Survival
        if (onlineServers.get("survival")) { loreholder.add(ChatColor.GREEN + "ONLINE"); } else { loreholder.add(ChatColor.RED + "OFFLINE"); }
        inventory.setItem(10 , makeItem(Material.GRASS, ChatColor.AQUA + "Survival", loreholder, 1));
        loreholder.clear();
        //

        // Duels
        if (onlineServers.get("duels")) { loreholder.add(ChatColor.GREEN + "ONLINE"); } else { loreholder.add(ChatColor.RED + "OFFLINE"); }
        inventory.setItem(11 , makeItem(Material.IRON_SWORD, ChatColor.AQUA + "Duels", loreholder, 1));
        loreholder.clear();
        //

        player.openInventory(inventory);
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {

        if (event.getClickedInventory() == null) {return;}

        if (event.getClickedInventory().getTitle() == title) {

            Player player = (Player) event.getWhoClicked();
            ByteArrayDataOutput out = ByteStreams.newDataOutput();

            event.setCancelled(true);

            switch (event.getSlot()) {
                case 8:
                    event.getWhoClicked().closeInventory();
                    return;
                case 10:
                    out.writeUTF("Connect");
                    out.writeUTF("survival");

                    try { player.sendPluginMessage(plugin, "BungeeCord", out.toByteArray()); } catch (Exception e) { System.out.println("Error send player to server. Is this a on a proxy? " + e); }

                    return;
                case 11:
                    out.writeUTF("Connect");
                    out.writeUTF("duels");

                    try { player.sendPluginMessage(plugin, "BungeeCord", out.toByteArray()); } catch (Exception e) { System.out.println("Error send player to server. Is this a on a proxy? " + e); }

                    return;
                default:
                    return;
            }

        }
    }
}
