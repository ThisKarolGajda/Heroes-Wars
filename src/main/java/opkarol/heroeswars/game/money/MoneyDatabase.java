package opkarol.heroeswars.game.money;

import java.util.HashMap;
import java.util.UUID;

public class MoneyDatabase {

    public static HashMap<UUID, Integer> moneyMap = new HashMap<>();

    public static void addPlayerToMap(UUID player, int money){
        moneyMap.put(player, money);
    }

    public static void addPlayerMoney(UUID player, int money){
        moneyMap.replace(player, getPlayerMoney(player) + money);
    }

    public static void setPlayerMoney(UUID player, int money){
        moneyMap.replace(player, money);
    }

    public static void removePlayerFromMap(UUID player){
        moneyMap.remove(player);
    }

    public static void removePlayerMoney(UUID player){
        moneyMap.replace(player, 0);
    }

    public static int getPlayerMoney(UUID player){
        if(playerBankAccountExists(player)) return moneyMap.get(player);
        return 0;
    }

    public static void changePlayerOfMoney(UUID giving, UUID getting){
        int money = getPlayerMoney(giving);
        removePlayerMoney(giving);
        moneyMap.replace(getting, getPlayerMoney(getting) + money);
    }

    public static void setMoneyMap(HashMap<UUID, Integer> moneyMap) {
        MoneyDatabase.moneyMap = moneyMap;
    }

    public static HashMap<UUID, Integer> getMoneyMap() {
        return moneyMap;
    }

    public static boolean playerBankAccountExists(UUID player){
        return moneyMap.containsKey(player);
    }
}
