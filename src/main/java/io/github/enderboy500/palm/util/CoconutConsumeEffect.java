package io.github.enderboy500.palm.util;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.consume_effects.ConsumeEffect;
import net.minecraft.world.level.Level;

import java.util.List;

public class CoconutConsumeEffect implements ConsumeEffect {
    private final boolean oneEffect;

    public CoconutConsumeEffect(boolean oneEffect) {
        this.oneEffect = oneEffect;
    }

    @Override
    public Type<? extends ConsumeEffect> getType() {
        return Type.REMOVE_EFFECTS;
    }

    @Override
    public boolean apply(Level level, ItemStack itemStack, LivingEntity livingEntity) {
        List<MobEffectInstance> effects = livingEntity.getActiveEffects().stream().toList();
        for (MobEffectInstance effectInstance : effects) {
            if (!effectInstance.getEffect().value().isBeneficial()) {
                livingEntity.removeEffect(effectInstance.getEffect());
                if (this.oneEffect) return true;
            } else return true;
        }
        return false;
    }
}
