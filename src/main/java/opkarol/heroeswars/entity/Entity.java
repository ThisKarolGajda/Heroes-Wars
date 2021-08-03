package opkarol.heroeswars.entity;

public class Entity {

    //Hp, speed, name(tag), effects, entity type
    public String name;
    public double speed;
    public int hp; //20hp = 10 hearts, 0,5 heart = 1hp
    public String type;
    public boolean baby; //true = baby

    public Entity(String name2, double speed2, int hp2, String type2, boolean baby2) {
        setName(name2);
        setSpeed(speed2);
        setHp(hp2);
        setType(type2);
        setBaby(baby2);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setBaby(boolean baby) {
        this.baby = baby;
    }

    public String getName() {
        return name;
    }

    public double getSpeed() {
        return speed;
    }

    public int getHp() {
        return hp;
    }

    public String getType() {
        return type;
    }

    public boolean isBaby() {
        return baby;
    }
}
