package tv.danmaku.bili.push.innerpush.config;

import android.content.SharedPreferences;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import com.bilibili.lib.blconfig.ConfigManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;

/* compiled from: InnerPushLocalStorage.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\"\u001b\u0010\u0000\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0000\u0010\u0002\"\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\u0007\u0010\b\"\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"isHitInnerPushV2Exp", "", "()Z", "isHitInnerPushV2Exp$delegate", "Lkotlin/Lazy;", "pref", "Landroid/content/SharedPreferences;", "getPref", "()Landroid/content/SharedPreferences;", "pref$delegate", "TAG", "", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class InnerPushLocalStorageKt {
    private static final String TAG = "[InnerPush]InnerPushLocalStorage";
    private static final Lazy isHitInnerPushV2Exp$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.push.innerpush.config.InnerPushLocalStorageKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            boolean isHitInnerPushV2Exp_delegate$lambda$0;
            isHitInnerPushV2Exp_delegate$lambda$0 = InnerPushLocalStorageKt.isHitInnerPushV2Exp_delegate$lambda$0();
            return Boolean.valueOf(isHitInnerPushV2Exp_delegate$lambda$0);
        }
    });
    private static final Lazy pref$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.push.innerpush.config.InnerPushLocalStorageKt$$ExternalSyntheticLambda1
        public final Object invoke() {
            SharedPreferences pref_delegate$lambda$0;
            pref_delegate$lambda$0 = InnerPushLocalStorageKt.pref_delegate$lambda$0();
            return pref_delegate$lambda$0;
        }
    });

    public static final boolean isHitInnerPushV2Exp() {
        return ((Boolean) isHitInnerPushV2Exp$delegate.getValue()).booleanValue();
    }

    public static final boolean isHitInnerPushV2Exp_delegate$lambda$0() {
        Boolean bool = (Boolean) ConfigManager.Companion.ab().get("inner_push_use_server_filter", true);
        boolean value = bool != null ? bool.booleanValue() : true;
        BLog.i(TAG, "inner_push_use_server_filter = " + value);
        return value;
    }

    public static final SharedPreferences getPref() {
        return (SharedPreferences) pref$delegate.getValue();
    }

    public static final SharedPreferences pref_delegate$lambda$0() {
        return BiliGlobalPreferenceHelper.getBLKVSharedPreference();
    }
}