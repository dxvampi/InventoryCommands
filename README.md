# InventoryCommands

**Are you tired of adding straight up bloatware to your server just to have some basic utilities?** Yeah, looking at you, EssentialsX. Why install a massive, heavy plugin with a ton of features you'll never use, just so your players can type `/craft`?

**InventoryCommands** is a lightweight, no-config, bloat-free plugin that adds exactly what the name suggests: useful, everyday inventory related commands. Nothing more, nothing less.

## Features & Commands

This plugin provides access to specific inventories. Here is how each command works:

### `/craftingtable`
* **Aliases:** `/craft`, `/ct`, `/workbench`, `/wb`
* **Description:** Opens a Crafting Table GUI. Perfect for when you are deep in a mine and forgot to bring wood.

### `/enderchest`
* **Aliases:** `/ec`
* **Description:** Opens your personal Ender Chest from anywhere.
* **Bonus:** With the right permissions, you can also open and manage the Ender Chest of other players using `/enderchest <player>`.

### `/invsee`
* **Aliases:** `/inventorysee`
* **Description:** Opens the inventory of another online player. Useful for admins to check for illegal items or help players sort their stuff. Usage: `/invsee <player>`.

### `/trash`
* **Aliases:** `/dispose`, `/garbage`
* **Description:** Opens a temporal trash bin. Dump all your unwanted cobblestone, dirt, or whatever inside, close the GUI, and it will be deleted forever.

### `/anvil`
* **Description:** Opens the anvil GUI. Useful for enchanting or renaming items on the go
---

## Permissions

All permissions default to **OP**, keeping your server secure. Give these to your player ranks or VIPs as you see fit.

| Command / Feature      | Permission Node                       | Default | Description                                                        | Version |
|:-----------------------|:--------------------------------------|:--------|:-------------------------------------------------------------------|---------|
| `/craftingtable`       | `inventorycommands.craftingtable`     | OP      | Allows the player to open the virtual crafting table.              | 1.0+    |
| `/enderchest`          | `inventorycommands.enderchest`        | OP      | Allows the player to open their own virtual ender chest.           | 1.0+    |  
| `/enderchest <player>` | `inventorycommands.enderchest.others` | OP      | Allows the player to open and manage another player's ender chest. | 1.0+    |
| `/invsee <player>`     | `inventorycommands.invsee`            | OP      | Allows inspecting and interacting with another player's inventory. | 1.0+    |
| `/trash`               | `inventorycommands.trash`             | OP      | Allows the player to open the virtual trash bin.                   | 1.0+    | 
| `/anvil`               | `inventorycommands.anvil`             | OP      | Allows the player to open the anvil GUI                            | 1.1+    |
---

## Installation

1. Download the latest release.
2. Drop it into your server's `plugins` folder.
3. Restart or reload **(NOT RECOMMENDED TO RELOAD)** the server.
4. Just enjoy idk

## Requirements

1. Paper
2. Minecraft version of 1.18+
3. Java 17+
