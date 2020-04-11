package xyz.nkomarn.owoifier;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Random;

public class Owoifier extends JavaPlugin implements Listener {
    final String[] expressions = {
            ">_<", ":3", "ʕʘ‿ʘʔ", ":D", "._.",
            ";3", "xD", "ㅇㅅㅇ", "(人◕ω◕)",
            ">_>", "ÙωÙ", "UwU", "OwO", ":P",
            "(◠‿◠✿)", "^_^", ";_;", "XDDD",
            "x3", "(• o •)", "<_<"
    };

    public void onEnable() {
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onAsyncChat(AsyncPlayerChatEvent event) {
        final Random random = new Random();
        final String expression = expressions[random.nextInt(expressions.length)];
        event.setMessage(event.getMessage().replace("l", "w").replace("L", "W")
                .replace("r", "w").replace("R", "W").replace("o", "u")
                .replace("O", "U") + " " + expression);
    }
}
