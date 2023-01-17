package au.chival.lobby.Cosmetics.Trails;

import org.bukkit.scheduler.BukkitRunnable;

import java.util.LinkedList;

public class Manager {
    public static LinkedList<BukkitRunnable> allTasks = new LinkedList<>();

    public static void stopAll() {
        allTasks.forEach(BukkitRunnable::cancel);
    }
}
