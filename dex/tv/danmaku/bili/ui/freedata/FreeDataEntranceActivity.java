package tv.danmaku.bili.ui.freedata;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.bilibili.common.webview.js.JsBridgeCallHandlerFactoryV2;
import com.bilibili.droid.H5UrlConfigHelper;
import com.bilibili.freedata.web.JsBridgeCallHandlerFreeData;
import com.bilibili.lib.tribe.core.internal.Hooks;
import java.util.Map;
import tv.danmaku.bili.ui.webview.MWebActivity;

public class FreeDataEntranceActivity extends MWebActivity {
    private static final String FREE_DATA_NAME_SPACE = "freedata";
    public static final String TARGET_WEB_SITE = H5UrlConfigHelper.INSTANCE.getUrl("core", "url_free_data", "https://www.bilibili.com/blackboard/activity-new-freedata.html");

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setEnableBrowserMenu(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected Map<String, JsBridgeCallHandlerFactoryV2> getExtraBuiltinJsBridgeCallHandlers() {
        Map<String, JsBridgeCallHandlerFactoryV2> map = super.getExtraBuiltinJsBridgeCallHandlers();
        map.put(FREE_DATA_NAME_SPACE, new JsBridgeCallHandlerFreeData.BilJsBridgeHandlerFreeDataFactory(this));
        return map;
    }

    public static Intent createIntent(Context context, Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setClass(context.getApplicationContext(), FreeDataEntranceActivity.class);
        intent.setData(uri);
        return intent;
    }

    public boolean isActivityDie() {
        return isFinishing() || isDestroyCalled();
    }
}