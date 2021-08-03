package opkarol.heroeswars.game.arena.database;

import opkarol.heroeswars.game.arena.Arena;
import opkarol.heroeswars.utils.FileUtils;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import java.util.ArrayList;
import java.util.List;

import static opkarol.heroeswars.game.arena.database.ArenaFileGenerator.*;

public class ArenaDatabase {

    private static List<Arena> arenaList = new ArrayList<>();

    public static List<Arena> getArenaList() {
        return arenaList;
    }

    public static void setArenaList(List<Arena> arenaList) {
        ArenaDatabase.arenaList = arenaList;
    }

    public static void addToArenaList(Arena arena){
        arenaList.add(arena);
    }

    public void arenaLoader(){
        String path;
        ConfigurationSection sec = getArenaFile().getConfigurationSection("Arenas");
        if (sec != null) {
            for (String key : sec.getKeys(false)) {
                path = "Arenas." + key + ".";
                addToArenaList(new Arena(key, getArenaFile().getInt(path + "maxPlayers"), (Location) getArenaFile().get(path + "spawn1"), (Location) getArenaFile().get(path + "spawn2"), (Location) getArenaFile().get(path + "bound1"), (Location) getArenaFile().get(path + "bound2"), false, new ArrayList<>()));
            }
        }
    }

    public void saveArenasToFile(){
        String path;
        for (Arena arena : arenaList){
            path = "Arenas." + arena.getArenaName() + ".";
            getArenaFile().set(path + "maxPlayers", arena.getMaxPlayers());
            getArenaFile().set(path + "spawn1", arena.getSpawn1());
            getArenaFile().set(path + "spawn2", arena.getSpawn2());
            getArenaFile().set(path + "bound1", arena.getBound1());
            getArenaFile().set(path + "bound2", arena.getBound2());
            FileUtils.saveCustomYml(getArenaFile(), getArenaFileMain());
        }
    }

    public static Arena getArenaFromList(int number){
        return getArenaList().get(number - 1);
    }

    public static Arena getArenaFromList(String arenaName){
        for (Arena arena : getArenaList()){
            if(arena.getArenaName().equals(arenaName)){
                return arena;
            }
        }
        return null;
    }
}
