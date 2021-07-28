package net.neromc.prohub.command.commands;

import net.neromc.prohub.command.CommandBase;
import net.neromc.prohub.main;
import net.neromc.prohub.utils.Permissions;
import net.neromc.prohub.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ProHubCommand extends CommandBase {

    public ProHubCommand() {
        super("prohub");
    }

    //Help message

    private boolean HelpMessage(Player player) {
        player.sendMessage(Utils.Color("[-----[ &eProHub &fHelp ]-----]"));
        player.sendMessage(Utils.Color(""));
        player.sendMessage(Utils.Color("&e&lPlayer Commands"));
        player.sendMessage(Utils.Color(""));
        player.sendMessage(Utils.Color(" &7- &e/spawn &7- &e/hub &7- &e/lobby &7- sends the player to the server spawn."));
        player.sendMessage(Utils.Color(""));
        player.sendMessage(Utils.Color("&e&lAdmin Commands"));
        player.sendMessage(Utils.Color(""));
        player.sendMessage(Utils.Color(" &7- &e/prohub help &7- to show help page."));
        player.sendMessage(Utils.Color(" &7- &e/prohub setspawn &7- to set the server spawn."));
        player.sendMessage(Utils.Color(" &7- &e/prohub reload &7- to reload the config."));

        player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1f, 1f);
        return true;
    }



    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length < 1) {
                return HelpMessage(player);
            }

            //Help Command
            if (args[0].equalsIgnoreCase("help")) {
                if (player.hasPermission(Permissions.COMMAND_PROHUB_HELP.getPermission())) {
                    return HelpMessage(player);
                }
            }


            //SetSpawnCommand
            else if (args[0].equalsIgnoreCase("setspawn")) {
                if (player.hasPermission(Permissions.COMMAND_PROHUB_SETSPAWN.getPermission())) {
                    main.getInstance().getConfig().set("Lobby.world", player.getLocation().getWorld().getName());
                    main.getInstance().getConfig().set("Lobby.location.x", player.getLocation().getX());
                    main.getInstance().getConfig().set("Lobby.location.y", player.getLocation().getY());
                    main.getInstance().getConfig().set("Lobby.location.z", player.getLocation().getZ());
                    main.getInstance().getConfig().set("Lobby.location.yaw", player.getLocation().getYaw());
                    main.getInstance().getConfig().set("Lobby.location.pitch", player.getLocation().getPitch());

                    main.getInstance().saveConfig();

                    player.sendMessage(Utils.Color(main.getInstance().prefix() + "&fThe spawnpoint has been set!"));
                    player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1f, 1f);
                    return true;
                }
            }


            //Reload Command
            else if (args[0].equalsIgnoreCase("reload")) {
                if (player.hasPermission(Permissions.COMMAND_PROHUB_RELOAD.getPermission())) {
                    main.getInstance().reloadConfig();
                    main.getInstance().saveDefaultConfig();
                    player.sendMessage(Utils.Color(main.getInstance().prefix() + "&fReloaded the config!"));
                    return true;
                }
            }
            return true;
        }









        else {
            sender.sendMessage(Utils.Color(main.getInstance().prefix() + "&cThis is a player only command!"));
        }
        return true;
    }

}