package au.chival.lobby.Cosmetics.GUI;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

import static au.chival.lobby.Cosmetics.GUI.GUI.INV;

public class HotBar implements Listener {

    public void onJoin(PlayerJoinEvent event) {

        HumanEntity hu = event.getPlayer();
        hu.getOpenInventory().getTopInventory().setItem(5, new ItemStack(Material.BANNER));
    }
}


