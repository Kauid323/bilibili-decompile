package tv.danmaku.bili.ui.teen;

import android.content.Context;
import android.os.Bundle;
import com.bilibili.app.comm.bh.BiliWebView;
import com.bilibili.lib.biliweb.MWebToolbar;
import com.bilibili.lib.jsbridge.legacy.WebProxyV2;
import com.bilibili.lib.tribe.core.internal.Hooks;
import kotlin.Metadata;
import tv.danmaku.bili.ui.webview.MWebActivity;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: WebTeenAuthActivity.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\n\u001a\u00020\u0007H\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Ltv/danmaku/bili/ui/teen/WebTeenAuthActivity;", "Ltv/danmaku/bili/ui/webview/MWebActivity;", "<init>", "()V", "closeListener", "Lcom/bilibili/lib/biliweb/MWebToolbar$OnMWebClickListener;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onBackPressed", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class WebTeenAuthActivity extends MWebActivity {
    public static final int $stable = 8;
    private final MWebToolbar.OnMWebClickListener closeListener = new MWebToolbar.OnMWebClickListener() { // from class: tv.danmaku.bili.ui.teen.WebTeenAuthActivity$$ExternalSyntheticLambda0
        public final void onClickClose() {
            WebTeenAuthActivity.closeListener$lambda$0(WebTeenAuthActivity.this);
        }
    };

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // tv.danmaku.bili.ui.webview.MWebActivity
    public void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void closeListener$lambda$0(WebTeenAuthActivity this$0) {
        String str;
        BiliWebView biliWebView = this$0.mWebView;
        str = WebTeenAuthActivityKt.FUNCTION_JS_CLOSE;
        WebProxyV2.evaluateJavascriptRaw(biliWebView, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tv.danmaku.bili.ui.webview.MWebActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MWebToolbar mWebToolbar = this.mToolbar;
        MWebToolbar mWebToolbar2 = mWebToolbar instanceof MWebToolbar ? mWebToolbar : null;
        if (mWebToolbar2 != null) {
            mWebToolbar2.setOnMWebClickListener(this.closeListener);
        }
    }

    @Override // tv.danmaku.bili.ui.webview.MWebActivity
    public void onBackPressed() {
        String str;
        BiliWebView biliWebView = this.mWebView;
        str = WebTeenAuthActivityKt.FUNCTION_JS_CLOSE;
        WebProxyV2.evaluateJavascriptRaw(biliWebView, str);
    }
}