package opkarol.heroeswars.classes.saver;

import opkarol.heroeswars.classes.Class;
import opkarol.heroeswars.classes.database.ClassFileGenerator;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.ArrayList;
import java.util.List;


public class ClassSaver {

    FileConfiguration configuration = ClassFileGenerator.getConfiguration();

    List<Class> classList = new ArrayList<>();

    public ClassSaver(){
        ConfigurationSection sec = configuration.getConfigurationSection("Classes");
        if (sec != null) {
            for (String key : sec.getKeys(false)) {
                String path = "Classes." + key + ".";
                classList.add(new Class(configuration.getString(path + "name"), configuration.getStringList(path + "lore"), configuration.getBoolean(path + "visibleInGui"), configuration.getInt(path + "slotInGui"), configuration.getBoolean(path + "glowing"), configuration.getBoolean(path + "hiddenAttributes")));
            }
        }
    }

    public List<Class> getClassList(){
        return this.classList;
    }




}

/*
Classes:
  Class1:
    name: '&b&lWarrior'
    lore:
    - ''
    - '&0&m&l-----------------'
    - '&6&lLegendary class'
    - '&7Special abilites'
    - '&0&m&l-----------------'
    - '&eOnly this day this'
    - '&eclass is very cheap'
    - ''
    - '&9&l50$ &8&m120$'
    visibleInGui: true
    glowing: false
    hiddenAttributes: true


1. Name
2. List lore
3. visible in gui
4. glowing
5. hidden attributes
 */
