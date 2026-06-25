package ic.dxvampi.inventoryCommands;

import ic.dxvampi.inventoryCommands.commands.*;
import ic.dxvampi.inventoryCommands.utils.MessageUtils;
import ic.dxvampi.inventoryCommands.utils.PluginUtils;
import ic.dxvampi.inventoryCommands.utils.UpdateChecker;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class InventoryCommands extends JavaPlugin {

    private final String version = getDescription().getVersion();
    private final UpdateChecker updateChecker = new UpdateChecker(this);
    private static final String PREFIX = "&7&l[&r&aInventoryCommands&7&l] &r";

    @Override
    public void onEnable() {
        saveDefaultConfig();
        registerCommands();
        updateChecker.checkForUpdates();
        Bukkit.getConsoleSender().sendMessage(MessageUtils.getComponent(PREFIX + "&aInventoryCommands has been enabled! &7Version: " + version));
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(MessageUtils.getComponent(PREFIX + "&cInventoryCommands has been disabled!"));
    }

    private void registerCommands() {

        PluginUtils.registerCommand("craftingtable", new CraftingTableCommand(), this);

        PluginUtils.registerCommand("enderchest", new EnderChestCommand(), this);

        PluginUtils.registerCommand("invsee", new InvSeeCommand(), this);

        PluginUtils.registerCommand("trash", new TrashCommand(), this);

        PluginUtils.registerCommand("anvil", new AnvilCommand(), this);

    }

    public String getPrefix() {
        return PREFIX;
    }

}
