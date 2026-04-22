package tv.danmaku.bili.mod;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bilibili.lib.basecomponent.R;
import com.bilibili.lib.tribe.core.internal.Hooks;
import com.bilibili.lib.ui.BaseToolbarActivity;
import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: ModLocalInfoActivity.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/mod/ModLocalInfoActivity;", "Lcom/bilibili/lib/ui/BaseToolbarActivity;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ModLocalInfoActivity extends BaseToolbarActivity {
    public static final int $stable = 8;

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
            Fragment modLocalInfoFragment = new ModLocalInfoFragment();
            Bundle b = new Bundle();
            modLocalInfoFragment.setArguments(b);
            getSupportFragmentManager().beginTransaction().add(tv.danmaku.bili.R.id.content_layout, modLocalInfoFragment).commit();
        }
    }
}