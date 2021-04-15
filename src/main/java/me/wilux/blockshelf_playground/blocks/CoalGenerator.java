package me.wilux.blockshelf_playground.blocks;

import me.benfah.cu.api.CustomRegistry;
import me.wilux.blockshelf_playground.BlockshelfPlayground;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

public class CoalGenerator extends OrientableCustomBlock {
    public static final String DISPLAY_NAME = "Coal Generator";
    public static final String ID = "coal_generator";
    public static final String ID_WE = "coal_generator_we";

    public static CoalGenerator defaultState;

    public CoalGenerator(String name, String modelPath, String title) {
        super(name, modelPath, title);
        baseMaterial = Material.BARRIER;
    }
    @Override
    public ItemStack[] getLoot(Block b) {
        return new ItemStack[] {defaultState.getBlockItem()};
    }

    public static void register(){
        CoalGenerator north_south = new CoalGenerator(ID,"pseudoblock/coal_generator",DISPLAY_NAME);
        CoalGenerator west_east = new CoalGenerator(ID_WE,"pseudoblock/coal_generator_we", BlockshelfPlayground.UNOBTAINABLE_BLOCK);

        defaultState = north_south;

        north_south.north_south = north_south;
        north_south.west_east = west_east;
        west_east.north_south = north_south;
        west_east.west_east = west_east;

        CustomRegistry.register(north_south, BlockshelfPlayground.plugin);
        CustomRegistry.register(west_east, BlockshelfPlayground.plugin);
    }
}
