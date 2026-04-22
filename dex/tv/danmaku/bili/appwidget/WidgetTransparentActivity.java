package tv.danmaku.bili.appwidget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.bilibili.lib.tribe.core.internal.Hooks;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.router.ChannelRoutes;

/* compiled from: WidgetTransparentActivity.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0014J\u0014\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002¨\u0006\u000f"}, d2 = {"Ltv/danmaku/bili/appwidget/WidgetTransparentActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "Landroid/content/Intent;", "getAppWidgetRouter", "Ltv/danmaku/bili/appwidget/IAppWidgetRouter;", ChannelRoutes.CHANNEL_NAME, "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class WidgetTransparentActivity extends AppCompatActivity {
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
        finish();
        IAppWidgetRouter appWidgetRouter = getAppWidgetRouter(getIntent().getStringExtra(WidgetTransparentActivityKt.APP_WIDGET_BUSINESS_CLASS_NAME));
        if (appWidgetRouter != null) {
            Intent intent = getIntent();
            Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
            appWidgetRouter.handleOnCreate((Activity) this, intent);
        }
    }

    protected void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        IAppWidgetRouter appWidgetRouter = getAppWidgetRouter(intent.getStringExtra(WidgetTransparentActivityKt.APP_WIDGET_BUSINESS_CLASS_NAME));
        if (appWidgetRouter != null) {
            appWidgetRouter.handleNewIntent((Activity) this, intent);
        }
        super.onNewIntent(intent);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0013 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0014 A[Catch: Exception -> 0x0024, TryCatch #0 {Exception -> 0x0024, blocks: (B:3:0x0002, B:5:0x0007, B:12:0x0014, B:14:0x0020), top: B:19:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final IAppWidgetRouter getAppWidgetRouter(String name) {
        boolean z;
        try {
            String str = name;
            if (str != null && !StringsKt.isBlank(str)) {
                z = false;
                if (!z) {
                    return null;
                }
                Object newInstance = Class.forName(name).newInstance();
                if (newInstance instanceof IAppWidgetRouter) {
                    return (IAppWidgetRouter) newInstance;
                }
                return null;
            }
            z = true;
            if (!z) {
            }
        } catch (Exception e) {
            BLog.e("WidgetTransparentActivity", "get app widget router error name:" + name, e);
            return null;
        }
    }
}