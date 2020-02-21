package me.puyodead1.cosmiclms;

import org.bukkit.Location;

import java.util.HashMap;
import java.util.Objects;

public class Arena {

    private String arenaName;
    private Location arenaCenter;
    private Location arenaMax;
    private Location arenaMin;

    public static HashMap<String, Arena> arenas = new HashMap<>();

    public Arena(String arenaName) {
        this.arenaName = arenaName;

        arenas.put(arenaName, this);
    }

    public String getArenaName() {
        return arenaName;
    }

    public static HashMap<String, Arena> getArenas() {
        return arenas;
    }

    public Location getArenaMax() {
        return arenaMax;
    }

    public void setArenaMax(Location arenaMax) {
        this.arenaMax = arenaMax;

        updateArena(arenaName, this);
    }

    public Location getArenaMin() {
        return arenaMin;
    }

    public void setArenaMin(Location arenaMin) {
        this.arenaMin = arenaMin;

        updateArena(arenaName, this);
    }

    public Location getArenaCenter() {
        return arenaCenter;
    }

    public void setArenaCenter(Location arenaCenter) {
        this.arenaCenter = arenaCenter;
    }

    public void updateArena(String key, Arena value) {
        getArenas().put(key, value);
    }

    public boolean hasCenter() {
        return Objects.isNull(this.arenaCenter);
    }

    public boolean hasMax() {
        return Objects.isNull(this.arenaMax);
    }

    public boolean hasMin() {
        return Objects.isNull(this.arenaMin);
    }
}
