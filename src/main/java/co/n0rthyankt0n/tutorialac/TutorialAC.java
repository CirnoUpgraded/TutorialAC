package co.n0rthyankt0n.tutorialac;

import co.n0rthyankt0n.tutorialac.check.checks.Fly;
import co.n0rthyankt0n.tutorialac.check.checks.Speed;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;


public final class TutorialAC extends JavaPlugin {


    @Override
    public void onEnable() {
        long start = System.currentTimeMillis();
        register( new Fly() );
        register( new Speed() );
        System.out.println( "TutorialAC has been loaded in " + (System.currentTimeMillis() - start ) + "ms! ");

    }

    public void register(Listener listener){
        getServer().getPluginManager().registerEvents( listener , this );
    }

}
