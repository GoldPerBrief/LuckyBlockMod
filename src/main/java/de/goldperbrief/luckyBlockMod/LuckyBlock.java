package de.goldperbrief.luckyBlockMod;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class LuckyBlock extends Block {
    public LuckyBlock(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(LUCK, 100));
    }

    public static final IntProperty LUCK = IntProperty.of("luck",0,200);

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (hand.equals(Hand.MAIN_HAND) && ItemStack.EMPTY.itemMatches(player.getMainHandStack(), Item.byRawId(Item.getRawId(Items.EMERALD)))) {
//            player.playSound(SoundEvents.BLOCK_NOTE_BLOCK_BIT, 1, 1);
            world.setBlockState(pos, state.with(LUCK, +6));
            return ActionResult.SUCCESS;
        } else {
            ActionResult.FAIL;
        }

        return ActionResult.SUCCESS;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(LUCK);
    }
}
