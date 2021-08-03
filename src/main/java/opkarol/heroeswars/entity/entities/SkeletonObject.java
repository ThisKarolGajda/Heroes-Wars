package opkarol.heroeswars.entity.entities;

import opkarol.heroeswars.entity.Entity;
import org.bukkit.Location;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Zombie;

import java.util.Objects;

public class SkeletonObject {

    public SkeletonObject(Entity entityObject, Location location){
        Skeleton object = (Skeleton) Objects.requireNonNull(location.getWorld()).spawnEntity(location, EntityType.SKELETON);

        object.setCustomName(entityObject.getName());
        object.setCustomNameVisible(true);

        //object.setBaby(entityObject.isBaby());

        object.setRemoveWhenFarAway(false);
        object.setAI(true);

        object.setMaxHealth(entityObject.getHp());
        object.setHealth(entityObject.getHp());

        Objects.requireNonNull(object.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED)).setBaseValue(entityObject.getSpeed());

    }

    public SkeletonObject(Entity entityObject, Location location, int times){
        for (int i = 0; i < times; i++){
            new SkeletonObject(entityObject, location);
        }
    }
}
