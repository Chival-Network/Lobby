package au.chival.lobby.util;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;

import static au.chival.lobby.Main.plugin;
import static java.lang.Thread.sleep;

public class CheakOnlineServer {

    public static HashMap<String, Boolean> onlineServers = new HashMap<>();

    public CheakOnlineServer() {

        new BukkitRunnable() {
            @Override
            public void run() {

                //survival
                try {
                    Socket socket = new Socket("121.213.187.37", 25103);
                    onlineServers.put("survival", true);
                    Bukkit.getLogger().info("Survival is online...");
                } catch (IOException e) {
                    onlineServers.put("survival", false);
                    Bukkit.getLogger().info("Survival is offline...");
                }

                //duels
                try {
                    Socket socket = new Socket("192.9.167.151", 25556);
                    onlineServers.put("duels", true);
                } catch (IOException e) {
                    onlineServers.put("duels", false);
                }

                //end
                try {
                    sleep(30000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                new CheakOnlineServer();
            }
        }.runTaskAsynchronously(plugin);

    }
}
