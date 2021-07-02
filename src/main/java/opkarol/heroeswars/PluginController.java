package opkarol.heroeswars;

import opkarol.heroeswars.classes.database.ClassFileGenerator;
import opkarol.heroeswars.commands.classes.Executor;
import opkarol.heroeswars.entity.database.EntitySaver;

import java.util.Objects;

public class PluginController {

    public PluginController() {
        initalize();
    }

    protected void initalize() {
        registerCommands();
        registerEvents();
        new ClassFileGenerator();
        new EntitySaver().loadHashMap();
    }

    protected void registerCommands() {
        Objects.requireNonNull(Heroeswars.getPlugin().getCommand("class")).setExecutor(new Executor());
    }

    protected void registerEvents() {

    }

}