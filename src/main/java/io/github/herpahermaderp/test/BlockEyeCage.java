package io.github.herpahermaderp.test;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockEyeCage extends Block {
    private static final AxisAlignedBB AABB = new AxisAlignedBB(3.0 / 16, 0, 3.0 / 16, 13.0 / 16, 1, 13.0 / 16);
    
    public BlockEyeCage(String name, Material mat) {
        super(mat);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess world, BlockPos pos) {
        return AABB;
    }
    
    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }
    
    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }
    
    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }
    
    @Override
    public boolean hasTileEntity() {
        return true;
    }
    
    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {
        System.out.println("Test");
        return new TileEntityEyeCage();
    }
    
    @Override
    public BlockFaceShape getBlockFaceShape(IBlockAccess world, IBlockState state, BlockPos pos, EnumFacing face) {
        return BlockFaceShape.UNDEFINED;
    }
    
    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        System.out.println((TileEntityEyeCage) world.getTileEntity(pos));
//        if(!world.isRemote) {
//            TileEntityEyeCage te = (TileEntityEyeCage) world.getTileEntity(pos);
//            if(side == EnumFacing.DOWN) {
//                te.decrementCount();
//            }
//            
//            else if (side == EnumFacing.UP) {
//                te.incrementCount();
//            }
//            
//            player.sendMessage(new TextComponentString("Count: " + te.getCount()));
//        }
        return true;
    }
}
