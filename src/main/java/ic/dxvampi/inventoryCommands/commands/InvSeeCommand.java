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

public class InvSeeCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(@NonNull CommandSender sender, @NonNull Command command, @NonNull String label, String @NonNull [] args) {
        if (!(sender instanceof Player p)) {
            CommandErrors.raiseConsoleError(sender, label);
            return true;
        }
        if (args.length != 1) {
            CommandErrors.raiseInvalidUsage(sender, label, args, "/" + label + " <player>");
            return true;
        }

        Player target = Bukkit.getPlayer(args[0]);
        if (target == null) {
            CommandErrors.raiseInvalidPlayer(sender, args[0]);
            return true;
        }

        p.openInventory(target.getInventory());
        return true;
    }

    @Override
    public List<String> onTabComplete(@NonNull CommandSender sender, @NonNull Command command, @NonNull String label, String @NonNull [] args) {
        if (args.length != 1) {
            return List.of();
        }
        List<String> completions = new ArrayList<>();
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.hasMetadata("vanished")) continue;
            if (player.getName().toLowerCase().startsWith(args[0].toLowerCase())) {
                completions.add(player.getName());
            }
        }
        return completions;
    }
}