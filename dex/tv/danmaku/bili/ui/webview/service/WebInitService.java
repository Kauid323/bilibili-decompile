package tv.danmaku.bili.ui.webview.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import com.bilibili.lib.tribe.core.internal.Hooks;
import tv.danmaku.android.log.BLog;

public class WebInitService extends IntentService {
    private static final String TAG = "WebInitService";

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    @Override // android.app.Service, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    public WebInitService() {
        super(TAG);
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        BLog.i(TAG, "onHandleIntent");
    }

    @Override // android.app.IntentService, android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        BLog.i(TAG, "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }
}