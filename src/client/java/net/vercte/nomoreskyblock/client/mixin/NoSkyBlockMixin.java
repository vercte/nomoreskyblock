package net.vercte.nomoreskyblock.client.mixin;

import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemBlockRenderTypes.class)
public class NoSkyBlockMixin {
    @Inject(method = "getChunkRenderType", at = @At(value = "RETURN", ordinal = 0), cancellable = true)
    private static void noMoreSkyBlockForYou(BlockState blockState, CallbackInfoReturnable<RenderType> cir) {
        cir.setReturnValue(RenderType.cutout());
    }
}
