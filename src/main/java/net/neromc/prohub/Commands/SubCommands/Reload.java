package net.neromc.prohub.Commands.SubCommands;

import net.neromc.prohub.main;
import net.neromc.prohub.utils.Permissions;
import net.neromc.prohub.utils.Utils;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.List;

public class Reload extends SubCommand{

    Plugin pl = main.getPlugin(main.class);

    String prefix = pl.getConfig().getString("Prefix");

    @Override
    public String getName() {
        return "reload";
    }

    @Override
    public String getDescription() {
        return "Reloads the ProHub Config.yml";
    }

    @Override
    public String getSyntax() {
        return "/prohub reload";
    }

    @Override
    public List<String> getAliases() {
        return null;
    }

    @Override
    public boolean perform(Player player, String[] args) {

        if (player.hasPermission(Permissions.COMMAND_PROHUB_RELOAD.getPermission())) {
            return true;
        }



            if (args.length > 0) {
                pl.reloadConfig();
                player.sendMessage(Utils.Color(prefix + "&fReloaded the config!"));
            } else if (args.length == 0) {
                player.sendMessage(Utils.Color("[-----[ &eProHub &fHelp ]-----]"));
                player.sendMessage(Utils.Color(" &7- &e/ProHub help &7- to show help page."));
                player.sendMessage(Utils.Color(" &7- &e/ProHub setspawn &7- to set the server spawn."));
                player.sendMessage(Utils.Color(" &7- &e/ProHub reload &7- to reload the config."));
            }

        return false;
    }
}
