package net.minecraft.src;

import java.util.Random;

public class WorldGenDungeons extends WorldGenerator {
	public boolean generate(World var1, Random var2, int var3, int var4, int var5) {
		byte var6 = 3;
		int var7 = var2.nextInt(2) + 2;
		int var8 = var2.nextInt(2) + 2;
		int var9 = 0;

		int var10;
		int var11;
		int var12;
		for(var10 = var3 - var7 - 1; var10 <= var3 + var7 + 1; ++var10) {
			for(var11 = var4 - 1; var11 <= var4 + var6 + 1; ++var11) {
				for(var12 = var5 - var8 - 1; var12 <= var5 + var8 + 1; ++var12) {
					Material var13 = var1.getBlockMaterial(var10, var11, var12);
					if(var11 == var4 - 1 && !var13.func_216_a()) {
						return false;
					}

					if(var11 == var4 + var6 + 1 && !var13.func_216_a()) {
						return false;
					}

					if((var10 == var3 - var7 - 1 || var10 == var3 + var7 + 1 || var12 == var5 - var8 - 1 || var12 == var5 + var8 + 1) && var11 == var4 && var1.getBlockId(var10, var11, var12) == 0 && var1.getBlockId(var10, var11 + 1, var12) == 0) {
						++var9;
					}
				}
			}
		}

		if(var9 >= 1 && var9 <= 5) {
			for(var10 = var3 - var7 - 1; var10 <= var3 + var7 + 1; ++var10) {
				for(var11 = var4 + var6; var11 >= var4 - 1; --var11) {
					for(var12 = var5 - var8 - 1; var12 <= var5 + var8 + 1; ++var12) {
						if(var10 != var3 - var7 - 1 && var11 != var4 - 1 && var12 != var5 - var8 - 1 && var10 != var3 + var7 + 1 && var11 != var4 + var6 + 1 && var12 != var5 + var8 + 1) {
							var1.setBlockWithNotify(var10, var11, var12, 0);
						} else if(var11 >= 0 && !var1.getBlockMaterial(var10, var11 - 1, var12).func_216_a()) {
							var1.setBlockWithNotify(var10, var11, var12, 0);
						} else if(var1.getBlockMaterial(var10, var11, var12).func_216_a()) {
							if(var11 == var4 - 1 && var2.nextInt(4) != 0) {
								var1.setBlockWithNotify(var10, var11, var12, Block.cobblestoneMossy.blockID);
							} else {
								var1.setBlockWithNotify(var10, var11, var12, Block.cobblestone.blockID);
							}
						}
					}
				}
			}

			label110:
			for(var10 = 0; var10 < 2; ++var10) {
				for(var11 = 0; var11 < 3; ++var11) {
					var12 = var3 + var2.nextInt(var7 * 2 + 1) - var7;
					int var14 = var5 + var2.nextInt(var8 * 2 + 1) - var8;
					if(var1.getBlockId(var12, var4, var14) == 0) {
						int var15 = 0;
						if(var1.getBlockMaterial(var12 - 1, var4, var14).func_216_a()) {
							++var15;
						}

						if(var1.getBlockMaterial(var12 + 1, var4, var14).func_216_a()) {
							++var15;
						}

						if(var1.getBlockMaterial(var12, var4, var14 - 1).func_216_a()) {
							++var15;
						}

						if(var1.getBlockMaterial(var12, var4, var14 + 1).func_216_a()) {
							++var15;
						}

						if(var15 == 1) {
							var1.setBlockWithNotify(var12, var4, var14, Block.crate.blockID);
							TileEntityChest var16 = (TileEntityChest)var1.getBlock(var12, var4, var14);
							int var17 = 0;

							while(true) {
								if(var17 >= 8) {
									continue label110;
								}

								ItemStack var18 = this.func_434_a(var2);
								if(var18 != null) {
									var16.func_197_a(var2.nextInt(var16.func_83_a()), var18);
								}

								++var17;
							}
						}
					}
				}
			}

			var1.setBlockWithNotify(var3, var4, var5, Block.mobSpawner.blockID);
			TileEntityMobSpawner var19 = (TileEntityMobSpawner)var1.getBlock(var3, var4, var5);
			var19.entityID = this.func_433_b(var2);
			return true;
		} else {
			return false;
		}
	}

	private ItemStack func_434_a(Random var1) {
		int var2 = var1.nextInt(11);
		return var2 == 0 ? new ItemStack(Item.saddle) : (var2 == 1 ? new ItemStack(Item.ingotIron, var1.nextInt(4) + 1) : (var2 == 2 ? new ItemStack(Item.bread) : (var2 == 3 ? new ItemStack(Item.wheat, var1.nextInt(4) + 1) : (var2 == 4 ? new ItemStack(Item.gunpowder, var1.nextInt(4) + 1) : (var2 == 5 ? new ItemStack(Item.silk, var1.nextInt(4) + 1) : (var2 == 6 ? new ItemStack(Item.bucketEmpty) : (var2 == 7 && var1.nextInt(100) == 0 ? new ItemStack(Item.appleGold) : (var2 == 8 && var1.nextInt(2) == 0 ? new ItemStack(Item.redstone, var1.nextInt(4) + 1) : (var2 == 9 && var1.nextInt(10) == 0 ? new ItemStack(Item.itemsList[Item.record13.swiftedIndex + var1.nextInt(2)]) : null)))))))));
	}

	private String func_433_b(Random var1) {
		int var2 = var1.nextInt(4);
		return var2 == 0 ? "Skeleton" : (var2 == 1 ? "Zombie" : (var2 == 2 ? "Zombie" : (var2 == 3 ? "Spider" : "")));
	}
}
