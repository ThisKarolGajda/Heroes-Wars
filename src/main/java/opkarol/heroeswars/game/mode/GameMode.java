package opkarol.heroeswars.game.mode;

public class GameMode {
    private String gameName;
    private GameType gameType;
    private int maxPlayers;

    public GameMode(String gameName2, GameType gameType2, int maxPlayers2){
        setGameType(gameType2);
        setGameName(gameName2);
        setMaxPlayers(maxPlayers2);
    }

    public String getGameName() {
        return gameName;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public GameType getGameType() {
        return gameType;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public void setGameType(GameType gameType) {
        this.gameType = gameType;
    }
}
