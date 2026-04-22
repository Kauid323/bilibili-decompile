package cmbapi;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import cmbapi.CMBApi;
import cmbapi.c;
import java.io.IOException;
import java.io.InputStream;

public class CMBWebview extends WebView {
    private Activity mActivity;
    private c mCmbSdkExecutor;
    private String mH5Url;
    private CMBWebViewListener mListener;
    private String mStrResponseData;

    public CMBWebview(Context context) {
        super(context);
        this.mH5Url = "";
        this.mStrResponseData = "";
        this.mActivity = (Activity) context;
        initWebView();
        initJsInterface();
    }

    public CMBWebview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mH5Url = "";
        this.mStrResponseData = "";
        this.mActivity = (Activity) context;
        initJsInterface();
        initWebView();
    }

    public CMBWebview(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mH5Url = "";
        this.mStrResponseData = "";
        this.mActivity = (Activity) context;
        initWebView();
        initJsInterface();
    }

    private String getStringFromLocalFile(int i) {
        InputStream inputStream = null;
        try {
            try {
                inputStream = this.mActivity.getResources().openRawResource(i);
                byte[] bArr = new byte[inputStream.available()];
                inputStream.read(bArr);
                return new String(bArr, com.alipay.sdk.m.o.a.z);
            } catch (IOException e) {
                Log.d(CMBConstants.TAG, "inputStream.read");
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        return "";
                    } catch (IOException e2) {
                        Log.d(CMBConstants.TAG, "inputStream.close");
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
                    Log.d(CMBConstants.TAG, "inputStream.close");
                }
            }
        }
    }

    private void initJsInterface() {
        this.mCmbSdkExecutor = new c(new c.a() { // from class: cmbapi.CMBWebview.1
            @Override // cmbapi.c.a
            public void a() {
                CMBWebview.this.loadFinalUrl();
            }

            @Override // cmbapi.c.a
            public void a(String str, String str2) {
                b.a(str, str2);
                CMBWebview.this.sendCloseMsg();
            }

            @Override // cmbapi.c.a
            public void b() {
                CMBWebview.this.sendCloseMsg();
            }

            @Override // cmbapi.c.a
            public void b(String str, String str2) {
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

    private void initWebView() {
        setWebChromeClient(new WebChromeClient());
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        String userAgentString = settings.getUserAgentString();
        Log.d(CMBConstants.TAG, "Origin User Agent:" + userAgentString);
        settings.setUserAgentString(userAgentString + " CMBSDK/" + CMBApiUtils.SDK_VERSION);
        setWebViewClient(new WebViewClient() { // from class: cmbapi.CMBWebview.2
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                CMBWebview.this.mListener.onTitleChanged(webView.getTitle());
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            }
        });
        addJavascriptInterface(this.mCmbSdkExecutor, "CMBSDK");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadFinalUrl() {
        if (!CMBApiUtils.isNetworkAvailable(this.mActivity)) {
            this.mCmbSdkExecutor.a("网络连接已断开");
            loadDataWithBaseURL("", getStringFromLocalFile(R.raw.errorpage), "text/html", com.alipay.sdk.m.o.a.z, "");
            return;
        }
        b.a(CMBConstants.ResponseCode_Cancel_Positive, CMBConstants.ResponseMsg_Cancel_Positive);
        try {
            if (TextUtils.isEmpty(this.mStrResponseData)) {
                loadUrl(this.mH5Url);
            } else {
                postUrl(this.mH5Url, this.mStrResponseData.getBytes(com.alipay.sdk.m.o.a.z));
            }
        } catch (Exception e) {
            Log.e(CMBConstants.TAG, "webview load url error,info: " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendCloseMsg() {
        int a = b.a();
        String b = b.b();
        Log.d(CMBConstants.TAG, "handleRespMessage respCode:" + b.a() + "respMessage:" + b.b());
        b.a(a + "", b);
        if (this.mListener != null) {
            this.mListener.onClosed(a, b);
        }
    }

    public CMBResponse getCMBResponse() {
        CMBResponse cMBResponse = new CMBResponse();
        cMBResponse.respCode = b.a();
        cMBResponse.respMsg = b.b();
        return cMBResponse;
    }

    public void sendRequest(CMBRequest cMBRequest, CMBWebViewListener cMBWebViewListener) {
        if (cMBWebViewListener != null) {
            this.mListener = cMBWebViewListener;
            if (!cMBRequest.CMBH5Url.startsWith("http://") && !cMBRequest.CMBH5Url.startsWith("https://")) {
                b.a(CMBConstants.RequestCode_Params_Error + "", CMBConstants.ResponseMsg_Params_Error_Params_Error + "链接不是以http/https开头");
                sendCloseMsg();
                return;
            }
        }
        this.mH5Url = cMBRequest.CMBH5Url;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.format(CMBConstants.REQ_PARAMS, CMBApiFactory.getCMBApi().getApiVersion(), CMBApiFactory.getCMBApi().getAppId(), cMBRequest.method));
        stringBuffer.append(cMBRequest.requestData);
        this.mStrResponseData = stringBuffer.toString();
        loadFinalUrl();
    }
}