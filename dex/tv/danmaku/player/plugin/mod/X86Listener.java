package tv.danmaku.player.plugin.mod;

import com.bilibili.lib.plugin.callback.PluginListenerHelper;
import com.bilibili.lib.plugin.exception.PluginError;
import com.bilibili.lib.plugin.extension.model.behavior.SoLibBehavior;
import com.bilibili.lib.plugin.extension.model.plugin.SoLibPackage;
import tv.danmaku.android.log.BLog;

public class X86Listener extends PluginListenerHelper<SoLibBehavior, SoLibPackage, X86IjkRequest> {
    private static final String TAG = "plugin.x86listener";

    @Override // 
    public void onPostLoad(X86IjkRequest request, SoLibBehavior behavior) {
        IjkX86Helper.sIjkX86 = behavior;
    }

    @Override // 
    public void onFail(X86IjkRequest request, PluginError error) {
        BLog.w(TAG, "Request ijk x86 fail, error = " + error);
    }
}