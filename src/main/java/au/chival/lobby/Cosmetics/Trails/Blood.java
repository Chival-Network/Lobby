package au.chival.lobby.Cosmetics.Trails;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.text.DecimalFormat;
import java.util.Collection;
import java.util.logging.Logger;

import static au.chival.lobby.Cosmetics.Trails.Manager.currentParticles;
import static au.chival.lobby.Cosmetics.Trails.Manager.stopAll;
import static au.chival.lobby.Main.plugin;

public class Blood {

    //Constants - Adjust as needed
    boolean debug = false; // DO NOT DELETE log lines. Change to false to turn off log messages
    Logger log = Bukkit.getLogger();
    double radius = 1;      //Radius in the x and z direction
    double helixHeight = 1; //Height in the y direction
    double noOfSteps = 10; //time/increments for each item
    double noOfLoops = 1; //number of times the helix should loop by time it gets to the helixHeight
    double helixBase = 0.25; //how far UP the helix begins
    long TimerSpeed = 85; //the speed in mSec for how fast a new heart appears (decrease for faster)
    //step calculation
    double stepDelta = helixHeight / noOfSteps; // The calculation of each step gabe

    public BukkitRunnable bloodRun;

    public void startBlood(Player player) {
        stopAll(player);

        if (debug) log.info(ChatColor.RED +"[Blood] startHearts");
        DecimalFormat df = new DecimalFormat("#.####");
        Location loc = player.getLocation();

        //timerTask = new Timer("Timer");
        //TimerTask taskDoHeart = new TimerTask() {
        bloodRun = (BukkitRunnable) new BukkitRunnable() {
            double y = 0;

            public void run() {
                if (!player.isOnline()) {
                    cancel();
                    bloodRun = null;
                }
                //p.sendMessage("C:"+count);
                double playX = player.getLocation().getX();
                double playY = player.getLocation().getY();
                double playZ = player.getLocation().getZ();

                //double angleRadians = (y * (noOfLoops / helixHeight) * 360) * Math.PI / 180;
                //p.sendMessage("Y:"+df.format(y)+" Angle:"+df.format(angleRadians));
                //double x = radius * Math.cos(angleRadians);
                //double z = radius * Math.sin(angleRadians);

                //Calculate the new location for this heart with teh x,y,z offset
                loc.setX(playX);
                loc.setY(playY + 1);
                loc.setZ(playZ);

                //p.sendMessage("Spawning particles.");
                boolean isvanishedfromsomeone = false;

                if (player.hasPermission("chival.vanish")) {
                    //Check to see if the player has the vanish permission
                    // If they do, then iterate through the collection of online players and see
                    //     if the current user is vanished from any of them. If so, then
                    //     flag that they are vanishedfromsomeone and don't show hearts later on.

                    final Collection<? extends Player> players = Bukkit.getOnlinePlayers();
                    for (Player player : players) {
                        // loop through players

                        if (!player.canSee(player)) {
                            //Player is vanished, so flag to not show hearts
                            isvanishedfromsomeone = true;
                        }
                    }
                }
                if (!isvanishedfromsomeone) {
                    player.getWorld().playEffect(loc, Effect.STEP_SOUND , Material.REDSTONE_BLOCK);
                }
                if (y > helixHeight) y = 0;
                y += stepDelta;     // move to the next step
            }
        };

        currentParticles.get(player).add(bloodRun);

        if (debug) log.info(ChatColor.RED +"[Blood] runTaskTimer");
        bloodRun.runTaskTimer(plugin, 0L, 5L);

        if (debug) log.info(ChatColor.RED +"[Blood] TaskID:"+ bloodRun.getTaskId());
    }

    public void stopBlood() {
        if (debug) log.info(ChatColor.RED +"[Blood] stopHearts" );
        if (debug) log.info(ChatColor.RED +"[Blood] TaskID:"+ bloodRun.getTaskId());
        bloodRun.cancel();
        if (debug) log.info(ChatColor.RED +"[Blood] cancel");
        bloodRun = null;
        if (debug) log.info(ChatColor.RED +"[Blood] null");
    }



}






