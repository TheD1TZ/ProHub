package net.neromc.prohub.Events;

import net.neromc.prohub.main;
import net.neromc.prohub.utils.Utils;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class JumpPadEvents implements Listener {

    Boolean JumpPadEnabled = main.getInstance().getConfig().getBoolean("JumpPad.enabled");
    Boolean JumpPadMessageEnabled = main.getInstance().getConfig().getBoolean("JumpPad.message");
    Boolean JumpPadSoundEnabled = main.getInstance().getConfig().getBoolean("JumpPad.sounds");
    String JumpPadSound = main.getInstance().getConfig().getString("JumpPad.sound");
    String JumpPadMessage = main.getInstance().getConfig().getString("JumpPad.launch-message");
    String JumpPadUnderBlock = main.getInstance().getConfig().getString("JumpPad.underblock");
    String JumpPadTopBlock = main.getInstance().getConfig().getString("JumpPad.topblock");

    int JumpPadHeight = main.getInstance().getConfig().getInt("JumpPad.y-velocity");
    int JumpPadVooruit = main.getInstance().getConfig().getInt("JumpPad.velocity-multiplier");



    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        if (JumpPadEnabled) {
            Player player = e.getPlayer();
            Location blockUnder = player.getLocation();
            blockUnder.setY(blockUnder.getY() - 1);

            if (player.getLocation().getBlock().getType().equals(Material.valueOf(JumpPadTopBlock)) && blockUnder.getBlock().getType().equals(Material.valueOf(JumpPadUnderBlock))) {

                player.setVelocity(player.getLocation().getDirection().multiply(JumpPadVooruit).setY(JumpPadHeight));

                if (JumpPadMessageEnabled) {
                    player.sendMessage(Utils.Color(JumpPadMessage));
                }

                if (JumpPadSoundEnabled) {
                    player.playSound(player.getLocation(), Sound.valueOf(JumpPadSound), 1f, 1f);
                }

            }
        }
    }
}
