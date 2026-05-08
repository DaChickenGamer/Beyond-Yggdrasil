package chicken.beyondyggdrasil.sapling;

import chicken.beyondyggdrasil.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import static chicken.karmaapi.karma.player.PlayerKarmaManager.getKarma;

public class YggdrasilTree extends Block{
    public YggdrasilTree(Properties properties) {
        super(properties);
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        // Look for the nearest player within 16 blocks to check their Karma
        Player player = level.getNearestPlayer(pos.getX(), pos.getY(), pos.getZ(), 16.0D, false);

        if (player != null) {
            // REPLACE THIS with your actual Karma getter logic

            int playerKarma = getKarma(player);

            if (playerKarma >= 50) { // Threshold for Stage 1
                this.evolve(level, pos);
            }
        }
    }

    private void evolve(ServerLevel level, BlockPos pos) {
        // Replace the sapling with the "Stage 1" block (the actual tree trunk/base)
        level.setBlock(pos, ModBlocks.YGGDRASIL_LOG.defaultBlockState(), 3);

        // Optional: Play a sound or particles
        level.levelEvent(2001, pos, Block.getId(this.defaultBlockState()));
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        if (random.nextInt(5) == 0) { // Only spawn 20% of the time
            double x = pos.getX() + 0.5 + (random.nextDouble() - 0.5) * 0.5;
            double y = pos.getY() + 0.5 + (random.nextDouble() - 0.5) * 0.5;
            double z = pos.getZ() + 0.5 + (random.nextDouble() - 0.5) * 0.5;

            // Spawn a green "Happy Villager" particle or a custom one
            level.addParticle(ParticleTypes.HAPPY_VILLAGER, x, y, z, 0.0, 0.1, 0.0);
        }
    }
}
