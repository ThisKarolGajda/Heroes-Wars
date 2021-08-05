package opkarol.heroeswars.game.money;

import opkarol.heroeswars.Heroeswars;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MoneyLoader extends MoneyDatabase implements Serializable {
    static Currency currency;

    public MoneyLoader(){
        currency = new Currency("", "", 1000);

    }

    public static void onStart(){
        try {
            moneyMap = readFile();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void onDisable(){
        try {
            saveFile(moneyMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static final String PATH = Heroeswars.getPlugin().getDataFolder().getPath() + "/money/database.txt";

    private static void saveFile(HashMap<UUID, Integer> users)
            throws IOException
    {
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(PATH))) {
            os.writeObject(users);
        }
    }

    private static HashMap<UUID, Integer> readFile()
            throws ClassNotFoundException, IOException
    {
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(PATH))) {
            return (HashMap<UUID, Integer>) is.readObject();
        }
    }

    public static Currency getCurrencyClass(){
        return currency;
    }

}
