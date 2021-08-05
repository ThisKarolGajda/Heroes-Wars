package opkarol.heroeswars;

import opkarol.heroeswars.game.arena.database.ArenaDatabase;
import opkarol.heroeswars.game.money.MoneyLoader;
import org.bukkit.plugin.java.JavaPlugin;

public final class Heroeswars extends JavaPlugin {
    static PluginController pluginController;
    static Heroeswars heroesWars;

    @Override
    public void onEnable() {
        heroesWars = this;
        pluginController = new PluginController();
        MoneyLoader.onStart();
    }

    @Override
    public void onDisable() {
        new ArenaDatabase().saveArenasToFile();
        MoneyLoader.onDisable();
        heroesWars = null;
    }

    public static Heroeswars getPlugin() {
        return heroesWars;
    }

    public static PluginController getPluginController() {
        return pluginController;
    }
}
