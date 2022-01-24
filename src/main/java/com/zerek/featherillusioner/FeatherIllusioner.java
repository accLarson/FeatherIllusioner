package com.zerek.featherillusioner;

import com.zerek.featherillusioner.listeners.*;
import org.bukkit.plugin.java.JavaPlugin;

public final class FeatherIllusioner extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new BlockPlaceListener(this),this);
        getServer().getPluginManager().registerEvents(new CreatureSpawnListener(this),this);
        getServer().getPluginManager().registerEvents(new EntityDamageListener(),this);
        getServer().getPluginManager().registerEvents(new EntityDeathListener(this),this);
        getServer().getPluginManager().registerEvents(new EntityTargetLivingEntityListener(),this);
        getServer().getPluginManager().registerEvents(new EntitySpellCastListener(),this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
