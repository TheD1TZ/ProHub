package net.neromc.prohub.utils;

import net.neromc.prohub.main;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;


public class Utils {

    Plugin pl = main.getPlugin(main.class);

    public static String prefix = Utils.Color("&e&lProHub &7&l| &7");

    public static String Color(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }


}
