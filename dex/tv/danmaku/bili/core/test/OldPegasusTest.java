package tv.danmaku.bili.core.test;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.view.View;
import androidx.core.app.ActivityCompat$;
import com.bilibili.app.comm.list.widget.utils.SharedPreferencesField;
import com.bilibili.app.provider.UtilKt;
import com.bilibili.droid.ToastHelper;
import com.bilibili.kaptbundle.BuildConfig;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.list.test.AbsButtonTestItem;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;

/* compiled from: MainTestPageActivity.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R+\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Ltv/danmaku/bili/core/test/OldPegasusTest;", "Lcom/bilibili/list/test/AbsButtonTestItem;", "<init>", "()V", "<set-?>", "", "switch", "getSwitch", "()Z", "setSwitch", "(Z)V", "switch$delegate", "Lcom/bilibili/app/comm/list/widget/utils/SharedPreferencesField;", "getButtonText", "", "context", "Landroid/content/Context;", "onClick", "", "v", "Landroid/view/View;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class OldPegasusTest extends AbsButtonTestItem {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(OldPegasusTest.class, "switch", "getSwitch()Z", 0))};
    public static final int $stable = AbsButtonTestItem.$stable | SharedPreferencesField.$stable;
    private final SharedPreferencesField switch$delegate = new SharedPreferencesField("sp_key_pegasus_show_old_pegasus_tab", false, (SharedPreferences) null, 4, (DefaultConstructorMarker) null);

    private static void __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookActivityFinish(Object activity) {
        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
        if (Intrinsics.areEqual(ConfigManager.Companion.ab().get("bgthread_ui_access_detect_enable", true), true)) {
            Thread thread = Thread.currentThread();
            if (!Intrinsics.areEqual(thread, Looper.getMainLooper().getThread())) {
                IllegalStateException exp = new IllegalStateException("Activity.finish() called from non-UI thread: " + thread + ", 请联系 Jackin");
                BLog.e("BgThreadUIAccess", "Activity.finish() called from non-UI thread: " + thread, exp);
                Neurons.trackT(false, "app.bgthread.ui.access", MapsKt.mapOf(new Pair[]{TuplesKt.to("stacktrace", ExceptionsKt.stackTraceToString(exp)), TuplesKt.to("threadName", thread.getName())}), 1, new ActivityCompat$.ExternalSyntheticLambda0());
                if (BuildConfig.DEBUG) {
                    throw exp;
                }
            }
        }
        ((Activity) activity).finish();
    }

    private final boolean getSwitch() {
        return ((Boolean) this.switch$delegate.getValue(this, $$delegatedProperties[0])).booleanValue();
    }

    private final void setSwitch(boolean z) {
        this.switch$delegate.setValue(this, $$delegatedProperties[0], Boolean.valueOf(z));
    }

    public CharSequence getButtonText(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return getSwitch() ? "首页tab关闭老天马" : "首页tab展示老天马";
    }

    public void onClick(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        setSwitch(!getSwitch());
        ToastHelper.showToastShort(v.getContext(), "重置成功，请冷启");
        Activity findActivityOrNull = UtilKt.findActivityOrNull(v.getContext());
        if (findActivityOrNull != null) {
            __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookActivityFinish(findActivityOrNull);
        }
    }
}