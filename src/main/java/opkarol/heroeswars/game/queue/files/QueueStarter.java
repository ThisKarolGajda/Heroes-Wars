package opkarol.heroeswars.game.queue.files;

import opkarol.heroeswars.game.mode.GameMode;
import opkarol.heroeswars.game.queue.Queue;

import java.util.ArrayList;

import static opkarol.heroeswars.game.mode.GameDatabase.*;

public class QueueStarter extends QueueDatabase {
   public QueueStarter(){
       runQueues();
   }

    public void runQueues(){
        for (GameMode gameMode : getGameModeList()){
            addQueueToMap(new Queue(new ArrayList<>(), gameMode));
        }
    }
}
