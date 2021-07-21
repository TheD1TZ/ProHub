package net.neromc.prohub;

import net.neromc.prohub.Commands.Spawn;
import net.neromc.prohub.Events.JoinLeaveEvents;
import net.neromc.prohub.Events.WorldSettings;
import net.neromc.prohub.Managers.CommandManager;
import net.neromc.prohub.utils.Metrics;
import net.neromc.prohub.utils.UpdateChecker;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public final class main extends JavaPlugin {





    @Override
    public void onEnable() {

        new Spawn(this);


        long start = System.currentTimeMillis();


        int pluginID = 12085;

        new UpdateChecker(this).checkForUpdate();


        getLogger().log(Level.INFO, "ProHub || Loading...");

        getLogger().log(Level.INFO, "ProHub || Loading Messages...");

        //Metrics

        Metrics metrics = new Metrics(this,pluginID);



        metrics.addCustomChart(new Metrics.SimplePie("chart_id", () -> "My value"));


        // Config

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        //

        getLogger().log(Level.INFO, "ProHub || Messages Done!");

        getLogger().log(Level.INFO, "ProHub || Loading Commands...");

        //Registering Commands

        registerCommands();

        //

        getLogger().log(Level.INFO, "ProHub || Commands Done!");

        getLogger().log(Level.INFO, "ProHub || Loading Events...");

        //Registering Events

        registerEvents();

        //

        getLogger().log(Level.INFO, "ProHub || Events Done!");


        getLogger().log(Level.INFO, "ProHub || Successfully loaded in " + (System.currentTimeMillis() - start) + "ms");
        getLogger().log(Level.INFO, "ProHub || All Rights Reserved");

        //UpdateChecker

    }

    public void registerEvents() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new WorldSettings(), this);
        pm.registerEvents(new JoinLeaveEvents(this), this);


    }

    public void registerCommands() {

        getCommand("prohub").setExecutor(new CommandManager());
    }


    public String prefix() {
        return getConfig().getString("Prefix");
    }
}




//Todo: Scoreboard
//Todo: Jump Pads
//Todo: Bossbars
//Todo: bStats
//Todo: Command Disabler

/*Todo: Commands
    - /ProHub Reload
    - /ProHub SetHub
    - /Hub
    - /Lobby
 */
