package net.neromc.prohub;

import net.neromc.prohub.Events.JoinLeaveEvents;
import net.neromc.prohub.Events.WorldSettings;
import net.neromc.prohub.utils.UpdateChecker;
import net.neromc.prohub.utils.Utils;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class main extends JavaPlugin {

    public String prefix = Utils.Color("&e&lProHub &7&l| &7");

    @Override
    public void onEnable() {
        // Plugin startup logic


        System.out.println("ProHub || Loading...");

        System.out.println("ProHub || Loading Messages...");

        // Config

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        //

        System.out.println("ProHub || Messages Done!");

        System.out.println("ProHub || Loading Commands...");

        //Registering Commands

        registerCommands();

        //

        System.out.println("ProHub || Commands Done!");

        System.out.println("ProHub || Loading Events...");

        //Registering Events

        registerEvents();

        //

        System.out.println("ProHub || Events Done!");


        System.out.println("ProHub || Plugin Loaded");
        System.out.println("ProHub || All Rights Reserved");

        //UpdateChecker

        new UpdateChecker(this,94324).getLatestVersion(version -> {
            if(this.getDescription().getVersion().equalsIgnoreCase(version)) {
                System.out.println("ProHub || Plugin is up to date!");
            } else {
                System.out.println("ProHub || Plugin has an update! Please update to the latest version!");
            }
        });
    }


    public void registerEvents() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new JoinLeaveEvents(), this);
        pm.registerEvents(new WorldSettings(), this);


    }

    public void registerCommands() {

    }

}
