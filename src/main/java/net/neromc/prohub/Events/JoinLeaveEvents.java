package net.neromc.prohub.Events;

import me.clip.placeholderapi.PlaceholderAPI;
import net.neromc.prohub.Commands.Spawn;
import net.neromc.prohub.main;
import net.neromc.prohub.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;

import java.util.List;
import java.util.Objects;

public class JoinLeaveEvents implements Listener {

    private main plugin;

    public JoinLeaveEvents(main main) {
        this.plugin = main;
    }




    Plugin pl = main.getPlugin(main.class);

    String JoinMessage = pl.getConfig().getString("JoinMessage.message");
    boolean JoinMessageEnabled = pl.getConfig().getBoolean("JoinMessage.enabled");

    String LeaveMessage = pl.getConfig().getString("LeaveMessage");
    boolean LeaveMessageEnabled = pl.getConfig().getBoolean("LeaveMessage.enabled");

    String TitleTitle = pl.getConfig().getString("Title.title");
    String TitleSubTitle = pl.getConfig().getString("Title.subtitle");
    boolean TitleEnabled = pl.getConfig().getBoolean("Title.enabled");
    int TitleFadein = pl.getConfig().getInt("Title.fadein");
    int TitleFadeout = pl.getConfig().getInt("Title.fadeout");
    int TitleDuration = pl.getConfig().getInt("Title.duration");

    String FirstJoinMessage = pl.getConfig().getString("FirstJoin.message");
    boolean FirstJoinMessageEnabled = pl.getConfig().getBoolean("FirstJoin.enabled");

    boolean MOTDEnabled = pl.getConfig().getBoolean("MOTD.enabled");
    List MOTDmessage = pl.getConfig().getList("MOTD.message");

    boolean ScoreboardEnabled = pl.getConfig().getBoolean("Scoreboard.enabled");
    String ScoreboardTitle = pl.getConfig().getString("Scoreboard.title");
    String ScoreboardLines = pl.getConfig().getString("Scoreboard.lines");

    List TabListHeader = pl.getConfig().getStringList("Tablist.header");
    List TabListFooter = pl.getConfig().getStringList("Tablist.footer");
    boolean TablistEnabled = pl.getConfig().getBoolean("Tablist.enabled");

    boolean SpawnJoinEnabled = pl.getConfig().getBoolean("Lobby.enabled");

    public String TLHeader(List<String> list) {
        return String.join("\n", list);
    }
    public String TLFooter(List<String> list) {
        return String.join("\n", list);
    }

    @EventHandler
    public void playerJoin(PlayerJoinEvent ej) {
        Player player = ej.getPlayer();

        //Spawn Join
        if (SpawnJoinEnabled) {

            World world = Bukkit.getWorld(Objects.requireNonNull(plugin.getConfig().getString("Lobby.world")));
            double x = plugin.getConfig().getDouble("Lobby.location.x");
            double y = plugin.getConfig().getDouble("Lobby.location.y");
            double z = plugin.getConfig().getDouble("Lobby.location.z");
            Float pitch = (Float) plugin.getConfig().get("Lobby.location.pitch");
            Float yaw = (Float) plugin.getConfig().get("Lobby.location.yaw");
            Location location = new Location(world, x, y, z, yaw,pitch);

            player.teleport(location);

        }

        //JoinMessages
        if (JoinMessageEnabled) {
            String message = PlaceholderAPI.setPlaceholders(player, JoinMessage);
            ej.setJoinMessage(Utils.Color(message));
        }

        //First Join Message
        if (!player.hasPlayedBefore()) {
            if (FirstJoinMessageEnabled) {
                String message = PlaceholderAPI.setPlaceholders(player, FirstJoinMessage);
                Bukkit.broadcastMessage(message);
            }
        }

        //MOTD messages
        if (MOTDEnabled) {
            for (int i = 0; i < pl.getConfig().getList("MOTD.message").size(); i++) {

                List MOTDmsg = PlaceholderAPI.setPlaceholders(player, MOTDmessage);

                player.sendMessage(ChatColor.translateAlternateColorCodes('&', MOTDmsg.get(i).toString()));
            }
        }

        //Scoreboard
        if (ScoreboardEnabled) {
            String Title = PlaceholderAPI.setPlaceholders(player, ScoreboardTitle);
            String Lines = PlaceholderAPI.setPlaceholders(player, ScoreboardLines);


        }

        //Join Title
        if (TitleEnabled) {
            String Title = PlaceholderAPI.setPlaceholders(player, TitleTitle);
            String SubTitle = PlaceholderAPI.setPlaceholders(player, TitleSubTitle);
            player.sendTitle(Title,SubTitle,TitleFadein,TitleDuration,TitleFadeout);
        }

        //TabList
        if (TablistEnabled) {
            String Header = PlaceholderAPI.setPlaceholders(player, TLHeader(TabListHeader));
            String Footer = PlaceholderAPI.setPlaceholders(player, TLHeader(TabListFooter));
            player.setPlayerListHeaderFooter(Header,Footer);


        }
    }

    @EventHandler
    public void playerLeave(PlayerQuitEvent eq) {
        Player player = eq.getPlayer();

        //LeaveMessages
        if (LeaveMessageEnabled) {
            String message = PlaceholderAPI.setPlaceholders(player, LeaveMessage);
            eq.setQuitMessage(Utils.Color(message));
        }
    }


}
