package me.wilux.blockshelf_playground.blocks;

import me.wilux.blockshelf.api.CustomRegistry;
import me.wilux.blockshelf.extentions.OrientableCustomBlock;
import me.wilux.blockshelf_playground.BlockshelfPlayground;
import me.wilux.blockshelf_playground.Register._DummyText;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class ElectricFurnace extends OrientableCustomBlock {
    public static final String DISPLAY_NAME = "Electric Furnace";
    public static final String ID = "electric_furnace";
    public static final String ID_WE = "electric_furnace_we";

    public static ElectricFurnace defaultState;

    public ElectricFurnace(String name, String modelPath, String title) {
        super(name, modelPath, title);
        baseMaterial = Material.BARRIER;
    }
    @Override
    public ItemStack[] getLoot(Block b) {
        return new ItemStack[] {defaultState.getBlockItem()};
    }

    public static void register(){
        ElectricFurnace north_south = new ElectricFurnace(ID,"pseudoblock/electric_furnace",DISPLAY_NAME);
        ElectricFurnace west_east = new ElectricFurnace(ID_WE,"pseudoblock/electric_furnace_we", BlockshelfPlayground.UNOBTAINABLE_BLOCK);

        defaultState = north_south;

        north_south.north_south = north_south;
        north_south.west_east = west_east;
        west_east.north_south = north_south;
        west_east.west_east = west_east;

        CustomRegistry.register(north_south, BlockshelfPlayground.plugin);
        CustomRegistry.register(west_east, BlockshelfPlayground.plugin);
    }

    @Override
    public void onInteract(PlayerInteractEvent evt) {
        evt.setCancelled(true);
        BlockshelfPlayground.logger.warning("ELECTRIC FURNACE OPEN GUI");

        Player player = evt.getPlayer();
        player.openInventory(
                Bukkit.createInventory(player, InventoryType.FURNACE, "§f"+ _DummyText.ELECTRIC_FURNACE_GUI));
    }
}
