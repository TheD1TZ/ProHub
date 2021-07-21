package net.neromc.prohub.Events;

import net.neromc.prohub.command.commands.SpawnCommand;
import net.neromc.prohub.main;
import net.neromc.prohub.utils.Permissions;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.BlockSpreadEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
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

    //Item entities

    boolean disable_item_drop = pl.getConfig().getBoolean("WorldSettings.disable_item_drop");
    boolean disable_item_pickup = pl.getConfig().getBoolean("WorldSettings.disable_item_pickup");

    //Blocks

    boolean disable_block_break = pl.getConfig().getBoolean("WorldSettings.disable_block_break");
    boolean disable_block_place = pl.getConfig().getBoolean("WorldSettings.disable_block_place");
    boolean disable_block_interact = pl.getConfig().getBoolean("WorldSettings.disable_block_interact");
    boolean disable_block_burn = pl.getConfig().getBoolean("WorldSettings.disable_block_burn");
    boolean disable_block_fire_spread = pl.getConfig().getBoolean("WorldSettings.disable_block_fire_spread");

    //Player
    @EventHandler
    public void hungerLoss(FoodLevelChangeEvent e) {
        if(!e.getEntity().hasPermission(Permissions.WORLD_SETTINGS_BYPASS.getPermission())){
        if(disable_hunger_loss){
            e.setCancelled(true);
            e.setFoodLevel(20);
        }
        if(!disable_hunger_loss){
            e.setCancelled(false);
        }
    }
    }

    @EventHandler
    public void fallDamage(EntityDamageEvent e) {
        if(!e.getEntity().hasPermission(Permissions.WORLD_SETTINGS_BYPASS.getPermission())){
        if(disable_fall_damage) {
            if (e.getCause().equals(EntityDamageEvent.DamageCause.FALL)){
                e.setCancelled(true);
            } else {
                e.setCancelled(false);
            }
        }
    }}

    @EventHandler
    public void playerPvP(EntityDamageByEntityEvent e) {
        if(!e.getEntity().hasPermission(Permissions.WORLD_SETTINGS_BYPASS.getPermission())){
        if(disable_player_pvp) {
            if (e.getDamager() instanceof Player){
                if (e.getEntity() instanceof Player) {
                    e.setCancelled(true);
                }
            }
        }
        if(!disable_player_pvp) {
            if (e.getDamager() instanceof Player){
                if (e.getEntity() instanceof Player) {
                    e.setCancelled(false);
                }
            }
        }
    }}

    @EventHandler
    public void AntiVoid(EntityDamageEvent e) {

        Player player = (Player) e.getEntity();

        if(disable_void_death) {
            if (e.getEntity() instanceof Player) {
                if (e.getCause().equals(EntityDamageEvent.DamageCause.VOID)) {
                    e.setCancelled(true);
                    SpawnCommand.SpawnTeleport(player);
                }
            }
        if(!disable_void_death) {
            if (e.getEntity() instanceof Player) {
                if (e.getCause().equals(EntityDamageEvent.DamageCause.VOID)) {
                    e.setCancelled(false);
                }
            }
        }
    }}

    @EventHandler
    public void fireDamage(EntityDamageEvent e) {
        if(!e.getEntity().hasPermission(Permissions.WORLD_SETTINGS_BYPASS.getPermission())){
        if(disable_fire_damage) {
            if (e.getCause().equals(EntityDamageEvent.DamageCause.FIRE)) {
                e.setCancelled(true);
            }
        }
        if(!disable_fire_damage) {
            if (e.getCause().equals(EntityDamageEvent.DamageCause.FIRE)) {
                e.setCancelled(false);
            }
        }
    }}

    @EventHandler
    public void Drowning(EntityDamageEvent e) {
        if(!e.getEntity().hasPermission(Permissions.WORLD_SETTINGS_BYPASS.getPermission())){
        if(disable_drowning) {
            if (e.getCause().equals(EntityDamageEvent.DamageCause.DROWNING)) {
                e.setCancelled(true);
                }
            }
        if(!disable_drowning) {
            if (e.getCause().equals(EntityDamageEvent.DamageCause.DROWNING)) {
                e.setCancelled(false);
            }
        }
    }}

    //Misc

    @EventHandler
    public void weatherChange(WeatherChangeEvent e) {
        if(disable_weather_change) {
            e.setCancelled(true);
        }
        if(!disable_weather_change) {
            e.setCancelled(false);
        }
    }

    @EventHandler
    public void deathMessage(PlayerDeathEvent e) {
        if(!e.getEntity().hasPermission(Permissions.WORLD_SETTINGS_BYPASS.getPermission())){
        if(disable_death_message) {
            e.setDeathMessage("");
        }
        if(!disable_death_message) {
            return;
        }
    }}


    //Item entities

    @EventHandler
    public void itemDropped(PlayerDropItemEvent e) {
        if(!e.getPlayer().hasPermission(Permissions.WORLD_SETTINGS_BYPASS.getPermission())){
        if(disable_item_drop) {
            e.setCancelled(true);
        }
        if(!disable_item_drop) {
            e.setCancelled(false);
        }
    }}

    @EventHandler
    public void itemPickedUp(PlayerPickupItemEvent e) {
        if(!e.getPlayer().hasPermission(Permissions.WORLD_SETTINGS_BYPASS.getPermission())){
        if(disable_item_pickup) {
            e.setCancelled(true);
        }
        if(!disable_item_pickup) {
            e.setCancelled(false);
        }
    }}

    //Blocks

    @EventHandler
    public void blockBreak(BlockBreakEvent e) {
        if(!e.getPlayer().hasPermission(Permissions.WORLD_SETTINGS_BYPASS.getPermission())){
        if(disable_block_break) {
            e.setCancelled(true);
        }
        if(!disable_block_break) {
            e.setCancelled(false);
        }
    }}

    @EventHandler
    public void blockPlace(BlockPlaceEvent e) {
        if(!e.getPlayer().hasPermission(Permissions.WORLD_SETTINGS_BYPASS.getPermission())){
        if(disable_block_place) {
            e.setCancelled(true);
        }
        if(!disable_block_place) {
            e.setCancelled(false);
        }
    }}

    @EventHandler
    public void blockInteraction(PlayerInteractEvent e) {
        if(!e.getPlayer().hasPermission(Permissions.WORLD_SETTINGS_BYPASS.getPermission())){
        if(disable_block_interact) {
            e.setCancelled(true);
        }
        if(!disable_block_interact) {
            e.setCancelled(false);
        }
    }}

    @EventHandler
    public void blockBurn(BlockBurnEvent e) {
        if(disable_block_burn) {
            e.setCancelled(true);
        }
        if(!disable_block_burn) {
            e.setCancelled(false);
        }
    }

    @EventHandler
    public void blockFireSpread(BlockSpreadEvent e) {
        if(disable_block_fire_spread) {
            e.setCancelled(true);
        }
        if(!disable_block_fire_spread) {
            e.setCancelled(false);
        }
    }

}


