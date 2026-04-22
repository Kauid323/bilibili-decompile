package tv.danmaku.bili.ui.webview;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bilibili.common.webview.js.HostCallHandler;
import com.bilibili.common.webview.js.JsBridgeCallHandlerFactoryV2;
import com.bilibili.common.webview.js.JsBridgeCallHandlerV2;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.utils.LoginSceneProcessor;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: MJsBridgeCallHandlerTopix.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001%B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J$\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0013\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\u0011H\u0016¢\u0006\u0002\u0010\u0012J\b\u0010\u0013\u001a\u00020\fH\u0016J\b\u0010\u0014\u001a\u00020\nH\u0014J \u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u000e\u001a\u0004\u0018\u00010\u001aJ\b\u0010\u001b\u001a\u00020\u000fH\u0002J)\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\n2\u0012\u0010\u001e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001f0\u0011\"\u00020\u001fH\u0016¢\u0006\u0002\u0010 J \u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020\nH\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Ltv/danmaku/bili/ui/webview/MJsBridgeCallHandlerTopix;", "Lcom/bilibili/common/webview/js/JsBridgeCallHandlerV2;", "Lcom/bilibili/common/webview/js/HostCallHandler;", "activity", "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "callbackId", "", "invokeNative", "", "method", "data", "Lcom/alibaba/fastjson/JSONObject;", "getSupportFunctions", "", "()[Ljava/lang/String;", "release", "getTag", "handleResult", "", "requestCode", "", "resultCode", "Landroid/content/Intent;", "failResult", "onHandler", "methodName", "params", "", "(Ljava/lang/String;[Ljava/lang/Object;)Z", "getCreateTopicUrl", LoginSceneProcessor.SCENE_KEY, "name", "desc", "Factory", "widget_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class MJsBridgeCallHandlerTopix extends JsBridgeCallHandlerV2 implements HostCallHandler {
    public static final int $stable = 8;
    private final Activity activity;
    private String callbackId;

    public MJsBridgeCallHandlerTopix(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
    }

    public final Activity getActivity() {
        return this.activity;
    }

    /* compiled from: MJsBridgeCallHandlerTopix.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/ui/webview/MJsBridgeCallHandlerTopix$Factory;", "Lcom/bilibili/common/webview/js/JsBridgeCallHandlerFactoryV2;", "activity", "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "create", "Lcom/bilibili/common/webview/js/JsBridgeCallHandlerV2;", "widget_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Factory implements JsBridgeCallHandlerFactoryV2 {
        public static final int $stable = 8;
        private final Activity activity;

        public Factory(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            this.activity = activity;
        }

        public final Activity getActivity() {
            return this.activity;
        }

        public JsBridgeCallHandlerV2 create() {
            return new MJsBridgeCallHandlerTopix(this.activity);
        }
    }

    public void invokeNative(String method, JSONObject data, String callbackId) {
        Intrinsics.checkNotNullParameter(method, "method");
        if (Intrinsics.areEqual(method, MJsBridgeCallHandlerTopixKt.CREATE_TOPIC)) {
            if (callbackId == null) {
                BLog.e("MJsBridgeCallHandlerCampus", "Empty callback id, check your param");
                return;
            }
            final String scene = data != null ? data.getString(LoginSceneProcessor.SCENE_KEY) : null;
            final String name = data != null ? data.getString("name") : null;
            final String desc = (data == null || (desc = data.getString("desc")) == null) ? "" : "";
            if (data != null) {
                String str = scene;
                boolean z = false;
                if (!(str == null || StringsKt.isBlank(str))) {
                    String str2 = name;
                    if (str2 == null || StringsKt.isBlank(str2)) {
                        z = true;
                    }
                    if (!z) {
                        this.callbackId = callbackId;
                        runOnUiThread(new Runnable() { // from class: tv.danmaku.bili.ui.webview.MJsBridgeCallHandlerTopix$$ExternalSyntheticLambda0
                            @Override // java.lang.Runnable
                            public final void run() {
                                MJsBridgeCallHandlerTopix.invokeNative$lambda$0(MJsBridgeCallHandlerTopix.this, scene, name, desc);
                            }
                        });
                        return;
                    }
                }
            }
            BLog.e("MJsBridgeCallHandlerCampus", "data not valid, check your param: " + data);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeNative$lambda$0(MJsBridgeCallHandlerTopix this$0, String $scene, String $name, String $desc) {
        BLRouter.routeTo(new RouteRequest.Builder(this$0.getCreateTopicUrl($scene, $name, $desc)).requestCode((int) MJsBridgeCallHandlerTopixKt.REQUEST_TOPIX).build(), this$0.activity);
    }

    public String[] getSupportFunctions() {
        return new String[]{MJsBridgeCallHandlerTopixKt.CREATE_TOPIC};
    }

    public void release() {
        this.callbackId = null;
    }

    protected String getTag() {
        return "MJsBridgeCallHandlerCampus";
    }

    public final boolean handleResult(int requestCode, int resultCode, Intent data) {
        JSONObject $this$handleResult_u24lambda_u240;
        if (requestCode != 1028 || this.callbackId == null) {
            return false;
        }
        String result = (data == null || (result = data.getStringExtra(MJsBridgeCallHandlerTopixKt.RESULT_KEY)) == null) ? "" : "";
        try {
            $this$handleResult_u24lambda_u240 = JSON.parseObject(result);
            if ($this$handleResult_u24lambda_u240 != null) {
                $this$handleResult_u24lambda_u240.put("result_code", resultCode == -1 ? "1" : "0");
                $this$handleResult_u24lambda_u240.remove("success_desc");
            } else {
                $this$handleResult_u24lambda_u240 = failResult();
            }
        } catch (Exception e) {
            $this$handleResult_u24lambda_u240 = failResult();
        }
        callbackToJs(new Object[]{this.callbackId, $this$handleResult_u24lambda_u240.toJSONString()});
        return true;
    }

    private final JSONObject failResult() {
        JSONObject $this$failResult_u24lambda_u240 = new JSONObject();
        $this$failResult_u24lambda_u240.put("result_code", "0");
        return $this$failResult_u24lambda_u240;
    }

    public boolean onHandler(String methodName, Object... params) {
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(params, "params");
        if (Intrinsics.areEqual(methodName, "onActivityResult")) {
            try {
                Object obj = params[0];
                Integer num = obj instanceof Integer ? (Integer) obj : null;
                if (num != null) {
                    int requestCode = num.intValue();
                    Object obj2 = params[1];
                    Integer num2 = obj2 instanceof Integer ? (Integer) obj2 : null;
                    if (num2 != null) {
                        int resultCode = num2.intValue();
                        Object obj3 = params[2];
                        Intent data = obj3 instanceof Intent ? (Intent) obj3 : null;
                        return handleResult(requestCode, resultCode, data);
                    }
                    return false;
                }
                return false;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    private final String getCreateTopicUrl(String scene, String name, String desc) {
        String uri = Uri.parse("bilibili://topic/create").buildUpon().appendQueryParameter(LoginSceneProcessor.SCENE_KEY, scene).appendQueryParameter("name", name).appendQueryParameter("desc", desc).build().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "toString(...)");
        return uri;
    }
}