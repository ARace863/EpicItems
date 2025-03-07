/*
  Made by ARace863
  This plugin is protected by the Apache 2.0 License
  You may not repost this plugin or sell it by any means.
 */

package me.arace863.epicitems.Commands;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

public class MainTab implements TabCompleter {
    List<String> arguments = new ArrayList();
    List<String> arguments1 = new ArrayList();


    public MainTab() {
    }

    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if (this.arguments.isEmpty()) {
            //this.arguments.add("menu");
            this.arguments.add("info");
            this.arguments.add("help");
            this.arguments.add("giveItem");
            this.arguments.add("items");
            this.arguments.add("stats");
            //this.arguments.add("checkForEpicItem");
            this.arguments.add("checkForUpdates");
            this.arguments.add("itemStore");
            this.arguments.add("setCooldown");
            this.arguments.add("playParticle");
        }

        if (this.arguments1.isEmpty()) {
            this.arguments1.add("*");
            this.arguments1.add("acesword");
            this.arguments1.add("airstrike");
            this.arguments1.add("bonemerang");
            this.arguments1.add("endermansword");
            this.arguments1.add("evokerstaff");
            this.arguments1.add("grapplinghook");
            this.arguments1.add("healingsword");
            this.arguments1.add("knockbackstick");
            this.arguments1.add("rocketlauncher");
            this.arguments1.add("runaansbow");
            this.arguments1.add("ultradrill");
            this.arguments1.add("stealthstrike");
            this.arguments1.add("warrioraxe");
            this.arguments1.add("fireballrod");
        }

        List<String> result = new ArrayList();
        Iterator var6;
        String a;
        if (args.length == 1) {
            var6 = this.arguments.iterator();

            while(var6.hasNext()) {
                a = (String)var6.next();
                if (a.toLowerCase().startsWith(args[0].toLowerCase(Locale.ROOT))) {
                    result.add(a);
                }
            }

            return result;
        } else if (args.length == 2) {
            var6 = this.arguments1.iterator();

            while(var6.hasNext()) {
                a = (String)var6.next();
                if (a.toLowerCase().startsWith(args[1].toLowerCase(Locale.ROOT))) {
                    result.add(a);
                }
            }

            return result;
        } else {
            return null;
        }
    }
}