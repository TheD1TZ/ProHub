package net.neromc.prohub.Events;


import net.neromc.prohub.main;
import net.neromc.prohub.utils.Utils;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;



public class JoinLeaveEvents implements Listener {

    Plugin pl = main.getPlugin(main.class);

    String JoinMessage = pl.getConfig().getString("JoinMessage.message");
    boolean JoinMessageEnabled = pl.getConfig().getBoolean("JoinMessage.enabled");

    String LeaveMessage = pl.getConfig().getString("LeaveMessage");
    boolean LeaveMessageEnabled = pl.getConfig().getBoolean("LeaveMessage.enabled");


    String FirstJoinMessage = pl.getConfig().getString("FirstJoin");
    boolean FirstJoinMessageEnabled = pl.getConfig().getBoolean("FirstJoin.enabled");

    boolean MOTDEnabled = pl.getConfig().getBoolean("MOTD.enabled");


    @EventHandler
    public void playerJoin(PlayerJoinEvent ej) {
        Player player = ej.getPlayer();


        //JoinMessages
        if (JoinMessageEnabled) {
            String message = (JoinMessage);
            ej.setJoinMessage(Utils.Color(message));
        }

        //MOTD messages
        if (MOTDEnabled) {
            for (int i = 0; i < pl.getConfig().getList("MOTD.message").size(); i++) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', pl.getConfig().getList("MOTD.message").get(i).toString()));
            }
        }
    }

    @EventHandler
    public void playerLeave(PlayerQuitEvent eq) {
        Player player = eq.getPlayer();

        //LeaveMessages
        if (LeaveMessageEnabled) {
            String message = (LeaveMessage);
            eq.setQuitMessage(Utils.Color(message));
        }
    }
}
