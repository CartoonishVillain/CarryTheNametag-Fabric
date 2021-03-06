package com.cartoonishvillain.CarryNametag.mixin;

import com.cartoonishvillain.CarryNametag.CarryTheNametag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.animal.Animal;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(Animal.class)
public class BreedMixin {
	@Inject(at = @At("TAIL"), method = "spawnChildFromBreeding", locals = LocalCapture.CAPTURE_FAILHARD)
	private void spawnChildFromBreeding(ServerLevel serverLevel, Animal animal, CallbackInfo ci, AgeableMob ageableMob) {
		CarryTheNametag.doRename(((Animal) (Object) this), animal, ageableMob);
	}
}
