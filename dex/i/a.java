package i;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import androidx.core.app.ActivityCompat$;
import com.bilibili.kaptbundle.BuildConfig;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.neuron.api.Neurons;
import com.sina.weibo.sdk.auth.AccessTokenHelper;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.common.UiError;
import com.sina.weibo.sdk.web.WebActivity;
import g.e;
import java.net.MalformedURLException;
import java.net.URL;
import kotlin.ExceptionsKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;

public final class a extends b {
    public a(Activity activity, h.d dVar, j.b bVar) {
        super(activity, dVar, bVar);
    }

    @Override // i.b
    public final boolean a() {
        b();
        return true;
    }

    @Override // i.b
    public final void b() {
        WbAuthListener wbAuthListener;
        String str = this.f1971d.b.d;
        if (!TextUtils.isEmpty(str)) {
            b.b bVar = this.a;
            synchronized (bVar) {
                if (TextUtils.isEmpty(str)) {
                    wbAuthListener = null;
                } else {
                    wbAuthListener = (WbAuthListener) bVar.a.get(str);
                }
            }
            this.f1972e = wbAuthListener;
            if (wbAuthListener != null) {
                wbAuthListener.onCancel();
            }
            b.b bVar2 = this.a;
            synchronized (bVar2) {
                if (!TextUtils.isEmpty(str)) {
                    bVar2.a.remove(str);
                }
            }
        }
        WebActivity webActivity = this.c;
        if (webActivity != null) {
            __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookActivityFinish(webActivity);
        }
    }

    @Override // i.b, android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        Bundle bundle;
        WbAuthListener wbAuthListener;
        super.onPageFinished(webView, str);
        AuthInfo authInfo = this.f1971d.b.a;
        if (authInfo == null || !str.startsWith(authInfo.getRedirectUrl())) {
            return;
        }
        String str2 = this.f1971d.b.d;
        if (!TextUtils.isEmpty(str2)) {
            b.b bVar = this.a;
            synchronized (bVar) {
                bundle = null;
                wbAuthListener = TextUtils.isEmpty(str2) ? null : (WbAuthListener) bVar.a.get(str2);
            }
            this.f1972e = wbAuthListener;
            if (wbAuthListener != null) {
                char[] cArr = e.a;
                try {
                    bundle = e.a(new URL(str).getQuery());
                } catch (MalformedURLException e2) {
                    e2.printStackTrace();
                }
                if (bundle != null) {
                    String string = bundle.getString("error");
                    String string2 = bundle.getString("error_code");
                    String string3 = bundle.getString("error_description");
                    if (TextUtils.isEmpty(string) && TextUtils.isEmpty(string2)) {
                        Oauth2AccessToken parseAccessToken = Oauth2AccessToken.parseAccessToken(bundle);
                        AccessTokenHelper.writeAccessToken(this.b, parseAccessToken);
                        this.f1972e.onComplete(parseAccessToken);
                    } else {
                        this.f1972e.onError(new UiError(-1, string2, string3));
                    }
                } else {
                    this.f1972e.onError(new UiError(-1, "bundle is null", "parse url error"));
                }
                b.b bVar2 = this.a;
                synchronized (bVar2) {
                    if (!TextUtils.isEmpty(str2)) {
                        bVar2.a.remove(str2);
                    }
                }
            }
        }
        WebActivity webActivity = this.c;
        if (webActivity != null) {
            __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookActivityFinish(webActivity);
        }
    }

    @Override // i.b, android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // i.b, android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        Bundle bundle;
        String uri = webResourceRequest.getUrl().toString();
        AuthInfo authInfo = this.f1971d.b.a;
        if (authInfo != null && uri.startsWith(authInfo.getRedirectUrl())) {
            char[] cArr = e.a;
            try {
                bundle = e.a(new URL(uri).getQuery());
            } catch (MalformedURLException e2) {
                e2.printStackTrace();
                bundle = null;
            }
            if (bundle != null) {
                return !TextUtils.isEmpty(bundle.getString("access_token"));
            }
        }
        return false;
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Bundle bundle;
        AuthInfo authInfo = this.f1971d.b.a;
        if (authInfo != null && str.startsWith(authInfo.getRedirectUrl())) {
            char[] cArr = e.a;
            try {
                bundle = e.a(new URL(str).getQuery());
            } catch (MalformedURLException e2) {
                e2.printStackTrace();
                bundle = null;
            }
            if (bundle != null) {
                return !TextUtils.isEmpty(bundle.getString("access_token"));
            }
        }
        return false;
    }

    private static void __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookActivityFinish(Object activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (Intrinsics.areEqual(ConfigManager.Companion.ab().get("bgthread_ui_access_detect_enable", true), true)) {
            Thread thread = Thread.currentThread();
            if (!Intrinsics.areEqual(thread, Looper.getMainLooper().getThread())) {
                IllegalStateException exp = new IllegalStateException("Activity.finish() called from non-UI thread: " + thread + ", 请联系 Jackin");
                BLog.e("BgThreadUIAccess", "Activity.finish() called from non-UI thread: " + thread, exp);
                Neurons.trackT(false, "app.bgthread.ui.access", MapsKt.mapOf(new Pair[]{TuplesKt.to("stacktrace", ExceptionsKt.stackTraceToString(exp)), TuplesKt.to("threadName", thread.getName())}), 1, new ActivityCompat$.ExternalSyntheticLambda0());
                if (BuildConfig.DEBUG) {
                    throw exp;
                }
            }
        }
        ((Activity) activity).finish();
    }
}