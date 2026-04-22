package tv.danmaku.bili.blconfig;

import com.bilibili.lib.foundation.FoundationAlias;
import com.bilibili.xpref.Xpref;
import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: DebugConfigActivity.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"$\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003@GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"SP_KEY_FFCONFIG_DEBUG_FUNCTIONAL_ENABLED", "", "value", "", "isFFConfigDebugged", "()Z", "setFFConfigDebugged", "(Z)V", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DebugConfigActivityKt {
    private static final String SP_KEY_FFCONFIG_DEBUG_FUNCTIONAL_ENABLED = "sp_key_ffconfig_debug_function_enabled";
    private static boolean isFFConfigDebugged = Xpref.getDefaultSharedPreferences(FoundationAlias.getFapp()).getBoolean(SP_KEY_FFCONFIG_DEBUG_FUNCTIONAL_ENABLED, false);

    public static final boolean isFFConfigDebugged() {
        return isFFConfigDebugged;
    }

    public static final void setFFConfigDebugged(boolean value) {
        isFFConfigDebugged = value;
        Xpref.getDefaultSharedPreferences(FoundationAlias.getFapp()).edit().putBoolean(SP_KEY_FFCONFIG_DEBUG_FUNCTIONAL_ENABLED, value).apply();
    }
}