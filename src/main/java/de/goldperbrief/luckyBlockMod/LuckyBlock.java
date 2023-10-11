package de.goldperbrief.luckyBlockMod;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

import java.util.List;

public class LuckyBlock extends BlockWithEntity {
    public LuckyBlock(Settings settings) {
        super(settings);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new LuckyBlockBlockEntity(pos, state);
    }
    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public void appendTooltip(ItemStack stack, BlockView world, List<Text> tooltip, TooltipContext context) {
        NbtCompound nbt = BlockItem.getBlockEntityNbt(stack);
        if (nbt == null ) {
            nbt = new NbtCompound();
            nbt.putInt("luck", 100);

            BlockItem.setBlockEntityNbt(stack, LuckyBlockMod.LUCKY_BLOCK_BLOCK_ENTITY, nbt);
        }

        tooltip.add(Text.literal("Luck: "+nbt.getInt("luck")));
    }

}
