package ic.dxvampi.inventoryCommands.commands;

import ic.dxvampi.inventoryCommands.commands.base.BaseCommand;
import ic.dxvampi.inventoryCommands.commands.base.CommandErrors;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class TrashCommand extends BaseCommand {
    @Override
    protected boolean execute(CommandSender sender, Player player, String label, String[] args) {
        if (args.length != 0) {
            CommandErrors.raiseInvalidUsage(sender, label, args, "/" + label);
            return true;
        }

        Inventory trashInventory = Bukkit.createInventory(null, 45, Component.text("Trash"));
        player.openInventory(trashInventory);
        return true;
    }
}