package hibi.blahaj;

import net.minecraft.world.inventory.ItemCombinerMenu;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod(BlahajMod.MOD_ID)
public class BlahajMod {
	public static final String MOD_ID = "blahaj";
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BlahajMod.MOD_ID);
	public static final RegistryObject<Item> KLAPPER_HAJ = ITEMS.register("gray_shark", () -> new CuddlyItem(new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_MISC),"item.blahaj.gray_shark.tooltip"));
	public static final RegistryObject<Item> BLAHAJ = ITEMS.register("blue_shark", () -> new CuddlyItem(new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_MISC),"item.blahaj.blue_shark.tooltip"));
	public static final RegistryObject<Item> BREAD = ITEMS.register("bread", () -> new CuddlyItem(new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_MISC),null));

	public BlahajMod() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

		ITEMS.register(modEventBus);
	}
}
