package net.neromc.prohub.Commands;

import net.neromc.prohub.main;
import net.neromc.prohub.utils.Permissions;
import net.neromc.prohub.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Spawn implements CommandExecutor {


    Plugin pl = main.getPlugin(main.class);

    String prefix = pl.getConfig().getString("Prefix");

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        Player player = (Player) sender;

        if (!(sender instanceof Player)) {
            return true;
        }

        if (args.length != 0) {
            return true;
        }

        if (player.hasPermission(Permissions.COMMAND_PROHUB_SPAWN.getPermission())) {
            return true;
        }


        World world = Bukkit.getWorld(Objects.requireNonNull(pl.getConfig().getString("Lobby.world")));
        double x = pl.getConfig().getDouble("Lobby.location.x");
        double y = pl.getConfig().getDouble("Lobby.location.y");
        double z = pl.getConfig().getDouble("Lobby.location.z");
        Float pitch = (Float) pl.getConfig().get("Lobby.location.pitch");
        Float yaw = (Float)pl.getConfig().get("Lobby.location.yaw");
        Location location = new Location(world, x, y, z, yaw,pitch);

        player.teleport(location);
        player.sendMessage(Utils.Color(prefix + "&fSended you to the Lobby!"));
        player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1f,1f);

        return false;
    }
}
