package opkarol.heroeswars.game.mode;

import org.bukkit.configuration.ConfigurationSection;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GameDatabase extends FileCreator {

    private static final List<GameMode> gameModeList = new ArrayList<>();
    private static final HashMap<String, GameType> gameTypeList = new HashMap<>();

    public void setLists(){
        setGameTypeList();
        setList();
    }

    public void setList() {
        String path;
        ConfigurationSection sec = getConfiguration().getConfigurationSection("GameModes");
        if (sec != null) {
            for (String key : sec.getKeys(false)) {
               path = "GameModes." + key + ".";
               gameModeList.add(new GameMode(getConfiguration().getString(path + "gameName"), getGameTypeFromList(getConfiguration().getString(path + "gameType")), getConfiguration().getInt(path + "maxPlayers")));
            }
        }
    }

    public void setGameTypeList(){
        String path;
        ConfigurationSection sec = getConfiguration().getConfigurationSection("GameTypes");
        if (sec != null) {
            for (String key : sec.getKeys(false)) {
                path = "GameTypes." + key + ".";
                GameType gameType = getGameTypeFromFile(getConfiguration().getString(path + "gameName"),getConfiguration().getInt(path + "gameLength"));
                gameTypeList.put(gameType.getName(), gameType);
            }
        }
    }

    public static List<GameMode> getGameModeList() {
        return gameModeList;
    }

    public GameType getGameTypeFromFile(String name, int length){
        return new GameType(name, length);
    }

    public GameMode createGameMode(String name, GameType gameType){
        return new GameMode(name, gameType, 2);
    }


    public static void addGameTypeToList(GameType gameType){
        gameTypeList.put(gameType.getName(), gameType);
    }

    public static void addGameModeToList(GameMode gameMode){
        gameModeList.add(gameMode);
    }

    public static void removeGameTypeFromList(GameType gameType){
        gameTypeList.remove(gameType.getName());
    }

    public static void removeGameModeFromList(GameMode gameMode){
        gameModeList.remove(gameMode);
    }

    public static GameType getGameTypeFromList(String name){
        return gameTypeList.get(name);
    }

    public static GameMode getGameModeFromListIndex(int index){
        return gameModeList.get(index);
    }

    @Nullable
    public static GameMode getGameModeFromListString(String gameName){
        for (GameMode gameMode : gameModeList){
            if (gameMode.getGameName().equals(gameName)){
                return gameMode;
            }
        }
        return null;
    }



}
