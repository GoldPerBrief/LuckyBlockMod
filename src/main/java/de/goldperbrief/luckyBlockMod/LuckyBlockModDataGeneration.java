package de.goldperbrief.luckyBlockMod;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;

public class LuckyBlockModDataGeneration implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator) {
        FabricDataGenerator.Pack pack = generator.createPack();

        pack.addProvider(RecipeGenerator::new);
    }

    private static class RecipeGenerator extends FabricRecipeProvider {
        private RecipeGenerator(FabricDataOutput generator) {
            super(generator);
        }

        @Override
        public void generate(RecipeExporter exporter) {
            ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, LuckyBlockMod.LUCKY_BLOCK)
                    .input(LuckyBlockMod.LUCKY_BLOCK)
                    .input(Items.EMERALD)
                    .criterion(FabricRecipeProvider.hasItem(LuckyBlockMod.LUCKY_BLOCK),
                            FabricRecipeProvider.conditionsFromItem(LuckyBlockMod.LUCKY_BLOCK))
                    .criterion(FabricRecipeProvider.hasItem(Items.EMERALD),
                            FabricRecipeProvider.conditionsFromItem(Items.EMERALD))
                    .offerTo(exporter);

        }
    }
}
