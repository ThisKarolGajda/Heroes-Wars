package opkarol.heroeswars.messagesFile;

import opkarol.heroeswars.Heroeswars;
import opkarol.heroeswars.commands.arena.Editor;
import opkarol.heroeswars.commands.money.Executor;
import opkarol.heroeswars.game.money.MoneyLoader;
import opkarol.heroeswars.utils.ColorUtils;
import opkarol.heroeswars.utils.FileUtils;
import opkarol.heroeswars.utils.MoneyUtils;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

import static opkarol.heroeswars.utils.FileUtils.saveCustomYml;

public class FileCreator {

    public FileCreator(){
        setFile();
        saveCustomYml(configuration, file);
    }

    private static final File file = new File(Heroeswars.getPlugin().getDataFolder() + "/messages.yml");
    private static final FileConfiguration configuration = YamlConfiguration.loadConfiguration(file);

    private static String clickOnBlockSpawn;
    private static String successfulSetSpawns;
    private static String successfulSetSpawn1;
    private static String clickOnBlockBound;
    private static String successfulSetBounds;
    private static String successfulSetBound1;

    public void setFile(){
        if (!file.exists()){
            FileUtils.addDefault(configuration, "Money.Executor.dontHavePermission", "&cYou don't have permission to use this command!");
            FileUtils.addDefault(configuration, "Money.Executor.lastArgumentNotInteger", "&cLast argument isn't an Integer!");
            FileUtils.addDefault(configuration, "Money.Executor.targetDoesntExists", "&cTarget dooesn't exists!");
            FileUtils.addDefault(configuration, "Money.Executor.badUsage", "&c/money <player> (set/add/remove) (amount)");
            FileUtils.addDefault(configuration, "Money.MoneyUtils.sendMessage", "&f&l%user% &7have &f&l%money%&7!");
            FileUtils.addDefault(configuration, "Arena.Editor.clickOnBlockSpawn", "&7Click on block that will be spawn ");
            FileUtils.addDefault(configuration, "Arena.Editor.successfulSetSpawns", "&7Spawns was successful set!");
            FileUtils.addDefault(configuration, "Arena.Editor.successfulSetSpawn1", "&7Spawn 1 was successful set!");
            FileUtils.addDefault(configuration, "Arena.Editor.clickOnBlockBound", "&7Click on block that will be bound ");
            FileUtils.addDefault(configuration, "Arena.Editor.successfulSetBounds", "&7Bounds was successful set!");
            FileUtils.addDefault(configuration, "Arena.Editor.successfulSetBound1", "&7Bound 1 was successful set!");
        }
    }

    public void refreshValues(){
        Executor.setBadUsage(getMessage("Money.Executor.badUsage"));
        Executor.setDontHavePermission(getMessage("Money.Executor.dontHavePermission"));
        Executor.setLastArgumentNotInteger(getMessage("Money.Executor.lastArgumentNotInteger"));
        Executor.setTargetDoesntExists(getMessage("Money.Executor.targetDoesntExists"));
        MoneyUtils.setSendMessage(getMessage("Money.MoneyUtils.sendMessage"));
        Editor.setClickOnBlockBound(getMessage("Arena.Editor.clickOnBlockBound"));
        Editor.setClickOnBlockSpawn(getMessage("Arena.Editor.clickOnBlockSpawn"));
        Editor.setSuccessfulSetBound1(getMessage("Arena.Editor.successfulSetBound1"));
        Editor.setSuccessfulSetBounds(getMessage("Arena.Editor.successfulSetBounds"));
        Editor.setSuccessfulSetSpawn1(getMessage("Arena.Editor.successfulSetSpawn1"));
        Editor.setSuccessfulSetSpawns(getMessage("Arena.Editor.successfulSetSpawns"));
    }

    public static File getFile() {
        return file;
    }

    public static FileConfiguration getConfiguration() {
        return configuration;
    }

    public static String getMessage(String path){
        return ColorUtils.formatText(configuration.getString(path));
    }
}
