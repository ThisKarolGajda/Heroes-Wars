package opkarol.heroeswars.classes.database;

import opkarol.heroeswars.Informator;
import opkarol.heroeswars.classes.Class;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class ClassSaver {

    FileConfiguration configuration = ClassFileGenerator.getConfiguration();

    List<Class> classList = new ArrayList<>();

    public ClassSaver() {
        ConfigurationSection sec = configuration.getConfigurationSection("Classes");
        if (sec != null) {
            for (String key : sec.getKeys(false)) {
                String path = "Classes." + key + ".";
                if (Informator.isDebugModeActive())Bukkit.broadcastMessage(Objects.requireNonNull(configuration.getString(path + "material")));
                classList.add(new Class(configuration.getString(path + "name"), configuration.getStringList(path + "lore"), configuration.getBoolean(path + "visibleInGui"), configuration.getInt(path + "slotInGui"), configuration.getBoolean(path + "glowing"), configuration.getBoolean(path + "hiddenAttributes"), Material.getMaterial(Objects.requireNonNull(configuration.getString(path + "material")))));
            }
        }
    }

    public List<Class> getClassList() {
        return this.classList;
    }


}

/*

 */
