package opkarol.heroeswars.classes;

import java.util.ArrayList;
import java.util.List;

public class Class {
    public String name;
    public ArrayList<String> lore = new ArrayList<>();
    public boolean visibleInGui;
    public boolean glowing;
    public boolean hiddenAttributes;
    //public items

    public Class(String name2, List<String> lore2, boolean visibleInGui2, int slotInGui2, boolean glowing2, boolean hiddenAttributes2){
        setName(name2);
        setLore((ArrayList<String>) lore2);
        setVisibleInGui(visibleInGui2);
        setGlowing(glowing2);
        setHiddenAttributes(hiddenAttributes2);
    }


    public void setName(String name){
        this.name = name;
    }

    public void setLore(ArrayList<String> lore) {
        this.lore = lore;
    }

    public void setVisibleInGui(boolean visibleInGui) {
        this.visibleInGui = visibleInGui;
    }

    public void setGlowing(boolean glowing) {
        this.glowing = glowing;
    }

    public void setHiddenAttributes(boolean hiddenAttributes){
        this.hiddenAttributes = hiddenAttributes;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getLore() {
        return lore;
    }

    public boolean isVisibleInGui() {
        return visibleInGui;
    }


    public boolean isGlowing() {
        return glowing;
    }

    public boolean isHiddenAttributes() {
        return hiddenAttributes;
    }
}
