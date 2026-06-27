package ic.dxvampi.inventoryCommands.commands;

import ic.dxvampi.inventoryCommands.commands.base.BaseCommand;
import ic.dxvampi.inventoryCommands.commands.base.CommandErrors;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LoomCommand extends BaseCommand {
    @Override
    protected boolean execute(CommandSender sender, Player player, String label, String[] args) {
        if (args.length != 0) {
            CommandErrors.raiseInvalidUsage(sender, label, args, "/" + label);
            return true;
        }

        player.openLoom(null, true);
        return true;
    }
}
