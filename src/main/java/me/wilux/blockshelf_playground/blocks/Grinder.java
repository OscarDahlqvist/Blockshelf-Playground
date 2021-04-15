package me.wilux.blockshelf_playground.blocks;

import me.benfah.cu.api.CustomRegistry;
import me.wilux.blockshelf_playground.BlockshelfPlayground;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

public class Grinder extends OrientableCustomBlock {
    public static final String DISPLAY_NAME = "Grinder";
    public static final String ID = "grinder";
    public static final String ID_WE = "grinder_we";

    public static Grinder defaultState;

    public Grinder(String name, String modelPath, String title) {
        super(name, modelPath, title);
        baseMaterial = Material.BARRIER;
    }
    @Override
    public ItemStack[] getLoot(Block b) {
        return new ItemStack[] {defaultState.getBlockItem()};
    }

    public static void register(){
        Grinder north_south = new Grinder(ID,"pseudoblock/grinder",DISPLAY_NAME);
        Grinder west_east = new Grinder(ID_WE,"pseudoblock/grinder_we", BlockshelfPlayground.UNOBTAINABLE_BLOCK);

        defaultState = north_south;

        north_south.north_south = north_south;
        north_south.west_east = west_east;
        west_east.north_south = north_south;
        west_east.west_east = west_east;

        CustomRegistry.register(north_south, BlockshelfPlayground.plugin);
        CustomRegistry.register(west_east, BlockshelfPlayground.plugin);
    }
}
