package comm.bili.digital.bridge;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import com.alibaba.fastjson.JSONObject;
import com.bilibili.common.webview.js.JsBridgeCallHandlerV2;
import com.bilibili.lib.blrouter.BLRouter;
import im.setting.UtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;

/* compiled from: DigitalJsBridgeCallHandler.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u000fH\u0016J\u0013\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0014H\u0016¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\rH\u0016J\b\u0010\u0017\u001a\u00020\u000fH\u0014R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcomm/bili/digital/bridge/DigitalJsBridgeCallHandler;", "Lcom/bilibili/common/webview/js/JsBridgeCallHandlerV2;", "activity", "Landroid/app/Activity;", "fragment", "Landroidx/fragment/app/Fragment;", "<init>", "(Landroid/app/Activity;Landroidx/fragment/app/Fragment;)V", "getActivity", "()Landroid/app/Activity;", "getFragment", "()Landroidx/fragment/app/Fragment;", "invokeNative", "", "method", "", UtilsKt.DATA_KEY, "Lcom/alibaba/fastjson/JSONObject;", "callbackId", "getSupportFunctions", "", "()[Ljava/lang/String;", "release", "getTag", "Companion", "digital-bridge_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DigitalJsBridgeCallHandler extends JsBridgeCallHandlerV2 {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "DigitalJsBridgeCallHandler";
    private final Activity activity;
    private final Fragment fragment;

    /* compiled from: DigitalJsBridgeCallHandler.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcomm/bili/digital/bridge/DigitalJsBridgeCallHandler$Companion;", "", "<init>", "()V", "TAG", "", "digital-bridge_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public DigitalJsBridgeCallHandler(Activity activity, Fragment fragment) {
        this.activity = activity;
        this.fragment = fragment;
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final Fragment getFragment() {
        return this.fragment;
    }

    public void invokeNative(String method, JSONObject data, String callbackId) {
        IDigitalJsMethodInvoker iDigitalJsMethodInvoker;
        Intrinsics.checkNotNullParameter(method, "method");
        try {
            Activity it = this.activity;
            if (it == null || (iDigitalJsMethodInvoker = (IDigitalJsMethodInvoker) BLRouter.get$default(BLRouter.INSTANCE, IDigitalJsMethodInvoker.class, (String) null, 2, (Object) null)) == null) {
                return;
            }
            iDigitalJsMethodInvoker.invokeNative(it, this.fragment, this, method, data, callbackId);
        } catch (Throwable th) {
            BLog.e(TAG, "invoke garb jsb error");
        }
    }

    public String[] getSupportFunctions() {
        String[] supportFunctions;
        IDigitalJsMethodInvoker iDigitalJsMethodInvoker = (IDigitalJsMethodInvoker) BLRouter.get$default(BLRouter.INSTANCE, IDigitalJsMethodInvoker.class, (String) null, 2, (Object) null);
        return (iDigitalJsMethodInvoker == null || (supportFunctions = iDigitalJsMethodInvoker.getSupportFunctions()) == null) ? new String[0] : supportFunctions;
    }

    public void release() {
    }

    protected String getTag() {
        return TAG;
    }
}