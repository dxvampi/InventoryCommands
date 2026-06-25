package ic.dxvampi.inventoryCommands.utils;

import ic.dxvampi.inventoryCommands.InventoryCommands;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.TabCompleter;

public class PluginUtils {

    public static void registerCommand(String command, CommandExecutor executor, InventoryCommands plugin) {
        if (plugin.getConfig().getBoolean("commands." + command, true)) {
            var cmd = plugin.getCommand(command);
            if (cmd != null) {
                cmd.setExecutor(executor);

                if (executor instanceof TabCompleter tc) {
                    cmd.setTabCompleter(tc);
                }

            } else {
                plugin.getLogger().warning("The command '" + command + "' was not found on 'plugin.yml'! Please add it! Defaulting to enabled");
            }
        }
    }

}
