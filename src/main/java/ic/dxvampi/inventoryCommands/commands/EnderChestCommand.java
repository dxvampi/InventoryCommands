package ic.dxvampi.inventoryCommands.commands;

import ic.dxvampi.inventoryCommands.commands.base.CommandErrors;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.List;

public class EnderChestCommand implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(@NonNull CommandSender sender, @NonNull Command command, @NonNull String label, String @NonNull [] args) {
        if (!(sender instanceof Player p)) {
            CommandErrors.raiseConsoleError(sender, label);
            return true;
        }

        if (args.length > 1) {
            CommandErrors.raiseInvalidUsage(sender, label, args, "/" + label + " OPTIONAL:<player>");
            return true;
        }

        if (args.length == 0) {
            p.openInventory(p.getEnderChest());
            return true;
        }

        if (!sender.hasPermission("inventorycommands.enderchest.others")) {
            CommandErrors.raiseNoPermissionOthers(sender, label);
            return true;
        }

        Player target = Bukkit.getPlayer(args[0]);
        if (target == null) {
            CommandErrors.raiseInvalidPlayer(sender, args[0]);
            return true;
        }

        p.openInventory(target.getEnderChest());
        return true;
    }

    @Override
    public List<String> onTabComplete(@NonNull CommandSender sender, @NonNull Command command, @NonNull String label, String @NonNull [] args) {
        if (args.length != 1) {
            return List.of();
        }
        List<String> completions = new ArrayList<>();
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.getName().toLowerCase().startsWith(args[0])) {
                completions.add(player.getName());
            }
        }
        return completions;
    }
}
