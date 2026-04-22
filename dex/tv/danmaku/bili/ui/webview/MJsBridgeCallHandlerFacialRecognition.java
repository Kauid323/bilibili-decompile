package tv.danmaku.bili.ui.webview;

import android.app.Activity;
import android.content.Intent;
import com.alibaba.fastjson.JSONObject;
import com.bilibili.common.webview.js.JsBridgeCallHandlerV2;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: MJsBridgeCallHandlerFacialRecognition.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016¢\u0006\u0002\u0010\tJ$\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u0010\u001a\u00020\bH\u0014J\b\u0010\u0011\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Ltv/danmaku/bili/ui/webview/MJsBridgeCallHandlerFacialRecognition;", "Lcom/bilibili/common/webview/js/JsBridgeCallHandlerV2;", "activity", "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "getSupportFunctions", "", "", "()[Ljava/lang/String;", "invokeNative", "", "method", "data", "Lcom/alibaba/fastjson/JSONObject;", "callbackId", "getTag", "release", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class MJsBridgeCallHandlerFacialRecognition extends JsBridgeCallHandlerV2 {
    private static final String BUNDLE_KEY_JSB_RESULT = "jsb_result";
    private static final String JS_BRIDGE_METHOD = "authResult";
    private static final String JS_BRIDGE_METHOD_RESULT = "result";
    public static final String JS_BRIDGE_NS = "live_stream_user_auth";
    private static final String TAG = "MJsBridgeCallHandlerAuth";
    private final Activity activity;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public MJsBridgeCallHandlerFacialRecognition(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
    }

    /* compiled from: MJsBridgeCallHandlerFacialRecognition.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/ui/webview/MJsBridgeCallHandlerFacialRecognition$Companion;", "", "<init>", "()V", "TAG", "", "JS_BRIDGE_NS", "BUNDLE_KEY_JSB_RESULT", "JS_BRIDGE_METHOD", "JS_BRIDGE_METHOD_RESULT", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public String[] getSupportFunctions() {
        return new String[]{JS_BRIDGE_METHOD};
    }

    public void invokeNative(String method, JSONObject data, String callbackId) {
        Intrinsics.checkNotNullParameter(method, "method");
        if (Intrinsics.areEqual(method, JS_BRIDGE_METHOD) && data != null) {
            int value = data.getIntValue(JS_BRIDGE_METHOD_RESULT);
            BLog.i(TAG, "MJsBridgeCallHandlerAuth:invokeNative result=" + value);
            Intent intent = new Intent();
            intent.putExtra(BUNDLE_KEY_JSB_RESULT, value);
            this.activity.setResult(-1, intent);
            callbackToJs(new Object[]{callbackId});
        }
    }

    protected String getTag() {
        return TAG;
    }

    public void release() {
    }
}