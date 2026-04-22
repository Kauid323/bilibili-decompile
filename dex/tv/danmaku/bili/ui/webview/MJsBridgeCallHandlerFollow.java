package tv.danmaku.bili.ui.webview;

import com.alibaba.fastjson.JSONObject;
import com.bilibili.app.comm.list.common.reservation.UpReservationMessageChannel;
import com.bilibili.common.webview.js.JsBridgeCallHandlerFactoryV2;
import com.bilibili.common.webview.js.JsBridgeCallHandlerV2;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: MJsBridgeCallHandlerFollow.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0002\u0010\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¢\u0006\u0002\u0010\u0007J$\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0014J\b\u0010\u000f\u001a\u00020\tH\u0016¨\u0006\u0012"}, d2 = {"Ltv/danmaku/bili/ui/webview/MJsBridgeCallHandlerFollow;", "Lcom/bilibili/common/webview/js/JsBridgeCallHandlerV2;", "<init>", "()V", "getSupportFunctions", "", "", "()[Ljava/lang/String;", "invokeNative", "", "method", "data", "Lcom/alibaba/fastjson/JSONObject;", "callbackId", "getTag", "release", "Factory", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class MJsBridgeCallHandlerFollow extends JsBridgeCallHandlerV2 {
    private static final String TAG = "MJsBridgeFollow";
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final String CARD_STATUS_CHANGE = "cardBookStatusChange";
    private static final String[] SUPPORT_FUNCTIONS = {CARD_STATUS_CHANGE};

    /* compiled from: MJsBridgeCallHandlerFollow.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/ui/webview/MJsBridgeCallHandlerFollow$Factory;", "Lcom/bilibili/common/webview/js/JsBridgeCallHandlerFactoryV2;", "<init>", "()V", "create", "Lcom/bilibili/common/webview/js/JsBridgeCallHandlerV2;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Factory implements JsBridgeCallHandlerFactoryV2 {
        public static final int $stable = 0;

        public JsBridgeCallHandlerV2 create() {
            return new MJsBridgeCallHandlerFollow();
        }
    }

    /* compiled from: MJsBridgeCallHandlerFollow.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/ui/webview/MJsBridgeCallHandlerFollow$Companion;", "", "<init>", "()V", "TAG", "", "CARD_STATUS_CHANGE", "SUPPORT_FUNCTIONS", "", "[Ljava/lang/String;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public String[] getSupportFunctions() {
        return SUPPORT_FUNCTIONS;
    }

    public void invokeNative(final String method, final JSONObject data, final String callbackId) {
        Intrinsics.checkNotNullParameter(method, "method");
        runOnUiThread(new Runnable() { // from class: tv.danmaku.bili.ui.webview.MJsBridgeCallHandlerFollow$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                MJsBridgeCallHandlerFollow.invokeNative$lambda$0(method, data, callbackId, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeNative$lambda$0(String $method, JSONObject $data, String $callbackId, MJsBridgeCallHandlerFollow this$0) {
        if (!Intrinsics.areEqual($method, CARD_STATUS_CHANGE) || $data == null) {
            return;
        }
        UpReservationMessageChannel.Companion.sendMessage($data.toJSONString());
        String str = $callbackId;
        if (!(str == null || str.length() == 0)) {
            this$0.callbackToJs(new Object[]{$callbackId});
        }
    }

    protected String getTag() {
        return TAG;
    }

    public void release() {
    }
}