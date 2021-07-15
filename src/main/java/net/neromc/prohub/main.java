package net.neromc.prohub;

import net.neromc.prohub.Commands.test;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class main extends JavaPlugin {

    public String prefix = Utils.Color("&e&lProHub &7&l| &7");

    @Override
    public void onEnable() {
        // Plugin startup logic


        System.out.println("ProHub || Loading...");

        System.out.println("ProHub || Loading Config...");

        // Config


        //

        System.out.println("ProHub || Config Done!");

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

    }


    public void registerEvents() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new test(this), this);


    }

    public void registerCommands() {

    }

}