package de.goldperbrief.luckyBlockMod;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;

public class LuckyBlockBlockEntity extends BlockEntity {
    private int luckValue = 100;
    public LuckyBlockBlockEntity(BlockPos pos, BlockState state) {
        super(LuckyBlockMod.LUCKY_BLOCK_BLOCK_ENTITY, pos, state);
    }

    @Override
    public void writeNbt(NbtCompound nbt) {
        nbt.putInt("luck", luckValue);
        super.writeNbt(nbt);
    }
    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        luckValue = nbt.getInt("luck");
    }
}
