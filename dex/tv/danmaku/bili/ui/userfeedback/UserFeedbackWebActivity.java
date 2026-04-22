package tv.danmaku.bili.ui.userfeedback;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.bilibili.common.webview.js.JsBridgeCallHandlerFactoryV2;
import com.bilibili.droid.H5UrlConfigHelper;
import com.bilibili.lib.tribe.core.internal.Hooks;
import java.util.Map;
import tv.danmaku.bili.ui.userfeedback.JsBridgeCallHandlerFeedback;
import tv.danmaku.bili.ui.webview.MWebActivity;

public class UserFeedbackWebActivity extends MWebActivity {
    private static final String FEEDBACK_NAMESPACE = "main";
    public static final String USER_FEEDBACK_URL = "https://www.bilibili.com/h5/faq/feedback";

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // tv.danmaku.bili.ui.webview.MWebActivity
    public void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    public static Intent createIntent(Context context, Uri uri) {
        Intent intent = new Intent(context, UserFeedbackWebActivity.class);
        intent.setData(uri);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tv.danmaku.bili.ui.webview.MWebActivity
    public void onCreate(Bundle savedInstanceState) {
        String url = H5UrlConfigHelper.INSTANCE.getUrl("core", "url_faq_feedback", USER_FEEDBACK_URL);
        getIntent().setData(Uri.parse(url));
        super.onCreate(savedInstanceState);
        setEnableBrowserMenu(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tv.danmaku.bili.ui.webview.MWebActivity
    public Map<String, JsBridgeCallHandlerFactoryV2> getExtraBuiltinJsBridgeCallHandlers() {
        Map<String, JsBridgeCallHandlerFactoryV2> map = super.getExtraBuiltinJsBridgeCallHandlers();
        map.put("main", new JsBridgeCallHandlerFeedback.JsBridgeCallHandlerFeedbackFactory(this));
        return map;
    }
}