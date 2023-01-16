package au.chival.lobby.QOL.AFK;

import au.chival.lobby.Main;
import org.bukkit.entity.Player;

public class CountDownTask implements Runnable{
    private Main main;
    private int id;
    private int i;
    private String t;
    private Player player;

    public CountDownTask(Main main,Player player, String type) {
        this.main = main;
        this.player = player;
        this.i = 5;
        this.t = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        if (this.t == "afk") {
            // put into afk
            AFK.addAFK(p);
        } else if (this.t == "kick") {
            // Kick from server
            p.set
        }




    }
}
