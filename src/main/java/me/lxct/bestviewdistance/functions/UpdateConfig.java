package me.lxct.bestviewdistance.functions;

import me.lxct.bestviewdistance.BestViewDistance;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;

public class UpdateConfig {
    public static void updateConfig() {
        FileConfiguration config = BestViewDistance.plugin.getConfig();
        double ver = config.getDouble("Version");
        if (ver < 1.1) {
            Bukkit.getLogger().info("[BestViewDistance] Update config.yml...");
            config.set("Version", 1.1);
            config.set("Delay.UnsetTeleportViewDelay", 5);
            config.set("ViewDistance.OnTeleport", 4);
            BestViewDistance.plugin.saveConfig();
            Bukkit.getLogger().info("[BestViewDistance] Updated config.yml!");
            Bukkit.getLogger().info("[BestViewDistance] Added: \"OnTeleport\" and \"UnsetTeleportViewDelay\"");
            Bukkit.getLogger().info("[BestViewDistance] More information here: https://www.spigotmc.org/resources/61963/updates");
        }
        if (ver < 1.2) {
            Bukkit.getLogger().info("[BestViewDistance] Update config.yml...");
            config.set("Version", 1.2);
            config.set("Misc.UseTeleportView", true);
            BestViewDistance.plugin.saveConfig();
            Bukkit.getLogger().info("[BestViewDistance] Updated config.yml!");
            Bukkit.getLogger().info("[BestViewDistance] Added: \"UseTeleportView\"");
            Bukkit.getLogger().info("[BestViewDistance] More information here: https://www.spigotmc.org/resources/61963/updates");
        }
        if (ver < 1.3) {
            Bukkit.getLogger().info("[BestViewDistance] Update config.yml...");
            config.set("Version", 1.3);
            config.set("Features.UseTasks", true);
            BestViewDistance.plugin.saveConfig();
            Bukkit.getLogger().info("[BestViewDistance] Updated config.yml!");
            Bukkit.getLogger().info("[BestViewDistance] Added: \"UseTasks\"");
            Bukkit.getLogger().info("[BestViewDistance] More information here: https://www.spigotmc.org/resources/61963/updates");
        }
        if (ver < 1.4) {
            Bukkit.getLogger().info("[BestViewDistance] Update config.yml...");
            config.set("Version", 1.4);
            config.set("ViewDistance.MoreThanSettings", 0);
            BestViewDistance.plugin.saveConfig();
            Bukkit.getLogger().info("[BestViewDistance] Updated config.yml!");
            Bukkit.getLogger().info("[BestViewDistance] Added: \"MoreThanSettings\"");
            Bukkit.getLogger().info("[BestViewDistance] More information here: https://www.spigotmc.org/resources/61963/updates");
        }
        if (ver < 2.0) {
            File f1 = new File(BestViewDistance.plugin.getDataFolder() + "config.yml");
            File f2 = new File(BestViewDistance.plugin.getDataFolder() + "old-config.yml");
            boolean b1 = f1.renameTo(f2);
            if (b1) {
                Bukkit.getLogger().info("[BestViewDistance] Changed config file.");
                Bukkit.getLogger().info("[BestViewDistance] Old \"config.yml\" will be renamed to \"old-config.yml\"!");
            } else {
                boolean b2 = f1.delete();
                if (b2) {
                    Bukkit.getLogger().info("[BestViewDistance] Deleted old config file.");
                } else {
                    Bukkit.getLogger().info("[BestViewDistance] Failed to delete old config file. Please delete it by yourself.");
                }
            }
        }
    }
}
