package com.latmod.yabba;

import com.feed_the_beast.ftbl.api.FTBLibAPI;
import com.feed_the_beast.ftbl.api.FTBLibPlugin;
import com.feed_the_beast.ftbl.api.IFTBLibPlugin;
import com.feed_the_beast.ftbl.api.IFTBLibRegistry;
import com.feed_the_beast.ftbl.api.IRecipes;
import com.latmod.yabba.models.ModelBarrel;
import com.latmod.yabba.util.EnumUpgrade;
import com.latmod.yabba.util.Tier;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.ItemHandlerHelper;

/**
 * Created by LatvianModder on 19.01.2017.
 */
public enum FTBLibIntegration implements IFTBLibPlugin
{
    @FTBLibPlugin
    INSTANCE;

    public static FTBLibAPI API;

    @Override
    public void init(FTBLibAPI api)
    {
        API = api;
    }

    @Override
    public void registerCommon(IFTBLibRegistry reg)
    {
        /*
        reg.addConfigFileProvider(XPT.MOD_ID, () -> new File(LMUtils.folderConfig, "YABBA.json"));

        reg.addConfig(XPT.MOD_ID, "general.enable_crafting", XPTConfig.ENABLE_CRAFTING).setInfo("Enable crafting recipes");
        reg.addConfig(XPT.MOD_ID, "general.levels_per_block", XPTConfig.LEVELS_PER_BLOCK).setInfo("Levels required to teleport in same dimension");
        reg.addConfig(XPT.MOD_ID, "general.levels_for_crossdim", XPTConfig.LEVELS_FOR_CROSSDIM).setInfo("Levels required to teleport to another dimension");
        reg.addConfig(XPT.MOD_ID, "general.soft_blocks", XPTConfig.SOFT_BLOCKS).setInfo("Soft blocks are like torches - you can walk trough them, BUT it solved the 'getting stuck in block' issue");

        reg.addSyncData(XPT.MOD_ID, new XPTSyncData());
        */
    }

    @Override
    public void registerRecipes(IRecipes recipes)
    {
        ItemStack blankUpgrade = EnumUpgrade.BLANK.item();

        recipes.addRecipe(ItemHandlerHelper.copyStackWithSize(blankUpgrade, 16),
                "SSS", "ICI", "SSS",
                'I', Blocks.IRON_BARS,
                'C', "chestWood",
                'S', "slabWood");

        recipes.addRecipe(YabbaItems.BARREL.createStack(ModelBarrel.INSTANCE, YabbaRegistry.DEFAULT_SKIN, Tier.WOOD),
                " U ", "SCS", " P ",
                'U', blankUpgrade,
                'C', "chestWood",
                'S', "slabWood",
                'P', "plankWood");

        recipes.addRecipe(new ItemStack(YabbaItems.PAINTER),
                "WWU", " I ", " I ",
                'U', blankUpgrade,
                'I', "ingotIron",
                'W', Blocks.WOOL);

        recipes.addRecipe(new ItemStack(YabbaItems.HAMMER),
                "WUW", " I ", " I ",
                'U', blankUpgrade,
                'I', "ingotIron",
                'W', Blocks.WOOL);

        recipes.addRecipe(EnumUpgrade.IRON_UPGRADE.item(),
                "III", "IUI", "III",
                'U', blankUpgrade,
                'I', "ingotIron");

        recipes.addRecipe(EnumUpgrade.GOLD_UPGRADE.item(),
                "III", "IUI", "III",
                'U', blankUpgrade,
                'I', "ingotGold");

        recipes.addRecipe(EnumUpgrade.DIAMOND_UPGRADE.item(),
                "IUI",
                'U', blankUpgrade,
                'I', "gemDiamond");

        recipes.addShapelessRecipe(EnumUpgrade.VOID.item(), blankUpgrade, "obsidian");
        recipes.addShapelessRecipe(EnumUpgrade.NETHER_STAR_UPGRADE.item(), EnumUpgrade.VOID.item(), Items.NETHER_STAR);

        recipes.addRecipe(new ItemStack(YabbaItems.UPGRADE, 1, EnumUpgrade.OBSIDIAN_SHELL.metadata),
                " I ", "IUI", " I ",
                'U', blankUpgrade,
                'I', "obsidian");

        recipes.addShapelessRecipe(new ItemStack(YabbaItems.UPGRADE, 1, EnumUpgrade.REDSTONE_OUT.metadata), blankUpgrade, Items.COMPARATOR);
        recipes.addShapelessRecipe(new ItemStack(YabbaItems.UPGRADE, 1, EnumUpgrade.HOPPER.metadata), blankUpgrade, Blocks.HOPPER);

        recipes.addRecipe(new ItemStack(YabbaItems.ANTIBARREL),
                "NQN", "NON", "NCN",
                'N', "ingotBrickNether",
                'Q', "blockQuartz",
                'O', "obsidian",
                'C', "chestWood");
    }
}