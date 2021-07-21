package net.neromc.prohub.utils;

import net.neromc.prohub.main;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;


public class Utils {

    private main plugin;

    public Utils(main main) {
        this.plugin = main;
    }

    public static String Color(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }




    public void HelpMessage(Player player) {
        player.sendMessage(Utils.Color("[-----[ &eProHub &7Help ]-----]"));
        player.sendMessage(Utils.Color(" &7- &e/ProHub help &7- to show help page."));
        player.sendMessage(Utils.Color(" &7- &e/ProHub setspawn &7- to set the server spawn."));
        player.sendMessage(Utils.Color(" &7- &e/ProHub reload &7- to reload the config."));
    }
}