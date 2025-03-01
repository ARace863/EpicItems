/*
  Made by ARace863
  This plugin is protected by the Apache 2.0 License
  You may not repost this plugin or sell it by any means.
 */

package me.arace863.epicitems.Events.ItemAbilities;

import me.arace863.epicitems.EpicItems;
import me.arace863.epicitems.Utils.Cooldown;
import me.arace863.epicitems.Utils.Managers.ParticleManager;
import org.bukkit.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.Iterator;

public class RocketLauncherEvent implements Listener {
    EpicItems plugin;
    FileConfiguration config;

    public RocketLauncherEvent(EpicItems plugin) {
        this.plugin = plugin;
        this.config = plugin.getConfig();
    }

    @EventHandler
    public void onClick(PlayerInteractEvent event) {
        int damage = 70;
        if (this.config.getBoolean("RocketLauncher", true)){
            if ((event.getAction().equals(Action.RIGHT_CLICK_BLOCK) || event.getAction().equals(Action.RIGHT_CLICK_AIR)) && event.getPlayer().getInventory().getItemInMainHand().getItemMeta()
                    != null && event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getLore()
                    != null && event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getLore().contains("§8EpicItem-RPG")) {

                final Player player = event.getPlayer();
                if (Cooldown.checkCooldown(event.getPlayer())) {
                    try {
                        Location eye = player.getEyeLocation();
                        final Firework firework = (Firework)eye.getWorld().spawnEntity(eye, EntityType.FIREWORK);
                        FireworkMeta meta = firework.getFireworkMeta();
                        meta.setPower(2);
                        if (meta.hasEffects()) {
                            firework.setFireworkMeta(meta);
                        } else {
                            meta.addEffect(FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL_LARGE).build());
                            firework.setFireworkMeta(meta);
                        }
                        firework.setShotAtAngle(true);
                        firework.setRotation(player.getLocation().getYaw(), player.getLocation().getPitch());
                        firework.setVelocity(eye.getDirection().normalize().multiply(2));
                        firework.setBounce(true);
                        firework.setCustomName(String.valueOf(damage));
                        firework.setShooter(player);
                        Cooldown.setCooldown(event.getPlayer(), this.config.getInt("RocketLauncherCooldown"));
                        (new BukkitRunnable() {
                            public void run() {
                                if (firework.isDead()) {
                                    ParticleManager particleManager = new ParticleManager(plugin);
                                    firework.getWorld().spawnParticle(Particle.EXPLOSION_HUGE, firework.getLocation(), 10);
                                    particleManager.fireSpiral(firework);
                                    firework.getWorld().playSound(firework.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 5.0F, 5.0F);
                                    Iterator var1 = firework.getNearbyEntities(5.0D, 5.0D, 5.0D).iterator();

                                    while(var1.hasNext()) {
                                        Entity entity = (Entity)var1.next();
                                        if (entity instanceof LivingEntity) {
                                            LivingEntity livingEntity = (LivingEntity)entity;
                                            if (!livingEntity.equals(player) && !livingEntity.equals(firework)) {
                                                livingEntity.damage((double)Integer.parseInt(firework.getCustomName()));
                                            }
                                        }
                                    }
                                    this.cancel();
                                }
                            }
                        }).runTaskTimer(this.plugin, 0L, 1L);
                        event.setCancelled(true);
                    }catch (NullPointerException exception){
                        Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "[EpicItems] " + ChatColor.RED + "An error occured, please report this here with a screenshot of the error: " + ChatColor.BLUE + "https://dsc.gg/arace863");
                        exception.printStackTrace();
                    }

                } else {
                    player.sendMessage(ChatColor.RED + "This is on cooldown for " + Math.round((Cooldown.cooldowns.get(player.getUniqueId()) - System.currentTimeMillis()) / 1000) +"s.");
                }
            }
        }
    }

    @EventHandler
    public void onHit(ProjectileHitEvent event) {
        if (this.config.getBoolean("RocketLauncher", true)){
            if (event.getEntity() instanceof Firework && event.getEntity().getCustomName() != null) {
                Firework firework = (Firework)event.getEntity();
                firework.getWorld().spawnParticle(Particle.EXPLOSION_LARGE, firework.getLocation(), 10);
                firework.getWorld().playSound(firework.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 5.0F, 5.0F);
                firework.setVelocity(new Vector(firework.getFacing().getModX(), firework.getFacing().getModY(), firework.getFacing().getModZ()));
                Iterator var3 = firework.getNearbyEntities(5.0D, 5.0D, 5.0D).iterator();

                while(var3.hasNext()) {

                    Entity entity = (Entity)var3.next();
                    if (entity instanceof LivingEntity) {
                        LivingEntity livingEntity = (LivingEntity)entity;
                        if (!livingEntity.equals(firework.getShooter()) && !livingEntity.equals(firework)) {
                            livingEntity.damage(config.getDouble("bonemerangDamage"), livingEntity);
                        }
                    }
                }
            }
        }
    }
}