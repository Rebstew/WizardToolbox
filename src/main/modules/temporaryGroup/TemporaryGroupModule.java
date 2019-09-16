package modules.temporaryGroup;

import modules.AbstractModule;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class TemporaryGroupModule extends AbstractModule {

    private Permission permissions;

    public TemporaryGroupModule(Permission permissions, JavaPlugin plugin){
        super(plugin);
        this.permissions = permissions;
    }

    /**
     * usage:   /tempgroups for self
     *          /tempgroups <playerName> for other players
     * @param sender
     * @param cmd
     * @param label
     * @param args
     * @return
     */
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        String playerName = "";
        if(args.length == 0 && sender instanceof Player){
            String playerName = sender.getName();
        } else if(args.length > 0){
            String playerName = args[0];
        } else {
            sender.sendMessage("Console may only use it with a player name: /tempgroups <player>");
            return true;
        }

        OfflinePlayer player = Bukkit.getOfflinePlayer(playerName);
        Set<PermissionAttachmentInfo> playerPermissions = player.getPlayer().getEffectivePermissions();

        for(PermissionAttachmentInfo playerPermission : playerPermissions){
          System.out.println(playerPermission.getPermission());
        }


        return true;
    }

    @Override
    public List<String> getCommands() {
        return Arrays.asList("tempgroups");
    }
}
