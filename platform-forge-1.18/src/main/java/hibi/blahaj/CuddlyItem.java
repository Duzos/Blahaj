package hibi.blahaj;

import net.minecraft.ChatFormatting;
import net.minecraft.nbt.*;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CuddlyItem extends Item {
	private final MutableComponent subtitle;
	public static final String OWNER_KEY = "Owner";

	public CuddlyItem(Properties properties, String subtitle) {
		super(properties);

		this.subtitle = subtitle == null? null: new TranslatableComponent(subtitle).withStyle(ChatFormatting.GRAY);
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
		super.appendHoverText(stack, level, tooltip, flag);

		if (this.subtitle != null) {
			tooltip.add(this.subtitle);
		}

		if (stack.hasTag()) {
			CompoundTag tag = stack.getTag();
			String owner = tag.getString(OWNER_KEY);

			if (owner.equals("")) {
				return;
			}
			if (stack.hasCustomHoverName()) {
				tooltip.add(new TranslatableComponent("tooltip.blahaj.owner.rename",this.getName(stack), FormattedText.of(owner)).withStyle(ChatFormatting.GRAY));
			}
			else {
				tooltip.add(new TranslatableComponent("tooltip.blahaj.owner.craft", FormattedText.of(owner)).withStyle(ChatFormatting.GRAY));
			}
		}
	}

	@Override
	public void onCraftedBy(ItemStack stack, Level level, Player player) {
		if (player != null) {
			stack.addTagElement(OWNER_KEY, StringTag.valueOf(player.getName().getString()));
		}

		super.onCraftedBy(stack, level, player);
	}

	@Override
	public float getDestroySpeed(ItemStack stack, BlockState state) {
		return 0.25f;
	}
}
