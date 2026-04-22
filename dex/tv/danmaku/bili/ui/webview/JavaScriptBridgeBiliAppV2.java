package tv.danmaku.bili.ui.webview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.webkit.JavascriptInterface;
import bolts.Continuation;
import bolts.Task;
import bolts.TaskCompletionSource;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bilibili.app.comm.bh.BiliWebView;
import com.bilibili.app.imagepicker.PickerActivity;
import com.bilibili.app.imagepicker.R;
import com.bilibili.boxing.Boxing;
import com.bilibili.boxing.model.config.CropConfig;
import com.bilibili.boxing.model.config.PickerConfig;
import com.bilibili.boxing.model.entity.BaseMedia;
import com.bilibili.boxing.model.entity.impl.ImageMedia;
import com.bilibili.commons.io.FileUtils;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.bilipay.BiliPay;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.MutableBundleLike;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.jsbridge.legacy.JavaScriptBridgeCommV2;
import com.bilibili.lib.jsbridge.legacy.WebProxyV2;
import com.bilibili.lib.router.Router;
import com.bilibili.magicasakura.widgets.TintProgressDialog;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import java.io.File;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.pay.recharge.helper.RechargeOrderInfo;
import tv.danmaku.bili.ui.pay.recharge.router.PayRouterAdapter;
import tv.danmaku.bili.ui.pay.recharge.router.RechargeUiConfig;
import tv.danmaku.bili.wauth.WAuthErrorMsg;
import tv.danmaku.biliplayerv2.router.PlayerRouteUris;

@Deprecated
public class JavaScriptBridgeBiliAppV2 extends JavaScriptBridgeCommV2 {
    private static final int REQUEST_BBPAY = 21;
    private static final int REQUEST_BUY_VIP = 22;
    private static final int REQUEST_IDENTITY = 23;
    private static final int REQUEST_PAYMENT = 20;
    private static final int REQUEST_PICK_FROM_JS = 19;
    private static final String TAG = "JavaScriptBridgeBiliApp";
    private String mBuyVipCallbackId;
    private boolean mEnableMenu = true;
    private TaskCompletionSource<Boolean> mRequestBbPayTask;

    public boolean isEnableMenu() {
        return this.mEnableMenu;
    }

    @JavascriptInterface
    public void setNavigationStyle(String json) {
        WebProxyV2.Keeper keeper = this.mProxy.getReliableContextWrapper();
        if (keeper == null) {
            return;
        }
        try {
            JSONObject jsonObject = JSON.parseObject(json);
            int style = jsonObject.getIntValue("style");
            String color = jsonObject.getString("color");
            int colorParsed = Color.parseColor(color);
            if (keeper.behavior() instanceof MWebBehavior) {
                ((MWebBehavior) keeper.behavior()).setNavigationStyle(style, colorParsed);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @JavascriptInterface
    public void hideNavigation() {
        WebProxyV2.Keeper keeper = this.mProxy.getReliableContextWrapper();
        if (keeper != null && (keeper.behavior() instanceof MWebBehavior)) {
            ((MWebBehavior) keeper.behavior()).hideNavigation();
        }
    }

    @JavascriptInterface
    public void hideMenu() {
        this.mEnableMenu = false;
        WebProxyV2.Keeper keeper = this.mProxy.getReliableContextWrapper();
        if (keeper == null) {
            return;
        }
        this.mProxy.runOnUiThread(new Runnable() { // from class: tv.danmaku.bili.ui.webview.JavaScriptBridgeBiliAppV2.1
            @Override // java.lang.Runnable
            public void run() {
                WebProxyV2.Keeper keeper2 = JavaScriptBridgeBiliAppV2.this.mProxy.getReliableContextWrapper();
                if (keeper2 == null) {
                    return;
                }
                keeper2.activity().supportInvalidateOptionsMenu();
            }
        });
    }

    @JavascriptInterface
    public void setStatusBarVisibility(String json) {
        WebProxyV2.Keeper keeper = this.mProxy.getReliableContextWrapper();
        if (keeper == null || TextUtils.isEmpty(json)) {
            return;
        }
        try {
            boolean isHidden = JSON.parseObject(json).getIntValue("isShow") == 0;
            if (keeper.behavior() instanceof MWebBehavior) {
                ((MWebBehavior) keeper.behavior()).setStatusBarVisibility(isHidden);
            }
        } catch (Exception e) {
            Log.e(TAG, "setStatusBarVisible unknown error!", e);
        }
    }

    @JavascriptInterface
    public void setTopicId(String json) {
        WebProxyV2.Keeper keeper = this.mProxy.getReliableContextWrapper();
        if (keeper == null || TextUtils.isEmpty(json)) {
            return;
        }
        try {
            String topicId = JSON.parseObject(json).getString("topic_id");
            if (!TextUtils.isEmpty(topicId) && (keeper.behavior() instanceof MWebBehavior)) {
                ((MWebBehavior) keeper.behavior()).showFavoriteMenu(topicId);
            }
        } catch (Exception e) {
            e.printStackTrace();
            ToastHelper.showToastShort(keeper.activity(), "can't set topic id.");
        }
    }

    @JavascriptInterface
    public void startPicker(String args) {
        WebProxyV2.Keeper keeper = this.mProxy.getReliableContextWrapper();
        if (keeper == null) {
            return;
        }
        try {
            JSONObject json = JSON.parseObject(args);
            int mode = json.getIntValue("mode");
            Integer maxSize = json.getInteger("maxsize");
            String callbackId = json.getString("callbackId");
            final PickerConfig pickerConfig = new PickerConfig(mode == 1 ? PickerConfig.Mode.MULTI_IMG : PickerConfig.Mode.SINGLE_IMG);
            if (maxSize != null) {
                pickerConfig.withMaxSize(maxSize.intValue());
            }
            if (mode == 3 && !setCropConfig(json, pickerConfig)) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("code", -2);
                WebProxyV2.jsonCallback(keeper.webView(), new Object[]{callbackId, jsonObject});
                return;
            }
            keeper.webView().setTag(R.id.pick_album_txt, callbackId);
            keeper.webView().post(new Runnable() { // from class: tv.danmaku.bili.ui.webview.JavaScriptBridgeBiliAppV2.2
                @Override // java.lang.Runnable
                public void run() {
                    WebProxyV2.Keeper keeper2 = JavaScriptBridgeBiliAppV2.this.mProxy.getReliableContextWrapper();
                    if (keeper2 == null) {
                        return;
                    }
                    Boxing.of(pickerConfig).withIntent(keeper2.activity(), PickerActivity.class).start(keeper2.activity(), 19);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            ToastHelper.showToastShort(keeper.activity(), "unable to start picker.");
        }
    }

    private boolean setCropConfig(JSONObject json, PickerConfig pickerConfig) {
        File cachePath;
        WebProxyV2.Keeper keeper = this.mProxy.getReliableContextWrapper();
        if (keeper == null || (cachePath = keeper.activity().getExternalCacheDir()) == null) {
            return false;
        }
        Uri destUri = new Uri.Builder().scheme("file").appendPath(cachePath.getAbsolutePath()).appendPath(String.format(Locale.US, "%s.png", Long.valueOf(System.currentTimeMillis()))).build();
        float x = json.getFloat("ratiox").floatValue();
        float y = json.getFloat("ratioy").floatValue();
        CropConfig cropConfig = new CropConfig(destUri);
        cropConfig.aspectRatio(x, y);
        pickerConfig.withCropConfig(cropConfig);
        return true;
    }

    public boolean onActivityResult(int requestCode, int resultCode, Intent data) {
        WebProxyV2.Keeper keeper;
        WebProxyV2.Keeper keeper2;
        if (super.onActivityResult(requestCode, resultCode, data)) {
            return true;
        }
        if (requestCode == 19 && data != null) {
            WebProxyV2.Keeper keeper3 = this.mProxy.getReliableContextWrapper();
            if (keeper3 == null) {
                return false;
            }
            Object id = keeper3.webView().getTag(R.id.pick_album_txt);
            if (String.class.isInstance(id)) {
                if (resultCode != -1) {
                    WebProxyV2.jsonCallback(keeper3.webView(), new Object[]{id.toString(), "{code: -1}"});
                    return true;
                }
                mediaCallback(keeper3.webView(), data);
                return true;
            }
            return false;
        } else if (requestCode == 23) {
            if (resultCode == -1 && (keeper2 = this.mProxy.getReliableContextWrapper()) != null && keeper2.activity() != null) {
                keeper2.activity().finish();
            }
            return true;
        } else if (requestCode == 20) {
            BiliPay.onActivityResult(requestCode, resultCode, data);
            return true;
        } else if (requestCode == 21) {
            if (this.mRequestBbPayTask != null) {
                this.mRequestBbPayTask.setResult(Boolean.valueOf(resultCode == -1));
            }
            this.mRequestBbPayTask = null;
            return true;
        } else if (requestCode == 22) {
            if (resultCode == -1 && !TextUtils.isEmpty(this.mBuyVipCallbackId) && (keeper = this.mProxy.getReliableContextWrapper()) != null) {
                WebProxyV2.jsonCallback(keeper.webView(), new Object[]{this.mBuyVipCallbackId});
            }
            this.mBuyVipCallbackId = null;
            return true;
        } else {
            return false;
        }
    }

    private void mediaCallback(final BiliWebView webView, final Intent data) {
        Context context = webView.getContext();
        final TintProgressDialog dialog = new TintProgressDialog(context);
        dialog.setCancelable(false);
        dialog.setMessage(context.getString(bili.resource.common.R.string.common_global_string_373));
        dialog.show();
        Task.callInBackground(new Callable<Void>() { // from class: tv.danmaku.bili.ui.webview.JavaScriptBridgeBiliAppV2.4
            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                List<BaseMedia> medias = Boxing.getResult(data);
                int size = medias == null ? 0 : medias.size();
                Object callbackId = webView.getTag(R.id.pick_album_txt);
                if (size == 0) {
                    JSONObject error = new JSONObject();
                    error.put("code", "-1");
                    WebProxyV2.jsonCallback(webView, new Object[]{callbackId, error});
                    return null;
                }
                for (int i = 0; i < size; i++) {
                    if (medias.get(i) instanceof ImageMedia) {
                        ImageMedia media = (ImageMedia) medias.get(i);
                        try {
                            String fileBase64 = "data:" + media.getMimeType() + ";base64," + Base64.encodeToString(FileUtils.readFileToByteArray(new File(media.getPath())), 0);
                            JSONObject params = new JSONObject();
                            params.put("code", "0");
                            params.put("content", fileBase64);
                            WebProxyV2.jsonCallback(webView, new Object[]{callbackId, params});
                        } catch (Exception e) {
                            JSONObject params2 = new JSONObject();
                            params2.put("code", "-3");
                            WebProxyV2.jsonCallback(webView, new Object[]{callbackId, params2});
                        }
                    } else {
                        JSONObject params3 = new JSONObject();
                        params3.put("code", WAuthErrorMsg.ERROR_CODE_UNINSTALLED);
                        WebProxyV2.jsonCallback(webView, new Object[]{callbackId, params3});
                    }
                }
                return null;
            }
        }).continueWith(new Continuation<Void, Void>() { // from class: tv.danmaku.bili.ui.webview.JavaScriptBridgeBiliAppV2.3
            public /* bridge */ /* synthetic */ Object then(Task task) throws Exception {
                return m1809then((Task<Void>) task);
            }

            /* renamed from: then  reason: collision with other method in class */
            public Void m1809then(Task<Void> task) throws Exception {
                dialog.dismiss();
                return null;
            }
        }, Task.UI_THREAD_EXECUTOR);
    }

    @JavascriptInterface
    public void openCashier(String args) {
        WebProxyV2.Keeper keeper = this.mProxy.getReliableContextWrapper();
        if (keeper == null || TextUtils.isEmpty(args)) {
            return;
        }
        try {
            JSONObject json = JSON.parseObject(args);
            String payParams = json.getString("payParams");
            final String callbackId = json.getString("callbackId");
            String accessKey = BiliAccounts.get(keeper.activity()).getAccessKey();
            BiliPay.configDefaultAccessKey(accessKey);
            BiliPay.paymentCrossProcess(keeper.activity(), payParams, new BiliPay.BiliPayCallback() { // from class: tv.danmaku.bili.ui.webview.JavaScriptBridgeBiliAppV2.5
                public void onPayResult(int channelId, int payStatus, String msg, int channelCode, String channelResult) {
                    if (!TextUtils.isEmpty(callbackId)) {
                        WebProxyV2.Keeper keeper2 = JavaScriptBridgeBiliAppV2.this.mProxy.getReliableContextWrapper();
                        if (keeper2 == null) {
                            return;
                        }
                        final JSONObject result = new JSONObject();
                        result.put("code", Integer.valueOf(payStatus));
                        result.put("msg", msg);
                        JavaScriptBridgeBiliAppV2.this.mProxy.runOnUiThread(new Runnable() { // from class: tv.danmaku.bili.ui.webview.JavaScriptBridgeBiliAppV2.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                WebProxyV2.Keeper keeper3 = JavaScriptBridgeBiliAppV2.this.mProxy.getReliableContextWrapper();
                                if (keeper3 == null) {
                                    return;
                                }
                                WebProxyV2.evaluateJavascript(keeper3.webView(), "window._biliapp.callback", new Object[]{callbackId, result});
                            }
                        });
                    }
                }
            }, 20);
        } catch (Exception e) {
            Log.e(TAG, "openCashier unkown error!", e);
        }
    }

    @JavascriptInterface
    public void openBpPay(String args) {
        WebProxyV2.Keeper keeper = this.mProxy.getReliableContextWrapper();
        if (keeper == null || TextUtils.isEmpty(args)) {
            return;
        }
        if (this.mRequestBbPayTask != null && !this.mRequestBbPayTask.getTask().isCompleted()) {
            this.mRequestBbPayTask.trySetCancelled();
        }
        this.mRequestBbPayTask = new TaskCompletionSource<>();
        try {
            JSONObject json = JSON.parseObject(args);
            String orderInfo = json.getString(PayRouterAdapter.Keys.BUNDLE_ORDER_INFO);
            String dialogConfig = json.getString(PayRouterAdapter.Keys.BUNDLE_UI_CONFIG);
            final String callbackId = json.getString("callbackId");
            RechargeOrderInfo order = (RechargeOrderInfo) JSON.parseObject(orderInfo, RechargeOrderInfo.class);
            RechargeUiConfig uiConfig = (RechargeUiConfig) JSON.parseObject(dialogConfig, RechargeUiConfig.class);
            this.mRequestBbPayTask.getTask().onSuccess(new Continuation<Boolean, Void>() { // from class: tv.danmaku.bili.ui.webview.JavaScriptBridgeBiliAppV2.6
                public /* bridge */ /* synthetic */ Object then(Task task) throws Exception {
                    return m1810then((Task<Boolean>) task);
                }

                /* renamed from: then  reason: collision with other method in class */
                public Void m1810then(Task<Boolean> task) throws Exception {
                    WebProxyV2.Keeper keeper2 = JavaScriptBridgeBiliAppV2.this.mProxy.getReliableContextWrapper();
                    if (keeper2 == null || !task.isCompleted()) {
                        return null;
                    }
                    JSONObject result = new JSONObject();
                    if (((Boolean) task.getResult()).booleanValue()) {
                        result.put("code", 0);
                        result.put("msg", "");
                    } else {
                        result.put("code", 1100);
                        result.put("msg", "");
                    }
                    WebProxyV2.evaluateJavascript(keeper2.webView(), "window._biliapp.callback", new Object[]{callbackId, result});
                    return null;
                }
            }, UiThreadImmediateExecutorService.getInstance());
            PayRouterAdapter.rechargeAndPay((Activity) keeper.activity(), order, uiConfig, 21);
        } catch (Exception e) {
            Log.e(TAG, "openBbPay unkown error!", e);
        }
    }

    @JavascriptInterface
    public void invokeVip(String args) {
        WebProxyV2.Keeper keeper = this.mProxy.getReliableContextWrapper();
        if (keeper == null || TextUtils.isEmpty(args)) {
            return;
        }
        try {
            JSONObject json = JSON.parseObject(args);
            final String appId = json.getString("appId");
            final String appSubId = json.getString("appSubId");
            final String sourceFrom = json.getString("source_from");
            this.mBuyVipCallbackId = json.getString("callbackId");
            this.mProxy.runOnUiThread(new Runnable() { // from class: tv.danmaku.bili.ui.webview.JavaScriptBridgeBiliAppV2.7
                @Override // java.lang.Runnable
                public void run() {
                    WebProxyV2.Keeper keeper2 = JavaScriptBridgeBiliAppV2.this.mProxy.getReliableContextWrapper();
                    if (keeper2 == null) {
                        return;
                    }
                    RouteRequest routeRequest = new RouteRequest.Builder(Uri.parse(PlayerRouteUris.Routers.ROUTE_URI_VIP_BUY)).extras(new Function1<MutableBundleLike, Unit>() { // from class: tv.danmaku.bili.ui.webview.JavaScriptBridgeBiliAppV2.7.1
                        public Unit invoke(MutableBundleLike mutableBundleLike) {
                            mutableBundleLike.put("appId", TextUtils.isEmpty(appId) ? "" : appId);
                            mutableBundleLike.put("appSubId", TextUtils.isEmpty(appSubId) ? "" : appSubId);
                            mutableBundleLike.put("source_from", TextUtils.isEmpty(sourceFrom) ? "" : sourceFrom);
                            return null;
                        }
                    }).flags(603979776).requestCode(22).build();
                    BLRouter.routeTo(routeRequest, keeper2.activity());
                }
            });
        } catch (Exception e) {
            BLog.e(e.getMessage(), e);
        }
    }

    @JavascriptInterface
    public void immersiveMode() {
        WebProxyV2.Keeper keeper = this.mProxy.getReliableContextWrapper();
        if (keeper != null && (keeper.behavior() instanceof MWebBehavior)) {
            ((MWebBehavior) keeper.behavior()).immersiveMode();
        }
    }

    protected boolean onInterceptOpenScheme(Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.contains("user_center") && pathSegments.contains("auth") && pathSegments.contains("realname")) {
            WebProxyV2.Keeper keeper = this.mProxy.getReliableContextWrapper();
            Router.global().with(keeper.activity()).forResult(23).open(uri);
            return true;
        }
        return false;
    }
}