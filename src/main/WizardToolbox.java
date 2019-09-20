import net.milkbowl.vault.permission.Permission;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class WizardToolbox extends JavaPlugin {

    private Permission permissions;
    private 

    @Override
    public void onEnable() {
        setupPermissions();





        initModules();
    }

    @Override
    public void onDisable() {

    }

    private boolean setupPermissions() {
        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
        permissions = rsp.getProvider();
        return permissions != null;
    }

    private void initModules(){
        
    }
}
