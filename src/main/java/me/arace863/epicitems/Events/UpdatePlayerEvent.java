/*
  Made by ARace863
  This plugin is protected by the Apache 2.0 License
  You may not repost this plugin or sell it by any means.
 */

package me.arace863.epicitems.Events;

import me.arace863.epicitems.EpicItems;
import me.arace863.epicitems.Utils.Updaters.UpdateChecker;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class UpdatePlayerEvent implements Listener {

    EpicItems plugin;
    FileConfiguration config;

    public UpdatePlayerEvent(EpicItems plugin) {
        this.plugin = plugin;
        this.config = plugin.getConfig();
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        if (player.isOp() || player.hasPermission("epicitems.main")) {
            (new UpdateChecker(plugin, 93541)).getVersion((version) -> {
                if (this.plugin.getDescription().getVersion().equalsIgnoreCase(version)) {
                    this.plugin.updateAvailable = false;
                } else {
                    if (player.isOp() || player.hasPermission("epicitems.main")){
                        player.sendMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.RED + "A new update is available, download it here:" + ChatColor.BLUE + " https://www.spigotmc.org/resources/epic-items-custom-items.93541/");
                        this.plugin.updateAvailable = true;
                    }
                }
            });
        }
    }
}