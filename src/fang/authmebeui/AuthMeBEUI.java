package fang.authmebeui;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class AuthMeBEUI extends JavaPlugin{
    @Override
    public void onLoad(){

    }

    public static JavaPlugin instance;
    @Override
    public void onEnable(){
        instance = this;

        getLogger().info("============ AuthMeGeyser ==============");
        getLogger().info("Enabling...");
        saveDefaultConfig();
        Bukkit.getPluginManager().registerEvents(new EventListener(), this);
        getLogger().info("Enabled.");
        getLogger().info("========================================");

        try {
            Class.forName("org.geysermc.floodgate.api.FloodgateApi");
        } catch (ClassNotFoundException e) {
            getLogger().warning("Not found Floodgate!");
            Bukkit.getPluginManager().disablePlugin(this);
        }

        try {
            Class.forName("fr.xephi.authme.api.v3.AuthMeApi");
        } catch (ClassNotFoundException e) {
            getLogger().warning("Not found AuthMe!");
            Bukkit.getPluginManager().disablePlugin(this);
        }

    }
    
    @Override
    public void onDisable(){

        getLogger().info("============ AuthMeGeyser ==============");
        getLogger().info("Disabled.");
        getLogger().info("========================================");

    }
}
