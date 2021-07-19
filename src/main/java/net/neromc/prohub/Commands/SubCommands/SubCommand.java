package net.neromc.prohub.Commands.SubCommands;

import net.neromc.prohub.main;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.List;

public abstract class SubCommand {

    Plugin pl = main.getPlugin(main.class);

    String prefix = pl.getConfig().getString("prefix");

    //name of the subcommand ex. /prank <subcommand> <-- that
    public abstract String getName();

    //ex. "This is a subcommand that let's a shark eat someone"
    public abstract String getDescription();

    //How to use command ex. /prank freeze <player>
    public abstract String getSyntax();

    public abstract List<String> getAliases();

    //code for the subcommand
    public abstract boolean perform(Player player, String[] args);



}

