package opkarol.heroeswars;

import opkarol.heroeswars.game.arena.database.ArenaDatabase;
import org.bukkit.plugin.java.JavaPlugin;

public final class Heroeswars extends JavaPlugin {
    static PluginController pluginController;
    static Heroeswars heroesWars;

    @Override
    public void onEnable() {
        heroesWars = this;
        pluginController = new PluginController();
    }

    @Override
    public void onDisable() {
        new ArenaDatabase().saveArenasToFile();
        heroesWars = null;
    }

    public static Heroeswars getPlugin() {
        return heroesWars;
    }

    public static PluginController getPluginController() {
        return pluginController;
    }
}
