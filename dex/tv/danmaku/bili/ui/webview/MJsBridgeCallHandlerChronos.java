package tv.danmaku.bili.ui.webview;

import com.alibaba.fastjson.JSONObject;
import com.bilibili.common.chronoscommon.plugins.WebViewPlugin;
import com.bilibili.common.webview.js.JsBridgeCallHandlerFactoryV2;
import com.bilibili.common.webview.js.JsBridgeCallHandlerV2;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: MJsBridgeCallHandlerChronos.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0002\u0012\u0013B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J$\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\tH\u0016J\u0013\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u000eH\u0016¢\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\tH\u0014R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Ltv/danmaku/bili/ui/webview/MJsBridgeCallHandlerChronos;", "Lcom/bilibili/common/webview/js/JsBridgeCallHandlerV2;", "activity", "Ltv/danmaku/bili/ui/webview/MWebActivity;", "<init>", "(Ltv/danmaku/bili/ui/webview/MWebActivity;)V", "invokeNative", "", "method", "", "data", "Lcom/alibaba/fastjson/JSONObject;", "callbackId", "getSupportFunctions", "", "()[Ljava/lang/String;", "release", "getTag", "Companion", "Factory", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class MJsBridgeCallHandlerChronos extends JsBridgeCallHandlerV2 {
    private static final String METHOD_RECKLESS_CALLBACK = "recklessCallback";
    private MWebActivity activity;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: MJsBridgeCallHandlerChronos.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/ui/webview/MJsBridgeCallHandlerChronos$Companion;", "", "<init>", "()V", "METHOD_RECKLESS_CALLBACK", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public MJsBridgeCallHandlerChronos(MWebActivity activity) {
        this.activity = activity;
    }

    public void invokeNative(final String method, final JSONObject data, final String callbackId) {
        Intrinsics.checkNotNullParameter(method, "method");
        runOnUiThread(new Runnable() { // from class: tv.danmaku.bili.ui.webview.MJsBridgeCallHandlerChronos$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                MJsBridgeCallHandlerChronos.invokeNative$lambda$0(method, data, callbackId, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeNative$lambda$0(String $method, JSONObject $data, String $callbackId, MJsBridgeCallHandlerChronos this$0) {
        if (Intrinsics.areEqual($method, METHOD_RECKLESS_CALLBACK)) {
            if ($data != null) {
                WebViewPlugin.INSTANCE.broadcastRecklessCallback($data);
            }
            if ($callbackId != null) {
                this$0.callbackToJs(new Object[]{$callbackId});
            }
        }
    }

    public String[] getSupportFunctions() {
        return new String[]{METHOD_RECKLESS_CALLBACK};
    }

    public void release() {
        this.activity = null;
    }

    protected String getTag() {
        return "BilJsBridgeHandlerChronos";
    }

    /* compiled from: MJsBridgeCallHandlerChronos.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/ui/webview/MJsBridgeCallHandlerChronos$Factory;", "Lcom/bilibili/common/webview/js/JsBridgeCallHandlerFactoryV2;", "activity", "Ltv/danmaku/bili/ui/webview/MWebActivity;", "<init>", "(Ltv/danmaku/bili/ui/webview/MWebActivity;)V", "getActivity", "()Ltv/danmaku/bili/ui/webview/MWebActivity;", "create", "Lcom/bilibili/common/webview/js/JsBridgeCallHandlerV2;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Factory implements JsBridgeCallHandlerFactoryV2 {
        public static final int $stable = 8;
        private final MWebActivity activity;

        public Factory(MWebActivity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            this.activity = activity;
        }

        public final MWebActivity getActivity() {
            return this.activity;
        }

        public JsBridgeCallHandlerV2 create() {
            return new MJsBridgeCallHandlerChronos(this.activity);
        }
    }
}