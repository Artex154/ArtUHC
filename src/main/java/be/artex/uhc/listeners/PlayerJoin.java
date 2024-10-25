package be.artex.uhc.listeners;

import be.artex.uhc.Main;
import be.artex.uhc.utils.Stacks;
import be.artex.uhc.utils.WorldUtils;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {
    @EventHandler
    public void PlayerJoinEvent(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        player.getInventory().clear();
        player.teleport(new Location(Bukkit.getWorlds().get(0), 0, 122, 0));

        if (Main.inGame) {
            player.setGameMode(GameMode.SPECTATOR);

            return;
        }

        if (player.hasPermission("artuhc.host"))
            player.getInventory().setItem(4, Stacks.CONFIG);

        WorldUtils.initializePlatform(Material.GLASS);

        player.teleport(new Location(Bukkit.getWorlds().get(0), 0, 122, 0));
    }
}
