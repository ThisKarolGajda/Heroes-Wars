package opkarol.heroeswars;

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
        heroesWars = null;
    }

    public static Heroeswars getPlugin() {
        return heroesWars;
    }

    public static PluginController getPluginController(){
        return pluginController;
    }
}
