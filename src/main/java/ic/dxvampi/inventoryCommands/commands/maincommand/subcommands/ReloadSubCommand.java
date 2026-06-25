package ic.dxvampi.inventoryCommands.commands.maincommand.subcommands;

import ic.dxvampi.inventoryCommands.InventoryCommands;
import ic.dxvampi.inventoryCommands.commands.base.CommandErrors;
import ic.dxvampi.inventoryCommands.commands.base.SubCommand;
import ic.dxvampi.inventoryCommands.utils.MessageUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.List;

public class ReloadSubCommand extends SubCommand {
    public ReloadSubCommand(InventoryCommands plugin, CommandSender sender, Command command, String label, String[] args) {
        super(plugin, sender, command, label, args);
    }

    @Override
    public void execute() {
        if (!(sender.hasPermission("inventorycommands.maincommand.reload"))) {
            CommandErrors.raiseNoPermission(sender, label, args);
            return;
        }
        plugin.reloadConfig();
        sender.sendMessage(MessageUtils.getComponent(plugin.getPrefix() + "&aConfig has been reloaded"));
        sender.sendMessage(MessageUtils.getComponent(plugin.getPrefix() + "&7Note: toggleable commands need a server restart"));
    }

    @Override
    public List<String> onTabComplete() {
        return List.of();
    }
}
