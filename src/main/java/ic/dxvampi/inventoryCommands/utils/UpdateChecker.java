package ic.dxvampi.inventoryCommands.utils;

import ic.dxvampi.inventoryCommands.InventoryCommands;
import org.bukkit.Bukkit;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class UpdateChecker {

    private final InventoryCommands plugin;
    public UpdateChecker(InventoryCommands plugin) {
        this.plugin = plugin;
    }

    public String getLatestVersionGist() {
        try {
            URL url = new URL("https://gist.githubusercontent.com/dxvampi/729bae6d34b462a89eb1b909ba562e03/raw/version.txt");
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
                return reader.readLine().trim();
            }
        } catch (Exception e) {
            Bukkit.getConsoleSender().sendMessage(MessageUtils.getColored("&cCould not get latest version! &7Current: " + plugin.getDescription().getVersion()));
            return plugin.getDescription().getVersion();
        }
    }

    public void checkForUpdates() {
        Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {
            String latest = getLatestVersionGist();
            String currentVersion = plugin.getDescription().getVersion();

            if (!currentVersion.equalsIgnoreCase(latest)) {
                Bukkit.getConsoleSender().sendMessage(MessageUtils.getColored("&aNew version available &7(" + latest + ")"));
                Bukkit.getConsoleSender().sendMessage(MessageUtils.getColored("&Update on: https://github.com/dxvampi/InventoryCommands/releases/latest"));
            }
        });
    }
}
