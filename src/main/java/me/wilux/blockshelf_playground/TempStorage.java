package me.wilux.blockshelf_playground;

import me.wilux.blockshelf_playground.nms_hacks.EntityFixedLeashTarget;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class TempStorage {
    public static HashMap<Player, EntityFixedLeashTarget> leashSource = new HashMap<>();
}
