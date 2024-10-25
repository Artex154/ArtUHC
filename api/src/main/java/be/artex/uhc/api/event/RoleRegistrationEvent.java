package be.artex.uhc.api.event;

import be.artex.uhc.api.Role;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.Arrays;
import java.util.List;

public class RoleRegistrationEvent extends Event {
    private static final HandlerList HANDLERS = new HandlerList();

    private final List<Role> roles;

    public RoleRegistrationEvent(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public void registerRoles(Role... roles) {
        this.roles.addAll(Arrays.asList(roles));
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}
