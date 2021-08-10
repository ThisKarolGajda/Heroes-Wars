package opkarol.heroeswars.game.mode;

public class GameType {
    private String name;
    private int length;

    public GameType(String name, int length){
        this.name = name;
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
