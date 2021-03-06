package com.latmod.yabba.client;

import com.latmod.yabba.Yabba;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ICustomModelLoader;
import net.minecraftforge.client.model.IModel;

/**
 * Created by LatvianModder on 19.12.2016.
 */
public class YabbaModels implements ICustomModelLoader
{
    @Override
    public boolean accepts(ResourceLocation modelLocation)
    {
        return modelLocation instanceof ModelResourceLocation && modelLocation.getResourceDomain().equals(Yabba.MOD_ID) && modelLocation.getResourcePath().equals("barrel");
    }

    @Override
    public IModel loadModel(ResourceLocation modelLocation) throws Exception
    {
        return new BarrelModel(((ModelResourceLocation) modelLocation).getVariant());
    }

    @Override
    public void onResourceManagerReload(IResourceManager resourceManager)
    {
    }
}