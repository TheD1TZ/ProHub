package net.neromc.prohub;

import net.neromc.prohub.Events.JoinLeaveEvents;
import net.neromc.prohub.Events.WorldSettings;
import net.neromc.prohub.command.CommandHandler;
import net.neromc.prohub.utils.Metrics;
import net.neromc.prohub.utils.UpdateChecker;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public final class main extends JavaPlugin {

    private static main instance;

    public static main getInstance() {
        return instance;
    }


    public String prefix() {
        return getConfig().getString("Prefix");
    }

    @Override
    public void onDisable() {
        saveDefaultConfig();

        getLogger().log(Level.INFO, "ProHub || Saved Config.yml");
        getLogger().log(Level.INFO, "ProHub || Thanks for using ProHub");
    }

    @Override
    public void onEnable() {

        long start = System.currentTimeMillis();


        int pluginID = 12085;

        new UpdateChecker(this).checkForUpdate();


        getLogger().log(Level.INFO, "ProHub || &fLoading...");

        getLogger().log(Level.INFO, "ProHub || &fLoading Messages...");

        //Metrics

        Metrics metrics = new Metrics(this,pluginID);

        metrics.addCustomChart(new Metrics.SimplePie("chart_id", () -> "My value"));

        //

        getLogger().log(Level.INFO, "ProHub || Messages Done!");

        getLogger().log(Level.INFO, "ProHub || Loading Commands...");

        //Commands loading

        new CommandHandler();

        //

        getLogger().log(Level.INFO, "ProHub || Commands Done!");

        getLogger().log(Level.INFO, "ProHub || Loading Events...");

        //Registering Events

        getServer().getPluginManager().registerEvents(new WorldSettings(), this);
        getServer().getPluginManager().registerEvents(new JoinLeaveEvents(this), this);

        //

        getLogger().log(Level.INFO, "ProHub || Events Done!");


        getLogger().log(Level.INFO, "ProHub || Successfully loaded in " + (System.currentTimeMillis() - start) + "ms");
        getLogger().log(Level.INFO, "ProHub || All Rights Reserved");

    }

    @Override
    public void onLoad() {

        instance = this;

        this.saveDefaultConfig();
    }


}




//Todo: Scoreboard
//Todo: Jump Pads
//Todo: Bossbars
//Todo: Command Disabler
