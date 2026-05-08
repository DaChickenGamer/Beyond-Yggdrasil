package chicken.beyondyggdrasil.client.docs.datagen;

import chicken.beyondyggdrasil.ModBlocks;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.resources.Identifier;

public class BeyondYggdrasilModelProvider extends FabricModelProvider {
    public BeyondYggdrasilModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
        blockStateModelGenerator.createCrossBlockWithDefaultItem(
                ModBlocks.YGGDRASIL_SAPLING,
                BlockModelGenerators.PlantType.TINTED
        );
        blockStateModelGenerator.createAxisAlignedPillarBlock(
                ModBlocks.YGGDRASIL_LOG,
                TexturedModel.COLUMN
        );
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
    }

    @Override
    public String getName() {
        return "BeyondYggdrasilModelProvider";
    }
}