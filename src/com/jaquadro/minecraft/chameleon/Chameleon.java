package com.jaquadro.minecraft.chameleon;

import com.jaquadro.minecraft.chameleon.core.CommonProxy;
import com.jaquadro.minecraft.chameleon.resources.IconRegistry;
import com.jaquadro.minecraft.chameleon.resources.ModelRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.Logger;

@Mod(modid = Chameleon.MOD_ID, name = Chameleon.MOD_NAME, version = Chameleon.MOD_VERSION, dependencies = "required-after:forge@[14.21.0.2362,);", acceptedMinecraftVersions = "[1.12,1.13)")
public class Chameleon
{
    public static final String MOD_ID = "chameleon";
    public static final String MOD_NAME = "Chameleon";
    public static final String MOD_VERSION = "@VERSION@";
    public static final String SOURCE_PATH = "com.jaquadro.minecraft.chameleon.";

    public static Logger log;

    @SideOnly(Side.CLIENT)
    public IconRegistry iconRegistry;

    @SideOnly(Side.CLIENT)
    public ModelRegistry modelRegistry;

    @Mod.Instance(MOD_ID)
    public static Chameleon instance;

    @SidedProxy(clientSide = SOURCE_PATH + "core.ClientProxy", serverSide = SOURCE_PATH + "core.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit (FMLPreInitializationEvent event) {
        log = event.getModLog();

        MinecraftForge.EVENT_BUS.register(proxy);
        proxy.preInitSidedResources();
    }

    @Mod.EventHandler
    public void init (FMLInitializationEvent event) {
        proxy.initSidedResources();

    }
}
