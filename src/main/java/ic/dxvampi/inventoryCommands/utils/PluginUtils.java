package ic.dxvampi.inventoryCommands.utils;

import ic.dxvampi.inventoryCommands.InventoryCommands;
import org.bukkit.Bukkit;
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
                Bukkit.getConsoleSender().sendMessage(MessageUtils.getColored(plugin.getPrefix() + "&aCommand '" + command + "' is disabled!"));
            } else {
                Bukkit.getConsoleSender().sendMessage(MessageUtils.getColored(plugin.getPrefix() + "&cCommand '" + command + "' specified on config.yml does not exist!"));
            }

        } else {
            var commandMap = plugin.getServer().getCommandMap();
            var cmd = commandMap.getCommand(command);
            if (cmd != null) {
                cmd.unregister(commandMap);
                Bukkit.getConsoleSender().sendMessage(MessageUtils.getColored(plugin.getPrefix() + "&cCommand '" + command + "' is disabled!"));
            } else {
                Bukkit.getConsoleSender().sendMessage(MessageUtils.getColored(plugin.getPrefix() + "&cCommand '" + command + "' specified on config.yml does not exist!"));
            }
        }
    }

}
