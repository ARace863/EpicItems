/*
  Made by ARace863
  This plugin is protected by the Apache 2.0 License
  You may not repost this plugin or sell it by any means.
 */

package me.arace863.epicitems.Items;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import me.arace863.epicitems.EpicItems;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.attribute.AttributeModifier.Operation;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class ItemManager {

    public static ItemStack EndermanSword;
    public static ItemStack AceSword;
    public static ItemStack Rpg;
    public static ItemStack Bonemerang;
    public static ItemStack GrapplingHook;
    public static ItemStack EndermanBow;
    public static ItemStack ExplosiveBow;
    public static ItemStack TripleStrikeBow;
    public static ItemStack Quiver;
    public static ItemStack EvokerStaff;
    public static ItemStack Airstrike;
    public static ItemStack KnockStick;
    public static ItemStack HealingSword;
    public static ItemStack UltraDrill;
    public static ItemStack StealthStrike;
    public static ItemStack WarriorAxe;
    public static ItemStack FireballRod;

    public static ItemStack BeeHelmet;
    public static ItemStack BeeChestplate;
    public static ItemStack BeeLeggings;
    public static ItemStack BeeBoots;

    public ItemManager() {
    }

    // TODO: 9/26/2021 Create custom resource pack while adding 'meta.setCustomResourceId' to create texture ID's

    public static void init() {
        createEndermanSword();
        createAceSword();
        createRpg();
        createBonemerang();
        createGrapplingHook();
        createEndermanBow();
        createExplosiveBow();
        createTripleStrikeBow();
        createQuiver();
        createEvokerStaff();
        createAirStrike();
        createKnockStick();
        createHealingSword();
        createUltraDrill();
        createWarriorsAxe();
        createBeeHelmet();
        createBeeChestplate();
        createBeeLeggings();
        createBeeBoots();
        createFireballRod();
        createStealthStrike();
    }

    private static void createEndermanSword() {
        ItemStack item = new ItemStack(Material.DIAMOND_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§9Aspect Of The End");
        List<String> lore = new ArrayList();
        lore.add("§7Damage: §c+" + EpicItems.getInstance().getConfig().getDouble("endermanSwordDamage"));
        lore.add("");
        lore.add("§6Ability: Instant Transmission §e§lRIGHT CLICK");
        lore.add("§7Teleport §a8 blocks§7 ahead of you and");
        lore.add("§7gain speed whilst holding it.");
        lore.add(" ");
        lore.add(ChatColor.BLUE + "§lRARE");
        lore.add(" ");
        lore.add("§8EpicItem-EndermanSword");
        meta.setLore(lore);
        meta.setUnbreakable(true);
        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", EpicItems.getInstance().getConfig().getDouble("endermanSwordDamage"), Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        AttributeModifier speed = new AttributeModifier(UUID.randomUUID(), "generic.movementSpeed", 0.05D, Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, speed);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(meta);
        EndermanSword = item;
    }

    private static void createAceSword() {
        ItemStack item = new ItemStack(Material.IRON_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§6Hyperion");
        List<String> lore = new ArrayList();
        lore.add("§7Damage: §c+" + EpicItems.getInstance().getConfig().getDouble("aceSwordDamage"));
        lore.add("");
        lore.add("§6Ability: Shadow Warp §e§lRIGHT CLICK");
        lore.add("§7Teleport §e8§7 blocks ahead and gain");
        lore.add(ChatColor.GRAY + "speed whilst exploding surrounding blocks");
        lore.add("");
        lore.add(ChatColor.GOLD + "§lLEGENDARY");
        lore.add(" ");
        lore.add("§8EpicItem-AceSword");
        meta.setLore(lore);
        meta.setUnbreakable(true);
        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", EpicItems.getInstance().getConfig().getDouble("aceSwordDamage"), Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        AttributeModifier attackspeed = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", 100.0D, Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, attackspeed);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(meta);
        AceSword = item;
    }

    private static void createRpg() {
        ItemStack item = new ItemStack(Material.GOLDEN_SHOVEL, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§6Rocket Launcher");
        List<String> lore = new ArrayList();
        lore.add("§7Damage: §c+"+ EpicItems.getInstance().getConfig().getDouble("rpgDamage"));
        lore.add("");
        lore.add("§6Ability: Ricochet Rocket §e§lRIGHT CLICK");
        lore.add("§7Fires a rocket that explodes for");
        lore.add("§c100 §7damage and when ricocheting");
        lore.add("§7off the ground creates explosions for");
        lore.add("§7half the damage");
        lore.add(ChatColor.DARK_GRAY + "Cooldown: "+EpicItems.getInstance().getConfig().getInt("RocketLauncherCooldown")+" second(s).");
        lore.add("");
        lore.add(ChatColor.GOLD + "§lLEGENDARY");
        lore.add(" ");
        lore.add("§8EpicItem-RPG");
        meta.setLore(lore);
        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", EpicItems.getInstance().getConfig().getDouble("rpgDamage"), Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.setUnbreakable(true);
        item.setItemMeta(meta);
        Rpg = item;
    }

    private static void createBonemerang() {
        ItemStack item = new ItemStack(Material.BONE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§6Bonemerang");
        item.addUnsafeEnchantment(Enchantment.PIERCING, 100);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        List<String> lore = new ArrayList();
        lore.add("§7Damage: §c+"+ EpicItems.getInstance().getConfig().getDouble("bonemerangDamage"));
        lore.add("");
        lore.add("§6Ability: Swing §e§lRIGHT CLICK");
        lore.add("§7Throw bone a short distance, dealing");
        lore.add("§7the damage an arrow would.");
        lore.add("§7Deals §cdouble damage§7 when coming back.");
        lore.add("§7Pierces up to §e10 §7foes");
        lore.add(" ");
        lore.add("§6§lLEGENDARY BOW");
        lore.add(" ");
        lore.add("§8EpicItem-Bonemerang");
        lore.add("§8ID: " + UUID.randomUUID());
        meta.setLore(lore);
        item.setItemMeta(meta);
        Bonemerang = item;
    }

    private static void createGrapplingHook() {
        ItemStack item = new ItemStack(Material.FISHING_ROD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aGrappling Hook");
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.setUnbreakable(true);
        List<String> lore = new ArrayList();
        lore.add("§7Travel around in style using");
        lore.add("§7this Grappling Hook.");
        lore.add(ChatColor.DARK_GRAY + "" + EpicItems.getInstance().getConfig().getInt("GrapplingHookCooldown") + " second cooldown");
        lore.add("");
        lore.add("§a§lUNCOMMON");
        lore.add(" ");
        lore.add("§8EpicItem-GrapplingHook");
        meta.setLore(lore);
        item.setItemMeta(meta);
        GrapplingHook = item;
    }

    private static void createEndermanBow() {
        ItemStack item = new ItemStack(Material.BOW, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§cEnderman Bow [UNFINISHED]");
        meta.addEnchant(Enchantment.ARROW_DAMAGE, 10, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.setUnbreakable(true);
        List<String> lore = new ArrayList();
        lore.add("§7Damage: §c+10");
        lore.add("");
        lore.add("§6Item Ability: Teleport §e§lRIGHT CLICK");
        lore.add("§7Teleport wherever your");
        lore.add("§7arrow lands.");
        lore.add(" ");
        lore.add("§c§lUNFINISHED");
        lore.add(" ");
        lore.add("§8EpicItem-EndermanBow");
        meta.setLore(lore);
        item.setItemMeta(meta);
        EndermanBow = item;
    }

    private static void createExplosiveBow() {
        ItemStack item = new ItemStack(Material.BOW, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§cExplosive Bow [UNFINISHED]");
        meta.addEnchant(Enchantment.ARROW_DAMAGE, 10, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.setUnbreakable(true);
        List<String> lore = new ArrayList();
        lore.add("§7Damage: §c+10");
        lore.add("");
        lore.add(ChatColor.GOLD + "Item Ability: Missile");
        lore.add("§7Creates an explosion for");
        lore.add("§7wherever your arrow lands.");
        lore.add(" ");
        lore.add(ChatColor.RED + "§lUNFINISHED");
        lore.add(" ");
        lore.add("§8EpicItem-ExplosiveBow");
        meta.setLore(lore);
        item.setItemMeta(meta);
        ExplosiveBow = item;
    }

    private static void createTripleStrikeBow() {
        ItemStack item = new ItemStack(Material.BOW, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§6Runaan's Bow");
        meta.addEnchant(Enchantment.ARROW_DAMAGE, 10, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.setUnbreakable(true);
        List<String> lore = new ArrayList();
        lore.add("§7Damage: §c+"+ EpicItems.getInstance().getConfig().getDouble("runaansBowDamage"));
        lore.add("");
        lore.add(ChatColor.GOLD + "Ability: Triple Shot §e§lRIGHT CLICK");
        lore.add("§7Shoots 3 arrows at a time! The 2");
        lore.add("§7extra arrows deal 40% of the");
        lore.add("§7damage.");
        lore.add("");
        lore.add(ChatColor.GOLD + "§lLEGENDARY BOW");
        lore.add(" ");
        lore.add("§8EpicItem-TSB");
        meta.setLore(lore);
        item.setItemMeta(meta);
        TripleStrikeBow = item;
    }

    private static void createQuiver() {
        ItemStack item = new ItemStack(Material.ARROW, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.AQUA + "Quiver");
        List<String> lore = new ArrayList();
        lore.add("When a bow is held, this");
        lore.add("quiver will give you arrows to shoot!");
        lore.add("");
        lore.add(ChatColor.AQUA + "§lSPECIAL");
        lore.add(" ");
        lore.add("§8EpicItem");
        meta.setLore(lore);
        item.setItemMeta(meta);
        Quiver = item;
    }

    private static void createEvokerStaff() {
        ItemStack item = new ItemStack(Material.NETHERITE_HOE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_PURPLE + "Evoker Staff");
        meta.addEnchant(Enchantment.LUCK, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        List<String> lore = new ArrayList();
        lore.add("§7Damage: §c+20");
        lore.add("§7Ability Damage: §c+40");
        lore.add("");
        lore.add("§6Item Ability: Claws §e§lRIGHT CLICK");
        lore.add("§7Summons the deadly fangs of");
        lore.add("§7an Evoker, use with caution.");
        lore.add(ChatColor.DARK_GRAY+ "" + EpicItems.getInstance().getConfig().getDouble("EvokerStaffCooldown") + " Second cooldown.");
        lore.add(" ");
        lore.add(ChatColor.DARK_PURPLE + "§lEPIC");
        lore.add(" ");
        lore.add("§8EpicItem-EvokerStaff");
        meta.setLore(lore);
        item.setItemMeta(meta);
        EvokerStaff = item;
    }

    private static void createAirStrike() {
        ItemStack item = new ItemStack(Material.SEA_PICKLE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_PURPLE + "Airstrike");
        List<String> lore = new ArrayList();
        lore.add("§6Ability: Missile §e§lRIGHT CLICK");
        lore.add("§7Right click on the ground location you want");
        lore.add("§7to be destroyed with TNT impact");
        lore.add(ChatColor.DARK_GRAY+ "" + EpicItems.getInstance().getConfig().getInt("AirstrikeCooldown") + " Second cooldown.");
        lore.add(" ");
        lore.add(ChatColor.DARK_PURPLE + "§lEPIC");
        lore.add(" ");
        lore.add("§8EpicItem-Airstrike");
        meta.setLore(lore);
        item.setItemMeta(meta);
        Airstrike = item;
    }

    private static void createKnockStick() {
        ItemStack item = new ItemStack(Material.STICK, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.BLUE + "Knockback Stick");
        meta.addEnchant(Enchantment.KNOCKBACK, 2, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        List<String> lore = new ArrayList();
        lore.add("§7Knock entities away from you!");
        lore.add(" ");
        lore.add(ChatColor.BLUE + "§lRARE");
        lore.add(" ");
        lore.add("§8EpicItem-KnockStick");
        meta.setLore(lore);
        item.setItemMeta(meta);
        KnockStick = item;
    }

    private static void createHealingSword() {
        ItemStack item = new ItemStack(Material.GOLDEN_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.BLUE + "Healing Sword");

        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        meta.setUnbreakable(true);
        List<String> lore = new ArrayList();
        lore.add("§6Ability: Lifeline §e§lRIGHT CLICK");
        lore.add("§7Replenishes your hunger and");
        lore.add("§7heals you for half of your max health.");
        lore.add(" ");
        lore.add(ChatColor.BLUE + "§lRARE");
        lore.add(" ");
        lore.add("§8EpicItem-HealingSword");
        meta.setLore(lore);
        item.setItemMeta(meta);
        HealingSword = item;
    }

    private static void createUltraDrill() {
        ItemStack item = new ItemStack(Material.DIAMOND_PICKAXE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_PURPLE + "Ultra Drill");
        meta.addEnchant(Enchantment.DIG_SPEED, 5, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.setUnbreakable(true);

        //meta.setCustomModelData(1234567);

        List<String> lore = new ArrayList();
        lore.add("§6Ability: Efficient Mining §e§lRIGHT CLICK");
        lore.add("§7Use this drill to mine a ");
        lore.add("§73x3 area of stone blocks.");
        lore.add(" ");
        lore.add(ChatColor.DARK_PURPLE + "§lEPIC");
        lore.add(" ");
        lore.add("§8EpicItem-UltraDrill");
        meta.setLore(lore);
        item.setItemMeta(meta);
        UltraDrill = item;
    }

    private static void createWarriorsAxe() {
        ItemStack item = new ItemStack(Material.NETHERITE_AXE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.setDisplayName(ChatColor.GOLD + "Warriors Axe");
        List<String> lore = new ArrayList<>();
        lore.add("§7Damage: §c+"+ EpicItems.getInstance().getConfig().getDouble("warriorsAxeDamage"));
        lore.add("");
        lore.add("§6Ability: Mighty Launch §e§lRIGHT CLICK");
        lore.add("§7Launch your axe to do");
        lore.add("§c100 §7damage on impact!");
        lore.add("");
        lore.add(ChatColor.GOLD + "" + ChatColor.BOLD + "LEGENDARY");
        lore.add("");
        lore.add("§8EpicItem-WarriorsAxe");
        meta.setLore(lore);
        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.armor", EpicItems.getInstance().getConfig().getDouble("warriorsAxeDamage"), AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        item.setItemMeta(meta);
        WarriorAxe = item;
    }

    private static void createBeeHelmet() {
        ItemStack item = new ItemStack(Material.LEATHER_HELMET, 1);
        ItemMeta meta = item.getItemMeta();
        LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta;

        meta.setDisplayName(ChatColor.BLUE + "Bee Helmet");
        List<String> lore = new ArrayList<>();
        lore.add("§7Protection: §c3");
        lore.add("");
        lore.add("§6Full Set Ability: Friends Forever");
        lore.add("§7Equip the full bee set");
        lore.add("§7to not be angered by bees");
        lore.add("");
        lore.add(ChatColor.BLUE + "" + ChatColor.BOLD + "RARE");
        lore.add("");
        lore.add("§8EpicItem-BeeHelmet");
        meta.setLore(lore);

        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armor", 3.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, toughness);

        item.setItemMeta(meta);

        BeeHelmet = item;
    }

    private static void createBeeChestplate() {
        ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
        ItemMeta meta = item.getItemMeta();
        LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta;

        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        meta.setUnbreakable(true);

        meta.setDisplayName(ChatColor.BLUE + "Bee Chestplate");

        leatherArmorMeta.setColor(Color.fromRGB(0,0,0));

        List<String> lore = new ArrayList<>();
        lore.add("§7Protection: §c5");
        lore.add("");
        lore.add("§6Full Set Ability: Friends Forever");
        lore.add("§7Equip the full bee set");
        lore.add("§7to not be angered by bees");
        lore.add("");
        lore.add(ChatColor.BLUE + "" + ChatColor.BOLD + "RARE");
        lore.add("");
        lore.add("§8EpicItem-BeeChestplate");
        meta.setLore(lore);

        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armor", 5.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, toughness);

        item.setItemMeta(meta);

        BeeChestplate = item;
    }

    private static void createBeeLeggings() {
        ItemStack item = new ItemStack(Material.LEATHER_LEGGINGS, 1);
        ItemMeta meta = item.getItemMeta();
        LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta;

        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        meta.setUnbreakable(true);

        meta.setDisplayName(ChatColor.BLUE + "Bee Leggings");

        leatherArmorMeta.setColor(Color.fromRGB(255,255,0));

        List<String> lore = new ArrayList<>();
        lore.add("§7Protection: §c4");
        lore.add("");
        lore.add("§6Full Set Ability: Friends Forever");
        lore.add("§7Equip the full bee set");
        lore.add("§7to not be angered by bees");
        lore.add("");
        lore.add(ChatColor.BLUE + "" + ChatColor.BOLD + "RARE");
        lore.add("");
        lore.add("§8EpicItem-BeeLeggings");
        meta.setLore(lore);

        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armor", 4.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, toughness);

        item.setItemMeta(meta);

        BeeLeggings = item;
    }

    private static void createBeeBoots() {
        ItemStack item = new ItemStack(Material.LEATHER_BOOTS, 1);
        ItemMeta meta = item.getItemMeta();
        LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta;

        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        meta.setUnbreakable(true);

        meta.setDisplayName(ChatColor.BLUE + "Bee Boots");

        leatherArmorMeta.setColor(Color.fromRGB(0,0,0));

        List<String> lore = new ArrayList<>();
        lore.add("§7Protection: §c3");
        lore.add("");
        lore.add("§6Full Set Ability: Friends Forever");
        lore.add("§7Equip the full bee set");
        lore.add("§7to not be angered by bees");
        lore.add("");
        lore.add(ChatColor.BLUE + "" + ChatColor.BOLD + "RARE");
        lore.add("");
        lore.add("§8EpicItem-BeeBoots");
        meta.setLore(lore);

        AttributeModifier toughness = new AttributeModifier(UUID.randomUUID(), "generic.armor", 3.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, toughness);

        item.setItemMeta(meta);

        BeeBoots = item;
    }

    private static void createFireballRod() {
        ItemStack item = new ItemStack(Material.BLAZE_ROD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.BLUE + "Fireball Rod");
        List<String> lore = new ArrayList();
        lore.add("§7Damage: §c+"+ EpicItems.getInstance().getConfig().getDouble("fireballRodDamage"));
        lore.add("");
        lore.add("§6Ability: Explosive Rage §e§lRIGHT CLICK");
        lore.add("§7Release a horde of fireballs.");
        lore.add(" ");
        lore.add(ChatColor.BLUE + "§lRARE");
        lore.add(" ");
        lore.add("§8EpicItem-FireballRod");
        meta.setLore(lore);
        AttributeModifier damage = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", EpicItems.getInstance().getConfig().getDouble("fireballRodDamage"), Operation.ADD_NUMBER, EquipmentSlot.HAND);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damage);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(meta);
        FireballRod = item;
    }

    private static void createStealthStrike() {
        ItemStack item = new ItemStack(Material.ENCHANTED_BOOK, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_PURPLE + "Stealth Strike");
        List<String> lore = new ArrayList();
        lore.add("§6Ability: Invisibility §e§lRIGHT CLICK");
        lore.add("§7Hides your character from other players");
        lore.add("§7for a limited amount of time!");
        lore.add(" ");
        lore.add(ChatColor.DARK_PURPLE + "§lEPIC");
        lore.add(" ");
        lore.add("§8EpicItem-StealthStrike");
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(meta);
        StealthStrike = item;
    }
}