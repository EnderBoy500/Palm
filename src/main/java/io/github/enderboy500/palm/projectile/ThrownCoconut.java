package io.github.enderboy500.palm.projectile;

import io.github.enderboy500.palm.content.PalmEntities;
import io.github.enderboy500.palm.content.PalmItems;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.projectile.throwableitemprojectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class ThrownCoconut extends ThrowableItemProjectile {
    public ThrownCoconut(EntityType<? extends ThrowableItemProjectile> entityType, Level level) {
        super(entityType, level);
    }

    protected ThrownCoconut(Level level, LivingEntity livingEntity, ItemStack itemStack) {
        super(PalmEntities.COCONUT, livingEntity, level, itemStack);
    }

    protected ThrownCoconut(Level level, double d, double e, double f, ItemStack itemStack) {
        super(PalmEntities.COCONUT, d, e, f, level, itemStack);
    }

    @Override
    protected Item getDefaultItem() {
        return PalmItems.COCONUT;
    }

    protected void onHitEntity(EntityHitResult entityHitResult) {
        super.onHitEntity(entityHitResult);
        Entity entity = entityHitResult.getEntity();
        int i = 3;
        entity.hurt(this.damageSources().thrown(this, this.getOwner()), (float)i);
    }

    protected void onHit(HitResult hitResult) {
        super.onHit(hitResult);

        if (!this.level().isClientSide()) {
            this.level().broadcastEntityEvent(this, (byte)3);
            this.discard();
        }

    }
}
