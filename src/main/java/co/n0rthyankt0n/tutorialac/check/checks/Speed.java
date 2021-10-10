package co.n0rthyankt0n.tutorialac.check.checks;

import co.n0rthyankt0n.tutorialac.check.Alert;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffectType;

public class Speed implements Listener {
    @EventHandler
    public void onMove(PlayerMoveEvent e){
        Player p = e.getPlayer();
        double distance = e.getTo().distance(e.getFrom());
        if(p.hasPotionEffect( PotionEffectType.SPEED))return;
        boolean ground = p.getWorld().getBlockAt(p.getLocation().subtract(0.0D, 1.0D, 0.0D)).getType().isSolid();
        if(distance > 0.6 && ground && !(e.getFrom().getY() < e.getTo().getY())){
            new Alert(p , "SPEED" , "DISTANCE").send();
        }
    }
}
