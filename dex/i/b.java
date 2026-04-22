package i;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.share.ShareTransActivity;
import com.sina.weibo.sdk.web.WebActivity;

public abstract class b extends WebViewClient {
    public b.b a = b.b.a();
    public Activity b;
    public h.d c;

    /* renamed from: d  reason: collision with root package name */
    public j.b f1971d;

    /* renamed from: e  reason: collision with root package name */
    public WbAuthListener f1972e;

    public b(Activity activity, h.d dVar, j.b bVar) {
        this.b = activity;
        this.c = dVar;
        this.f1971d = bVar;
    }

    public final void a(int i2, String str) {
        Bundle extras = this.b.getIntent().getExtras();
        if (extras == null) {
            return;
        }
        Intent intent = new Intent(this.b, ShareTransActivity.class);
        intent.setAction("com.sina.weibo.sdk.action.ACTION_SDK_REQ_ACTIVITY");
        intent.putExtras(extras);
        intent.putExtra("_weibo_resp_errcode", i2);
        intent.putExtra("_weibo_resp_errstr", str);
        this.b.setResult(-1, intent);
    }

    public void a(String str) {
    }

    public boolean a() {
        return false;
    }

    public void b() {
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        WebActivity webActivity = this.c;
        if (webActivity != null) {
            webResourceError.getErrorCode();
            webResourceError.getDescription().toString();
            webResourceRequest.getUrl().toString();
            WebActivity webActivity2 = webActivity;
            webActivity2.a.setVisibility(0);
            webActivity2.d.setVisibility(8);
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        return super.shouldOverrideUrlLoading(webView, webResourceRequest);
    }
}