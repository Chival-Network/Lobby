package au.chival.lobby.QOL.AFK;

import au.chival.lobby.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.HashMap;
import java.util.UUID;

public class AFK implements Listener {
    HashMap<Player, Integer> afkMins = new HashMap<>();
    // Mins player has been inactiveases
    HashMap<Player, CountDownTask> countList = new Hashmap<>();
}

