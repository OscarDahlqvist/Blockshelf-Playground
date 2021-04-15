package me.wilux.blockshelf_playground;

import me.wilux.blockshelf_playground.blocks.CoalGenerator;
import me.wilux.blockshelf_playground.blocks.ElectricFurnace;
import me.wilux.blockshelf_playground.blocks.Grinder;
import me.wilux.blockshelf_playground.blocks.Press;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ShapedRecipe;

public class CustomRecipes {

    public static NamespacedKey electricFurnaceRecipeKey;
    public static NamespacedKey coalGeneratorRecipeKey;
    public static NamespacedKey pressRecipeKey;
    public static NamespacedKey grinderRecipeKey;

    public static void init(){
        //ItemStack recipeOut = ElectricFurnace.defaultState.getBlockItem();

        electricFurnaceRecipeKey = new NamespacedKey(BlockshelfPlayground.plugin, ElectricFurnace.ID);
        ShapedRecipe electricFurnaceRecipe = new ShapedRecipe(electricFurnaceRecipeKey, ElectricFurnace.defaultState.getBlockItem());
        electricFurnaceRecipe.shape("ggg", "gFg", "NIN");
        electricFurnaceRecipe.setIngredient('g', Material.GOLD_INGOT);
        electricFurnaceRecipe.setIngredient('F', Material.BLAST_FURNACE);
        electricFurnaceRecipe.setIngredient('N', Material.NETHERRACK);
        electricFurnaceRecipe.setIngredient('I', Material.IRON_BLOCK);

        coalGeneratorRecipeKey = new NamespacedKey(BlockshelfPlayground.plugin, CoalGenerator.ID);
        ShapedRecipe coalGeneratorRecipe = new ShapedRecipe(coalGeneratorRecipeKey, CoalGenerator.defaultState.getBlockItem());
        coalGeneratorRecipe.shape("ggg", "gFg", "CIC");
        coalGeneratorRecipe.setIngredient('g', Material.GOLD_INGOT);
        coalGeneratorRecipe.setIngredient('F', Material.BLAST_FURNACE);
        coalGeneratorRecipe.setIngredient('C', Material.COAL_BLOCK);
        coalGeneratorRecipe.setIngredient('I', Material.IRON_BLOCK);

        pressRecipeKey = new NamespacedKey(BlockshelfPlayground.plugin, Press.ID);
        ShapedRecipe pressRecipe = new ShapedRecipe(pressRecipeKey, Press.defaultState.getBlockItem());
        pressRecipe.shape("iii", "PFP", "GGG");
        pressRecipe.setIngredient('i', Material.IRON_INGOT);
        pressRecipe.setIngredient('P', Material.PISTON);
        pressRecipe.setIngredient('F', Material.BLAST_FURNACE);
        pressRecipe.setIngredient('G', Material.GOLD_BLOCK);

        grinderRecipeKey = new NamespacedKey(BlockshelfPlayground.plugin, Grinder.ID);
        ShapedRecipe grinderRecipe = new ShapedRecipe(grinderRecipeKey, Grinder.defaultState.getBlockItem());
        grinderRecipe.shape("iii", "gFg", "GGG");
        grinderRecipe.setIngredient('i', Material.IRON_INGOT);
        grinderRecipe.setIngredient('g', Material.GRINDSTONE);
        grinderRecipe.setIngredient('F', Material.BLAST_FURNACE);
        grinderRecipe.setIngredient('G', Material.GOLD_BLOCK);

        Bukkit.addRecipe(electricFurnaceRecipe);
        Bukkit.addRecipe(coalGeneratorRecipe);
        Bukkit.addRecipe(pressRecipe);
        Bukkit.addRecipe(grinderRecipe);

    }
    public static void remove(){
        Bukkit.getServer().removeRecipe(electricFurnaceRecipeKey);
    }
}
