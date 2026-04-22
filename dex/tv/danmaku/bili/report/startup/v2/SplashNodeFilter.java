package tv.danmaku.bili.report.startup.v2;

import android.content.Context;
import com.bilibili.base.Applications;
import com.bilibili.teenagersmode.TeenagersMode;
import tv.danmaku.bili.report.startup.v2.TraceNode;

/* compiled from: TraceNodeFilterHolder.java */
class SplashNodeFilter implements TraceNode.INodeFilter {
    private Boolean mDisableSplash = null;

    @Override // tv.danmaku.bili.report.startup.v2.TraceNode.INodeFilter
    public boolean dropCurrent(TraceNode node) {
        if (BootTagHolder.TAG_SP_INIT.equalsIgnoreCase(node.getTag())) {
            if (this.mDisableSplash != null && this.mDisableSplash.booleanValue()) {
                StartUpUtilsKt.startUpTrace("drop SplashInit node because mDisableSplash = true");
                return true;
            }
            Context context = Applications.getCurrent();
            if (context != null) {
                this.mDisableSplash = Boolean.valueOf(TeenagersMode.getInstance().isEnable());
                StartUpUtilsKt.startUpTrace("drop SplashInit node mDisableSplash = " + this.mDisableSplash);
                return this.mDisableSplash.booleanValue();
            }
            StartUpUtilsKt.startUpTrace("drop SplashInit node because context = null");
            return true;
        }
        return false;
    }
}