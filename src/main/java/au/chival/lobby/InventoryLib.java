package au.chival.lobby;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.List;

public class InventoryLib {

    public static ItemStack makeItem( Material material, String name, List<String> lore, int amount) {
        ItemStack itemStack = new ItemStack(material, amount);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(name);
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public static ItemStack makeItem(Material material, String name, List<String> lore, int amount, String skullOwner) {
        ItemStack itemStack = new ItemStack(material, amount);
        SkullMeta itemMeta = (SkullMeta) itemStack.getItemMeta();
        itemStack.setDurability((short) 3);
        itemMeta.setDisplayName(name);
        itemMeta.setLore(lore);
        itemMeta.setOwner(skullOwner);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
