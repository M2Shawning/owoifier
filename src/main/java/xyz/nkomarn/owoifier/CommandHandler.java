package xyz.nkomarn.owoifier;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;
import java.util.Vector;

public class CommandHandler implements CommandExecutor {

    private final Owoifier plugin;
    private final Vector<UUID> enabledPlayerUUIDs;
    public CommandHandler(Owoifier plugin) {
        this.plugin = plugin;
        this.enabledPlayerUUIDs = plugin.enabledPlayerUUIDs;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "You must be a player to use this command");
            return true;
        }

        final Player p = (Player) sender;
        if ((p.hasPermission("owoifier.use.chat") && plugin.getConfig().getBoolean("use_perms"))||!plugin.getConfig().getBoolean("use_perms")) {
            if((p.hasPermission("owoifier.use.sign") && plugin.getConfig().getBoolean("use_perms"))||!plugin.getConfig().getBoolean("use_perms")) {
                final UUID pUUID = p.getUniqueId();
                if (enabledPlayerUUIDs.contains(pUUID)) {
                    enabledPlayerUUIDs.remove(pUUID);
                } else {
                    enabledPlayerUUIDs.add(pUUID);
                }
            }
        }

        return true;
    }
}