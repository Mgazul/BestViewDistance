package me.lxct.bestviewdistance.commands;

import me.lxct.bestviewdistance.BestViewDistance;
import me.lxct.bestviewdistance.functions.Other;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

import static me.lxct.bestviewdistance.functions.Variable.*;


class Commands {


    static String colorize(String string) {return org.bukkit.ChatColor.translateAlternateColorCodes('&', string);}

    static void commandTPS(String[] args, CommandSender sender){
        if(args[0].equalsIgnoreCase("tps")){
            sender.sendMessage(colorize(Other.replacePlaceHolders(viewTps)));
        }
    }

    static void commandHelp(CommandSender sender) {
        sender.sendMessage(colorize(Other.replacePlaceHolders(viewHelpLine1)));
        sender.sendMessage(colorize(Other.replacePlaceHolders(viewHelpLine2)));
        sender.sendMessage(colorize(Other.replacePlaceHolders(viewHelpLine3)));
        sender.sendMessage(colorize(Other.replacePlaceHolders(viewHelpLine4)));
        sender.sendMessage(colorize(Other.replacePlaceHolders(viewHelpLine5)));
        sender.sendMessage(colorize(Other.replacePlaceHolders(viewHelpLine6)));
    }

    static void commandPing(String[] args, CommandSender sender) {
        if(args[0].equalsIgnoreCase("ping")) {
            player = Bukkit.getServer().getPlayerExact(args[1]);
            if (player == null) {
                sender.sendMessage(colorize(Other.replacePlaceHolders(viewIncorrectPing)));
            } else {
                sender.sendMessage(colorize(Other.replacePlaceHolders(viewPing)));
            }
        }
    }

    static void commandView(String[] args, CommandSender sender) {
        player = Bukkit.getServer().getPlayerExact(args[0]);
        if (player == null) {
            sender.sendMessage(colorize(Other.replacePlaceHolders(viewIncorrectView)));
        }
        else {
            sender.sendMessage(colorize(Other.replacePlaceHolders(viewPlayerLine1)));
            sender.sendMessage(colorize(Other.replacePlaceHolders(viewPlayerLine2)));
            sender.sendMessage(colorize(Other.replacePlaceHolders(viewPlayerLine3)));
        }
    }


    static void commandServer(String[] args, CommandSender sender){
        if(args[0].equalsIgnoreCase("server")){
            sender.sendMessage(colorize(Other.replacePlaceHolders(viewServer)));
        }
    }

    static void commandReload(String[] args, CommandSender sender){
        if(args[0].equalsIgnoreCase("reload")){
            BestViewDistance.plugin.reloadConfig();
            loadVariables();
            sender.sendMessage(colorize(Other.replacePlaceHolders(viewReload)));
        }
    }


}