package ic.dxvampi.inventoryCommands.commands;

import ic.dxvampi.inventoryCommands.commands.base.CommandErrors;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class TrashCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String @NotNull [] args) {
        if(!(sender instanceof Player p)) {
            CommandErrors.raiseConsoleError(sender, label);
            return true;
        }

        if (args.length != 0) {
            CommandErrors.raiseInvalidUsage(sender, label, args, "/" + label);
            return true;
        }

        Inventory trashInventory = Bukkit.createInventory(null, 45, Component.text("Trash"));
        p.openInventory(trashInventory);
        return true;
    }

    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String @NotNull [] args) {
        return List.of();
    }
}