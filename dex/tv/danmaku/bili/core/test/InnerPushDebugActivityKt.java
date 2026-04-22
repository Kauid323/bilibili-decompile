package tv.danmaku.bili.core.test;

import android.content.SharedPreferences;
import com.bilibili.base.BiliContext;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import com.bilibili.droid.ToastHelper;
import com.google.gson.Gson;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;

/* compiled from: InnerPushDebugActivity.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u000b\u001a\u00020\f*\u0004\u0018\u00010\rH\u0002\u001a\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\fH\u0002\"\u001d\u0010\u0000\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003\"\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"pref", "Landroid/content/SharedPreferences;", "getPref", "()Landroid/content/SharedPreferences;", "pref$delegate", "Lkotlin/Lazy;", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "gson$delegate", "toJson", "", "", "toast", "", AuthResultCbHelper.ARGS_MSG, "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class InnerPushDebugActivityKt {
    private static final Lazy pref$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.core.test.InnerPushDebugActivityKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            SharedPreferences pref_delegate$lambda$0;
            pref_delegate$lambda$0 = InnerPushDebugActivityKt.pref_delegate$lambda$0();
            return pref_delegate$lambda$0;
        }
    });
    private static final Lazy gson$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.core.test.InnerPushDebugActivityKt$$ExternalSyntheticLambda1
        public final Object invoke() {
            Gson gson_delegate$lambda$0;
            gson_delegate$lambda$0 = InnerPushDebugActivityKt.gson_delegate$lambda$0();
            return gson_delegate$lambda$0;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final SharedPreferences getPref() {
        return (SharedPreferences) pref$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SharedPreferences pref_delegate$lambda$0() {
        return BiliGlobalPreferenceHelper.getBLKVSharedPreference();
    }

    private static final Gson getGson() {
        return (Gson) gson$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Gson gson_delegate$lambda$0() {
        return new Gson();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String toJson(Object $this$toJson) {
        if ($this$toJson == null) {
            return "";
        }
        String json = getGson().toJson($this$toJson);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        return json;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void toast(String msg) {
        ToastHelper.showToastShort(BiliContext.application(), msg);
    }
}