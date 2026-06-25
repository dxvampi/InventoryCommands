package ic.dxvampi.inventoryCommands.utils;

import ic.dxvampi.inventoryCommands.InventoryCommands;
import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

public class UpdateChecker {

    private final InventoryCommands plugin;

    public UpdateChecker(InventoryCommands plugin) {
        this.plugin = plugin;
    }

    public void checkForUpdates() {
        plugin.getServer().getScheduler().runTaskAsynchronously(plugin, () -> {
            try {
                String latestVersion = getLatestVersion();
                String currentVersion = plugin.getDescription().getVersion();

                if (!currentVersion.equals(latestVersion)) {
                    Bukkit.getConsoleSender().sendMessage(MessageUtils.getColored("&cYou're out of date!"));
                    Bukkit.getConsoleSender().sendMessage(MessageUtils.getColored("&cDownload latest version on https://github.com/dxvampi/InventoryCommands/releases/latest"));
                }

            } catch (Exception e) {
                Bukkit.getConsoleSender().sendMessage(MessageUtils.getColored("&cAn error occurred while checking for updates. (Do you have Internet?)"));
                Bukkit.getConsoleSender().sendMessage(Arrays.toString(e.getStackTrace()));
            }
        });
    }

    private static @NotNull String getLatestVersion() throws IOException {
        BufferedReader reader = getBufferedReader();
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) response.append(line);
        reader.close();

        // Search tag
        String json = response.toString();
        String tag = json.split("\"tagname\":\"")[1].split("\"")[0];

        // Clear the 'v'
        return tag.replace("v", "");
    }

    private static @NotNull BufferedReader getBufferedReader() throws IOException {
        URL url = new URL("https://api.github.com/repos/dxvampi/InventoryCommands/releases/latest");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "InventoryCommands-Plugin");
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);

        // Read answer
        return new BufferedReader(new InputStreamReader(connection.getInputStream()));
    }

}
