package tv.danmaku.bili.moss;

import android.content.Context;
import android.os.Bundle;
import com.bilibili.lib.basecomponent.R;
import com.bilibili.lib.tribe.core.internal.Hooks;
import com.bilibili.lib.ui.BaseToolbarActivity;

public class MossConfigActivity extends BaseToolbarActivity {
    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bili_app_activity_with_toolbar);
        showBackButton();
        if (savedInstanceState == null) {
            MossConfigFragment mossConfigFragment = new MossConfigFragment();
            Bundle b = new Bundle();
            mossConfigFragment.setArguments(b);
            getSupportFragmentManager().beginTransaction().add(tv.danmaku.bili.R.id.content_layout, mossConfigFragment).commit();
        }
    }
}