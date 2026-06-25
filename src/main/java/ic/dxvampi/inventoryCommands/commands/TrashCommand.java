package ic.dxvampi.inventoryCommands.commands;

import ic.dxvampi.inventoryCommands.InventoryCommands;
import ic.dxvampi.inventoryCommands.commands.base.BaseCommand;
import ic.dxvampi.inventoryCommands.commands.base.CommandErrors;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class TrashCommand extends BaseCommand {

    private final InventoryCommands plugin;
    public TrashCommand(InventoryCommands plugin) {
        this.plugin = plugin;
    }

    @Override
    protected boolean execute(CommandSender sender, Player player, String label, String[] args) {
        if (args.length != 0) {
            CommandErrors.raiseInvalidUsage(sender, label, args, "/" + label);
            return true;
        }

        int rows = plugin.getConfig().getInt("trash-gui.rows");

        Inventory trashInventory = Bukkit.createInventory(null, rows * 5, Component.text("Trash"));
        player.openInventory(trashInventory);
        return true;
    }
}