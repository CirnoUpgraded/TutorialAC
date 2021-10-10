package co.n0rthyankt0n.tutorialac.check.checks;

import co.n0rthyankt0n.tutorialac.check.Alert;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class Fly implements Listener {
    @EventHandler
    public void onMove(PlayerMoveEvent e){
        Player p = e.getPlayer(); // put e.getPlayer()'s responce to 'p'
        Location to = e.getTo(); // put e.getTo()'s responce to 'to'
        Location from = e.getFrom(); //put e.getFrom()'s responce to 'from'
        double yDiff = from.getY() - to.getY(); //yDiff is how many blocks down between from's y and to's y. sry for bad english
        if(to.getY() > from.getY())return; //if player didnt downing not do ↓.
        boolean ground =  to.getY() % 0.015625 < 0.0001;
        if(yDiff < 0.15 && !ground && yDiff != 0.07840000152587834 ){ // if fall distance is lower than 0.15 , flag!! ( 0.15 is not best value maybe. )
            new Alert(p,"Fly","A").send(); // let flag.
            //p.sendMessage( "" + yDiff );
        }
    }
}
