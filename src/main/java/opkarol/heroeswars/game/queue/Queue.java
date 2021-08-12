package opkarol.heroeswars.game.queue;

import opkarol.heroeswars.game.mode.GameMode;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Queue {
    private List<Player> playerQueue = new ArrayList<>();
    private GameMode gameMode;

    public Queue(List<Player> playerQueue, GameMode gameMode){
        setGameMode(gameMode);
        setPlayerQueue(playerQueue);
    }

    public boolean isQueueEmpty(){
        return playerQueue.isEmpty();
    }

    @Nullable
    public Player getFirstPlayerFromQueue(){
        if(isQueueEmpty()) return null;
        getPlayerQueue().remove(0);
        return getPlayerQueue().get(0);
    }

    public GameMode getGameMode() {
        return gameMode;
    }

    public List<Player> getPlayerQueue() {
        return playerQueue;
    }

    public void setGameMode(GameMode gameMode) {
        this.gameMode = gameMode;
    }

    public void setPlayerQueue(List<Player> playerQueue) {
        this.playerQueue = playerQueue;
    }
}
