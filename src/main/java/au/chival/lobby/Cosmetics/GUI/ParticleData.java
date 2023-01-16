package au.chival.lobby.Cosmetics.GUI;

import org.bukkit.Bukkit;

import java.nio.Buffer;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ParticleData {

    public static Map<UUID, Integer> Particle = new HashMap<UUID, Integer>();
    private final UUID uuid;

    public ParticleData(UUID uuid) {
        this.uuid = uuid;
    }
    public void setID(int id) {
        Particle.put(uuid, id);
    }
    public int getId() {
        return Particle.get(uuid);
    }
    public boolean hasID() {
        if (Particle.containsKey(uuid))
            return true;
        return false;
    }
    public void removeID() {
        Particle.remove(uuid);
    }
    public void endTask() {
        if (getId() == 1)
            return;

        Bukkit.getScheduler().cancelTask(getId());
    }
    public static boolean hasFakeID(UUID uuid) {
        if (Particle.containsKey(uuid))
            if (Particle.get(uuid) == 1)
                return true;
        return false;

    }
}
