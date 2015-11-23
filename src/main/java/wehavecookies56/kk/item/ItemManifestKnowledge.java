package wehavecookies56.kk.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import wehavecookies56.kk.network.packet.PacketDispatcher;
import wehavecookies56.kk.network.packet.server.ManifestKnowledgePacket;

public class ItemManifestKnowledge extends Item {

	public ItemManifestKnowledge() {
		this.setMaxStackSize(1);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {
		if(worldIn.isRemote){
			PacketDispatcher.sendToServer(new ManifestKnowledgePacket());
		}
		return super.onItemRightClick(itemStackIn, worldIn, playerIn);
	}
	
}