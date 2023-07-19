package net.w.fabrichammers.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.w.fabrichammers.FabricHammers;
import net.w.fabrichammers.config.ConfigProvider;

public class HammerItemGroup {
    public static ItemGroup FABRIC_HAMMERS;

    public static void registerItemGroup() {
        FABRIC_HAMMERS = FabricItemGroup.builder(new Identifier(FabricHammers.MOD_ID, "citrine"))
                .displayName(Text.translatable("itemgroup.fabrichammers"))
                .icon(() -> new ItemStack(HammerItem.DIAMOND_HAMMER)).build();
        addItemsToItemGroup();
    }

    public static void addItemsToItemGroup() {
        addToItemGroup(FABRIC_HAMMERS, HammerItem.WOODEN_HAMMER);
        addToItemGroup(FABRIC_HAMMERS, HammerItem.STONE_HAMMER);
        addToItemGroup(FABRIC_HAMMERS, HammerItem.IRON_HAMMER);
        addToItemGroup(FABRIC_HAMMERS, HammerItem.GOLDEN_HAMMER);
        addToItemGroup(FABRIC_HAMMERS, HammerItem.DIAMOND_HAMMER);
        addToItemGroup(FABRIC_HAMMERS, HammerItem.NETHERITE_HAMMER);

        if (ConfigProvider.CONFIG.isEnableEmeradlTools()){
            addToItemGroup(FABRIC_HAMMERS, HammerItem.EMERALD_HAMMER);
        }
    }

    private static void addToItemGroup(ItemGroup group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }
}
