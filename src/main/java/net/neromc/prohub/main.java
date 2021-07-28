package net.neromc.prohub;

import net.neromc.prohub.Events.JoinLeaveEvents;
import net.neromc.prohub.Events.JumpPadEvents;
import net.neromc.prohub.Events.WorldSettings;
import net.neromc.prohub.Managers.AutoTab;
import net.neromc.prohub.Managers.Bar;
import net.neromc.prohub.command.CommandHandler;
import net.neromc.prohub.utils.Metrics;
import net.neromc.prohub.utils.UpdateChecker;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
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

    public Bar bar;

    @Override
    public void onDisable() {
        saveDefaultConfig();

        getLogger().log(Level.INFO, "ProHub || Saved Config.yml");
        getLogger().log(Level.INFO, "ProHub || Thanks for using ProHub");
    }

    @Override
    public void onEnable() {

        long start = System.currentTimeMillis();

        bar = new Bar(this);
        bar.createBar();

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
        this.getCommand("prohub").setTabCompleter(new AutoTab());

        //

        getLogger().log(Level.INFO, "ProHub || Commands Done!");

        getLogger().log(Level.INFO, "ProHub || Loading Events...");

        //Registering Events

        getServer().getPluginManager().registerEvents(new WorldSettings(), this);
        getServer().getPluginManager().registerEvents(new JoinLeaveEvents(this), this);
        getServer().getPluginManager().registerEvents(new JumpPadEvents(), this);


        if (Bukkit.getOnlinePlayers().size() > 0)
            for (Player on : Bukkit.getOnlinePlayers())
                bar.addPlayer(on);

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

    public Bar getBar() {
        return bar;
    }
}




//Todo: Scoreboard
//Todo: Bossbars
/*Todo: Command Disabler
    /prohub disabledcommands add [command]
    /prohub disabledcommands remove [command]
    /prohub disabledcommands list
* */
