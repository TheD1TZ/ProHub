package net.neromc.prohub.Managers;

import net.neromc.prohub.main;
import net.neromc.prohub.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;

public class Bar {

    String bossbarline1 = main.getInstance().getConfig().getString("BossBar.title-1");
    String bossbarline2 = main.getInstance().getConfig().getString("BossBar.title-2");
    String bossbarline3 = main.getInstance().getConfig().getString("BossBar.title-3");
    String bossbarcolor1 = main.getInstance().getConfig().getString("BossBar.barcolor-1");
    String bossbarcolor2 = main.getInstance().getConfig().getString("BossBar.barcolor-2");
    String bossbarcolor3 = main.getInstance().getConfig().getString("BossBar.barcolor-3");
    int bossbardelay = main.getInstance().getConfig().getInt("BossBar.delay");


    private final main plugin;
    private int taskID = -1;
    private BossBar bar;

    public Bar(main plugin) {
        this.plugin = plugin;
    }

    public void addPlayer(Player player) {
        bar.addPlayer(player);
    }

    public BossBar getBar() {
        return bar;
    }

    public void createBar() {
        bar = Bukkit.createBossBar(Utils.Color(bossbarline1), BarColor.valueOf(bossbarcolor1), BarStyle.SOLID);
        bar.setVisible(true);
        cast();
    }

    public void cast() {
        taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(main.getInstance(), new Runnable() {

            int count = -1;
            double progress = 1.0;
            double time = 1.0 /(bossbardelay * 20);

            @Override
            public void run() {
                bar.setProgress(progress);

                switch(count){
                    case -1:
                        break;
                    case 0:
                        bar.setColor(BarColor.valueOf(bossbarcolor2));
                        bar.setTitle(Utils.Color(bossbarline2));
                        break;
                    case 1:
                        bar.setColor(BarColor.valueOf(bossbarcolor3));
                        bar.setTitle(Utils.Color(bossbarline3));
                        break;
                    case 2:
                    default:
                        bar.setColor(BarColor.valueOf(bossbarcolor1));
                        bar.setTitle(Utils.Color(bossbarline1));
                        count = -1;
                        break;
                }

                progress = progress - time;
                if (progress <= 0) {
                    count++;
                    progress = 1.0;
                }

            }
        },0,0);
    }

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }
}
