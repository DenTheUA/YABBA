package com.latmod.yabba.net;

import com.feed_the_beast.ftbl.lib.net.LMNetworkWrapper;
import com.latmod.yabba.Yabba;

/**
 * Created by LatvianModder on 15.12.2016.
 */
public class YabbaNetHandler
{
    static final LMNetworkWrapper NET = LMNetworkWrapper.newWrapper(Yabba.MOD_ID);

    public static void init()
    {
        int id = 0;
        NET.register(++id, new MessageSyncData());
        NET.register(++id, new MessageUpdateBarrelItemCount());
        NET.register(++id, new MessageUpdateBarrelFull());
        NET.register(++id, new MessageRequestBarrelUpdate());
        NET.register(++id, new MessageSelectModel());
        NET.register(++id, new MessageSelectSkin());
    }
}