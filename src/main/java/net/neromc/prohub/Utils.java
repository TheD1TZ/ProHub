package net.neromc.prohub;

import org.bukkit.ChatColor;

public class Utils {


    public static String prefix = Utils.Color("&e&lProHub &7&l| &7");

    public static String Color(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

}
