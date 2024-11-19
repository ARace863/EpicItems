/*
  Made by ARace863
  This plugin is protected by the Apache 2.0 License
  You may not repost this plugin or sell it by any means.
 */

package me.arace863.epicitems.Utils;

import me.arace863.epicitems.Commands.MainCommand;
import me.arace863.epicitems.EpicItems;
import me.arace863.epicitems.Items.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class UtilOptions {
    FileConfiguration config;
    EpicItems plugin;

    public UtilOptions(EpicItems plugin) {
        this.config = plugin.getConfig();
        this.plugin = plugin;
    }

    public void playerMessage(Player player, String message) {
        player.sendMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.translateAlternateColorCodes('&', message));
        // TODO: 10/9/2021 Replace all strings with this method to get rid of the obsolete'§' char
    }

    public void consoleMessages(String message){
        Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.translateAlternateColorCodes('&', message));
    }

    public void nonTarget(){
        MainCommand mc = new MainCommand(plugin);
    }
}