package me.mical.autogeneratechunk;

import me.mical.autogeneratechunk.task.AutoRefresher;
import org.bukkit.plugin.java.JavaPlugin;

public final class AutoGenerateChunk extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        new AutoRefresher();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
