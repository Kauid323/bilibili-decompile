package tv.danmaku.player.plugin.mod;

import com.bilibili.lib.plugin.extension.model.plugin.SoLibPackage;
import com.bilibili.lib.plugin.model.plugin.PluginFactory;
import com.bilibili.lib.plugin.model.plugin.PluginMaterial;
import com.bilibili.lib.plugin.model.request.PluginRequest;

public class X86IjkRequest extends PluginRequest<SoLibPackage> {
    public static final String PLUGIN_ID = "ijkx86";
    public static final String POOL = "player";

    public X86IjkRequest() {
        super(POOL, PLUGIN_ID, new IjkChecker());
    }

    public PluginFactory<SoLibPackage> getPluginFactory() {
        return new PluginFactory<SoLibPackage>() { // from class: tv.danmaku.player.plugin.mod.X86IjkRequest.1
            /* renamed from: createPlugin */
            public SoLibPackage m2684createPlugin(PluginMaterial material) {
                return new SoLibPackage(material);
            }
        };
    }
}