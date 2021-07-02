package opkarol.heroeswars.classes.gui;

import opkarol.heroeswars.classes.Class;
import opkarol.heroeswars.classes.database.ClassFileGenerator;
import opkarol.heroeswars.classes.gui.holder.ClassesMainHolder;
import opkarol.heroeswars.classes.items.GetItemFromClassObject;
import opkarol.heroeswars.utils.ColorUtils;
import opkarol.heroeswars.utils.ItemUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ClassesMainGui {
    String guiTitle = ClassFileGenerator.getConfigurationSettings().getString("Gui.name");
    List<Class> list = new ArrayList<>();

    public ClassesMainGui(List<Class> list){
        this.list = list;
        setGui();
    }

    public Inventory gui = Bukkit.createInventory(new ClassesMainHolder(), ClassFileGenerator.getConfigurationSettings().getInt("Gui.size"), Objects.requireNonNull(ColorUtils.formatText(guiTitle)));

    public void setGui(){
        int i = 0; //index of current slot

        for(Class object : list){
            ItemStack item = new GetItemFromClassObject().getItemFromClass(Material.BEDROCK, object);
            if(ItemUtils.haveItemStackData(item, GetItemFromClassObject.key)) {
                gui.setItem(i, item);
                i++;
            }
        }

    }
}
