package au.chival.lobby.Cosmetics.GUI;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class GUI {

    public static Inventory INV;
    public void register() {
        Inventory inv = Bukkit.createInventory(null, 27, "Particle Trails");

        ItemStack item = new ItemStack(Material.APPLE);
        ItemMeta meta = item.getItemMeta();
        //Heart Particle
        meta.setDisplayName(ChatColor.AQUA + "Heart Particle Pack");
        List<String> lore = new ArrayList<String>();
        lore.add(ChatColor.YELLOW + "Click to Select!");
        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(3, item);
        setInventory(inv);


        item.setType(Material.BARRIER);
        meta.setDisplayName(ChatColor.RED + "RESET TRAIL");
        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(0, item);
        setInventory(inv);

        item.setType(Material.IRON_SWORD);
        meta.setDisplayName(ChatColor.AQUA + "Crit Particle Pack");
        lore.clear();
        lore.add(ChatColor.YELLOW + "Click To Select");
        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(1, item);
        setInventory(inv);

        //Close button
        item.setType(Material.ARROW);
        meta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Close Menu");
        lore.clear();
        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(8, item);


        /*item = new ItemStack(Material.IRON_SWORD);
        meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.AQUA + "Damage Particle Pack");
        ArrayList<String> lores = new ArrayList<String>();
        lores.add("Add Descriptions with this just add another lore.add()");
        meta.setLore(lores);
        inv.setItem(5, item);
        setInventory(inv);

         */

    }
    public Inventory getInventory() {
        return INV;
    }
    private void setInventory(Inventory inv) {
        INV = inv;

    }
    public void openInventory(Player player) {
        player.openInventory(INV);
    }
}

