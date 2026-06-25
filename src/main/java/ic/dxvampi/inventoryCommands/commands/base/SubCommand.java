package ic.dxvampi.inventoryCommands.commands.base;

import ic.dxvampi.inventoryCommands.InventoryCommands;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.List;

public abstract class SubCommand {
    protected final InventoryCommands plugin;
    protected final CommandSender sender;
    protected final Command command;
    protected final String label;
    protected final String[] args;

    public SubCommand(InventoryCommands plugin, CommandSender sender, Command command, String label, String[] args) {
        this.plugin = plugin;
        this.sender = sender;
        this.command = command;
        this.label = label;
        this.args = args;
    }

    public abstract void execute();
    public abstract List<String> onTabComplete();
}
