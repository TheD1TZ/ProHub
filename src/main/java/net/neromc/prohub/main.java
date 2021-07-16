package net.neromc.prohub;

import net.neromc.prohub.Events.JoinLeaveEvents;
import net.neromc.prohub.Events.WorldSettings;
import net.neromc.prohub.utils.Utils;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public final class main extends JavaPlugin {

    Plugin pl = main.getPlugin(main.class);


    public String prefix = Utils.Color("&e&lProHub &7&l| &7");

    @Override
    public void onEnable() {
        // Plugin startup logic
        long start = System.currentTimeMillis();


        getLogger().log(Level.INFO, "ProHub || Loading...");

        getLogger().log(Level.INFO, "ProHub || Loading Messages...");

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


    }

    public void registerCommands() {

    }

}



//Todo: Placeholder API
//Todo: Lobby Command
//Todo: Scoreboard
//Todo: Tablist
//Todo: Teleport Bow
//Todo: Jump Pads
//Todo: Bossbars
//Todo:
