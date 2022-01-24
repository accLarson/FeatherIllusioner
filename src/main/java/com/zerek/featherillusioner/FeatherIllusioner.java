package com.zerek.featherillusioner;

import com.zerek.featherillusioner.listeners.BlockPlaceListener;
import com.zerek.featherillusioner.listeners.CreatureSpawnListener;
import com.zerek.featherillusioner.listeners.EntityDamageListener;
import com.zerek.featherillusioner.listeners.EntityDeathListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class FeatherIllusioner extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new BlockPlaceListener(this),this);
        getServer().getPluginManager().registerEvents(new CreatureSpawnListener(this),this);
        getServer().getPluginManager().registerEvents(new EntityDamageListener(),this);
        getServer().getPluginManager().registerEvents(new EntityDeathListener(this),this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
