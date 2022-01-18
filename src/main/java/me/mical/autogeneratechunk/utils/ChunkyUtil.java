package me.mical.autogeneratechunk.utils;

import org.bukkit.Bukkit;

public class ChunkyUtil {

    public static boolean generating = false;

    public static boolean start() {
        try {
            //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "wborder world fill 3 208 false");
            //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "wborder fill confirm");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "chunky continue");
            generating = true;
            return true;
        } catch (Throwable e) {
            generating = false;
            return false;
        }
    }

    public static boolean stop() {
        try {
            //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "wborder fill cancel");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "chunky pause");
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
