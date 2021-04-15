package me.wilux.blockshelf_playground.blocks;

import org.bukkit.event.inventory.InventoryCloseEvent;

public interface GuiAble {
    void onCloseGui(InventoryCloseEvent e);
}
