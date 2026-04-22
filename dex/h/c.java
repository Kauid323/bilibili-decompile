package h;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.sina.weibo.sdk.web.WebActivity;

public final class c extends WebChromeClient {
    public final /* synthetic */ WebActivity a;

    public c(WebActivity webActivity) {
        this.a = webActivity;
    }

    @Override // android.webkit.WebChromeClient
    public final void onProgressChanged(WebView webView, int i2) {
        super.onProgressChanged(webView, i2);
        this.a.e.setProgress(i2);
        if (i2 == 100) {
            this.a.e.setVisibility(4);
        } else {
            this.a.e.setVisibility(0);
        }
    }

    @Override // android.webkit.WebChromeClient
    public final void onReceivedTitle(WebView webView, String str) {
        super.onReceivedTitle(webView, str);
    }
}