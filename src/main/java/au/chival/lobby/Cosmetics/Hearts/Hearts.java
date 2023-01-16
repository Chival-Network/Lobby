package au.chival.lobby.Cosmetics.Hearts;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;

import java.text.DecimalFormat;
import java.util.Collection;
import java.util.Timer;
import java.util.TimerTask;

public class Hearts {

        private Timer timerTask;

        public void startHearts (Player player) {

            DecimalFormat df = new DecimalFormat("#.####");
            Location loc = player.getLocation();

            //Constants - Adjust as needed
            double radius = 1;      //Radius in the x and z direction
            double helixHeight = 1; //Height in the y direction
            double noOfSteps = 10; //time/increments for each item
            double noOfLoops = 1; //number of times the helix should loop by time it gets to the helixHeight
            double helixBase = 0.25; //how far UP the helix begins
            long TimerSpeed = 85; //the speed in mSec for how fast a new heart appears (decrease for faster)
            //step calculation
            double stepDelta = helixHeight / noOfSteps; // The calculation of each step gabe
            timerTask = new Timer("Timer");

            TimerTask taskDoHeart = new TimerTask() {
                double y = 0;

                public void run() {
                    //p.sendMessage("C:"+count);
                    double playX = player.getLocation().getX();
                    double playY = player.getLocation().getY();
                    double playZ = player.getLocation().getZ();

                    if (!player.isOnline()) {
                        timerHearts.cancel();
                    }
                    double angleRadians = (y * (noOfLoops / helixHeight) * 360) * Math.PI / 180;
                    //p.sendMessage("Y:"+df.format(y)+" Angle:"+df.format(angleRadians));
                    double x = radius * Math.cos(angleRadians);
                    double z = radius * Math.sin(angleRadians);

                    //Calculate the new location for this heart with teh x,y,z offset
                    loc.setX(playX + x);
                    loc.setY(playY + y + helixBase);
                    loc.setZ(playZ + z);

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

                        player.getWorld().playEffect(loc, Effect.HEART, null);

                    }
                    if (y > helixHeight) y = 0;
                    y += stepDelta;     // move to the next step
                }
            };

            timerTask.scheduleAtFixedRate(taskDoHeart, 3000, TimerSpeed);
        }

        public void StopHearts() {
            timerTask.cancel();
        }
    }

