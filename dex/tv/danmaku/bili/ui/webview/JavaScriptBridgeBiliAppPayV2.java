package tv.danmaku.bili.ui.webview;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.provider.Settings;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import androidx.appcompat.app.AlertDialog;
import bili.resource.common.R;
import bolts.Continuation;
import bolts.Task;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bilibili.app.comm.bh.BiliWebView;
import com.bilibili.droid.PackageManagerHelper;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.jsbridge.legacy.WebProxyV2;
import com.bilibili.lib.pay.alibaba.AliPayResult;
import com.bilibili.lib.pay.alibaba.AliPayTask;
import com.bilibili.lib.pay.wechat.WXApiConfig;
import com.bilibili.lib.pay.wechat.WechatPayTask;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.tencent.mm.opensdk.modelpay.PayResp;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.concurrent.Callable;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.IntentHelper;

@Deprecated
public class JavaScriptBridgeBiliAppPayV2 extends JavaScriptBridgeBiliAppV2 {
    private static final boolean DEBUG = false;
    private static final int REQUEST_PAY_ON_WX = 18;
    private static final String TAG = "JavaScriptBridgeBiliAppPay";
    private boolean mPaying = false;
    private WechatPayTask mWXPayTask;

    @Override // tv.danmaku.bili.ui.webview.JavaScriptBridgeBiliAppV2
    public boolean isEnableMenu() {
        return false;
    }

    @JavascriptInterface
    public void jumpToScheme(String args) {
        WebProxyV2.Keeper keeper = this.mProxy.getReliableContextWrapper();
        if (keeper == null) {
            return;
        }
        try {
            JSONObject json = JSON.parseObject(args);
            String url = json.getString("url");
            final Uri uri = Uri.parse(url);
            String scheme = uri.getScheme();
            if ("bilibili".equals(scheme)) {
                if ("pay".equals(uri.getHost())) {
                    keeper.activity().setResult("1".equals(uri.getQueryParameter("status")) ? -1 : 0);
                } else {
                    IntentHelper.intentTo(keeper.activity(), uri);
                }
                keeper.activity().finish();
            } else if ("http".equals(scheme) || "https".equals(scheme)) {
                this.mProxy.runOnUiThread(new Runnable() { // from class: tv.danmaku.bili.ui.webview.JavaScriptBridgeBiliAppPayV2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        WebProxyV2.Keeper keeper2 = JavaScriptBridgeBiliAppPayV2.this.mProxy.getReliableContextWrapper();
                        if (keeper2 == null) {
                            return;
                        }
                        keeper2.behavior().loadNewUrl(uri, true);
                    }
                });
            }
            String callbackId = json.getString("callbackId");
            if (callbackId != null) {
                BLog.e(TAG, "jumpToScheme no callback!");
            }
        } catch (Exception e) {
            BLog.w(TAG, e);
            ToastHelper.showToastShort(keeper.activity(), "Invalid args: biliapp.openScheme(" + args + ")");
        }
    }

    @JavascriptInterface
    public void alipay(String args) {
        WebProxyV2.Keeper keeper = this.mProxy.getReliableContextWrapper();
        if (keeper == null) {
            return;
        }
        JSONObject json = JSON.parseObject(args);
        final String callbackId = json.getString("callbackId");
        if (this.mPaying) {
            BLog.e(TAG, "have pay task already");
        } else if (showAlertIfAlwaysFinishActivities(keeper.activity())) {
        } else {
            final String sign = json.getString("sign");
            checkUrl(keeper.webView()).onSuccessTask(new Continuation<Void, Task<AliPayResult>>() { // from class: tv.danmaku.bili.ui.webview.JavaScriptBridgeBiliAppPayV2.3
                /* renamed from: then  reason: collision with other method in class */
                public /* bridge */ /* synthetic */ Object m1806then(Task task) throws Exception {
                    return then((Task<Void>) task);
                }

                public Task<AliPayResult> then(Task<Void> task) throws Exception {
                    WebProxyV2.Keeper keeper2 = JavaScriptBridgeBiliAppPayV2.this.mProxy.getReliableContextWrapper();
                    if (keeper2 == null) {
                        return null;
                    }
                    return JavaScriptBridgeBiliAppPayV2.payOnAli(sign, keeper2.activity());
                }
            }).continueWith(new Continuation<AliPayResult, Void>() { // from class: tv.danmaku.bili.ui.webview.JavaScriptBridgeBiliAppPayV2.2
                public /* bridge */ /* synthetic */ Object then(Task task) throws Exception {
                    return m1805then((Task<AliPayResult>) task);
                }

                /* renamed from: then  reason: collision with other method in class */
                public Void m1805then(Task<AliPayResult> task) throws Exception {
                    WebProxyV2.Keeper keeper2 = JavaScriptBridgeBiliAppPayV2.this.mProxy.getReliableContextWrapper();
                    if (keeper2 == null) {
                        return null;
                    }
                    JSONObject result = new JSONObject();
                    if (task.isFaulted() || task.isCancelled()) {
                        ToastHelper.showToastShort(keeper2.activity(), R.string.common_global_string_362);
                        BLog.e(JavaScriptBridgeBiliAppPayV2.TAG, "error occurred on alipay()!", task.getError());
                        result.put("code", -1);
                        result.put("message", "error");
                    } else {
                        AliPayResult r = (AliPayResult) task.getResult();
                        result.put("code", Integer.valueOf(r.success ? 1 : r.code == 6001 ? 0 : -1));
                        if (r.success) {
                            keeper2.activity().setResult(-1);
                        }
                        result.put("message", r.resultStatus);
                        ToastHelper.showToastShort(keeper2.activity(), r.resultStatus);
                        result.put("result", r.getResult());
                    }
                    if (callbackId != null) {
                        WebProxyV2.jsonCallback(keeper2.webView(), new Object[]{callbackId, result});
                    }
                    JavaScriptBridgeBiliAppPayV2.this.mPaying = false;
                    return null;
                }
            }, UiThreadImmediateExecutorService.getInstance());
        }
    }

    @JavascriptInterface
    public void wechatpay(String args) {
        WebProxyV2.Keeper keeper = this.mProxy.getReliableContextWrapper();
        if (keeper == null) {
            return;
        }
        if (this.mPaying) {
            BLog.e(TAG, "have pay task already");
        } else if (showAlertIfAlwaysFinishActivities(keeper.activity())) {
        } else {
            JSONObject json = JSON.parseObject(args);
            final String callbackId = json.getString("callbackId");
            PackageInfo mm = PackageManagerHelper.getPackageInfo(keeper.activity(), "com.tencent.mm", 0);
            if (mm == null || !mm.applicationInfo.enabled) {
                showNoWechatAlert(keeper, callbackId);
                return;
            }
            final String sign = json.getString("sign");
            checkUrl(keeper.webView()).onSuccessTask(new Continuation<Void, Task<PayResp>>() { // from class: tv.danmaku.bili.ui.webview.JavaScriptBridgeBiliAppPayV2.5
                /* renamed from: then  reason: collision with other method in class */
                public /* bridge */ /* synthetic */ Object m1808then(Task task) throws Exception {
                    return then((Task<Void>) task);
                }

                public Task<PayResp> then(Task<Void> task) throws Exception {
                    WebProxyV2.Keeper keeper2 = JavaScriptBridgeBiliAppPayV2.this.mProxy.getReliableContextWrapper();
                    if (keeper2 == null) {
                        return null;
                    }
                    return JavaScriptBridgeBiliAppPayV2.this.payOnWX(keeper2.activity(), sign);
                }
            }).continueWith(new Continuation<PayResp, Void>() { // from class: tv.danmaku.bili.ui.webview.JavaScriptBridgeBiliAppPayV2.4
                public /* bridge */ /* synthetic */ Object then(Task task) throws Exception {
                    return m1807then((Task<PayResp>) task);
                }

                /* renamed from: then  reason: collision with other method in class */
                public Void m1807then(Task<PayResp> task) throws Exception {
                    int ret;
                    WebProxyV2.Keeper keeper2 = JavaScriptBridgeBiliAppPayV2.this.mProxy.getReliableContextWrapper();
                    if (keeper2 == null) {
                        return null;
                    }
                    JSONObject result = new JSONObject();
                    if (task.isFaulted()) {
                        ToastHelper.showToastShort(keeper2.activity(), R.string.common_global_string_362);
                        BLog.e(JavaScriptBridgeBiliAppPayV2.TAG, "error occurred on wechatpay()!", task.getError());
                        result.put("code", -1);
                        result.put("message", "error");
                    } else if (task.isCancelled()) {
                        result.put("code", 0);
                        result.put("message", "user cancelled purchase");
                        ToastHelper.showToastShort(keeper2.activity(), com.bilibili.lib.pay.R.string.pay_user_cancel_pay);
                    } else {
                        PayResp resp = (PayResp) task.getResult();
                        if (!resp.checkArgs()) {
                            result.put("code", -1);
                            result.put("message", "error occurred! Response from wx is illegal!");
                        } else {
                            if (resp.errCode == 0) {
                                ret = 1;
                            } else {
                                ret = resp.errCode == -2 ? 0 : -1;
                            }
                            result.put("code", Integer.valueOf(ret));
                            result.put("message", resp.returnKey);
                            if (ret == 0) {
                                ToastHelper.showToastShort(keeper2.activity(), com.bilibili.lib.pay.R.string.pay_user_cancel_pay);
                            } else if (ret == 1) {
                                keeper2.activity().setResult(-1);
                            }
                            JSONObject object = new JSONObject();
                            object.put("errCode", Integer.valueOf(resp.errCode));
                            object.put("errStr", resp.errStr);
                            object.put("prepayId", resp.prepayId);
                            object.put("returnKey", resp.returnKey);
                            object.put("extData", resp.extData);
                            result.put("result", object);
                        }
                    }
                    if (callbackId != null) {
                        WebProxyV2.jsonCallback(keeper2.webView(), new Object[]{callbackId, result});
                    }
                    JavaScriptBridgeBiliAppPayV2.this.mPaying = false;
                    WXApiConfig.setWXPayAppId((String) null);
                    return null;
                }
            }, UiThreadImmediateExecutorService.getInstance());
        }
    }

    private boolean showAlertIfAlwaysFinishActivities(final Activity activity) {
        int alwaysFinishActivity = Settings.Global.getInt(activity.getContentResolver(), "always_finish_activities", 0);
        if (alwaysFinishActivity == 1) {
            DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() { // from class: tv.danmaku.bili.ui.webview.JavaScriptBridgeBiliAppPayV2.6
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialog, int which) {
                    try {
                        activity.startActivity(new Intent("android.settings.APPLICATION_DEVELOPMENT_SETTINGS"));
                    } catch (Exception e) {
                    }
                }
            };
            new AlertDialog.Builder(activity).setPositiveButton(R.string.common_global_string_202, listener).setMessage(com.bilibili.lib.pay.R.string.pay_movie_alert_always_finish_activities).show();
            return true;
        }
        return false;
    }

    private Task<Void> checkUrl(final BiliWebView webView) {
        return Task.call(new Callable<Void>() { // from class: tv.danmaku.bili.ui.webview.JavaScriptBridgeBiliAppPayV2.7
            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                String url = webView.getUrl();
                Uri parsed = Uri.parse(url);
                if (!JavaScriptBridgeBiliAppPayV2.isSupported(parsed)) {
                    throw new UnsupportedOperationException();
                }
                return null;
            }
        }, UiThreadImmediateExecutorService.getInstance());
    }

    private void showNoWechatAlert(final WebProxyV2.Keeper keeper, final String callbackId) {
        new AlertDialog.Builder(keeper.activity()).setTitle(com.bilibili.lib.pay.R.string.pay_no_wechat_tip).setPositiveButton(R.string.common_global_string_202, new DialogInterface.OnClickListener() { // from class: tv.danmaku.bili.ui.webview.JavaScriptBridgeBiliAppPayV2.8
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                if (callbackId != null) {
                    JSONObject result = new JSONObject();
                    result.put("code", -2);
                    result.put("message", "wechat app is not found!");
                    WebProxyV2.jsonCallback(keeper.webView(), new Object[]{callbackId, result});
                }
            }
        }).setCancelable(false).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Task<AliPayResult> payOnAli(String sign, Activity activity) {
        ToastHelper.showToastShort(activity.getApplicationContext(), bili.resource.homepage.R.string.homepage_global_string_204);
        return new AliPayTask().pay(sign, activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Task<PayResp> payOnWX(Activity activity, String sign) {
        String params;
        if (this.mWXPayTask != null) {
            return Task.forError(new IllegalStateException("repeat click"));
        }
        ToastHelper.showToastShort(activity, bili.resource.homepage.R.string.homepage_global_string_218);
        try {
            params = URLDecoder.decode(sign, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            params = URLDecoder.decode(sign);
        }
        this.mWXPayTask = new WechatPayTask();
        return this.mWXPayTask.pay(activity, 18, params);
    }

    @Override // tv.danmaku.bili.ui.webview.JavaScriptBridgeBiliAppV2
    public boolean onActivityResult(int requestCode, int resultCode, Intent data) {
        if (super.onActivityResult(requestCode, resultCode, data)) {
            return true;
        }
        if (requestCode == 18 && this.mWXPayTask != null) {
            this.mWXPayTask.onActivityResult(resultCode, data);
            this.mWXPayTask = null;
            return true;
        }
        return false;
    }

    public void onActivityDestroy() {
        super.onActivityDestroy();
        if (this.mWXPayTask != null) {
            this.mWXPayTask = null;
        }
    }

    public boolean onBackPressed() {
        return this.mWXPayTask != null || super.onBackPressed();
    }

    public static boolean isSupported(Uri uri) {
        String host = uri.getHost();
        String scheme = uri.getScheme();
        boolean isPayHost = host != null && host.equalsIgnoreCase("pay.bilibili.com");
        return isPayHost && TextUtils.equals("https", scheme);
    }
}