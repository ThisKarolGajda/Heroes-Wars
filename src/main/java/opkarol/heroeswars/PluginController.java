package opkarol.heroeswars;

import opkarol.heroeswars.classes.database.ClassFileGenerator;
import opkarol.heroeswars.commands.classes.Executor;
import opkarol.heroeswars.entity.database.EntityFileGenerator;
import opkarol.heroeswars.entity.database.EntitySaver;
import opkarol.heroeswars.game.arena.database.ArenaFileGenerator;
import opkarol.heroeswars.game.arena.editor.inventory.EditorInventory;
import opkarol.heroeswars.game.arena.editor.inventory.events.PlayerBlockInventoryMovement;
import opkarol.heroeswars.game.arena.editor.inventory.events.PlayerBreakBlockEvent;
import opkarol.heroeswars.game.mode.GameDatabase;
import opkarol.heroeswars.game.money.events.PlayerJoiningServer;
import opkarol.heroeswars.game.queue.QueueStarter;
import opkarol.heroeswars.messagesFile.FileCreator;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

import java.util.Objects;

public class PluginController {

    public PluginController() {
        initalize();
    }

    protected void initalize() {
        registerCommands();
        registerEvents();
        generateFiles();
        new EntitySaver().loadHashMap();
        new QueueStarter();
    }

    protected void registerCommands() {
        Objects.requireNonNull(Heroeswars.getPlugin().getCommand("class")).setExecutor(new Executor());
        Objects.requireNonNull(Heroeswars.getPlugin().getCommand("entity")).setExecutor(new opkarol.heroeswars.commands.entity.Executor());
        Objects.requireNonNull(Heroeswars.getPlugin().getCommand("arena")).setExecutor(new opkarol.heroeswars.commands.arena.Executor());
        Objects.requireNonNull(Heroeswars.getPlugin().getCommand("arenaeditor")).setExecutor(new opkarol.heroeswars.commands.arena.Editor());
        Objects.requireNonNull(Heroeswars.getPlugin().getCommand("money")).setExecutor(new opkarol.heroeswars.commands.money.Executor());
        Objects.requireNonNull(Heroeswars.getPlugin().getCommand("play")).setExecutor(new opkarol.heroeswars.commands.play.Executor());
    }

    protected void registerEvents() {
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new PlayerBlockInventoryMovement(), Heroeswars.getPlugin());
        pluginManager.registerEvents(new PlayerBreakBlockEvent(), Heroeswars.getPlugin());
        pluginManager.registerEvents(new PlayerJoiningServer(), Heroeswars.getPlugin());
    }

    protected void generateFiles(){
        new ClassFileGenerator();
        new EntityFileGenerator();
        new ArenaFileGenerator();
        new FileCreator().refreshValues();
        new GameDatabase().setLists();

    }

}
