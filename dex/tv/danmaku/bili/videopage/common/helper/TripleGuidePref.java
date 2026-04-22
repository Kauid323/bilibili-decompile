package tv.danmaku.bili.videopage.common.helper;

import android.content.SharedPreferences;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import com.bilibili.lib.foundation.FoundationAlias;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: VideoDetailsSharedPreferences.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Ltv/danmaku/bili/videopage/common/helper/TripleGuidePref;", "", "<init>", "()V", "PREF_KEY_TRIPLE_GUIDE_TIME", "", "defaultPref", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "getLastGuideTime", "", "saveLastGuideTime", "", "isOverInterval", "", "interval", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class TripleGuidePref {
    private static final String PREF_KEY_TRIPLE_GUIDE_TIME = "pref_key_triple_guide_time";
    public static final TripleGuidePref INSTANCE = new TripleGuidePref();
    private static final SharedPreferences defaultPref = BiliGlobalPreferenceHelper.getBLKVSharedPreference(FoundationAlias.getFapp());

    private TripleGuidePref() {
    }

    public final long getLastGuideTime() {
        return defaultPref.getLong(PREF_KEY_TRIPLE_GUIDE_TIME, -1L);
    }

    public final void saveLastGuideTime() {
        SharedPreferences $this$edit_u24default$iv = defaultPref;
        Intrinsics.checkNotNullExpressionValue($this$edit_u24default$iv, "defaultPref");
        SharedPreferences.Editor editor$iv = $this$edit_u24default$iv.edit();
        editor$iv.putLong(PREF_KEY_TRIPLE_GUIDE_TIME, System.currentTimeMillis());
        editor$iv.apply();
    }

    public final boolean isOverInterval(long interval) {
        long lastTime = getLastGuideTime();
        if (lastTime >= 0) {
            long currentTime = System.currentTimeMillis();
            r3 = currentTime - lastTime > interval;
            boolean it = r3;
            BLog.i(PREF_KEY_TRIPLE_GUIDE_TIME, "isOverInterval -> [res = " + it + ", currentTime = " + currentTime + ", lastTime = " + lastTime + ", interval = " + interval + "]");
        }
        return r3;
    }
}