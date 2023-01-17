package au.chival.lobby;

import org.bukkit.scheduler.BukkitRunnable;

import java.sql.SQLOutput;

import static au.chival.lobby.Main.plugin;

public class Example {

    public static BukkitRunnable task;

    public static void main(String[] args) {

        task = (BukkitRunnable) new BukkitRunnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("helloooo");
                    try {
                        wait(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }.runTaskAsynchronously(plugin);
    }

    public static void other() {
        task.cancel();
    }
}
