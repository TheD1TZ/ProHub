package net.neromc.prohub.Managers;

import net.neromc.prohub.utils.Utils;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getServer;

public class BossBarManager {

    public static void createBossBar(Player player) {
        BossBar bossBar = getServer().createBossBar("Work?", BarColor.BLUE, BarStyle.SOLID);
        bossBar.setTitle(Utils.Color("&7Test"));
        bossBar.addPlayer(player);
    }


}
