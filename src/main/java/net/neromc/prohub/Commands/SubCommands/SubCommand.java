package net.neromc.prohub.Commands.SubCommands;

import net.neromc.prohub.main;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.List;

public abstract class SubCommand {

    Plugin pl = main.getPlugin(main.class);

    String prefix = pl.getConfig().getString("prefix");


    public abstract String getName();

    public abstract String getDescription();

    public abstract String getSyntax();

    public abstract List<String> getAliases();

    public abstract boolean perform(Player player, String[] args);

}

