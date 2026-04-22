package tv.danmaku.bili.ui.garb;

import android.app.Activity;
import com.bilibili.common.webview.js.JsBridgeCallHandlerFactoryV2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;

/* compiled from: GarbJsBridgeCallHandler.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/ui/garb/GarbJsBridgeCallHandlerFactory;", "Lcom/bilibili/common/webview/js/JsBridgeCallHandlerFactoryV2;", AudioIntentHelper.FROM_ACTIVITY, "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "create", "Ltv/danmaku/bili/ui/garb/GarbJsBridgeCallHandler;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class GarbJsBridgeCallHandlerFactory implements JsBridgeCallHandlerFactoryV2 {
    public static final int $stable = 8;
    private final Activity activity;

    public GarbJsBridgeCallHandlerFactory(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
        this.activity = activity;
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public GarbJsBridgeCallHandler create() {
        return new GarbJsBridgeCallHandler(this.activity);
    }
}