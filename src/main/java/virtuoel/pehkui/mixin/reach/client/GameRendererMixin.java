package virtuoel.pehkui.mixin.reach.client;

import java.util.Optional;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.Entity;
import virtuoel.pehkui.api.PehkuiConfig;
import virtuoel.pehkui.api.ScaleData;

@Mixin(GameRenderer.class)
public class GameRendererMixin
{
	@Shadow @Final @Mutable
	MinecraftClient client;

	@ModifyConstant(method = "updateTargetedEntity", constant = @Constant(doubleValue = 3.0D))
	private double updateTargetedEntityModifyDistance(double value)
	{
		final Entity entity = client.getCameraEntity();
		
		if (entity != null)
		{
			final float scale = ScaleData.of(entity).getScale(client.getTickDelta());
			
			if (scale > 1.0F)
			{
				if (Optional.ofNullable(PehkuiConfig.DATA.get("scaledReach"))
					.filter(JsonElement::isJsonPrimitive).map(JsonElement::getAsJsonPrimitive)
					.filter(JsonPrimitive::isBoolean).map(JsonPrimitive::getAsBoolean)
					.orElse(true))
				{
					return scale * scale * value;
				}
			}
		}
		
		return value;
	}
	
	@ModifyConstant(method = "updateTargetedEntity", constant = @Constant(doubleValue = 6.0D))
	private double updateTargetedEntityModifyExtendedDistance(double value)
	{
		final Entity entity = client.getCameraEntity();
		
		if (entity != null)
		{
			final float scale = ScaleData.of(entity).getScale(client.getTickDelta());
			
			if (scale > 1.0F)
			{
				if (Optional.ofNullable(PehkuiConfig.DATA.get("scaledReach"))
					.filter(JsonElement::isJsonPrimitive).map(JsonElement::getAsJsonPrimitive)
					.filter(JsonPrimitive::isBoolean).map(JsonPrimitive::getAsBoolean)
					.orElse(true))
				{
					return scale * scale * value;
				}
			}
		}
		
		return value;
	}
	
	@ModifyConstant(method = "updateTargetedEntity", constant = @Constant(doubleValue = 9.0D))
	private double updateTargetedEntityModifyMaxDistance(double value)
	{
		final Entity entity = client.getCameraEntity();
		
		if (entity != null)
		{
			final float scale = ScaleData.of(entity).getScale(client.getTickDelta());
			
			if (scale > 1.0F)
			{
				if (Optional.ofNullable(PehkuiConfig.DATA.get("scaledReach"))
					.filter(JsonElement::isJsonPrimitive).map(JsonElement::getAsJsonPrimitive)
					.filter(JsonPrimitive::isBoolean).map(JsonPrimitive::getAsBoolean)
					.orElse(true))
				{
					return scale * scale * value;
				}
			}
		}
		
		return value;
	}
}
