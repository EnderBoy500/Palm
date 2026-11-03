package io.github.enderboy500.palm.data.provider;

import io.github.enderboy500.palm.content.PalmOtherRegistries;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

import static io.github.enderboy500.palm.content.PalmBlocks.*;

public class PalmItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public PalmItemTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        valueLookupBuilder(PalmOtherRegistries.PALM_PLANK_INGREDIENT).add(PALM_LOG.asItem(), PALM_WOOD.asItem(), STRIPPED_PALM_LOG.asItem(), STRIPPED_PALM_WOOD.asItem());
    }
}
