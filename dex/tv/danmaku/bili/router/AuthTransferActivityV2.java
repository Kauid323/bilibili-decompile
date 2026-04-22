package tv.danmaku.bili.router;

import android.content.Context;
import android.os.Bundle;
import com.bilibili.droid.H5UrlConfigHelper;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.blrouter.RouteRequestKt;
import com.bilibili.lib.spy.generated.android_app_Activity;
import com.bilibili.lib.tribe.core.internal.Hooks;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.utils.AliAppUtil;

/* compiled from: AuthTransferActivityV2.kt */
@Deprecated(message = "use BiliAuthTransferActivity instead")
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\b\u0010\b\u001a\u00020\u0005H\u0002¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/router/AuthTransferActivityV2;", "Landroid/app/Activity;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "requestAuth", "Companion", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AuthTransferActivityV2 extends android_app_Activity {
    private static final String AUTH_IDENTIFY_DEFAULT = "https://www.bilibili.com/h5/identify/submit";
    private static final String AUTH_IDENTIFY_HOME = "https://www.bilibili.com/h5/identify/home";
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "AuthTransferActivityV2";

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestAuth();
        finish();
    }

    private final void requestAuth() {
        String authUrl;
        if (AliAppUtil.hasApplication()) {
            authUrl = H5UrlConfigHelper.INSTANCE.getUrl("auth", "url_auth_identify_home", "https://www.bilibili.com/h5/identify/home");
        } else {
            authUrl = H5UrlConfigHelper.INSTANCE.getUrl("auth", "url_auth_identify_default", "https://www.bilibili.com/h5/identify/submit");
        }
        BLog.d(TAG, "requestAuth url = " + authUrl);
        Intrinsics.checkNotNull(authUrl);
        RouteRequest request = RouteRequestKt.toRouteRequest(authUrl).newBuilder().build();
        BLRouter.routeTo(request, (Context) this);
    }

    /* compiled from: AuthTransferActivityV2.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/router/AuthTransferActivityV2$Companion;", "", "<init>", "()V", "TAG", "", "AUTH_IDENTIFY_HOME", "AUTH_IDENTIFY_DEFAULT", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}