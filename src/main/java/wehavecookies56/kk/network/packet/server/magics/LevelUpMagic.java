package wehavecookies56.kk.network.packet.server.magics;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import net.minecraftforge.fml.relauncher.Side;
import wehavecookies56.kk.api.recipes.RecipeRegistry;
import wehavecookies56.kk.entities.ExtendedPlayer;
import wehavecookies56.kk.network.packet.AbstractMessage.AbstractServerMessage;
import wehavecookies56.kk.util.TextHelper;

public class LevelUpMagic extends AbstractServerMessage<LevelUpMagic> {

	String magic;

	public LevelUpMagic() {}

	public LevelUpMagic(String magic){
		this.magic = magic;
	}

	@Override
	protected void read(PacketBuffer buffer) throws IOException {
		magic = buffer.readStringFromBuffer(40);
	}

	@Override
	protected void write(PacketBuffer buffer) throws IOException {
		buffer.writeString(magic);
	}

	@Override
	public void process(EntityPlayer player, Side side)
	{
		if(!player.worldObj.isRemote)
		{
			ExtendedPlayer ep = ExtendedPlayer.get(player);
			int fireLevel = ExtendedPlayer.get(player).getMagicLevel("Fire");
			int blizzardLevel = ExtendedPlayer.get(player).getMagicLevel("Blizzard");
			int thunderLevel = ExtendedPlayer.get(player).getMagicLevel("Thunder");
			int cureLevel = ExtendedPlayer.get(player).getMagicLevel("Cure");
			int aeroLevel = ExtendedPlayer.get(player).getMagicLevel("Aero");
			int stopLevel = ExtendedPlayer.get(player).getMagicLevel("Stop");
			
			if(magic.equals("Fire"))
			{
				if(fireLevel == 1 || fireLevel == 2)
				{
					ep.setMagicLevel("Fire", fireLevel+1);
					player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
				}
				else
				{
					TextHelper.sendFormattedChatMessage("Can't level up "+magic+", Actual level: "+fireLevel, EnumChatFormatting.YELLOW, player);
				}
			}
			else if(magic.equals("Blizzard"))
			{
				if(blizzardLevel == 1 || blizzardLevel == 2)
				{
					ep.setMagicLevel("Blizzard", blizzardLevel+1);
					player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
				}
				else
				{
					TextHelper.sendFormattedChatMessage("Can't level up "+magic+", Actual level: "+blizzardLevel, EnumChatFormatting.YELLOW, player);
				}
			}
			else if(magic.equals("Thunder"))
			{
				if(thunderLevel == 1 || thunderLevel == 2)
				{
					ep.setMagicLevel("Thunder", thunderLevel+1);
					player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
				}
				else
				{
					TextHelper.sendFormattedChatMessage("Can't level up "+magic+", Actual level: "+thunderLevel, EnumChatFormatting.YELLOW, player);
				}
			}
			else if(magic.equals("Cure"))
			{
				if(cureLevel == 1 || cureLevel == 2)
				{
					ep.setMagicLevel("Cure", cureLevel+1);
					player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
				}
				else
				{
					TextHelper.sendFormattedChatMessage("Can't level up "+magic+", Actual level: "+cureLevel, EnumChatFormatting.YELLOW, player);
				}
			}
			else if(magic.equals("Aero"))
			{
				if(aeroLevel == 1 || aeroLevel == 2)
				{
					ep.setMagicLevel("Aero", aeroLevel+1);
					player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
				}
				else
				{
					TextHelper.sendFormattedChatMessage("Can't level up "+magic+", Actual level: "+aeroLevel, EnumChatFormatting.YELLOW, player);
				}
			}
			else if(magic.equals("Stop"))
			{
				if(stopLevel == 1 || stopLevel == 2)
				{
					ep.setMagicLevel("Stop", stopLevel+1);
					player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
				}
				else
				{
					TextHelper.sendFormattedChatMessage("Can't level up "+magic+", Actual level: "+stopLevel, EnumChatFormatting.YELLOW, player);
				}
			}
		}
	}

}