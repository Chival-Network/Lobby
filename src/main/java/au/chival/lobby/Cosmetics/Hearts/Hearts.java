package au.chival.lobby.Cosmetics.Hearts;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.block.BlockFace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.text.DecimalFormat;
import java.util.Collection;
import java.util.Timer;
import java.util.TimerTask;

public class Hearts implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Player p = event.getPlayer();

        DecimalFormat df = new DecimalFormat("#.####");
        Location loc = event.getPlayer().getLocation();

        //Constants - Adjust as needed
        double radius = 1;      //Radius in the x and z direction
        double helixHeight = 1; //Height in the y direction
        double noOfSteps = 10; //time/increments for each item
        double noOfLoops = 1; //number of times the helix should loop by time it gets to the helixHeight
        double helixBase = 0.25; //how far UP the helix begins
        long TimerSpeed = 85; //the speed in mSec for how fast a new heart appears (decrease for faster)
        //step calculation
        double stepDelta = helixHeight/noOfSteps; // The calculation of each step gabe
        Timer timerHearts = new Timer("Timer");

        TimerTask taskDoHeart = new TimerTask() {
            double y=0;
            public void run() {
                //p.sendMessage("C:"+count);
                double playX = event.getPlayer().getLocation().getX();
                double playY = event.getPlayer().getLocation().getY();
                double playZ = event.getPlayer().getLocation().getZ();

                if (!event.getPlayer().isOnline()) {
                    timerHearts.cancel();
                }
                double angleRadians = (y*(noOfLoops/helixHeight)*360)*Math.PI/180;
                //p.sendMessage("Y:"+df.format(y)+" Angle:"+df.format(angleRadians));
                double x = radius * Math.cos(angleRadians);
                double z = radius * Math.sin(angleRadians);

                //Calculate the new location for this heart with teh x,y,z offset
                loc.setX(playX+x);
                loc.setY(playY+y+helixBase);
                loc.setZ(playZ+z);

                //p.sendMessage("Spawning particles.");
                boolean isvanishedfromsomeone = false;

                if  (event.getPlayer().hasPermission("chival.vanish")) {
                    //Check to see if the player has the vanish permission
                    // If they do, then iterate through the collection of online players and see
                    //     if the current user is vanished from any of them. If so, then
                    //     flag that they are vanishedfromsomeone and don't show hearts later on.

                    final Collection<? extends Player> players = Bukkit.getOnlinePlayers();
                    for (Player player : players) {
                        // loop through players

                        if (!player.canSee(event.getPlayer())) {
                            //Player is vanished, so flag to not show hearts
                            isvanishedfromsomeone = true;

                        }
                    }
                }

                if (!isvanishedfromsomeone){
                    p.getWorld().playEffect(loc, Effect.HEART, null);
                }
                //p.sendMessage("Spawning complete.");

                if (y > helixHeight) y=0;   //Reset back to bottom when y reaches the helixheight
                y += stepDelta;     // move to the next step
            }
        };


        timerHearts.scheduleAtFixedRate(taskDoHeart,3000, TimerSpeed);

        
        
            
        }
    }
    

/*
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
//    public void onEntityClick(PlayerInteractEntityEvent event) {

    //@EventHandler
    //public void onClick(PlayerMoveEvent event, Player player) {
        Player p = event.getPlayer();
        DecimalFormat df = new DecimalFormat("#.####");
        //p.sendMessage("This IS Particle Test");
        Location loc = event.getPlayer().getLocation();
        double playX = loc.getX();
        double playY = loc.getY();
        double playZ = loc.getZ();

        //p.sendMessage("Particles!");
        double radius = 1;      //Radius in the x and z direction
        double helixHeight = 1; //Height in the y direction
        double noOfSteps = 10; //time/increments for each item
        double noOfLoops = 1; //number of times the helix should loop by time it gets to the helixHeight
        double stepDelta = helixHeight/noOfSteps; // The calculation of each step gabe
        for (double y = 0; y<= helixHeight; y += (stepDelta)) {
            //p.sendMessage("H:"+df.format(helixHeight)+" s:"+df.format(stepDelta)+" y:"+df.format(y));
            double angleRadians = (y*(noOfLoops/helixHeight)*360)*Math.PI/180;
            //p.sendMessage("Y:"+df.format(y)+" Angle:"+df.format(angleRadians));
            double x = radius * Math.cos(angleRadians);
            double z = radius * Math.sin(angleRadians);

            //Calculate the new location for this heart with teh x,y,z offset
            loc.setX(playX+x);
            loc.setY(playY+y);
            loc.setZ(playZ+z);

            //p.sendMessage("Spawning particles.");
            p.getWorld().playEffect(loc,Effect.HAPPY_VILLAGER, null);
            //p.sendMessage("Spawning complete.");

        }
    } //end createHelix
    */
  //end class

