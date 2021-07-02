package opkarol.heroeswars.classes.database;

import opkarol.heroeswars.Heroeswars;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

import static opkarol.heroeswars.utils.FileUtils.*;

public class ClassFileGenerator {
    protected String key = "secret-key";
    protected String guiName = "&b&lClasses";
    protected int guiSize = 27;

    public ClassFileGenerator(){
        saveCustomYml(configuration, classFile);
        setConfigurationSettings();
        saveCustomYml(configurationSettings, classFileSettings);
    }

    private static final File classFile = new File(Heroeswars.getPlugin().getDataFolder() + "/classes/class.yml");
    private static final FileConfiguration configuration = YamlConfiguration.loadConfiguration(classFile);

    public static FileConfiguration getConfiguration(){
        return configuration;
    }

    private static final File classFileSettings = new File(Heroeswars.getPlugin().getDataFolder() + "/classes/classSettings.yml");
    private static final FileConfiguration configurationSettings = YamlConfiguration.loadConfiguration(classFileSettings);


    public void setConfigurationSettings(){
        if(!classFileSettings.exists()){
            setObject(configurationSettings, "Secret-Key", key);
            setObject(configurationSettings, "Gui.name", guiName);
            setObject(configurationSettings, "Gui.size", guiSize);
            addDefault(configurationSettings, "Secret-Key", key);
            addDefault(configurationSettings, "Gui.name", guiName);
            addDefault(configurationSettings, "Gui.size", guiSize);
        }
    }

    public static FileConfiguration getConfigurationSettings(){
        return configurationSettings;
    }
}
