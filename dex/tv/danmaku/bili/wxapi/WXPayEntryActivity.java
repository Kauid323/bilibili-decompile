package tv.danmaku.bili.wxapi;

import android.content.Context;
import android.os.Bundle;
import com.bilibili.bilipay.wechat.BaseWXPayEntryActivity;
import com.bilibili.lib.tribe.core.internal.Hooks;

public class WXPayEntryActivity extends BaseWXPayEntryActivity {
    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}