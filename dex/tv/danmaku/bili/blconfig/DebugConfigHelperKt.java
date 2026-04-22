package tv.danmaku.bili.blconfig;

import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: DebugConfigHelper.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u001a\u0006\u0010\u0003\u001a\u00020\u0004\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"BLCONFIG_DEBUG", "", "TAG", "hookConfigManagerIfNeed", "", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DebugConfigHelperKt {
    public static final String BLCONFIG_DEBUG = "blconfig_debug";
    private static final String TAG = "FFConfigDebugger";

    public static final void hookConfigManagerIfNeed() {
        if (DebugConfigActivityKt.isFFConfigDebugged()) {
            NoopDebugConfigManager.INSTANCE.attachNoopConfigManager();
        }
    }
}