package fang.authmebeui;

import java.io.File;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class Util {
    public static String getText (String s){
        File msgFile = new File(AuthMeBEUI.instance.getDataFolder(), "config.yml");
        FileConfiguration text = YamlConfiguration.loadConfiguration(msgFile);
        return text.getString(s);
    }
}
