package io.github.enderboy500.palm.data.generator;

import io.github.ciph3rj.cipherlib.helper.CipherLibRecipeGenerator;
import io.github.enderboy500.palm.content.PalmBlocks;
import io.github.enderboy500.palm.content.PalmItems;
import io.github.enderboy500.palm.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class PalmRecipeGenerator extends CipherLibRecipeGenerator {
    public PalmRecipeGenerator(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
        super(provider, recipeOutput);
    }

    @Override
    public void buildRecipes() {
        stairs(PalmBlocks.PALM_PLANKS, PalmBlocks.PALM_STAIRS);
        sign(PalmBlocks.PALM_PLANKS, PalmItems.PALM_SIGN);
        hangingSign(PalmItems.PALM_HANGING_SIGN, PalmBlocks.STRIPPED_PALM_LOG);
        this.shaped(RecipeCategory.BUILDING_BLOCKS, PalmBlocks.PALM_SLABS, 6).define('#', PalmBlocks.PALM_PLANKS).pattern("###").unlockedBy(getHasName(PalmBlocks.PALM_SLABS), this.has(PalmBlocks.PALM_PLANKS)).save(this.output);
        woodFromLogs(PalmBlocks.PALM_WOOD, PalmBlocks.PALM_LOG);
        woodFromLogs(PalmBlocks.STRIPPED_PALM_WOOD, PalmBlocks.STRIPPED_PALM_LOG);
        offerBoatRecipes(PalmBlocks.PALM_PLANKS, PalmItems.PALM_BOAT, PalmItems.PALM_CHEST_BOAT);
        planksFromLogs(PalmBlocks.PALM_PLANKS, ModTags.PALM_PLANK_INGREDIENT, 4);
        fence(PalmBlocks.PALM_PLANKS, PalmBlocks.PALM_FENCE);
        this.shaped(RecipeCategory.REDSTONE, PalmBlocks.PALM_FENCE_GATE).define('#', Items.STICK).define('W', PalmBlocks.PALM_PLANKS).pattern("#W#").pattern("#W#")
                .unlockedBy(getHasName(PalmBlocks.PALM_FENCE_GATE), has(PalmBlocks.PALM_PLANKS)).save(output);
        door(PalmBlocks.PALM_PLANKS, PalmBlocks.PALM_DOOR);
        trapdoor(PalmBlocks.PALM_PLANKS, PalmBlocks.PALM_TRAPDOOR);
        pressurePlate(PalmBlocks.PALM_PRESSURE_PLATE, PalmBlocks.PALM_PLANKS);
        button(PalmBlocks.PALM_PLANKS, PalmBlocks.PALM_BUTTON);
        shelf(PalmBlocks.STRIPPED_PALM_LOG, PalmBlocks.PALM_SHELF);

        this.shapeless(RecipeCategory.BUILDING_BLOCKS, PalmBlocks.COCONUT_BLOCK).requires(PalmItems.HALF_COCONUT, 9)
                .unlockedBy(getHasName(PalmBlocks.COCONUT_BLOCK), has(PalmItems.HALF_COCONUT)).save(output);
        offer2x2CompactingRecipe(RecipeCategory.BUILDING_BLOCKS, PalmBlocks.COCONUT_BLOCK, PalmBlocks.COCONUT_BRICKS, 8);
        offer2x2CompactingRecipe(RecipeCategory.BUILDING_BLOCKS, PalmBlocks.STRIPPED_COCONUT_BLOCK, PalmBlocks.STRIPPED_COCONUT_BRICKS, 8);

        stairs(PalmBlocks.COCONUT_BRICKS, PalmBlocks.COCONUT_BRICK_STAIRS);
        stairs(PalmBlocks.STRIPPED_COCONUT_BRICKS, PalmBlocks.STRIPPED_COCONUT_BRICK_STAIRS);
        slab(PalmBlocks.COCONUT_BRICKS, PalmBlocks.COCONUT_BRICK_SLAB);
        slab(PalmBlocks.STRIPPED_COCONUT_BRICKS, PalmBlocks.STRIPPED_COCONUT_BRICK_SLAB);

        this.shapeless(RecipeCategory.MISC, PalmItems.COCONUT).requires(PalmItems.HALF_COCONUT, 2).unlockedBy(getHasName(PalmItems.COCONUT), has(PalmItems.HALF_COCONUT)).save(output);
        this.shapeless(RecipeCategory.MISC, PalmItems.COCONUT_WATER, 2).requires(PalmItems.HALF_COCONUT).requires(Items.GLASS_BOTTLE, 2).unlockedBy(getHasName(PalmItems.COCONUT), has(PalmItems.HALF_COCONUT)).save(output);
    }

    public static class Provider extends RecipeProvider.Runner {
        public Provider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture) {
            super(packOutput, completableFuture);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
            return new PalmRecipeGenerator(provider, recipeOutput);
        }

        @Override
        public String getName() {
            return "Recipe Provider";
        }
    }
}
