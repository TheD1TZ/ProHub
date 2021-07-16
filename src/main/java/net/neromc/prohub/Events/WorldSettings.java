package net.neromc.prohub.Events;

import net.neromc.prohub.main;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

public class WorldSettings implements Listener {

    Plugin pl = main.getPlugin(main.class);

    //Player

    boolean disable_hunger_loss = pl.getConfig().getBoolean("WorldSettings.disable_hunger_loss");
    boolean disable_fall_damage = pl.getConfig().getBoolean("WorldSettings.disable_fall_damage");
    boolean disable_player_pvp = pl.getConfig().getBoolean("WorldSettings.disable_player_pvp");
    boolean disable_void_death = pl.getConfig().getBoolean("WorldSettings.disable_void_death");
    boolean disable_fire_damage = pl.getConfig().getBoolean("WorldSettings.disable_fire_damage");
    boolean disable_drowning = pl.getConfig().getBoolean("WorldSettings.disable_drowning");

    //Misc

    boolean disable_weather_change = pl.getConfig().getBoolean("WorldSettings.disable_weather_change");
    boolean disable_death_message = pl.getConfig().getBoolean("WorldSettings.disable_death_message");
    boolean disable_mob_spawning = pl.getConfig().getBoolean("WorldSettings.disable_mob_spawning");

    //Item entities

    boolean disable_item_drop = pl.getConfig().getBoolean("WorldSettings.disable_item_drop");
    boolean disable_item_pickup = pl.getConfig().getBoolean("WorldSettings.disable_item_pickup");

    //Blocks

    boolean disable_block_break = pl.getConfig().getBoolean("WorldSettings.disable_block_break");
    boolean disable_block_place = pl.getConfig().getBoolean("WorldSettings.disable_block_place");
    boolean disable_block_interact = pl.getConfig().getBoolean("WorldSettings.disable_block_interact");
    boolean disable_block_burn = pl.getConfig().getBoolean("WorldSettings.disable_block_burn");
    boolean disable_block_fire_spread = pl.getConfig().getBoolean("WorldSettings.disable_block_fire_spread");
}
