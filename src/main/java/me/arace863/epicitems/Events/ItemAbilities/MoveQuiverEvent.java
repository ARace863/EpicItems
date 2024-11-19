package me.arace863.epicitems.Events.ItemAbilities;

import me.arace863.epicitems.Items.ItemManager;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MoveQuiverEvent implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        ItemStack currentItem = event.getCurrentItem();

        // Check if the clicked item is the Quiver and if it's in the off-hand slot
        if (currentItem != null && currentItem.getItemMeta() != null && currentItem.getItemMeta().getLore() != null
                && currentItem.getItemMeta().getLore().contains("§8EpicItem-Quiver")) {

            // Prevent moving the item from the off-hand slot
            if (event.getSlot() == 40) { //off hand slot
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onPlayerSwapHandItems(PlayerSwapHandItemsEvent event) {
        ItemStack offHandItem = event.getOffHandItem();

        // Prevent swapping the Quiver if it's in the off-hand
        if (offHandItem != null && offHandItem.getItemMeta() != null && offHandItem.getItemMeta().getLore() != null
                && offHandItem.getItemMeta().getLore().contains("§8EpicItem-Quiver")) {
            event.setCancelled(true); // Cancel the swap if Quiver is in off-hand
        }
    }

    @EventHandler
    public void oneQuiverEvent(PlayerMoveEvent event){
        // Loop through the player's inventory
        for (ItemStack item : event.getPlayer().getInventory().getContents()) {
            // Check if the item is not null and is the Quiver
            if (item != null && item.hasItemMeta()) {
                ItemMeta meta = item.getItemMeta();
                // Check if the item is the Quiver by its display name
                if (meta != null && meta.hasDisplayName() && meta.getDisplayName().equals(ChatColor.AQUA + "Quiver")) {
                    // Check if the amount is greater than 1
                    if (item.getAmount() > 1) {
                        // Set the amount to 1
                        item.setAmount(1);
                    }
                }
            }
        }
    }
}
