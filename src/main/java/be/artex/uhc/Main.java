package be.artex.uhc;

import be.artex.uhc.command.Host;
import be.artex.uhc.listeners.PlayerJoin;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class Main extends JavaPlugin {
    public static Plugin instance;
    public static Logger logger;
    public static boolean inGame;

    @Override
    public void onEnable() {
        instance = this;
        logger = Logger.getLogger("ArtUHC");
        inGame = false;

        this.getServer().getPluginManager().registerEvents(new PlayerJoin(), this);

        getCommand("h").setExecutor(new Host());
    }
}
