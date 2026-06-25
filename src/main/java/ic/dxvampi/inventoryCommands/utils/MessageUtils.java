package ic.dxvampi.inventoryCommands.utils;

import org.bukkit.ChatColor;

public class MessageUtils {

    private MessageUtils() {}

    public static String getColored(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}
