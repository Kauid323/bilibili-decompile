package tv.danmaku.bili.ui.garb;

import android.app.Activity;
import com.bilibili.common.webview.js.JsBridgeCallHandlerFactoryV2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;

/* compiled from: NftCardJsBridgeCallHandler.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Ltv/danmaku/bili/ui/garb/NftCardJsBridgeCallHandlerFactory;", "Lcom/bilibili/common/webview/js/JsBridgeCallHandlerFactoryV2;", AudioIntentHelper.FROM_ACTIVITY, "Landroid/app/Activity;", AuthResultCbHelper.ARGS_CALLBACK, "Ltv/danmaku/bili/ui/garb/NftCardJsbCallback;", "<init>", "(Landroid/app/Activity;Ltv/danmaku/bili/ui/garb/NftCardJsbCallback;)V", "getActivity", "()Landroid/app/Activity;", "getCallback", "()Ltv/danmaku/bili/ui/garb/NftCardJsbCallback;", "create", "Ltv/danmaku/bili/ui/garb/NftCardJsBridgeCallHandler;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class NftCardJsBridgeCallHandlerFactory implements JsBridgeCallHandlerFactoryV2 {
    public static final int $stable = 8;
    private final Activity activity;
    private final NftCardJsbCallback callback;

    public NftCardJsBridgeCallHandlerFactory(Activity activity, NftCardJsbCallback callback) {
        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
        Intrinsics.checkNotNullParameter(callback, AuthResultCbHelper.ARGS_CALLBACK);
        this.activity = activity;
        this.callback = callback;
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final NftCardJsbCallback getCallback() {
        return this.callback;
    }

    public NftCardJsBridgeCallHandler create() {
        return new NftCardJsBridgeCallHandler(this.activity, this.callback);
    }
}