package co.n0rthyankt0n.tutorialac.check;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Alert{

    String check,type,log;
    Player player;
    boolean alreadysend;

    public Alert(Player p,String check,String type){
        this.player = p;
        this.check = check;
        this.type = type;
        log = "§cTutorialAC§7>§e " + player.getName() + "§7 failed §e" + check + "§7(§c" + type + "§7)";
        alreadysend = false;
    }
    public Player getPlayer(){
        return player;
    }

    public void send(){
        if(alreadysend)return;
        for(Player pl : Bukkit.getOnlinePlayers()){
            if(pl.hasPermission("ac.noitfy")){
                pl.sendMessage(log);
            }
        }
        this.alreadysend = true;
    }
}