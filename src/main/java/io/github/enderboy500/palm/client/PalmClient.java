package io.github.enderboy500.palm.client;

import io.github.enderboy500.palm.content.PalmBlocks;
import io.github.enderboy500.palm.content.PalmEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.object.boat.BoatModel;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;

public class PalmClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.putBlocks(ChunkSectionLayer.CUTOUT, PalmBlocks.PALM_DOOR, PalmBlocks.PALM_TRAPDOOR, PalmBlocks.PALM_LEAVES,
                PalmBlocks.PALM_SAPLING, PalmBlocks.POTTED_PALM_SAPLING);

        LayerDefinition boatModel = BoatModel.createBoatModel();
        LayerDefinition chestBoatModel = BoatModel.createChestBoatModel();
        EntityModelLayerRegistry.registerModelLayer(PalmEntityModelLayers.PALM_BOAT, () -> boatModel);
        EntityModelLayerRegistry.registerModelLayer(PalmEntityModelLayers.PALM_CHEST_BOAT, () -> chestBoatModel);

        ColorMapHelper.assignBlockColor(PalmBlocks.PALM_LEAVES, -7158200);

        EntityRenderers.register(PalmEntities.PALM_BOAT, context -> new BoatRenderer(context, PalmEntityModelLayers.PALM_BOAT));
        EntityRenderers.register(PalmEntities.PALM_CHEST_BOAT, context -> new BoatRenderer(context, PalmEntityModelLayers.PALM_CHEST_BOAT));
        EntityRenderers.register(PalmEntities.COCONUT, ThrownItemRenderer::new);
    }
}
