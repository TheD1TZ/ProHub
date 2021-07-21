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
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Spawn implements CommandExecutor {

    private main plugin;

    public Spawn(main main) {
        this.plugin = main;
        plugin.getCommand("spawn").setExecutor(this);
    }


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


        SpawnTeleport(player);
        player.sendMessage(Utils.Color(plugin.prefix() + "&fSended you to the Lobby!"));
        player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1f,1f);

        return false;

    }

    public void SpawnTeleport(Player player) {
        World world = Bukkit.getWorld(Objects.requireNonNull(plugin.getConfig().getString("Lobby.world")));
        double x = plugin.getConfig().getDouble("Lobby.location.x");
        double y = plugin.getConfig().getDouble("Lobby.location.y");
        double z = plugin.getConfig().getDouble("Lobby.location.z");
        Float pitch = (Float) plugin.getConfig().get("Lobby.location.pitch");
        Float yaw = (Float) plugin.getConfig().get("Lobby.location.yaw");
        Location location = new Location(world, x, y, z, yaw,pitch);

        player.teleport(location);
    }

}
