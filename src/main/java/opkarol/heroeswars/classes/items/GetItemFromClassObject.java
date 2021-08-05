package opkarol.heroeswars.classes.items;

import opkarol.heroeswars.classes.Class;
import opkarol.heroeswars.classes.database.ClassFileGenerator;
import opkarol.heroeswars.utils.ColorUtils;
import opkarol.heroeswars.utils.ItemUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GetItemFromClassObject {
    public static String key = ClassFileGenerator.getConfigurationSettings().getString("Secret-Key"); //if key is on item -> its visible

    public ItemStack getItemFromClass(Class classObject) {
        if (classObject.isVisibleInGui()) {
            Material mat = null;
            if (classObject.getMaterial() == null) return null;

            mat = classObject.getMaterial();
            ItemStack item = new ItemStack(mat);
            ItemMeta meta = item.getItemMeta();

            assert meta != null;

            meta.setDisplayName(ColorUtils.formatText(classObject.getName()));
            meta.setLore(ColorUtils.formatList(classObject.getLore()));

            if (classObject.isGlowing()) meta.addEnchant(Enchantment.BINDING_CURSE, 1, true);
            if (classObject.isHiddenAttributes()) {
                meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            }

            item.setItemMeta(meta);

            return ItemUtils.setDataOnItemStack(item, key);
        }

        return null;

    }
}
