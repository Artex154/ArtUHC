package be.artex.uhc.utils;

import be.raft.crafty.item.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Stacks {
    public static final ItemStack CONFIG = new ItemBuilder<>(new ItemStack(Material.COMMAND))
            .displayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Configuration")
            .setLore(ChatColor.GRAY + "Permet de modifier les paramètres de votre partie à l'aide d'un clic droit !")
            .build();
}
