package com.latmod.yabba.item;

import com.latmod.yabba.Yabba;
import com.latmod.yabba.YabbaCommon;
import net.minecraft.item.Item;

/**
 * Created by LatvianModder on 19.01.2017.
 */
public class ItemYabba extends Item
{
    public ItemYabba(String id)
    {
        setRegistryName(Yabba.MOD_ID + ':' + id);
        setUnlocalizedName(Yabba.MOD_ID + '.' + id);
        setCreativeTab(YabbaCommon.TAB);
    }
}