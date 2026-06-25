package ic.dxvampi.inventoryCommands.commands;

import ic.dxvampi.inventoryCommands.commands.base.BaseCommand;
import ic.dxvampi.inventoryCommands.commands.base.CommandErrors;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class EnderChestCommand extends BaseCommand {

    @Override
    protected boolean execute(CommandSender sender, Player player, String label, String[] args) {

        if (args.length > 1) {
            CommandErrors.raiseInvalidUsage(sender, label, args, "/" + label + " OPTIONAL:<player>");
            return true;
        }

        if (args.length == 0) {
            player.openInventory(player.getEnderChest());
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

        player.openInventory(target.getEnderChest());
        return true;
    }

    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String @NotNull [] args) {
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