package opkarol.heroeswars.game.queue.files;

import opkarol.heroeswars.game.mode.GameMode;
import opkarol.heroeswars.game.queue.Queue;

import java.util.HashMap;

public class QueueDatabase {

    private static HashMap<GameMode, Queue> gameQueue = new HashMap<>();

    public static void addQueueToMap(Queue queue){
        gameQueue.put(queue.getGameMode(), queue);
    }

    public static HashMap<GameMode, Queue> getGameQueue() {
        return gameQueue;
    }

    public static void setGameQueue(HashMap<GameMode, Queue> gameQueue) {
        QueueDatabase.gameQueue = gameQueue;
    }

    public static Queue getQueueFromGameMode(GameMode mode){
        return gameQueue.get(mode);
    }
}
