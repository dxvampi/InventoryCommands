package ic.dxvampi.inventoryCommands.events;

import ic.dxvampi.inventoryCommands.InventoryCommands;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandSendEvent;

public class CommandTabListener implements Listener {

    private final InventoryCommands plugin;

    public CommandTabListener(InventoryCommands plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onCommandSend(PlayerCommandSendEvent event) {

        for (String command : event.getCommands().toArray(new String[0])) {

            if (!plugin.getConfig().getBoolean("command." + command, true)) {
                event.getCommands().remove(command);
            }

        }
    }

}
