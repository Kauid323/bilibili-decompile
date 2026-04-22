package tv.danmaku.player.plugin.mod;

import android.text.TextUtils;
import com.bilibili.lib.mod.ModResource;
import com.bilibili.lib.plugin.model.plugin.PluginConfig;
import com.bilibili.lib.plugin.model.request.ModResourceChecker;
import com.bilibili.lib.plugin.util.ConfigUtils;
import java.io.File;
import java.io.IOException;

public class IjkChecker implements ModResourceChecker {
    public boolean check(ModResource resource) {
        File file = resource.retrieveFile("config");
        String modVersion = "";
        try {
            PluginConfig config = ConfigUtils.parseConfig(file);
            modVersion = config.mVersion;
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (TextUtils.isEmpty(modVersion)) {
            return false;
        }
        return TextUtils.equals(modVersion, "0.8.74.5");
    }
}