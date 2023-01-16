package au.chival.lobby;

import org.bukkit.scheduler.BukkitRunnable;

import static au.chival.lobby.Main.plugin;

public class Example {

    public static BukkitRunnable task;

    public static void main(String[] args) {

        task = (BukkitRunnable) new BukkitRunnable() {
            @Override
            public void run() {

            }
        }.runTaskAsynchronously(plugin);
    }

    public static void other() {
        task.cancel();
    }
}
