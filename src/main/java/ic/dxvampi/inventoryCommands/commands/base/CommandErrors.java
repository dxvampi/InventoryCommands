package ic.dxvampi.inventoryCommands.commands.base;

import ic.dxvampi.inventoryCommands.utils.MessageUtils;
import org.bukkit.command.CommandSender;

public class CommandErrors {
    public static void raiseConsoleError(CommandSender sender, String label) {
        sender.sendMessage(MessageUtils.getColored("&cYou can't use &7/" + label + "&c in the console!"));
    }

    public static void raiseInvalidUsage(CommandSender sender, String label, String[] args, String usage) {
        StringBuilder arguments = new StringBuilder();
        for (String arg : args) {
            arguments.append(arg).append(" ");
        }
        sender.sendMessage(MessageUtils.getColored("&cInvalid usage: &7/" + label + " " + arguments.toString() + "&c Usage: &7" + usage));
    }
}
