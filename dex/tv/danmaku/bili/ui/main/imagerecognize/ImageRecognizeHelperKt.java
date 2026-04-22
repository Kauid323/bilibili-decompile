package tv.danmaku.bili.ui.main.imagerecognize;

import android.app.Activity;
import android.os.Looper;
import androidx.core.app.ActivityCompat$;
import com.bilibili.kaptbundle.BuildConfig;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.neuron.api.Neurons;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;

/* compiled from: ImageRecognizeHelper.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"SHARE_TYPE_UGC", "", "SHARE_TYPE_ACTIVITY", "MARK_TYPE_IMAGE", "MARK_TYPE_SVGA", "DEFAULT_CLOSE_SECONDS", "routerToSchema", "", AudioIntentHelper.FROM_ACTIVITY, "Landroid/app/Activity;", "info", "Ltv/danmaku/bili/ui/main/imagerecognize/ImageUrlInfo;", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ImageRecognizeHelperKt {
    public static final int DEFAULT_CLOSE_SECONDS = 5;
    public static final int MARK_TYPE_IMAGE = 1;
    public static final int MARK_TYPE_SVGA = 2;
    public static final int SHARE_TYPE_ACTIVITY = 2;
    public static final int SHARE_TYPE_UGC = 1;

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

    public static final void routerToSchema(Activity activity, ImageUrlInfo info) {
        if (activity != null) {
            String schema = info != null ? info.getSchema() : null;
            if (schema == null || StringsKt.isBlank(schema)) {
                return;
            }
            String schema2 = info != null ? info.getSchema() : null;
            Intrinsics.checkNotNull(schema2);
            BLRouter.routeTo(new RouteRequest.Builder(schema2).build(), activity);
            ImageRecognizeHelper.INSTANCE.reportDialogClick$core_apinkDebug(info);
            __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookActivityFinish(activity);
        }
    }
}