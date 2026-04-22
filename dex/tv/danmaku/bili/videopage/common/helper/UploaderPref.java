package tv.danmaku.bili.videopage.common.helper;

import android.content.SharedPreferences;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import com.bilibili.lib.foundation.FoundationAlias;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: VideoDetailsSharedPreferences.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Ltv/danmaku/bili/videopage/common/helper/UploaderPref;", "", "<init>", "()V", "PREF_KEY_UPLOADER_EXPAND", "", "defaultPref", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "getUploaderExpand", "", "saveUploaderExpand", "", "expand", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class UploaderPref {
    private static final String PREF_KEY_UPLOADER_EXPAND = "pref_key_uploader_expand";
    public static final UploaderPref INSTANCE = new UploaderPref();
    private static final SharedPreferences defaultPref = BiliGlobalPreferenceHelper.getBLKVSharedPreference(FoundationAlias.getFapp());

    private UploaderPref() {
    }

    public final boolean getUploaderExpand() {
        return defaultPref.getBoolean(PREF_KEY_UPLOADER_EXPAND, true);
    }

    public final void saveUploaderExpand(boolean expand) {
        SharedPreferences $this$edit_u24default$iv = defaultPref;
        Intrinsics.checkNotNullExpressionValue($this$edit_u24default$iv, "defaultPref");
        SharedPreferences.Editor editor$iv = $this$edit_u24default$iv.edit();
        editor$iv.putBoolean(PREF_KEY_UPLOADER_EXPAND, expand);
        editor$iv.apply();
    }
}