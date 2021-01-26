package me.mical.autogeneratechunk.utils;

import org.bukkit.Bukkit;

public class WorldBorderUtil {

    public static boolean generating = false;

    public static boolean start() {
        try {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "wborder world fill 3 208 false");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "wborder fill confirm");
            generating = true;
            return true;
        } catch (Throwable e) {
            generating = false;
            return false;
        }
    }

    public static boolean stop() {
        try {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "wborder fill cancel");
            generating = false;
            return true;
        } catch (Throwable e) {
            generating = true;
            return false;
        }
    }

    public static void setState(boolean state) {
        generating = state;
    }

    public static boolean getState() {
        return generating;
    }
}
