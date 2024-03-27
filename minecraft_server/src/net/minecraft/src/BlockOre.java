package net.minecraft.src;

import java.util.Random;

public class BlockOre extends Block {
	public BlockOre(int var1, int var2) {
		super(var1, var2, Material.rock);
	}

	public int idDropped(int var1, Random var2) {
		return this.blockID == Block.oreCoal.blockID ? Item.coal.swiftedIndex : (this.blockID == Block.oreDiamond.blockID ? Item.diamond.swiftedIndex : this.blockID);
	}

	public int quantityDropped(Random var1) {
		return 1;
	}
}
