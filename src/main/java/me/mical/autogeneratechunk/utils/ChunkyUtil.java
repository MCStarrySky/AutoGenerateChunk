package me.mical.autogeneratechunk.utils;

import me.mical.autogeneratechunk.AutoGenerateChunk;
import org.bukkit.Bukkit;

public class ChunkyUtil {

    private static boolean generating = false;

    public static void start() {
        try {
            if (AutoGenerateChunk.NEW_TASK) {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "chunky world example");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "chunky center 0 0");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "chunky start");
                AutoGenerateChunk.setNewTask(false);
            } else {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "chunky continue");
            }
            generating = true;
        } catch (Throwable e) {
            generating = false;
        }
    }

    public static void stop() {
        try {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "chunky pause");
            generating = false;
        } catch (Throwable e) {
            generating = true;
        }
    }

    public static void setState(boolean state) {
        generating = state;
    }

    public static boolean getState() {
        return generating;
    }
}
