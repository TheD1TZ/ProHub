package net.neromc.prohub.command;

import net.neromc.prohub.main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public abstract class CommandBase implements CommandExecutor {

    public CommandBase(String name) {
        main.getInstance().getCommand(name).setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        return true;
    }
}