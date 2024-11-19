package me.arace863.epicitems.Events;

import me.arace863.epicitems.EpicItems;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class VaultCheck implements Listener {

    EpicItems plugin;
    FileConfiguration config;

    public VaultCheck(EpicItems plugin) {
        this.plugin = plugin;
        this.config = plugin.getConfig();
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        if (this.config.getBoolean("CheckForVault", true)) {
            boolean VaultTest = true;
            if (!Bukkit.getPluginManager().isPluginEnabled("Vault")){
                if (player.isOp() || player.hasPermission("epicitems.main")){
                    player.sendMessage(ChatColor.AQUA + "[EpicItems]" + ChatColor.RED + " Please install Vault to use certain features within EpicItems." + " Link:" +  ChatColor.BLUE +" §n https://www.spigotmc.org/resources/vault.34315/");
                    VaultTest = false;
                    return;
                }
            }
        }
    }
}