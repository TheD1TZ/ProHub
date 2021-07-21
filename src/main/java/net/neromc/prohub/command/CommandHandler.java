package net.neromc.prohub.command;

import net.neromc.prohub.command.commands.ProHubCommand;
import net.neromc.prohub.command.commands.SpawnCommand;

public class CommandHandler {

    public CommandHandler() {
        new ProHubCommand();
        new SpawnCommand();
    }
}