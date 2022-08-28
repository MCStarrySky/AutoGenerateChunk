package me.mical.autogeneratechunk;

import me.mical.autogeneratechunk.task.AutoRefresher;
import org.bukkit.plugin.java.JavaPlugin;

public final class AutoGenerateChunk extends JavaPlugin {

    public static boolean NEW_TASK;

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
        NEW_TASK = getConfig().getBoolean("NewTask", true);
        new AutoRefresher();
        getLogger().info("插件已加载，应用于 StarrySky 服务器。");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("插件已卸载。");
    }

    public static void setNewTask(boolean newTask) {
        NEW_TASK = newTask;
        final JavaPlugin plugin = JavaPlugin.getPlugin(AutoGenerateChunk.class);
        plugin.getConfig().set("NewTask", newTask);
        plugin.saveConfig();
    }
}
