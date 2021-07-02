package opkarol.heroeswars;

import opkarol.heroeswars.classes.database.ClassFileGenerator;
import opkarol.heroeswars.commands.classes.Executor;

import java.util.Objects;

public class PluginController {

    public PluginController(){
        initalize();
    }

    protected void initalize(){
        registerCommands();
        registerEvents();
        new ClassFileGenerator();
    }

    protected void registerCommands(){
        Objects.requireNonNull(Heroeswars.getPlugin().getCommand("class")).setExecutor(new Executor());
    }

    protected void registerEvents(){

    }

}
