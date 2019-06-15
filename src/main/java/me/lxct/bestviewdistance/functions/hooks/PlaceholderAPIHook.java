package me.lxct.bestviewdistance.functions.hooks;

import me.clip.placeholderapi.PlaceholderAPI;
import me.clip.placeholderapi.PlaceholderHook;
import me.lxct.bestviewdistance.functions.BVDPlayer;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import static me.lxct.bestviewdistance.functions.data.Variable.decimalsIndice;
import static me.lxct.bestviewdistance.functions.data.Variable.decimalsTPS;
import static me.lxct.bestviewdistance.functions.data.Variable.onlinePlayers;
import static me.lxct.bestviewdistance.functions.data.Variable.timings;

public class PlaceholderAPIHook extends PlaceholderHook {

    @Override
    public String onPlaceholderRequest(final Player p, final String identifier) {
        if (identifier.equals("REDUCTION_INDICE_DECIMAL")) {
            return String.valueOf((Math.round(timings.getReductionIndice() * Math.pow(10, decimalsIndice))) / Math.pow(10, decimalsIndice));
        }
        if (identifier.equals("REDUCTION_INDICE")) {
            return String.valueOf(Math.round(timings.getReductionIndice() * 100));
        }
        if (identifier.equals("DECIMAL_TPS")) {
            return String.valueOf((Math.round(timings.get1minTPS() * Math.pow(10, decimalsTPS))) / Math.pow(10, decimalsTPS));
        }
        if (identifier.equals("TPS")) {
            return String.valueOf(Math.round(timings.get1minTPS()));
        }
        if (p == null) {
            return "";
        }
        final BVDPlayer player = onlinePlayers.get(p);
        if (identifier.equals("PLAYER_SETTINGS_VIEW")) {
            return String.valueOf(player.getSettingsViewDistance());
        }
        if (identifier.equals("PLAYER_SUPPORTED_VIEW")) {
            return String.valueOf(player.getSupportedViewDistance());
        }
        if (identifier.equals("PLAYER_CURRENT_VIEW")) {
            return String.valueOf(p.getViewDistance());
        }
        if (identifier.equals("PLAYER_PING")) {
            return String.valueOf(player.getPing());
        }
        return null;
    }

    public static void hook() {
        PlaceholderAPI.registerPlaceholderHook("pfess", new PlaceholderAPIHook());
    }

    public static void unhook() {
        PlaceholderAPI.unregisterPlaceholderHook("pfess");
    }

    public static String replacepapi(final OfflinePlayer player, final String x) {
        return PlaceholderAPI.setPlaceholders(player, x.replace("&", "ยง"));
    }
}