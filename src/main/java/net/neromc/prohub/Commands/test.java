package net.neromc.prohub.Commands;

import net.neromc.prohub.Utils;
import net.neromc.prohub.main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class test implements Listener {

    final main plugin;

    public test(main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void OnJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        player.sendMessage(Utils.prefix + "Welcome x");
    }


}
