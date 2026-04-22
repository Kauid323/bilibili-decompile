package tv.danmaku.bili.utils.vip;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.bilibili.common.webview.js.HostCallHandler;
import com.bilibili.common.webview.js.JsBridgeCallHandlerFactoryV2;
import com.bilibili.common.webview.js.JsBridgeCallHandlerV2;
import com.bilibili.common.webview.js.JsBridgeException;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.MutableBundleLike;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.moduleservice.vip.VipService;
import com.bilibili.moduleservice.vip.VipUnFreezeCallBack;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import tv.danmaku.biliplayerv2.router.PlayerRouteUris;

public class JsBridgeCallHandlerVip extends JsBridgeCallHandlerV2 implements HostCallHandler {
    private static final String HANDLER_METHOD_OPEN_NATIVE_VIP = "jumpVip";
    private static final String HANDLER_METHOD_SHOW_FREEZE_DIALOG = "showFreezeDialog";
    private static final int REQUEST_BUY_VIP = 1109;
    private static final String TAG = "JsBridgeCallHandlerVip";
    public static final String VIP_NAME_SPACE = "vip";
    public static final int VIP_WEB_REQUEST_CODE = 1108;
    private Activity mActivity;
    private String mBuyVipCallbackId;
    private String mReloadCallbackId;

    public JsBridgeCallHandlerVip(Activity mActivity) {
        this.mActivity = mActivity;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void invokeNative(String method, JSONObject data, String callbackId) throws JsBridgeException {
        char c;
        switch (method.hashCode()) {
            case -1255160561:
                if (method.equals(HANDLER_METHOD_OPEN_NATIVE_VIP)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -968609188:
                if (method.equals(HANDLER_METHOD_SHOW_FREEZE_DIALOG)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                tryToShowFreezeDialog(data);
                return;
            case 1:
                tryJumpVip(data);
                return;
            default:
                return;
        }
    }

    private void tryJumpVip(JSONObject data) {
        if (data == null) {
            return;
        }
        final String appId = data.getString("appId");
        final String appSubId = data.getString("appSubId");
        final String sourceFrom = data.getString("source_from");
        final String orderReportParam = data.getString(VipRoutes.VIP_BUY_ORDER_REPORT_PARAMS);
        this.mBuyVipCallbackId = data.getString("callbackId");
        runOnUiThread(new Runnable() { // from class: tv.danmaku.bili.utils.vip.JsBridgeCallHandlerVip.1
            @Override // java.lang.Runnable
            public void run() {
                RouteRequest routeRequest = new RouteRequest.Builder(Uri.parse(PlayerRouteUris.Routers.ROUTE_URI_VIP_BUY)).extras(new Function1<MutableBundleLike, Unit>() { // from class: tv.danmaku.bili.utils.vip.JsBridgeCallHandlerVip.1.1
                    public Unit invoke(MutableBundleLike mutableBundleLike) {
                        mutableBundleLike.put("appId", TextUtils.isEmpty(appId) ? "" : appId);
                        mutableBundleLike.put("appSubId", TextUtils.isEmpty(appSubId) ? "" : appSubId);
                        mutableBundleLike.put("source_from", TextUtils.isEmpty(sourceFrom) ? "" : sourceFrom);
                        mutableBundleLike.put(VipRoutes.VIP_BUY_ORDER_REPORT_PARAMS, TextUtils.isEmpty(orderReportParam) ? "" : orderReportParam);
                        return null;
                    }
                }).flags(603979776).requestCode((int) JsBridgeCallHandlerVip.REQUEST_BUY_VIP).build();
                BLRouter.routeTo(routeRequest, JsBridgeCallHandlerVip.this.mActivity);
            }
        });
    }

    public boolean onHandler(String methodName, Object... params) {
        char c;
        switch (methodName.hashCode()) {
            case -1656256565:
                if (methodName.equals("onActivityResult")) {
                    c = 0;
                    break;
                }
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                return onHostResult(params);
            default:
                return false;
        }
    }

    private boolean onHostResult(Object[] params) {
        if (params != null && params.length == 3) {
            try {
                return onActivityResult(((Integer) params[0]).intValue(), ((Integer) params[1]).intValue(), (Intent) params[2]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    private boolean onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_BUY_VIP) {
            if (resultCode == -1 && !TextUtils.isEmpty(this.mBuyVipCallbackId)) {
                callbackToJs(new Object[]{this.mBuyVipCallbackId});
            }
            this.mBuyVipCallbackId = null;
            return true;
        }
        return false;
    }

    private void tryToShowFreezeDialog(JSONObject data) {
        if (this.mActivity != null && data != null) {
            String callBackId = data.getString("callbackId");
            if (!TextUtils.isEmpty(callBackId)) {
                callbackToJs(new Object[]{callBackId});
            }
            this.mReloadCallbackId = data.getString("onReloadCallbackId");
            runOnUiThread(new Runnable() { // from class: tv.danmaku.bili.utils.vip.JsBridgeCallHandlerVip$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    JsBridgeCallHandlerVip.this.m1948lambda$tryToShowFreezeDialog$1$tvdanmakubiliutilsvipJsBridgeCallHandlerVip();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$tryToShowFreezeDialog$1$tv-danmaku-bili-utils-vip-JsBridgeCallHandlerVip  reason: not valid java name */
    public /* synthetic */ void m1948lambda$tryToShowFreezeDialog$1$tvdanmakubiliutilsvipJsBridgeCallHandlerVip() {
        VipService vipService = (VipService) BLRouter.INSTANCE.get(VipService.class, "default");
        if (vipService != null) {
            vipService.showVipFreezeDialog(this.mActivity, Integer.valueOf((int) VIP_WEB_REQUEST_CODE), new VipUnFreezeCallBack() { // from class: tv.danmaku.bili.utils.vip.JsBridgeCallHandlerVip$$ExternalSyntheticLambda1
                public final void onVipUnFreeze() {
                    JsBridgeCallHandlerVip.this.m1947lambda$tryToShowFreezeDialog$0$tvdanmakubiliutilsvipJsBridgeCallHandlerVip();
                }
            });
        }
    }

    public String[] getSupportFunctions() {
        return new String[]{HANDLER_METHOD_SHOW_FREEZE_DIALOG, HANDLER_METHOD_OPEN_NATIVE_VIP};
    }

    public void release() {
        this.mActivity = null;
    }

    protected String getTag() {
        return TAG;
    }

    public boolean isDestroyed() {
        return super.isDestroyed() || this.mActivity == null || this.mActivity.isFinishing();
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class BiliJsBridgeCallHandlerVipFactory implements JsBridgeCallHandlerFactoryV2 {
        private Activity mActivity;
        private JsBridgeCallHandlerVip mJsBridgeCallHandlerVip;

        public BiliJsBridgeCallHandlerVipFactory(Activity activity) {
            this.mActivity = activity;
            this.mJsBridgeCallHandlerVip = new JsBridgeCallHandlerVip(this.mActivity);
        }

        public JsBridgeCallHandlerV2 create() {
            return this.mJsBridgeCallHandlerVip;
        }

        public void reload() {
            this.mJsBridgeCallHandlerVip.m1947lambda$tryToShowFreezeDialog$0$tvdanmakubiliutilsvipJsBridgeCallHandlerVip();
        }
    }

    /* renamed from: onReload */
    public void m1947lambda$tryToShowFreezeDialog$0$tvdanmakubiliutilsvipJsBridgeCallHandlerVip() {
        if (!isDestroyed() && !TextUtils.isEmpty(this.mReloadCallbackId)) {
            callbackToJs(new Object[]{this.mReloadCallbackId});
            this.mReloadCallbackId = null;
        }
    }
}