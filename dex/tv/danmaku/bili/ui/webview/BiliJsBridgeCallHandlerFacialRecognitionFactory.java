package tv.danmaku.bili.ui.webview;

import android.app.Activity;
import com.bilibili.common.webview.js.JsBridgeCallHandlerFactoryV2;
import com.bilibili.common.webview.js.JsBridgeCallHandlerV2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: MJsBridgeCallHandlerFacialRecognition.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/ui/webview/BiliJsBridgeCallHandlerFacialRecognitionFactory;", "Lcom/bilibili/common/webview/js/JsBridgeCallHandlerFactoryV2;", "activity", "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "mJsBridgeCallHandlerAuth", "Ltv/danmaku/bili/ui/webview/MJsBridgeCallHandlerFacialRecognition;", "create", "Lcom/bilibili/common/webview/js/JsBridgeCallHandlerV2;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BiliJsBridgeCallHandlerFacialRecognitionFactory implements JsBridgeCallHandlerFactoryV2 {
    public static final int $stable = 8;
    private MJsBridgeCallHandlerFacialRecognition mJsBridgeCallHandlerAuth;

    public BiliJsBridgeCallHandlerFacialRecognitionFactory(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.mJsBridgeCallHandlerAuth = new MJsBridgeCallHandlerFacialRecognition(activity);
    }

    public JsBridgeCallHandlerV2 create() {
        return this.mJsBridgeCallHandlerAuth;
    }
}