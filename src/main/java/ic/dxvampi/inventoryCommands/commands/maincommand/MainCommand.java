package ic.dxvampi.inventoryCommands.commands.maincommand;

import ic.dxvampi.inventoryCommands.InventoryCommands;
import ic.dxvampi.inventoryCommands.commands.base.CommandErrors;
import ic.dxvampi.inventoryCommands.commands.maincommand.subcommands.ReloadSubCommand;
import ic.dxvampi.inventoryCommands.utils.MessageUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MainCommand implements CommandExecutor, TabCompleter {

    private final InventoryCommands plugin;
    public MainCommand(InventoryCommands plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 0) {
            sender.sendMessage(MessageUtils.getComponent(plugin.getPrefix()+"&aRunning version &7" + plugin.getDescription().getVersion()));
            return true;
        }
        if (args.length != 1) {
            CommandErrors.raiseInvalidUsage(sender, label, args, "/" + label + " <reload>");
            return true;
        }
        switch (args[0]) {
            case "reload":
                new ReloadSubCommand(plugin, sender, command, label, args).execute(); break;
            default: sender.sendMessage(MessageUtils.getComponent(plugin.getPrefix() + "&cSub-command &7/" + label + " " +
                    args[0] + "&c does not exist"));
        }
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        List<String> completions = new ArrayList<>();
        completions.add("reload");
        if (args.length == 1) {
            return completions;
        }
        if (args.length > 2) {
            switch(args[0]) {
                case "reload":
                    return new ReloadSubCommand(plugin, sender, command, label, args).onTabComplete();
                default:
                    break;
            }
        }
        return List.of();
    }
}
