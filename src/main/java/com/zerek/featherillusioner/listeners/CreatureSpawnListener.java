package com.zerek.featherillusioner.listeners;

import com.zerek.featherillusioner.FeatherIllusioner;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class CreatureSpawnListener implements Listener {
    private final FeatherIllusioner plugin;

    public CreatureSpawnListener(FeatherIllusioner plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent event){
        if (event.getEntity() instanceof WanderingTrader && (Objects.equals(event.getSpawnReason().toString(), "NATURAL"))){

            Location spawnLoc = event.getLocation();
            event.getEntity().remove();
            WanderingTrader wanderingTrader = (WanderingTrader) spawnLoc.getWorld().spawnEntity(spawnLoc, EntityType.WANDERING_TRADER, CreatureSpawnEvent.SpawnReason.COMMAND);
            wanderingTrader.getEquipment().setItemInOffHand(new ItemStack(Material.LEAD));
            TraderLlama traderLlama1 = (TraderLlama) spawnLoc.getWorld().spawnEntity(spawnLoc, EntityType.TRADER_LLAMA, CreatureSpawnEvent.SpawnReason.COMMAND);
            traderLlama1.setLeashHolder(wanderingTrader);
            TraderLlama traderLlama2 = (TraderLlama) spawnLoc.getWorld().spawnEntity(spawnLoc, EntityType.TRADER_LLAMA, CreatureSpawnEvent.SpawnReason.COMMAND);
        }
    }
}
