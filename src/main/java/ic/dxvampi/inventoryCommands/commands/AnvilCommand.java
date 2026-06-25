package ic.dxvampi.inventoryCommands.commands;

import ic.dxvampi.inventoryCommands.commands.base.BaseCommand;
import ic.dxvampi.inventoryCommands.commands.base.CommandErrors;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AnvilCommand extends BaseCommand {

    @Override
    protected boolean execute(CommandSender sender, Player player, String label, String[] args) {
        if(!(sender instanceof Player p)) {
            CommandErrors.raiseConsoleError(sender, label);
            return true;
        }

        if(args.length != 0) {
            CommandErrors.raiseInvalidUsage(sender, label, args, "/" + label);
            return true;
        }

        p.openAnvil(null, true);
        return true;
    }

}
