package me.mical.autogeneratechunk.task;

import me.mical.autogeneratechunk.AutoGenerateChunk;
import me.mical.autogeneratechunk.utils.ChunkyUtil;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class AutoRefresher {

    public AutoRefresher() {
        new BukkitRunnable() {

            /**
             * When an object implementing interface <code>Runnable</code> is used
             * to create a thread, starting the thread causes the object's
             * <code>run</code> method to be called in that separately executing
             * thread.
             * <p>
             * The general contract of the method <code>run</code> is that it may
             * take any action whatsoever.
             *
             * @see Thread#run()
             */
            @Override
            public void run() {
                int size = Bukkit.getOnlinePlayers().size();
                if (size == 0) {
                    if (!ChunkyUtil.getState()) {
                        Bukkit.getScheduler().runTask(JavaPlugin.getPlugin(AutoGenerateChunk.class), ChunkyUtil::start);
                        ChunkyUtil.setState(true);
                        JavaPlugin.getPlugin(AutoGenerateChunk.class).getLogger().info("Task Enabled.");
                    }
                } else {
                    if (ChunkyUtil.getState()) {
                        Bukkit.getScheduler().runTask(JavaPlugin.getPlugin(AutoGenerateChunk.class), ChunkyUtil::stop);
                        ChunkyUtil.setState(false);
                        JavaPlugin.getPlugin(AutoGenerateChunk.class).getLogger().info("Task Disabled.");
                    }
                }
            }
        }.runTaskTimerAsynchronously(JavaPlugin.getPlugin(AutoGenerateChunk.class), 20L, 20L);
    }
}
