package io.github.enderboy500.palm.client;

import io.github.enderboy500.palm.Palm;
import net.minecraft.client.model.geom.ModelLayerLocation;

public class PalmEntityModelLayers {
    public static final ModelLayerLocation PALM_BOAT = ofMain("boat/palm");
    public static final ModelLayerLocation PALM_CHEST_BOAT = ofMain("chest_boat/palm");
    public static final ModelLayerLocation TUMBLEWEED = ofMain("tumbleweed");

    private static ModelLayerLocation of(String name, String layer) {
        return new ModelLayerLocation(Palm.id(name), layer);
    }

    private static ModelLayerLocation ofMain(String name) {
        return of(name, "main");
    }
}
