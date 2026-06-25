package ic.dxvampi.inventoryCommands.commands;

import ic.dxvampi.inventoryCommands.commands.base.BaseCommand;
import ic.dxvampi.inventoryCommands.commands.base.CommandErrors;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CraftingTableCommand extends BaseCommand {

    @Override
    protected boolean execute(CommandSender sender, Player player, String label, String[] args) {
        if (args.length != 0) {
            CommandErrors.raiseInvalidUsage(sender, label, args, "/" + label);
            return true;
        }

        player.openWorkbench(null, true);
        return true;
    }
}
