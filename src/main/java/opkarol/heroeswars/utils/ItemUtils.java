package opkarol.heroeswars.utils;

import opkarol.heroeswars.Heroeswars;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.tags.CustomItemTagContainer;
import org.bukkit.inventory.meta.tags.ItemTagType;

public class ItemUtils {

    public static ItemStack setDataOnItemStack(ItemStack item, String key){
        if(item == null) return null;

        NamespacedKey access = new NamespacedKey(Heroeswars.getPlugin(), key);
        ItemMeta itemMeta = item.getItemMeta();
        assert itemMeta != null;
        itemMeta.getCustomTagContainer().setCustomTag(access, ItemTagType.STRING, "Yes");
        item.setItemMeta(itemMeta);
        return item;
    }

    public static boolean haveItemStackData(ItemStack item, String key){
        if(item == null) return false;

        NamespacedKey access = new NamespacedKey(Heroeswars.getPlugin(), key);
        ItemMeta itemMeta = item.getItemMeta();
        assert itemMeta != null;
        CustomItemTagContainer tagContainer = itemMeta.getCustomTagContainer();

        return tagContainer.hasCustomTag(access, ItemTagType.STRING);
    }
}
