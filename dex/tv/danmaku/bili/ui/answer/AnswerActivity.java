package tv.danmaku.bili.ui.answer;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.bilibili.droid.BundleUtil;
import com.bilibili.lib.tribe.core.internal.Hooks;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.webview.MWebAPActivity;

public class AnswerActivity extends MWebAPActivity {
    static final Uri ANSWER_URL = Uri.parse("https://account.bilibili.com/answer/landing");
    public static final String KEY_DYNAMIC_URL = "key_dynamic_url";
    public static final String KEY_DYNAMIC_URL_SPMID = "key_dynamic_url_spmid";
    public static final String KEY_SPMID = "spm_id";
    private static final String TAG = "AnswerActivity";

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    public static Intent createIntent(Context context) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setClass(context.getApplicationContext(), AnswerActivity.class);
        return intent;
    }

    protected void onCreate(Bundle savedInstanceState) {
        Uri uri = ANSWER_URL;
        String dynamicUrl = BundleUtil.getString(getIntent().getExtras(), KEY_DYNAMIC_URL, new String[0]);
        if (!TextUtils.isEmpty(dynamicUrl)) {
            uri = Uri.parse(dynamicUrl);
            String spmidValue = BundleUtil.getString(getIntent().getExtras(), KEY_DYNAMIC_URL_SPMID, new String[0]);
            if (!TextUtils.isEmpty(spmidValue)) {
                uri = uri.buildUpon().appendQueryParameter("spm_id", spmidValue).build();
            }
        }
        BLog.d(TAG, "AnswerActivity :" + uri.toString());
        getIntent().setData(uri);
        super.onCreate(savedInstanceState);
        setEnableOverflowMenu(false);
    }

    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        getToolbar().setNavigationOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.answer.AnswerActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                AnswerActivity.this.finish();
            }
        });
    }

    public void onBackPressed() {
        finish();
    }
}