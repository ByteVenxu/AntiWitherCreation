package de.noahtrx.antiwithercreation.listener;

import de.noahtrx.antiwithercreation.commands.AntiWitherCommand;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class CreatureSpawnEventListener implements Listener {
    public CreatureSpawnEventListener() {
    }

    @EventHandler
    public void onJoin(CreatureSpawnEvent creatureSpawnEvent) {

        if (creatureSpawnEvent.getEntityType().equals(EntityType.WITHER)) {
            if (!AntiWitherCommand.isEnabled) {
                creatureSpawnEvent.setCancelled(true);
            }
        }
    }
}