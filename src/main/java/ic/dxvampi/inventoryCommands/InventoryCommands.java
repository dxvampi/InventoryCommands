package ic.dxvampi.inventoryCommands;

import ic.dxvampi.inventoryCommands.commands.*;
import ic.dxvampi.inventoryCommands.events.CommandTabListener;
import ic.dxvampi.inventoryCommands.utils.MessageUtils;
import ic.dxvampi.inventoryCommands.utils.PluginUtils;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class InventoryCommands extends JavaPlugin {

    private final String version = getDescription().getVersion();

    @Override
    public void onEnable() {
        saveDefaultConfig();
        registerCommands();
        Bukkit.getConsoleSender().sendMessage(MessageUtils.getColored("&aInventoryCommands has been enabled! &7Version: " + version));
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(MessageUtils.getColored("&cInventoryCommands has been disabled!"));
    }

    private void registerCommands() {

        // /craftingtable

        PluginUtils.registerCommand("craftingtable", new CraftingTableCommand(), this);

        // /enderchest

        PluginUtils.registerCommand("enderchest", new EnderChestCommand(), this);

        // /invsee

        PluginUtils.registerCommand("invsee", new InvSeeCommand(), this);

        // /trash

        PluginUtils.registerCommand("trash", new TrashCommand(), this);

        // /anvil

        PluginUtils.registerCommand("anvil", new AnvilCommand(), this);

    }

    private void registerListeners() {
        getServer().getPluginManager().registerEvents(new CommandTabListener(this), this);
    }
}
