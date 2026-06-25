package ic.dxvampi.inventoryCommands;

import ic.dxvampi.inventoryCommands.commands.CraftingTableCommand;
import ic.dxvampi.inventoryCommands.commands.EnderChestCommand;
import ic.dxvampi.inventoryCommands.commands.InvSeeCommand;
import ic.dxvampi.inventoryCommands.commands.TrashCommand;
import ic.dxvampi.inventoryCommands.utils.MessageUtils;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class InventoryCommands extends JavaPlugin {

    private final String version = getDescription().getVersion();

    @Override
    public void onEnable() {
        registerCommands();
        Bukkit.getConsoleSender().sendMessage(MessageUtils.getColored("&aInventoryCommands has been enabled! &7Version: " + version));
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(MessageUtils.getColored("&cInventoryCommands has been disabled!"));
    }

    private void registerCommands() {

        // /craftingtable

        CraftingTableCommand craftingTableCommand = new CraftingTableCommand();
        Objects.requireNonNull(this.getCommand("craftingtable")).setExecutor(craftingTableCommand);
        Objects.requireNonNull(this.getCommand("craftingtable")).setTabCompleter(craftingTableCommand);

        // /enderchest

        EnderChestCommand enderChestCommand = new EnderChestCommand();
        Objects.requireNonNull(this.getCommand("enderchest")).setExecutor(enderChestCommand);
        Objects.requireNonNull(this.getCommand("enderchest")).setTabCompleter(enderChestCommand);

        // /invsee

        InvSeeCommand invSeeCommand = new InvSeeCommand();
        Objects.requireNonNull(this.getCommand("invsee")).setExecutor(invSeeCommand);
        Objects.requireNonNull(this.getCommand("invsee")).setTabCompleter(invSeeCommand);

        // /trash

        TrashCommand trashCommand = new TrashCommand();
        Objects.requireNonNull(this.getCommand("trash")).setExecutor(trashCommand);
        Objects.requireNonNull(this.getCommand("trash")).setTabCompleter(trashCommand);
    }
}
