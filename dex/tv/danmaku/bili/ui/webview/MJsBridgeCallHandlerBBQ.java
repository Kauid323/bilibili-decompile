package tv.danmaku.bili.ui.webview;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.bilibili.app.comm.IJsBridgeBehavior;
import com.bilibili.common.webview.js.JsBridgeCallHandlerFactoryV2;
import com.bilibili.common.webview.js.JsBridgeCallHandlerV2;
import com.bilibili.common.webview.js.JsBridgeException;
import com.bilibili.droid.PackageManagerHelper;
import com.bilibili.lib.jsbridge.common.BaseJsBridgeCallHandlerV2;

@Deprecated
public class MJsBridgeCallHandlerBBQ extends BaseJsBridgeCallHandlerV2<BiliJsBridgeBBQBehavior> {
    private static final String HANDLER_IS_INSTALLED = "isInstalled";
    private static final String HANDLER_OPEN_WITH_BROWSER = "openWithBrowser";

    public MJsBridgeCallHandlerBBQ(BiliJsBridgeBBQBehavior behavior) {
        super(behavior);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void invokeNative(String method, JSONObject data, String callbackId) throws JsBridgeException {
        char c;
        switch (method.hashCode()) {
            case -910272808:
                if (method.equals(HANDLER_OPEN_WITH_BROWSER)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 1207466352:
                if (method.equals(HANDLER_IS_INSTALLED)) {
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
                isInstalled(data, callbackId);
                return;
            case 1:
                openWithBrowser(data);
                return;
            default:
                return;
        }
    }

    private void isInstalled(JSONObject json, String callbackId) {
        BiliJsBridgeBBQBehavior behavior;
        if (json == null) {
            return;
        }
        String packageName = json.getString("packageName");
        if (!TextUtils.isEmpty(packageName) && (behavior = (BiliJsBridgeBBQBehavior) getJBBehavior()) != null) {
            JSONObject result = new JSONObject();
            result.put(HANDLER_IS_INSTALLED, Boolean.valueOf(behavior.checkAppInstalled(packageName)));
            callbackToJs(new Object[]{callbackId, result});
        }
    }

    private void openWithBrowser(JSONObject json) {
        BiliJsBridgeBBQBehavior behavior;
        if (json == null) {
            return;
        }
        String url = json.getString("url");
        if (!TextUtils.isEmpty(url) && (behavior = (BiliJsBridgeBBQBehavior) getJBBehavior()) != null) {
            behavior.openWithBrowser(url);
        }
    }

    public String[] getSupportFunctions() {
        return new String[]{HANDLER_IS_INSTALLED, HANDLER_OPEN_WITH_BROWSER};
    }

    protected String getTag() {
        return "BilJsBridgeHandlerBBQ";
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class BilJsBridgeHandlerBBQFactory implements JsBridgeCallHandlerFactoryV2 {
        private BiliJsBridgeBBQBehavior mJBBehavior;

        public BilJsBridgeHandlerBBQFactory(MWebActivity activity) {
            this.mJBBehavior = new BiliJsBridgeBBQBehavior(activity);
        }

        public JsBridgeCallHandlerV2 create() {
            return new MJsBridgeCallHandlerBBQ(this.mJBBehavior);
        }
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class BiliJsBridgeBBQBehavior implements IJsBridgeBehavior {
        private MWebActivity mActivity;

        public BiliJsBridgeBBQBehavior(MWebActivity activity) {
            this.mActivity = activity;
        }

        public boolean checkAppInstalled(String pkgName) {
            try {
                if (this.mActivity == null) {
                    return false;
                }
                return PackageManagerHelper.checkAppInstalled(this.mActivity, pkgName);
            } catch (Exception e) {
                return false;
            }
        }

        public void openWithBrowser(String url) {
            if (this.mActivity == null) {
                return;
            }
            Uri uri = Uri.parse(url);
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            this.mActivity.startActivity(intent);
        }

        public void release() {
            this.mActivity = null;
        }

        public boolean isDestroyed() {
            return this.mActivity == null || this.mActivity.isFinishing();
        }
    }
}