package io.github.enderboy500.palm.data;

import io.github.enderboy500.palm.data.generator.PalmRecipeGenerator;
import io.github.enderboy500.palm.data.provider.*;
import io.github.enderboy500.palm.world.PalmPlacedFeatures;
import io.github.enderboy500.palm.world.PalmTreeFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.registries.VanillaRegistries;
import net.minecraft.util.Util;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;

public class PalmDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		CompletableFuture<HolderLookup.Provider> completableFuture = CompletableFuture.supplyAsync(
				VanillaRegistries::createLookup, Util.backgroundExecutor()
		);

		pack.addProvider(PalmBlockLootTableProvider::new);
		pack.addProvider(PalmBlockTagProvider::new);
		pack.addProvider(PalmItemTagProvider::new);
		pack.addProvider(PalmModelProvider::new);
		pack.addProvider(PalmRegistryProvider::new);

        pack.addProvider(toFactory(PalmRecipeGenerator.Provider::new, completableFuture));
    }

    private static <T extends DataProvider> DataProvider.Factory<T> toFactory(BiFunction<PackOutput, CompletableFuture<HolderLookup.Provider>, T> baseFactory, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        return output -> (T)baseFactory.apply(output, registriesFuture);
    }

	@Override
	public void buildRegistry(RegistrySetBuilder registryBuilder) {
		DataGeneratorEntrypoint.super.buildRegistry(registryBuilder);
		registryBuilder.add(Registries.PLACED_FEATURE, PalmPlacedFeatures::bootstrap);
		registryBuilder.add(Registries.CONFIGURED_FEATURE, PalmTreeFeatures::bootstrap);
	}
}