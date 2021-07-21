package net.neromc.prohub.command.commands;

import net.neromc.prohub.command.CommandBase;
import net.neromc.prohub.main;
import net.neromc.prohub.utils.Permissions;
import net.neromc.prohub.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

public class SpawnCommand extends CommandBase {

    public SpawnCommand() {
        super("spawn");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            spawnTeleport(player);
            player.sendMessage(Utils.Color(main.getInstance().prefix() + "&fTeleported to spawn!"));
            return true;
        } else {
            sender.sendMessage(Utils.Color("&cThis is a player only command!"));
        }
        return true;
    }

    public void spawnTeleport(Player player) {
        if (player.hasPermission(Permissions.COMMAND_PROHUB_SPAWN.getPermission())) {
            SpawnTeleport(player);

        }
    }

    public static void SpawnTeleport(Player player) {
        World world = Bukkit.getWorld(Objects.requireNonNull(main.getInstance().getConfig().getString("Lobby.world")));
        double x = main.getInstance().getConfig().getDouble("Lobby.location.x");
        double y = main.getInstance().getConfig().getDouble("Lobby.location.y");
        double z = main.getInstance().getConfig().getDouble("Lobby.location.z");
        double pitch = main.getInstance().getConfig().getDouble("Lobby.location.pitch");
        double yaw = main.getInstance().getConfig().getDouble("Lobby.location.yaw");
        Location location = new Location(world, x, y, z, (float) yaw, (float) pitch);

        player.teleport(location);
    }
}