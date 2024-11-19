package me.arace863.epicitems.GUI;

import me.arace863.epicitems.EpicItems;
import me.arace863.epicitems.Items.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GUIMethods implements Listener {

    private final EpicItems plugin;
    public GUIMethods(EpicItems plugin) {
        this.plugin = plugin;
    }

    // Helper method to create an ItemStack with meta data
    private ItemStack createItem(Material material, String displayName, List<String> lore, ItemFlag... flags) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();

        if (meta != null) {
            meta.setDisplayName(displayName);
            meta.setLore(lore);
            meta.addItemFlags(flags);
            item.setItemMeta(meta);
        }

        return item;
    }

    public void openVaultStoreGUI(Player player) {
        if (!Bukkit.getPluginManager().isPluginEnabled("Vault")){
            player.sendMessage("no vault");
        } else {
            Inventory gui = Bukkit.createInventory(player, 45, ChatColor.RED + "Store | EpicItems");

            ItemStack emerald = createItem(Material.EMERALD, ChatColor.GREEN + "" + ChatColor.BOLD + "Buy All Items", Arrays.asList(
                    " ", ChatColor.GRAY + "Click on the emerald to buy",
                    ChatColor.GRAY + "all the available items for",
                    ChatColor.RED + "$25,910", "",
                    ChatColor.GREEN + "$25,910"), ItemFlag.HIDE_ATTRIBUTES);

            ItemStack[] items = {
                    ItemManager.AceSword, ItemManager.Bonemerang, ItemManager.Airstrike, ItemManager.EndermanSword,
                    // other items go here...
                    emerald, // Emerald item goes here
                    new ItemStack(Material.AIR), // Fillers
                    createItem(Material.BARRIER, ChatColor.RED + "Go back to menu", Collections.emptyList())
            };

            gui.setContents(items);
            player.openInventory(gui);
        }
    }

    public void openItemGUI(Player player) {
        Inventory gui = Bukkit.createInventory(player, 45, ChatColor.RED + "Items | EpicItems");

        ItemStack emerald = createItem(Material.EMERALD, ChatColor.GREEN + "" + ChatColor.BOLD + "Buy All Items", Arrays.asList(" ", ChatColor.GRAY + "Click on the emerald to buy", ChatColor.GRAY + "all the available items for", ChatColor.RED + "$25,910", "", ChatColor.GREEN + "$25,910"), ItemFlag.HIDE_ATTRIBUTES);

        ItemStack[] items = {ItemManager.AceSword, ItemManager.Bonemerang, ItemManager.Airstrike, ItemManager.EndermanSword,emerald, new ItemStack(Material.AIR), createItem(Material.BARRIER, ChatColor.RED + "Go back to menu", Collections.emptyList())
        };

            gui.setContents(items);
            player.openInventory(gui);
    }

    // Event handler to listen for clicks in the GUI
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getView().getTitle().equals(ChatColor.RED + "Store | EpicItems")) {
            event.setCancelled(true);

            Player player = (Player) event.getWhoClicked();
            ItemStack clickedItem = event.getCurrentItem();

            if (clickedItem != null && clickedItem.getType() == Material.EMERALD) {
                player.getInventory().addItem(ItemManager.WarriorAxe);
                EpicItems.getEconomy().withdrawPlayer(player, 2);
                player.sendMessage(ChatColor.GREEN + "You bought item for 2");
                player.closeInventory();
            }
        }

        if (event.getView().getTitle().equals(ChatColor.RED + "Items | EpicItems")) {
            event.setCancelled(true);

            Player player = (Player) event.getWhoClicked();
            ItemStack clickedItem = event.getCurrentItem();

            if (clickedItem != null && clickedItem.getType() == Material.EMERALD) {
                player.getInventory().addItem(ItemManager.WarriorAxe);
                EpicItems.getEconomy().withdrawPlayer(player, 2);
                player.sendMessage(ChatColor.GREEN + "You bought item for 2");

                EpicItems.getEconomy().depositPlayer(player, 100000); //Deposits 10000 of a specific currency into a certain players inventlory
                player.closeInventory();
                //Todo: Complete the nullified blocks for correct formatting.
            }
        }
    }
}
