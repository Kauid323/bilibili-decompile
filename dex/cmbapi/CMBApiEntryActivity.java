package cmbapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;
import cmbapi.CMBApi;
import cmbapi.c;
import com.bilibili.lib.spy.generated.android_app_Activity;
import com.bilibili.lib.tribe.core.internal.Hooks;
import java.io.IOException;
import java.io.InputStream;

public class CMBApiEntryActivity extends android_app_Activity {
    private static final String TAG = "CMBApiEntryActivity";
    private static final int mResultCode = 2;
    private static final String mStrCMBFuncPrefix = "http://cmbls/";
    private static final String mStrSafeCMBFuncPrefix = "https://cmbls/";
    private static final String mTPAppCall = "TPAppCall";
    private CMBTitleBar mTitleBar;
    private WebView mWebView = null;
    private WebViewClient mWebViewClient = null;
    private ProgressBar mProgressBar = null;
    private c mCmbSdkExecutor = null;
    private Activity mActivity = null;
    private int mProcessValue = 0;
    private String mUserAgent = "";
    private boolean isFinishThread = false;
    private Handler hander = new Handler() { // from class: cmbapi.CMBApiEntryActivity.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1 && CMBApiEntryActivity.this.mProgressBar != null) {
                CMBApiEntryActivity.this.mProcessValue += 10;
                if (CMBApiEntryActivity.this.mProcessValue >= 100) {
                    CMBApiEntryActivity.this.mProcessValue = 95;
                }
                CMBApiEntryActivity.this.mProgressBar.setProgress(CMBApiEntryActivity.this.mProcessValue);
            }
            super.handleMessage(message);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public class a extends Thread {
        a() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (!CMBApiEntryActivity.this.isFinishThread) {
                try {
                    Thread.sleep(1000L);
                    Message message = new Message();
                    message.what = 1;
                    CMBApiEntryActivity.this.hander.sendMessage(message);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleRespMessage() {
        Log.d(CMBConstants.TAG, "handleRespMessage respCode:" + b.a() + "respMessage:" + b.b());
        Intent intent = new Intent();
        intent.putExtra(CMBApiUtils.CMBAPI_INTENT_MSG, b.b());
        intent.putExtra(CMBApiUtils.CMBAPI_INTENT_CODE, b.a());
        setResult(2, intent);
        finish();
    }

    private void initJsInterface() {
        this.mCmbSdkExecutor = new c(new c.a() { // from class: cmbapi.CMBApiEntryActivity.2
            @Override // cmbapi.c.a
            public void a() {
                CMBApiEntryActivity.this.showHtmlPage();
            }

            @Override // cmbapi.c.a
            public void a(String str, String str2) {
                b.a(str, str2);
                Log.d(CMBConstants.TAG, "handleRespMessage respCode: 1");
                CMBApiEntryActivity.this.handleRespMessage();
            }

            @Override // cmbapi.c.a
            public void b() {
                Log.d(CMBConstants.TAG, "handleRespMessage respCode: 2");
                CMBApiEntryActivity.this.handleRespMessage();
            }

            @Override // cmbapi.c.a
            public void b(String str, String str2) {
                CMBApiEntryActivity.this.finish();
                if (CMBApi.PaySdk.mCallback != null) {
                    if (str.equals("0")) {
                        CMBApi.PaySdk.mCallback.onSuccess(str2);
                    } else {
                        CMBApi.PaySdk.mCallback.onError(str2);
                    }
                    CMBApi.PaySdk.mCallback = null;
                    CMBApi.PaySdk.mAppId = "";
                    CMBApi.PaySdk.mContext = null;
                }
            }

            @Override // cmbapi.c.a
            public void c(String str, String str2) {
                b.a(str, str2);
            }
        });
    }

    private void initProcessbar() {
        new Thread(new a()).start();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initView() {
        this.mActivity = this;
        this.mWebView = (WebView) findViewById(R.id.webview1);
        this.mTitleBar = (CMBTitleBar) findViewById(R.id.titleBar);
        this.mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        if (this.mTitleBar != null) {
            this.mTitleBar.setOnBackListener(new View.OnClickListener() { // from class: cmbapi.CMBApiEntryActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Log.d(CMBConstants.TAG, "handleRespMessage respCode: 3");
                    CMBApiEntryActivity.this.handleRespMessage();
                }
            });
        }
    }

    private void initWebView() {
        this.mWebView.setWebChromeClient(new WebChromeClient());
        WebSettings settings = this.mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        String userAgentString = settings.getUserAgentString();
        Log.d(CMBConstants.TAG, "Origin User Agent:" + userAgentString);
        this.mUserAgent = userAgentString + " CMBSDK/" + CMBApiUtils.SDK_VERSION;
        settings.setUserAgentString(this.mUserAgent);
        this.mWebView.setWebViewClient(new WebViewClient() { // from class: cmbapi.CMBApiEntryActivity.3
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                CMBApiEntryActivity.this.mProcessValue = 100;
                CMBApiEntryActivity.this.mProgressBar.setProgress(CMBApiEntryActivity.this.mProcessValue);
                CMBApiEntryActivity.this.mProgressBar.setVisibility(8);
                CMBApiEntryActivity.this.isFinishThread = true;
                if (CMBApiEntryActivity.this.mTitleBar != null) {
                    CMBApiEntryActivity.this.mTitleBar.setTitle(webView.getTitle());
                }
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                CMBApiEntryActivity.this.mProgressBar.setVisibility(0);
                CMBApiEntryActivity.this.mProcessValue = 20;
                CMBApiEntryActivity.this.mProgressBar.setProgress(CMBApiEntryActivity.this.mProcessValue);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                CMBApiEntryActivity.this.mCmbSdkExecutor.a(str2);
                if (i != 200) {
                    CMBApiEntryActivity.this.mWebView.loadDataWithBaseURL("", CMBApiEntryActivity.this.getStringFromLocalFile(R.raw.errorpage), "text/html", com.alipay.sdk.m.o.a.z, "");
                }
                CMBApiEntryActivity.this.mProcessValue = 100;
                CMBApiEntryActivity.this.mProgressBar.setProgress(CMBApiEntryActivity.this.mProcessValue);
                CMBApiEntryActivity.this.mProgressBar.setVisibility(8);
                CMBApiEntryActivity.this.isFinishThread = true;
            }
        });
        this.mWebView.addJavascriptInterface(this.mCmbSdkExecutor, "CMBSDK");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void showHtmlPage() {
        String stringExtra = getIntent().getStringExtra(CMBConstants.Key_Params_URL);
        String stringExtra2 = getIntent().getStringExtra(CMBConstants.Key_Params_Data);
        boolean booleanExtra = getIntent().getBooleanExtra(CMBConstants.Key_Params_ShowNavigation, true);
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        if (!booleanExtra) {
            this.mTitleBar.setVisibility(8);
        }
        if (!CMBApiUtils.isNetworkAvailable(this)) {
            b.a(CMBConstants.ResponseCode_Net_Error, CMBConstants.ResponseMsgNet_Error);
            this.mCmbSdkExecutor.a("网络连接已断开");
            this.mWebView.loadDataWithBaseURL("", getStringFromLocalFile(R.raw.errorpage), "text/html", com.alipay.sdk.m.o.a.z, "");
            return;
        }
        b.a(CMBConstants.ResponseCode_Cancel_Positive, CMBConstants.ResponseMsg_Cancel_Positive);
        try {
            if (TextUtils.isEmpty(stringExtra2)) {
                this.mWebView.loadUrl(stringExtra);
            } else {
                this.mWebView.postUrl(stringExtra, stringExtra2.getBytes(com.alipay.sdk.m.o.a.z));
            }
        } catch (Exception e) {
            Log.e(TAG, "mWebView.postUrl");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    public String getStringFromLocalFile(int i) {
        InputStream inputStream = null;
        try {
            try {
                inputStream = getApplicationContext().getResources().openRawResource(i);
                byte[] bArr = new byte[inputStream.available()];
                inputStream.read(bArr);
                return new String(bArr, com.alipay.sdk.m.o.a.z);
            } catch (IOException e) {
                Log.e(TAG, "inputStream.read");
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        return "";
                    } catch (IOException e2) {
                        Log.e(TAG, "inputStream.close");
                        return "";
                    }
                }
                return "";
            }
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                    Log.e(TAG, "inputStream.close");
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            setContentView(R.layout.cmbwebview);
            initView();
            initJsInterface();
            initWebView();
            showHtmlPage();
            initProcessbar();
        } catch (Exception e) {
            Log.d("问题定位", "错误:" + e.getStackTrace());
            Toast.makeText((Context) this, (CharSequence) "该机型仅支持跳转招商银行APP支付，请试试以下办法：下载招商银行APP，重新发起支付", 1).show();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        this.isFinishThread = true;
        if (this.mWebView != null) {
            this.mWebView.clearHistory();
            this.mWebView.destroy();
            this.mWebView = null;
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            Log.d(CMBConstants.TAG, "handleRespMessage respCode: 4");
            handleRespMessage();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}