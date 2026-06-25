package ic.dxvampi.inventoryCommands.utils;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;

public class MessageUtils {

    private MessageUtils() {}

    private static final LegacyComponentSerializer SERIALIZER = LegacyComponentSerializer.legacyAmpersand();

    public static Component getComponent(String message) {
        return SERIALIZER.deserialize(message);
    }
}
