package au.chival.lobby.Cosmetics.Trails;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.LinkedHashMap;
import java.util.LinkedList;

public class Manager {
    public static LinkedHashMap<Player, LinkedList<BukkitRunnable>> currentParticles = new LinkedHashMap<>();

    public static void stopAll(Player player) {
        currentParticles.get(player).forEach(value -> {
            if (value == null) {
                currentParticles.get(player).remove(value);
                System.out.println("removed " + value.getTaskId());
                return;
            }
            value.cancel();
            System.out.println("canceled " + value.getTaskId());
        });
    }
}
