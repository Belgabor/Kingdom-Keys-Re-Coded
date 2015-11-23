package wehavecookies56.kk.block;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.util.Vec3i;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.network.packet.PacketDispatcher;
import wehavecookies56.kk.network.packet.client.SpawnCureParticles;
import wehavecookies56.kk.network.packet.server.MagnetBloxMotion;
import wehavecookies56.kk.util.TextHelper;

public class BlockMagnetBlox extends BlockBlox {


	protected BlockMagnetBlox(Material material, String toolClass, int level, float hardness, float resistance) {
		super(material, toolClass, level, hardness, resistance);
	}
	public static final PropertyDirection PROPERTYFACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	public static final PropertyBool PROPERTYON = PropertyBool.create("on");

	@Override
	public int getMetaFromState(IBlockState state)
	{
		EnumFacing facing = (EnumFacing)state.getValue(PROPERTYFACING);
		boolean on = (Boolean) state.getValue(PROPERTYON);
		int facingbits = facing.getHorizontalIndex();

		if(on){
			facingbits += 4;
		}
		return facingbits;
	}

	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
	{
		return state;
	}

	@Override
	public void onEntityCollidedWithBlock(World world, BlockPos pos, Entity entityIn) {
		if (!world.isRemote){
			this.updateState(world, pos);
		}
		super.onEntityCollidedWithBlock(world, pos, entityIn);
	}

	@Override
	public void updateTick(World world, BlockPos pos, IBlockState state, Random rand) {
		if (!world.isRemote){
			this.updateState(world, pos);
		}
		super.updateTick(world, pos, state, rand);
	}

	private void updateState(World world, BlockPos pos){
		List list = world.getEntitiesWithinAABBExcludingEntity((Entity)null, this.getCollisionBoundingBox(world, pos, world.getBlockState(pos)));
		if(!list.isEmpty())
		{
			for(int i=0; i<list.size();i++)
			{
				Entity e = (Entity) list.get(i);
				if(e instanceof EntityLivingBase){
					if(e instanceof EntityPlayer){
						System.out.println("Ok");
						((EntityPlayer) e).jump();
					}
				}

			}
		}
		world.scheduleUpdate(pos, this, this.tickRate(world));
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, BlockPos pos) {
		IBlockState state = world.getBlockState(pos);
		EnumFacing facing = (EnumFacing) state.getValue(PROPERTYFACING);
		boolean isOn = (Boolean) state.getValue(PROPERTYON);
		if(isOn){
			if(facing == EnumFacing.NORTH){
				state.getBlock().setBlockBounds(0, 0, 0, 1, 1, 10);
			}else if(facing == EnumFacing.SOUTH){
				state.getBlock().setBlockBounds(0, 0, 0, 1, 1, -10);
			}else if(facing == EnumFacing.EAST){
				state.getBlock().setBlockBounds(0, 0, 0, -10, 1, 1);
			}else if(facing == EnumFacing.WEST){
				state.getBlock().setBlockBounds(0, 0, 0, 10, 1, 1);
			}
		}else{
			state.getBlock().setBlockBounds(0, 0, 0, 1, 1, 1);
		}
		super.setBlockBoundsBasedOnState(world, pos);
	}

	@Override
	public void onNeighborBlockChange(World world, BlockPos pos, IBlockState state, Block neighborBlock) {

		if(world.isBlockPowered(pos))
		{
			world.setBlockState(pos, world.getBlockState(pos).withProperty(PROPERTYON, true));
		}
		else
		{
			world.setBlockState(pos, world.getBlockState(pos).withProperty(PROPERTYON, false));
		}
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBox(World world, BlockPos pos, IBlockState state) {
		EnumFacing facing = (EnumFacing) state.getValue(PROPERTYFACING);
		if(world.isBlockPowered(pos)){
			if(facing == EnumFacing.NORTH){
				return new AxisAlignedBB(pos.add(0, 0, 0), pos.add(1, 1, 10));
			}else if(facing == EnumFacing.SOUTH){
				return new AxisAlignedBB(pos.add(0, 0, -10), pos.add(1, 1, 10));
			}else if(facing == EnumFacing.EAST){
				return new AxisAlignedBB(pos.add(-10, 0, 0), pos.add(10, 1, 1));
			}else if(facing == EnumFacing.WEST){
				return new AxisAlignedBB(pos.add(0, 0, 0), pos.add(10, 1, 1));
			}
		}else{
			return new AxisAlignedBB(pos.add(0, 0, 0), pos.add(1, 1, 1));
		}
		return new AxisAlignedBB(pos.add(0, 0, 0), pos.add(1, 1, 1));
	}

	@Override
	protected BlockState createBlockState()
	{
		return new BlockState(this, new IProperty[] {PROPERTYFACING, PROPERTYON});
	}

	@Override
	public IBlockState onBlockPlaced(World world, BlockPos pos, EnumFacing blockFaceClickedOn, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
	{
		EnumFacing enumfacing = (placer == null) ? EnumFacing.NORTH : EnumFacing.fromAngle(placer.rotationYaw);

		return this.getDefaultState().withProperty(PROPERTYFACING, enumfacing).withProperty(PROPERTYON, false);
	}
}