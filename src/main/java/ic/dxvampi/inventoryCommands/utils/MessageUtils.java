package ic.dxvampi.inventoryCommands.utils;

import net.md_5.bungee.api.ChatColor;

public class MessageUtils {
    public static String getColored(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}
