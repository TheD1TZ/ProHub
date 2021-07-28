package net.neromc.prohub.utils;

import net.neromc.prohub.main;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;


public class Utils {

    private main plugin;

    public Utils(main main) {
        this.plugin = main;
    }

    public static String Color(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

}