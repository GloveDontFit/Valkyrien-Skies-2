package org.valkyrienskies.mod.fabric.mixin;

import java.util.List;
import java.util.Set;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;
import org.valkyrienskies.mod.compat.LoadedMods;

public class ValkyrienSkiesFabricMixinPlugin implements IMixinConfigPlugin {

    private static boolean classExists(final String className) {
        try {
            Class.forName(className, false, ValkyrienSkiesFabricMixinPlugin.class.getClassLoader());
            return true;
        } catch (final ClassNotFoundException ex) {
            return false;
        }
    }

    @Override
    public void onLoad(final String s) {

    }

    @Override
    public String getRefMapperConfig() {
        return "";
    }

    private static boolean isModLoaded(final String modId) {
        try {
            return net.fabricmc.loader.api.FabricLoader.getInstance().isModLoaded(modId);
        } catch (final Throwable t) {
            return false;
        }
    }

    @Override
    public boolean shouldApplyMixin(final String s, final String mixinClassName) {
        if (mixinClassName.contains(".compat.cc_restitched.") && !isModLoaded("computercraft")) {
            return false;
        }
        if (mixinClassName.contains(".compat.sodium.") && !isModLoaded("sodium")) {
            return false;
        }
        if (mixinClassName.contains(".compat.connectiblechains.") && !isModLoaded("connectiblechains")) {
            return false;
        }
        if (mixinClassName.contains(".compat.emf.") && !isModLoaded("entity_model_features")) {
            return false;
        }
        if (mixinClassName.contains("org.valkyrienskies.mod.fabric.mixin.compat.old_create")) {
            return LoadedMods.getOldCreate();
        }

        return true;
    }

    @Override
    public void acceptTargets(final Set<String> set, final Set<String> set1) {

    }

    @Override
    public List<String> getMixins() {
        return List.of();
    }

    @Override
    public void preApply(final String s, final ClassNode classNode, final String s1, final IMixinInfo iMixinInfo) {

    }

    @Override
    public void postApply(final String s, final ClassNode classNode, final String s1, final IMixinInfo iMixinInfo) {

    }
}
