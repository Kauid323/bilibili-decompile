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
import com.sina.weibo.sdk.web.WebActivity;
import com.tencent.open.SocialConstants;
import g.e;
import java.net.URI;
import java.net.URISyntaxException;
import kotlin.ExceptionsKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;

public final class d extends b {
    public d(Activity activity, h.d dVar, j.b bVar) {
        super(activity, dVar, bVar);
    }

    @Override // i.b
    public final void a(String str) {
        a(2, str);
    }

    @Override // i.b
    public final void b() {
        a(1, "cancel share!!!");
        WebActivity webActivity = this.c;
        if (webActivity != null) {
            __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookActivityFinish(webActivity);
        }
    }

    @Override // i.b, android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
    }

    @Override // i.b, android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Bundle bundle;
        if (TextUtils.isEmpty(str) || !str.startsWith("sinaweibo://browser/close")) {
            return false;
        }
        char[] cArr = e.a;
        try {
            bundle = e.a(new URI(str).getQuery());
        } catch (URISyntaxException e2) {
            e2.printStackTrace();
            bundle = null;
        }
        if (bundle != null) {
            String string = bundle.getString("code");
            String string2 = bundle.getString(SocialConstants.PARAM_SEND_MSG);
            if ("0".equals(string)) {
                a(0, string2);
            } else {
                a(2, string2);
            }
        } else {
            a(2, "bundle is null!!!");
        }
        WebActivity webActivity = this.c;
        if (webActivity != null) {
            __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookActivityFinish(webActivity);
            return true;
        }
        return true;
    }

    @Override // i.b
    public final boolean a() {
        b();
        return true;
    }

    @Override // i.b, android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        Bundle bundle;
        String uri = webResourceRequest.getUrl().toString();
        if (TextUtils.isEmpty(uri) || !uri.startsWith("sinaweibo://browser/close")) {
            return false;
        }
        char[] cArr = e.a;
        try {
            bundle = e.a(new URI(uri).getQuery());
        } catch (URISyntaxException e2) {
            e2.printStackTrace();
            bundle = null;
        }
        if (bundle != null) {
            String string = bundle.getString("code");
            String string2 = bundle.getString(SocialConstants.PARAM_SEND_MSG);
            if (TextUtils.isEmpty(string)) {
                a(1, "code is null!!!");
            } else if ("0".equals(string)) {
                a(0, string2);
            } else {
                a(2, string2);
            }
        } else {
            a(2, "bundle is null!!!");
        }
        WebActivity webActivity = this.c;
        if (webActivity != null) {
            __Ghost$Insertion$com_bilibili_kaptbundle_BgThreadUIAccessDetectKt_hookActivityFinish(webActivity);
        }
        return true;
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