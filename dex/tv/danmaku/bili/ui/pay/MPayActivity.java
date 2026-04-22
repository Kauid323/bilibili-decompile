package tv.danmaku.bili.ui.pay;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.webkit.JavascriptInterface;
import bili.resource.common.R;
import com.bilibili.app.comm.bh.BiliWebView;
import com.bilibili.bilipay.api.BiliPayBridge;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.pay.alibaba.AliPayResult;
import com.bilibili.lib.tribe.core.internal.Hooks;
import com.bilibili.magicasakura.widgets.TintProgressDialog;
import java.net.URLDecoder;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.android.ConnectivityManagerHelper;
import tv.danmaku.android.log.BLog;
import tv.danmaku.android.util.DebugLog;
import tv.danmaku.bili.BuildConfig;
import tv.danmaku.bili.ui.loginv2.LoginActivityV2;
import tv.danmaku.bili.ui.webview.JavaScriptBridgeBiliAppPayV2;
import tv.danmaku.bili.ui.webview.JavaScriptBridgeBiliAppV2;
import tv.danmaku.bili.ui.webview.MWebActivity;

public class MPayActivity extends MWebActivity implements Handler.Callback {
    static final int DIALOG = 2;
    static final int ERR = 1;
    public static final String IS_PAY_FAILED_FOR_CANCEL = "is_pay_failed_cancel_key";
    public static final String KEY_FROM = "key:from";
    static final int OK = 0;
    static final String PAY_V1_CHANNEL_ALIPAY = "alipay";
    static final String PAY_V1_SELLER_BILI = "1";
    static final String PAY_V1_URL_PATTERN = "pay\\.bilibili\\.com/cashier/standard";
    static final String PAY_V1_URL_PREFIX = "https://pay.bilibili.com/cashier/standard?orderNo=";
    static final String PAY_V3_URL_PATTERN = "pay\\.bilibili\\.com/mobile/center\\.html";
    private static final String TAG = "MPayActivity";
    TintProgressDialog mDialog;
    Handler mHandler = new Handler(this);
    private String mOrderNO;
    ExecutorService mThreadExecutor;

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // tv.danmaku.bili.ui.webview.MWebActivity
    public void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tv.danmaku.bili.ui.webview.MWebActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setEnableOverflowMenu(false);
    }

    @Override // tv.danmaku.bili.ui.webview.MWebActivity
    protected JavaScriptBridgeBiliAppV2 createAppMainJavaScriptBridge() {
        this.mWebView.addJavascriptInterface(new JS(), "android");
        return new JavaScriptBridgeBiliAppPayV2();
    }

    @Override // tv.danmaku.bili.ui.webview.MWebActivity
    protected void onInterceptIntentUri() {
        Intent intent;
        Uri oUri;
        Uri uri;
        String accessKey = BiliAccounts.get(getApplicationContext()).getAccessKey();
        if (TextUtils.isEmpty(accessKey) || (oUri = (intent = getIntent()).getData()) == null || oUri.getHost() == null || (uri = onInterceptPayUri(oUri)) == oUri) {
            return;
        }
        intent.setData(uri);
        setIntent(intent);
    }

    @Override // tv.danmaku.bili.ui.webview.MWebActivity
    protected boolean onOverrideUrlLoading(BiliWebView view2, Uri uri) {
        Uri newUri;
        if (!isPayUrl(uri) || (newUri = onInterceptPayUri(uri)) == uri) {
            return false;
        }
        view2.loadUrl(newUri.toString());
        return true;
    }

    Uri onInterceptPayUri(Uri oUri) {
        if (this.mOrderNO == null) {
            tryOpenTracer(oUri);
        }
        if (!isPayUrl(oUri)) {
            return oUri;
        }
        if (TextUtils.isEmpty(oUri.getQueryParameter("nosdk"))) {
            Uri fixUri = extractQueryParams(oUri);
            if (fixUri == null) {
                return oUri;
            }
            return Uri.parse(fixUri.toString() + "&supportSdk=alipay");
        }
        return oUri;
    }

    private void tryOpenTracer(Uri oUri) {
        this.mOrderNO = oUri.getQueryParameter("orderNo");
        if (TextUtils.isEmpty(this.mOrderNO)) {
            this.mOrderNO = oUri.getQueryParameter("order_no");
        }
        if (this.mOrderNO == null) {
        }
    }

    Uri extractQueryParams(Uri uri) {
        int index = uri.toString().indexOf("?");
        if (index < 0) {
            return null;
        }
        Uri fixUri = Uri.parse(uri.toString().substring(0, index));
        String[] params = uri.getQuery().split("&");
        Uri.Builder builder = fixUri.buildUpon();
        for (String param : params) {
            DebugLog.i(TAG, param);
            if (param.length() > 3) {
                String[] pair = param.split("=");
                if (pair.length >= 2 && pair[0].length() != 0 && pair[1].length() != 0 && !"supportSdk".equalsIgnoreCase(pair[0])) {
                    builder.appendQueryParameter(pair[0], pair[1]);
                }
            }
        }
        return builder.build();
    }

    public static boolean isPayUrl(Uri url) {
        if (url != null) {
            if ("https".equalsIgnoreCase(url.getScheme()) || BuildConfig.DEBUG) {
                Pattern patternV1 = Pattern.compile(PAY_V1_URL_PATTERN);
                Pattern patternV3 = Pattern.compile(PAY_V3_URL_PATTERN);
                Matcher matchV1 = patternV1.matcher(url.toString());
                Matcher matchV3 = patternV3.matcher(url.toString());
                if (matchV1.find() || matchV3.find()) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public static Intent createIntent(Context context, Uri uri, int from, String extraObj) {
        String accessKey = BiliAccounts.get(context).getAccessKey();
        if (TextUtils.isEmpty(accessKey)) {
            ToastHelper.showToastShort(context, R.string.common_global_string_371);
            return LoginActivityV2.createIntent(context);
        }
        Intent intent = new Intent(context.getApplicationContext(), MPayActivity.class);
        intent.setData(uri);
        intent.putExtra(KEY_FROM, from);
        return intent;
    }

    public static Intent createIntent(Context context, Uri uri, int from) {
        return createIntent(context, uri, from, (String) null);
    }

    public static Intent createIntent(Context context, String no, int from, String extraObj) {
        String goUrl = PAY_V1_URL_PREFIX + no;
        return createIntent(context, Uri.parse(goUrl), from, extraObj);
    }

    public static Intent createIntent(Context context, String no, int from) {
        return createIntent(context, no, from, (String) null);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message msg) {
        if (isFinishing()) {
            return true;
        }
        if (msg.what == 0) {
            AliPayResult r = (AliPayResult) msg.obj;
            Intent data = new Intent(getIntent());
            if (r.success) {
                setResult(-1, data);
            } else {
                ToastHelper.showToastShort(getApplicationContext(), r.resultStatus);
                data.putExtra(IS_PAY_FAILED_FOR_CANCEL, r.code == 6001);
                setResult(0, data);
            }
            finish();
        } else if (msg.what == 1) {
            dismissDialog();
            ToastHelper.showToastShort(getApplicationContext(), R.string.common_global_string_362);
        } else if (msg.what == 2) {
            dismissDialog();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void startAliPay(String decode) {
        this.mDialog = TintProgressDialog.show(this, (CharSequence) null, getString(bili.resource.homepage.R.string.homepage_global_string_204), true, true, new DialogInterface.OnCancelListener() { // from class: tv.danmaku.bili.ui.pay.MPayActivity.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialog) {
                if (MPayActivity.this.mThreadExecutor != null && !MPayActivity.this.mThreadExecutor.isShutdown()) {
                    MPayActivity.this.mThreadExecutor.shutdownNow();
                    MPayActivity.this.mThreadExecutor = null;
                }
                ToastHelper.showToastShort(MPayActivity.this.getApplicationContext(), R.string.common_global_string_238);
            }
        });
        this.mThreadExecutor = Executors.newSingleThreadExecutor(new PayThreadFactory());
        this.mThreadExecutor.execute(new AlipayTask(this, decode, this.mOrderNO, this.mHandler));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class PayThreadFactory implements ThreadFactory {
        private final ThreadGroup mThreadGroup;
        private final AtomicInteger mThreadNumber = new AtomicInteger(1);

        PayThreadFactory() {
            SecurityManager s = System.getSecurityManager();
            this.mThreadGroup = s != null ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r) {
            Thread t = new Thread(this.mThreadGroup, r, "MWebPay#" + this.mThreadNumber.getAndIncrement(), 0L);
            if (t.isDaemon()) {
                t.setDaemon(false);
            }
            if (t.getPriority() != 5) {
                t.setPriority(5);
            }
            return t;
        }
    }

    @Deprecated
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    class JS {
        JS() {
        }

        @JavascriptInterface
        public void startPaySdk(String channel_type, String seller, String data) {
            if (!ConnectivityManagerHelper.isConnectedOrConnecting(MPayActivity.this.getApplicationContext())) {
                ToastHelper.showToastShort(MPayActivity.this.getApplicationContext(), R.string.common_global_string_111);
                return;
            }
            DebugLog.i(MPayActivity.TAG, "channel:" + channel_type + ",seller:" + seller);
            if (!"1".equals(seller)) {
                ToastHelper.showToastShort(MPayActivity.this.getApplicationContext(), MPayActivity.this.getString(bili.resource.homepage.R.string.homepage_global_string_372) + seller);
            } else if (MPayActivity.PAY_V1_CHANNEL_ALIPAY.equalsIgnoreCase(channel_type) && !MPayActivity.this.isFinishing()) {
                MPayActivity.this.startAliPay(data);
            }
        }

        @JavascriptInterface
        public void closeBrowser() {
            MPayActivity.this.dismissDialog();
            MPayActivity.this.finish();
        }

        @JavascriptInterface
        public void closeBrowser(String content) {
            if (!TextUtils.isEmpty(content)) {
                try {
                    JSONObject json = new JSONObject(content);
                    boolean success = "success".equals(json.optString("status"));
                    if (success) {
                        MPayActivity.this.setResult(-1, new Intent(MPayActivity.this.getIntent()));
                    } else {
                        MPayActivity.this.setResult(0);
                    }
                } catch (JSONException e) {
                    ToastHelper.showToastShort(MPayActivity.this.getApplicationContext(), content);
                }
            }
            MPayActivity.this.dismissDialog();
            MPayActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissDialog() {
        if (this.mDialog != null && this.mDialog.isShowing()) {
            this.mDialog.dismiss();
        }
    }

    @Override // tv.danmaku.bili.ui.webview.MWebActivity
    public void onBackPressed() {
        if (this.mDialog != null && this.mDialog.isShowing()) {
            return;
        }
        super.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tv.danmaku.bili.ui.webview.MWebActivity
    public void onDestroy() {
        dismissDialog();
        super.onDestroy();
        if (this.mThreadExecutor != null) {
            this.mThreadExecutor.shutdown();
            this.mThreadExecutor = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class AlipayTask implements Runnable {
        static final byte[] MY_PUBLIC = Base64.decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC9GZDlHEnVjz4U/whASjjYoorJX0CRTYArdFzjb1Py9Tfqk7VWoD6CXvbL345fOAeC1R1giGaZicrQgnYo04/IyKwvvPwvEt3JrgWM2VBM4ILcs51v98irTgXNP4dVsS7X/vsGYgDXKyCNWp4WXkjAkT514DAt19dpfjuXGhL/IwIDAQAB", 0);
        Activity activity;
        String decode;
        Handler handler;
        String orderNo;

        AlipayTask(Activity activity, String decode, String orderNo, Handler handler) {
            this.decode = decode;
            this.handler = handler;
            this.activity = activity;
            this.orderNo = orderNo;
        }

        static boolean doCheck(String content, String sign) {
            try {
                KeyFactory keyFactory = KeyFactory.getInstance("RSA");
                PublicKey pubKey = keyFactory.generatePublic(new X509EncodedKeySpec(MY_PUBLIC));
                Signature signature = Signature.getInstance("SHA1WithRSA");
                signature.initVerify(pubKey);
                signature.update(content.getBytes("UTF-8"));
                boolean verified = signature.verify(Base64.decode(sign, 0));
                BLog.ifmt("AlipayTask", "content:%s\nsign:%s\nverified:%s", new Object[]{content, sign, Boolean.valueOf(verified)});
                return verified;
            } catch (Exception e) {
                BLog.w("AlipayTask", "checking signature failed", e);
                return false;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                JSONObject json = AliPayResult.string2JSON(this.decode, "&");
                int pos = this.decode.indexOf("&sign=");
                String signContent = this.decode.substring(0, pos);
                String signType = json.getString("sign_type");
                String signType2 = signType.replace("\"", "");
                String sign = json.getString("sign");
                String sign2 = URLDecoder.decode(sign.replace("\"", ""), "UTF-8");
                if (signType2.equalsIgnoreCase("RSA") && !doCheck(signContent, sign2)) {
                    BLog.e(MPayActivity.TAG, "error content!!!\n" + this.decode);
                    this.handler.sendEmptyMessage(1);
                    return;
                }
                String result = BiliPayBridge.payAli(this.activity, this.decode, true);
                this.handler.sendEmptyMessage(2);
                AliPayResult r = new AliPayResult(result);
                r.parseResult();
                this.handler.obtainMessage(0, r).sendToTarget();
            } catch (Exception e) {
                BLog.e(MPayActivity.TAG, "error content!!!\n" + this.decode, e);
                this.handler.sendEmptyMessage(1);
            }
        }
    }
}