package io.github.enderboy500.palm.content;

import io.github.ciph3rj.cipherlib.helper.RegistryHelper;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageType;

public interface PalmDamageTypes {
    ResourceKey<DamageType> COCONUT = RegistryHelper.registerDamageType("coconut");

    static void load() {}
}
