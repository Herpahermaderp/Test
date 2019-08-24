package io.github.herpahermaderp.test;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.MathHelper;

public class TileEntityEyeCage extends TileEntity {
    public int tickCount;
    public float rotation;
    public float rotationPrev;
    public float tRot;
    private int count;
    
    public TileEntityEyeCage() { }
    
//    @Override
//    public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
//        nbt.setInteger("count", count);
//        return super.writeToNBT(nbt);
//    }
//    
//    @Override
//    public void readFromNBT(NBTTagCompound nbt) {
//        count = nbt.getInteger("count");
//        super.readFromNBT(nbt);
//    }
//    
//    public int getCount() {
//        return count;
//    }
//    
//    public void incrementCount() {
//        count++;
//        markDirty();
//    }
//    
//    public void decrementCount() {
//        count--;
//        markDirty();
//    }
    
    public void update() {
        this.rotationPrev = this.rotation;
        EntityPlayer player = this.getWorld().getClosestPlayer((double)((float)this.pos.getX() + 0.5f), (double)((float)this.pos.getY() + 0.5f), (double)((float)this.pos.getZ() + 0.5f), 3.0d, false);
        
        if(player != null) {
            double d0 = player.posX - (double)((float)this.pos.getX() + 0.5f);
            double d1 = player.posZ - (double)((float)this.pos.getZ() + 0.5f);
            this.tRot = (float)MathHelper.atan2(d1, d0);
        }
        
        else {
            this.tRot += 0.02f;
        }
        
        while (this.rotation >= (float)Math.PI) {
            this.rotation -= ((float)Math.PI * 2F);
        }

        while (this.rotation < -(float)Math.PI) {
            this.rotation += ((float)Math.PI * 2F);
        }

        while (this.tRot >= (float)Math.PI) {
            this.tRot -= ((float)Math.PI * 2F);
        }

        while (this.tRot < -(float)Math.PI) {
            this.tRot += ((float)Math.PI * 2F);
        }
        
        float f2;
        
        for(f2 = this.tRot - this.rotation; f2 >= (float)Math.PI; f2 -= ((float)Math.PI * 2f)) {
            ;
        }
        
        while(f2 < -(float)Math.PI) {
            f2 += ((float)Math.PI * 2f);
        }
        
        this.rotation += f2 * 0.4f;
        ++this.tickCount;
    }
}
