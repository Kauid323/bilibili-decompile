package tv.danmaku.ijk.media.player.services;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.bilibili.lib.spy.generated.android_app_Activity;
import com.bilibili.lib.tribe.core.internal.Hooks;
import tv.danmaku.android.log.BLog;

public class IjkMediaPlayerNoUIActivity extends android_app_Activity {
    private final String TAG = "IjkMediaPlayerNoUIActivity";

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(1);
        BLog.d("IjkMediaPlayerNoUIActivity", "onCreate");
        Intent intent = new Intent((Context) this, (Class<?>) IjkMediaPlayerService.class);
        try {
            startService(intent);
        } catch (RuntimeException e) {
        }
        finish();
    }
}