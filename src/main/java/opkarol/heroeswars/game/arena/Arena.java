package opkarol.heroeswars.game.arena;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.List;

public class Arena {
    public String arenaName;
    public int maxPlayers;
    public Location spawn1, spawn2;
    public Location bound1, bound2;
    public boolean currentPlaying;
    public List<Player> currentPlayers;

    public Arena(){
        setArenaName(null);
        setBound1(null);
        setBound2(null);
        setCurrentPlaying(null);
        setCurrentPlayers(null);
        setMaxPlayers(null);
        setSpawn1(null);
        setSpawn2(null);
    }


    public Arena(String arenaName, int maxPlayers, Location spawn1, Location spawn2, Location bound1, Location bound2, boolean currentPlaying, List<Player> currentPlayers){
        setArenaName(arenaName);
        setBound1(bound1);
        setBound2(bound2);
        setCurrentPlayers(currentPlayers);
        setCurrentPlaying(currentPlaying);
        setMaxPlayers(maxPlayers);
        setSpawn1(spawn1);
        setSpawn2(spawn2);
    }
    private final StringBuilder sb;

    {
        sb = new StringBuilder();
    }

    public String getCurrentPlayersName(){
        for (Player player : currentPlayers){
            sb.append(player.getName());
        }
        return sb.toString();
    }

    public boolean isCurrentPlaying() {
        return currentPlaying;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public Location getBound1() {
        return bound1;
    }

    public Location getBound2() {
        return bound2;
    }

    public Location getSpawn1() {
        return spawn1;
    }

    public Location getSpawn2() {
        return spawn2;
    }

    public String getArenaName() {
        return arenaName;
    }

    public void setArenaName(String arenaName) {
        this.arenaName = arenaName;
    }

    public void setBound1(Location bound1) {
        this.bound1 = bound1;
    }

    public void setBound2(Location bounds2) {
        this.bound2 = bounds2;
    }

    public void setCurrentPlaying(Boolean currentPlaying) {
        this.currentPlaying = currentPlaying;
    }

    public void setMaxPlayers(Integer maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public void setSpawn1(Location spawn1) {
        this.spawn1 = spawn1;
    }

    public void setSpawn2(Location spawn2) {
        this.spawn2 = spawn2;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public void setCurrentPlaying(boolean currentPlaying) {
        this.currentPlaying = currentPlaying;
    }

    public List<Player> getCurrentPlayers() {
        return currentPlayers;
    }

    public void setCurrentPlayers(List<Player> currentPlayers) {
        this.currentPlayers = currentPlayers;
    }
}
