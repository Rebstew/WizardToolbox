package modules;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public abstract class AbstractModule implements Listener, CommandExecutor {

    protected static String moduleName = "defaultModule";

    public AbstractModule(JavaPlugin plugin){
        registerCommands(getCommands(), plugin);
    }

    public abstract List<String> getCommands();


    private void registerCommands(List<String> commandList, JavaPlugin plugin){
        for(String commandName : commandList){
            plugin.getCommand(commandName).setExecutor(this);
        }
    }

    public static String getModuleName(){
        return moduleName;
    }
}
