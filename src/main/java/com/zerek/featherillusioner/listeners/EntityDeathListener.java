package com.zerek.featherillusioner.listeners;

import com.zerek.featherillusioner.FeatherIllusioner;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.sound.Sound;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Illusioner;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class EntityDeathListener implements Listener {

    private final FeatherIllusioner plugin;

    public EntityDeathListener(FeatherIllusioner plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event){
        if (event.getEntity() instanceof Illusioner){
            event.getDrops().add(new ItemStack(Material.TOTEM_OF_UNDYING,1));
            event.setDroppedExp(500);
            Location loc = event.getEntity().getLocation();
            plugin.getServer().playSound(Sound.sound(Key.key("entity.strider.death"), Sound.Source.HOSTILE, 1f, 0.4f));
            plugin.getServer().playSound(Sound.sound(Key.key("entity.lightning_bolt.thunder"), Sound.Source.HOSTILE, 1f, 0.2f));
        }
    }
}
