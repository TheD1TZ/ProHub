package net.neromc.prohub.Commands.SubCommands;

import net.neromc.prohub.main;
import net.neromc.prohub.utils.Permissions;
import net.neromc.prohub.utils.Utils;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.List;

public class SetSpawn extends SubCommand {

    Plugin pl = main.getPlugin(main.class);

    String prefix = pl.getConfig().getString("Prefix");

    @Override
    public String getName() {
        return "setspawn";
    }

    @Override
    public String getDescription() {
        return "Sets the spawn of the lobby";
    }

    @Override
    public String getSyntax() {
        return "/prohub setspawn";
    }

    @Override
    public List<String> getAliases() {
        return null;
    }

    @Override
    public boolean perform(Player player, String[] args) {

        if (player.hasPermission(Permissions.COMMAND_PROHUB_SETSPAWN.getPermission())) {
            return true;
        }



            if (args.length > 0) {
                pl.getConfig().set("Lobby.world", player.getLocation().getWorld().getName());
                pl.getConfig().set("Lobby.location.x", player.getLocation().getX());
                pl.getConfig().set("Lobby.location.y", player.getLocation().getY());
                pl.getConfig().set("Lobby.location.z", player.getLocation().getZ());
                pl.getConfig().set("Lobby.location.yaw", player.getLocation().getYaw());
                pl.getConfig().set("Lobby.location.pitch", player.getLocation().getPitch());

                pl.saveConfig();

                player.sendMessage(Utils.Color(prefix + "&fThe spawnpoint has been set!"));
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1f, 1f);
            } else if (args.length == 0) {
                return true;
            }

        return false;
    }
}
