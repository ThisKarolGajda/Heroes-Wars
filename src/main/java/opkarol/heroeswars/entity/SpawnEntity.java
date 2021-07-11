package opkarol.heroeswars.entity;

import opkarol.heroeswars.entity.entities.ZombieObject;
import org.bukkit.Location;

public class SpawnEntity {

    public void spawnEntity(Location location, Entity object){
        String type = String.valueOf(object.getType());
        switch (type.toLowerCase()){
            case "zombie":
                new ZombieObject(object, location);
                break;
            case "skeleton":
                break;
        }
    }

    public void spawnEntity(Location location, Entity object, int times){
        String type = String.valueOf(object.getType());
        switch (type.toLowerCase()){
            case "zombie":
                new ZombieObject(object, location, times);
                break;
            case "skeleton":
                break;
        }
    }
}
