package me.mical.autogeneratechunk;

import me.mical.autogeneratechunk.task.AutoRefresher;
import org.bukkit.plugin.java.JavaPlugin;

public final class AutoGenerateChunk extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        new AutoRefresher();
        getLogger().info("插件已加载，应用于 StarrySky 服务器。");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("插件已卸载。");
    }
}
