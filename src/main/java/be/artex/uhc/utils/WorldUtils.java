package be.artex.uhc.utils;

import be.artex.uhc.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.WorldBorder;
import org.bukkit.block.Block;

public class WorldUtils {
    public static boolean isWorldInitialized = false;

    public static boolean isWorldBorderInitialized(World world) {
        return world.getWorldBorder().getSize() == 200;
    }

    public static void initializePlatform(Material material) {
        World world = Bukkit.getWorlds().get(0);
        int centerX = 0;
        int centerY = 120;
        int centerZ = 0;
        int platformSize = 30;
        int borderHeight = 4;

        int startX = centerX - platformSize / 2;
        int endX = centerX + platformSize / 2;
        int startZ = centerZ - platformSize / 2;
        int endZ = centerZ + platformSize / 2;

        for (int x = startX; x <= endX; x++) {
            for (int z = startZ; z <= endZ; z++) {
                Block block = world.getBlockAt(x, centerY, z);

                if (x == startX || x == endX || z == startZ || z == endZ) {
                    for (int y = centerY; y < centerY + borderHeight; y++) {
                        Block borderBlock = world.getBlockAt(x, y, z);
                        borderBlock.setType(material);
                    }
                } else {
                    block.setType(material);
                }

            }

        }

        isWorldInitialized = true;
    }

}