package tv.danmaku.bili.ui.webview;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.alibaba.fastjson.JSONObject;
import com.bilibili.app.comm.list.common.campus.CampusEventCallback;
import com.bilibili.app.comm.list.common.campus.CampusFunction;
import com.bilibili.bus.Violet;
import com.bilibili.common.webview.js.JsBridgeCallHandlerFactoryV2;
import com.bilibili.common.webview.js.JsBridgeCallHandlerV2;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: MJsBridgeCallHandlerCampus.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0019B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J$\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u000fH\u0016J\u0013\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0014H\u0016¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\rH\u0016J\b\u0010\u0017\u001a\u00020\u000fH\u0014J\u0012\u0010\u0018\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000fH\u0002R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Ltv/danmaku/bili/ui/webview/MJsBridgeCallHandlerCampus;", "Lcom/bilibili/common/webview/js/JsBridgeCallHandlerV2;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "(Landroidx/lifecycle/LifecycleOwner;)V", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "setLifecycleOwner", "observer", "Landroidx/lifecycle/Observer;", "Lcom/bilibili/app/comm/list/common/campus/CampusEventCallback;", "invokeNative", "", "method", "", "data", "Lcom/alibaba/fastjson/JSONObject;", "callbackId", "getSupportFunctions", "", "()[Ljava/lang/String;", "release", "getTag", "ensureObserver", "Factory", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class MJsBridgeCallHandlerCampus extends JsBridgeCallHandlerV2 {
    public static final int $stable = 8;
    private LifecycleOwner lifecycleOwner;
    private Observer<CampusEventCallback> observer;

    public MJsBridgeCallHandlerCampus(LifecycleOwner lifecycleOwner) {
        this.lifecycleOwner = lifecycleOwner;
    }

    public final LifecycleOwner getLifecycleOwner() {
        return this.lifecycleOwner;
    }

    public final void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        this.lifecycleOwner = lifecycleOwner;
    }

    public void invokeNative(final String method, final JSONObject data, final String callbackId) {
        Intrinsics.checkNotNullParameter(method, "method");
        runOnUiThread(new Runnable() { // from class: tv.danmaku.bili.ui.webview.MJsBridgeCallHandlerCampus$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                MJsBridgeCallHandlerCampus.invokeNative$lambda$0(method, data, this, callbackId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeNative$lambda$0(String $method, JSONObject $data, MJsBridgeCallHandlerCampus this$0, String $callbackId) {
        CampusFunction campusFunction;
        LifecycleOwner lifecycleOwner;
        CampusFunction[] values = CampusFunction.values();
        int length = values.length;
        int i = 0;
        while (true) {
            if (i < length) {
                campusFunction = values[i];
                if (Intrinsics.areEqual(campusFunction.getMethod(), $method)) {
                    break;
                }
                i++;
            } else {
                campusFunction = null;
                break;
            }
        }
        if (campusFunction != null) {
            CampusFunction $this$invokeNative_u24lambda_u240_u241 = campusFunction;
            $this$invokeNative_u24lambda_u240_u241.run($data);
            if ($this$invokeNative_u24lambda_u240_u241.getCallback() && (lifecycleOwner = this$0.lifecycleOwner) != null) {
                this$0.ensureObserver($callbackId);
                Observer it = this$0.observer;
                if (it != null) {
                    Violet.INSTANCE.ofChannel(CampusEventCallback.class).observe(lifecycleOwner, it);
                }
            }
        }
    }

    public String[] getSupportFunctions() {
        CampusFunction[] values = CampusFunction.values();
        Collection destination$iv$iv = new ArrayList(values.length);
        for (CampusFunction campusFunction : values) {
            destination$iv$iv.add(campusFunction.getMethod());
        }
        Collection thisCollection$iv = (List) destination$iv$iv;
        return (String[]) thisCollection$iv.toArray(new String[0]);
    }

    public void release() {
        Observer p0 = this.observer;
        if (p0 != null) {
            Violet.INSTANCE.ofChannel(CampusEventCallback.class).removeObserver(p0);
        }
        this.observer = null;
    }

    protected String getTag() {
        return "MJsBridgeCallHandlerCampus";
    }

    private final void ensureObserver(final String callbackId) {
        if (callbackId != null && this.observer == null) {
            this.observer = new Observer() { // from class: tv.danmaku.bili.ui.webview.MJsBridgeCallHandlerCampus$$ExternalSyntheticLambda1
                public final void onChanged(Object obj) {
                    MJsBridgeCallHandlerCampus.ensureObserver$lambda$0(MJsBridgeCallHandlerCampus.this, callbackId, (CampusEventCallback) obj);
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ensureObserver$lambda$0(MJsBridgeCallHandlerCampus this$0, String $callbackId, CampusEventCallback it) {
        Serializable callbackData;
        Intrinsics.checkNotNullParameter(it, "it");
        try {
            callbackData = (Serializable) JSONObject.parseObject(it.getData());
        } catch (Exception e) {
            BLog.e("CampusJSBCallback", "Fail to parse call back data " + it.getData(), e);
            callbackData = it.getData();
        }
        this$0.callbackToJs(new Object[]{$callbackId, callbackData});
        this$0.observer = null;
    }

    /* compiled from: MJsBridgeCallHandlerCampus.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/ui/webview/MJsBridgeCallHandlerCampus$Factory;", "Lcom/bilibili/common/webview/js/JsBridgeCallHandlerFactoryV2;", "activity", "Ltv/danmaku/bili/ui/webview/MWebActivity;", "<init>", "(Ltv/danmaku/bili/ui/webview/MWebActivity;)V", "getActivity", "()Ltv/danmaku/bili/ui/webview/MWebActivity;", "create", "Lcom/bilibili/common/webview/js/JsBridgeCallHandlerV2;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
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
            return new MJsBridgeCallHandlerCampus(this.activity);
        }
    }
}