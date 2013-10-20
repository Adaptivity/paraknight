package lawnmower.client;

import net.minecraft.block.Block;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Deprecated
@SideOnly(Side.CLIENT)
public class EntitySlimeFX extends EntityFX {
	public EntitySlimeFX(World var1, double var2, double var4, double var6, Item var8) {
		super(var1, var2, var4, var6, 0.0D, 0.0D, 0.0D);
		this.setParticleIcon(var8.getIconIndex(new ItemStack(var8)));
		this.particleRed = this.particleGreen = this.particleBlue = 1.0F;
		this.particleGravity = Block.blockSnow.blockParticleGravity;
		this.particleScale /= 2.0F;
	}

	@Override
	public int getFXLayer() {
		return 2;
	}

	@Override
	public void renderParticle(Tessellator var1, float var2, float var3, float var4, float var5, float var6, float var7) {
		float var8 = (this.particleTextureIndexX / 16F + this.particleTextureJitterX / 4.0F) / 16.0F;
		float var9 = var8 + 0.01560938F;
		float var10 = (this.particleTextureIndexX / 16F + this.particleTextureJitterY / 4.0F) / 16.0F;
		float var11 = var10 + 0.01560938F;
		float var12 = 0.1F * this.particleScale;
		float var13 = (float) (this.prevPosX + (this.posX - this.prevPosX) * var2 - interpPosX);
		float var14 = (float) (this.prevPosY + (this.posY - this.prevPosY) * var2 - interpPosY);
		float var15 = (float) (this.prevPosZ + (this.posZ - this.prevPosZ) * var2 - interpPosZ);
		float var16 = this.getBrightness(var2);
		var1.setColorOpaque_F(var16 * this.particleRed, var16 * this.particleGreen, var16 * this.particleBlue);
		var1.addVertexWithUV(var13 - var3 * var12 - var6 * var12, var14 - var4 * var12, var15 - var5 * var12 - var7 * var12, var8, var11);
		var1.addVertexWithUV(var13 - var3 * var12 + var6 * var12, var14 + var4 * var12, var15 - var5 * var12 + var7 * var12, var8, var10);
		var1.addVertexWithUV(var13 + var3 * var12 + var6 * var12, var14 + var4 * var12, var15 + var5 * var12 + var7 * var12, var9, var10);
		var1.addVertexWithUV(var13 + var3 * var12 - var6 * var12, var14 - var4 * var12, var15 + var5 * var12 - var7 * var12, var9, var11);
	}
}
