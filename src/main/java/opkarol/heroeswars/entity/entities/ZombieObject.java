package opkarol.heroeswars.entity.entities;

import opkarol.heroeswars.entity.Entity;
import org.bukkit.Location;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Zombie;

import java.util.Objects;

public class ZombieObject {

    public ZombieObject(Entity entityObject, Location location){
        Zombie zombie = (Zombie) Objects.requireNonNull(location.getWorld()).spawnEntity(location, EntityType.ZOMBIE);

        zombie.setCustomName(entityObject.getName());
        zombie.setCustomNameVisible(true);

        zombie.setBaby(entityObject.isBaby());

        zombie.setRemoveWhenFarAway(false);
        zombie.setAI(true);

        zombie.setMaxHealth(entityObject.getHp());
        zombie.setHealth(entityObject.getHp());

        Objects.requireNonNull(zombie.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED)).setBaseValue(entityObject.getSpeed());

    }

    public ZombieObject(Entity entityObject, Location location, int times){
        for (int i = 0; i < times; i++){
            new ZombieObject(entityObject, location);
        }
    }
}
