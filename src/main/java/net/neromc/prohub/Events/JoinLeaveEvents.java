package net.neromc.prohub.Events;

import me.clip.placeholderapi.PlaceholderAPI;
import net.neromc.prohub.Managers.Bar;
import net.neromc.prohub.command.commands.SpawnCommand;
import net.neromc.prohub.main;
import net.neromc.prohub.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.List;

public class JoinLeaveEvents implements Listener {

    private main plugin;

    public Bar bar;

    public JoinLeaveEvents(main main) {
        this.plugin = main;
    }


    String JoinMessage = main.getInstance().getConfig().getString("JoinMessage.message");
    boolean JoinMessageEnabled = main.getInstance().getConfig().getBoolean("JoinMessage.enabled");

    String LeaveMessage = main.getInstance().getConfig().getString("LeaveMessage.message");
    boolean LeaveMessageEnabled = main.getInstance().getConfig().getBoolean("LeaveMessage.enabled");

    String TitleTitle = main.getInstance().getConfig().getString("Title.title");
    String TitleSubTitle = main.getInstance().getConfig().getString("Title.subtitle");
    boolean TitleEnabled = main.getInstance().getConfig().getBoolean("Title.enabled");
    int TitleFadein = main.getInstance().getConfig().getInt("Title.fadein");
    int TitleFadeout = main.getInstance().getConfig().getInt("Title.fadeout");
    int TitleDuration = main.getInstance().getConfig().getInt("Title.duration");

    String FirstJoinMessage = main.getInstance().getConfig().getString("FirstJoin.message");
    boolean FirstJoinMessageEnabled = main.getInstance().getConfig().getBoolean("FirstJoin.enabled");

    boolean MOTDEnabled = main.getInstance().getConfig().getBoolean("MOTD.enabled");
    List MOTDmessage = main.getInstance().getConfig().getList("MOTD.message");

    boolean ScoreboardEnabled = main.getInstance().getConfig().getBoolean("Scoreboard.enabled");

    boolean BossBarEnabled = main.getInstance().getConfig().getBoolean("BossBar.enabled");

    List TabListHeader = main.getInstance().getConfig().getStringList("Tablist.header");
    List TabListFooter = main.getInstance().getConfig().getStringList("Tablist.footer");
    boolean TablistEnabled = main.getInstance().getConfig().getBoolean("Tablist.enabled");

    boolean SpawnJoinEnabled = main.getInstance().getConfig().getBoolean("Lobby.enabled");

    public String TabList(List<String> list) {
        return String.join("\n", list);
    }

    @EventHandler
    public void playerJoin(PlayerJoinEvent ej) {
        Player player = ej.getPlayer();

        //Spawn Join
        if (SpawnJoinEnabled) {

            if (main.getInstance().getConfig().getString("Lobby.world") != null) {

                SpawnCommand.SpawnTeleport(player);

            }
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
            for (int i = 0; i < main.getInstance().getConfig().getList("MOTD.message").size(); i++) {

                List MOTDmsg = PlaceholderAPI.setPlaceholders(player, MOTDmessage);

                player.sendMessage(ChatColor.translateAlternateColorCodes('&', MOTDmsg.get(i).toString()));
            }
        }

        //Scoreboard
        if (ScoreboardEnabled) {

        }

        //Join Title
        if (TitleEnabled) {
            String Title = PlaceholderAPI.setPlaceholders(player, TitleTitle);
            String SubTitle = PlaceholderAPI.setPlaceholders(player, TitleSubTitle);
            player.sendTitle(Title, SubTitle, TitleFadein, TitleDuration, TitleFadeout);
        }

        //TabList
        if (TablistEnabled) {
            String Header = PlaceholderAPI.setPlaceholders(player, TabList(TabListHeader));
            String Footer = PlaceholderAPI.setPlaceholders(player, TabList(TabListFooter));
            player.setPlayerListHeaderFooter(Header, Footer);
        }

        //Bossbar
        if (BossBarEnabled) {
            if (!plugin.getBar().getBar().getPlayers().contains(player)) {
                plugin.getBar().addPlayer(player);
            }
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
