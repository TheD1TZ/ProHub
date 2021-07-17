package net.neromc.prohub.utils;


import net.neromc.prohub.main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionDefault;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.logging.Level;

public class UpdateChecker {


    /*
        Credits: Benz56
        https://www.spigotmc.org/threads/async-update-checker-for-premium-and-regular-plugins.327921/
    */

    //Constants
    private static final int ID = 94324;
    private static final String ERR_MSG = "&e&lProHub &7&l|| &cUpdate checker failed!";
    private static final String UPDATE_MSG = "&e&lProHub &7&l|| &fA new update is available at:&e https://www.spigotmc.org/resources/" + ID + "/updates";
    private static final String UPDATE_MSG_CONSOLE = "ProHub || A new update is available at: https://www.spigotmc.org/resources/" + ID + "/updates";
    private static final Permission UPDATE_PERM = new Permission(Permissions.UPDATE_NOTIFICATION.getPermission(), PermissionDefault.TRUE);
    private static final long CHECK_INTERVAL = 12_000;
    private final JavaPlugin javaPlugin;
    private final String localPluginVersion;
    Plugin pl = main.getPlugin(main.class);
    private String spigotPluginVersion;


    public UpdateChecker(final JavaPlugin javaPlugin) {
        this.javaPlugin = javaPlugin;
        this.localPluginVersion = javaPlugin.getDescription().getVersion();
    }

    public void checkForUpdate() {
        new BukkitRunnable() {
            @Override
            public void run() {
                Bukkit.getScheduler().runTaskAsynchronously(javaPlugin, () -> {
                    //Request the current version of your plugin on SpigotMC.
                    try {
                        final HttpsURLConnection connection = (HttpsURLConnection) new URL("https://api.spigotmc.org/legacy/update.php?resource=" + ID).openConnection();
                        connection.setRequestMethod("GET");
                        spigotPluginVersion = new BufferedReader(new InputStreamReader(connection.getInputStream())).readLine();
                    } catch (final IOException e) {
                        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', ERR_MSG));
                        e.printStackTrace();
                        cancel();
                        return;
                    }

                    //Check if the requested version is the same as the one in your plugin.yml.
                    if (localPluginVersion.equals(spigotPluginVersion)) return;

                    pl.getLogger().log(Level.WARNING, UPDATE_MSG_CONSOLE);

                    //Register the PlayerJoinEvent
                    Bukkit.getScheduler().runTask(javaPlugin, () -> Bukkit.getPluginManager().registerEvents(new Listener() {
                        @EventHandler(priority = EventPriority.MONITOR)
                        public void onPlayerJoin(final PlayerJoinEvent event) {
                            final Player player = event.getPlayer();
                            if (!player.hasPermission(UPDATE_PERM)) return;
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', UPDATE_MSG));
                        }
                    }, javaPlugin));

                    cancel(); //Cancel the runnable as an update has been found.
                });
            }
        }.runTaskTimer(javaPlugin, 0, CHECK_INTERVAL);
    }
}