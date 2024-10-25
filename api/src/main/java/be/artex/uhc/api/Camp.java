package be.artex.uhc.api;

import org.bukkit.inventory.ItemStack;

import java.awt.*;

/**
 * A camp is a group of multiple roles.
 */
public interface Camp {

    /**
     * The icon that will be shown to the users.
     *
     * @return item as icon.
     */
    ItemStack icon();


    // todo : link with Description Builder
    /**
     * The name that will be used in the {@link }.
     *
     * @return the name.
     */
    TextComponent name();

    /**
     * Unique identifier for the camp.
     *
     * @return the identifier.
     */
    String id();
}
