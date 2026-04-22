package tv.danmaku.bili.ui.register;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.bilibili.app.comm.baseres.R;
import com.bilibili.lib.tribe.core.internal.Hooks;
import tv.danmaku.bili.ui.webview.MWebAPActivity;

public class RegisterFastWebActivity extends MWebAPActivity {
    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // tv.danmaku.bili.ui.webview.MWebAPActivity, tv.danmaku.bili.ui.webview.MWebActivity
    public void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    public static Intent createIntent(Context context, Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setClass(context.getApplicationContext(), RegisterFastWebActivity.class);
        intent.setData(uri);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tv.danmaku.bili.ui.webview.MWebAPActivity, tv.danmaku.bili.ui.webview.MWebActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (this.mContentFrame != null) {
            this.mContentFrame.setBackgroundColor(getResources().getColor(R.color.daynight_color_view_background));
        }
        if (this.mWebView != null) {
            this.mWebView.setBackgroundColor(0);
        }
    }
}