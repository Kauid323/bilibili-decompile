package tv.danmaku.bili.ui.account;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.bilibili.droid.H5UrlConfigHelper;
import com.bilibili.lib.tribe.core.internal.Hooks;
import kotlin.Metadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.services.AccountServiceImplKt;
import tv.danmaku.bili.ui.webview.MWebAPActivity;

/* compiled from: BindPhoneActivity.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/ui/account/BindPhoneActivity;", "Ltv/danmaku/bili/ui/webview/MWebAPActivity;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BindPhoneActivity extends MWebAPActivity {
    public static final int $stable = 8;

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    protected void onCreate(Bundle savedInstanceState) {
        String url = H5UrlConfigHelper.INSTANCE.getUrl("core", "url_bind_phone", AccountServiceImplKt.BIND_PHONE_URI);
        Intent intent = getIntent();
        if (intent != null) {
            intent.setData(Uri.parse(url));
        }
        super.onCreate(savedInstanceState);
    }
}