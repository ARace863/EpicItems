/*
  Made by ARace863
  This plugin is protected by the Apache 2.0 License
  You may not repost this plugin or sell it by any means.
 */

package me.arace863.epicitems.Commands;

import me.arace863.epicitems.EpicItems;
import me.arace863.epicitems.GUI.GUIMethods;
import me.arace863.epicitems.Items.ItemManager;
import me.arace863.epicitems.Utils.UtilOptions;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {
    EpicItems plugin;

    public Commands(EpicItems plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        UtilOptions utilOptions = new UtilOptions(plugin);
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.RED + "Sorry, only players can use this command, try using 'epicitems giveItem <item>, <player>'.");
        } else {
            Player player = (Player)sender;
            if (!player.hasPermission("epicitems.main") || !player.isOp()) {
                sender.sendMessage(ChatColor.RED + "Running EpicItems v" + plugin.getDescription().getVersion());
                sender.sendMessage("Error: Insufficient permission!");
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BIT, 10.0F, 1.0F);
            } else {

                if (cmd.getName().equalsIgnoreCase("endermansword")) {
                    player.getInventory().addItem(ItemManager.EndermanSword);
                    player.sendMessage(ChatColor.GREEN + "Gave the §6Enderman Sword§a to " + player.getName() + "!");
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10.0F, 5.0F);
                    player.getWorld().spawnParticle(Particle.LANDING_LAVA, player.getLocation(), 10);
                }

                if (cmd.getName().equalsIgnoreCase("acesword")) {
                    player.getInventory().addItem(ItemManager.AceSword);
                    player.sendMessage(ChatColor.GREEN + "Gave the §4Ace Sword§a to " + player.getName() + "!");
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10.0F, 5.0F);
                    player.getWorld().spawnParticle(Particle.LANDING_LAVA, player.getLocation(), 10);
                }

                if (cmd.getName().equalsIgnoreCase("rpg")) {
                    player.getInventory().addItem(ItemManager.Rpg);
                    player.sendMessage(ChatColor.GREEN + "Gave the §6Rocket Launcher§a to " + player.getName() + "!");
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10.0F, 5.0F);
                    player.getWorld().spawnParticle(Particle.LANDING_LAVA, player.getLocation(), 10);
                }

                if (cmd.getName().equalsIgnoreCase("bonemerang")) {
                    player.getInventory().addItem(ItemManager.Bonemerang);
                    player.sendMessage(ChatColor.GREEN + "Gave the §6Bonemerang§a to " + player.getName() + "!");
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10.0F, 5.0F);
                    player.getWorld().spawnParticle(Particle.LANDING_LAVA, player.getLocation(), 10);
                }

                if (cmd.getName().equalsIgnoreCase("grapplinghook")) {
                    player.getInventory().addItem(ItemManager.GrapplingHook);
                    player.sendMessage(ChatColor.GREEN + "Gave the Grappling Hook to " + player.getName() + "!");
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10.0F, 5.0F);
                    player.getWorld().spawnParticle(Particle.LANDING_LAVA, player.getLocation(), 10);
                }

                if (cmd.getName().equalsIgnoreCase("endermanbow")) {
                    player.getInventory().addItem(ItemManager.EndermanBow);
                    player.sendMessage(ChatColor.GREEN + "Gave the §6Enderman Bow§a to " + player.getName() + "!");
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10.0F, 5.0F);
                    player.getWorld().spawnParticle(Particle.LANDING_LAVA, player.getLocation(), 10);
                }

                if (cmd.getName().equalsIgnoreCase("explosivebow")) {
                    player.getInventory().addItem(ItemManager.ExplosiveBow);
                    player.sendMessage(ChatColor.GREEN + "Gave the §6Explosive Bow§a to " + player.getName() + "!");
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10.0F, 5.0F);
                    player.getWorld().spawnParticle(Particle.LANDING_LAVA, player.getLocation(), 10);
                }

                if (cmd.getName().equalsIgnoreCase("runaansbow")) {
                    player.getInventory().addItem(ItemManager.TripleStrikeBow);
                    player.sendMessage(ChatColor.GREEN + "Gave the §6Runaan's Bow§a to " + player.getName() + "!");
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10.0F, 5.0F);
                    player.getWorld().spawnParticle(Particle.LANDING_LAVA, player.getLocation(), 10);
                }

                if (cmd.getName().equalsIgnoreCase("evokerstaff")) {
                    player.getInventory().addItem(ItemManager.EvokerStaff);
                    player.sendMessage(ChatColor.GREEN + "Gave the §6Evoker Staff§a to " + player.getName() + "!");
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10.0F, 5.0F);
                    player.getWorld().spawnParticle(Particle.LANDING_LAVA, player.getLocation(), 10);
                }

                if (cmd.getName().equalsIgnoreCase("airstrike")) {
                    player.getInventory().addItem(ItemManager.Airstrike);
                    player.sendMessage(ChatColor.GREEN + "Gave the §6Airstrike§a to " + player.getName() + "!");
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10.0F, 5.0F);
                    player.getWorld().spawnParticle(Particle.LANDING_LAVA, player.getLocation(), 10);
                }

                if (cmd.getName().equalsIgnoreCase("knockbackstick")) {
                    player.getInventory().addItem(ItemManager.KnockStick);
                    player.sendMessage(ChatColor.GREEN + "Gave the §6Knockback Stick§a to " + player.getName() + "!");
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10.0F, 5.0F);
                    player.getWorld().spawnParticle(Particle.LANDING_LAVA, player.getLocation(), 10);
                }

                if (cmd.getName().equalsIgnoreCase("healingsword")) {
                    player.getInventory().addItem(ItemManager.HealingSword);
                    player.sendMessage(ChatColor.GREEN + "Gave the §6Healing Sword§a to " + player.getName() + "!");
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10.0F, 5.0F);
                    player.getWorld().spawnParticle(Particle.LANDING_LAVA, player.getLocation(), 10);
                }

                if (cmd.getName().equalsIgnoreCase("ultradrill")) {
                    player.getInventory().addItem(ItemManager.UltraDrill);
                    player.sendMessage(ChatColor.GREEN + "Gave the §6Ultra Drill§a to " + player.getName() + "!");
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10.0F, 5.0F);
                    player.getWorld().spawnParticle(Particle.LANDING_LAVA, player.getLocation(), 10);
                }

                if (cmd.getName().equalsIgnoreCase("warrioraxe")) {
                    player.getInventory().addItem(ItemManager.WarriorAxe);
                    player.sendMessage(ChatColor.GREEN + "Gave the §6Warrior Axe§a to " + player.getName() + "!");
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10.0F, 5.0F);
                    player.getWorld().spawnParticle(Particle.LANDING_LAVA, player.getLocation(), 10);
                }

                if (cmd.getName().equalsIgnoreCase("fireballrod")) {
                    player.getInventory().addItem(ItemManager.FireballRod);
                    player.sendMessage(ChatColor.GREEN + "Gave the §6Fireball Rod§a to " + player.getName() + "!");
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10.0F, 5.0F);
                    player.getWorld().spawnParticle(Particle.LANDING_LAVA, player.getLocation(), 10);
                }

                if (cmd.getName().equalsIgnoreCase("stealthstrike")) {
                    player.getInventory().addItem(ItemManager.StealthStrike);
                    player.sendMessage(ChatColor.GREEN + "Gave the §6Stealth Strike§a to " + player.getName() + "!");
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10.0F, 5.0F);
                    player.getWorld().spawnParticle(Particle.LANDING_LAVA, player.getLocation(), 10);
                }

                if (cmd.getName().equalsIgnoreCase("beearmourset")) {
                    player.getInventory().addItem(ItemManager.FireballRod);
                    player.sendMessage(ChatColor.GREEN + "Gave the §6Bee Armour set§a to " + player.getName() + "!");
                }

                if (cmd.getName().equalsIgnoreCase("epicstore")) {
                    if (Bukkit.getPluginManager().isPluginEnabled("Vault")){
                        GUIMethods guiMethods = new GUIMethods(plugin);
                        guiMethods.openVaultStoreGUI(player);
                        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10.0F, 5.0F);
                        player.getWorld().spawnParticle(Particle.LANDING_LAVA, player.getLocation(), 10);
                        utilOptions.playerMessage(player, "&cTemporarily disabled due to a game breaking bug");
                    }else {
                        utilOptions.playerMessage(player, "&cYou must have the Vault plugin installed to use this, Install it here: &9&mhttps://www.spigotmc.org/resources/vault.34315/");
                    }
                }
            }
        }
        return true;
    }
}