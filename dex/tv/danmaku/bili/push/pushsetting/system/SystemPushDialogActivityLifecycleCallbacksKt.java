package tv.danmaku.bili.push.pushsetting.system;

import android.app.Application;
import android.os.Build;
import androidx.appcompat.app.AppCompatActivity;
import com.bilibili.lib.blconfig.ConfigManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: SystemPushDialogActivityLifecycleCallbacks.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\"\u001b\u0010\u0004\u001a\u00020\u00058@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007\"\u0018\u0010\n\u001a\u00020\u0005*\u00020\u000b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"initSystemPushDialogActivityListener", "", "application", "Landroid/app/Application;", "enableSystemPushDialogListener", "", "getEnableSystemPushDialogListener", "()Z", "enableSystemPushDialogListener$delegate", "Lkotlin/Lazy;", "shouldShowRequestNotificationPermission", "Landroidx/appcompat/app/AppCompatActivity;", "getShouldShowRequestNotificationPermission", "(Landroidx/appcompat/app/AppCompatActivity;)Z", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SystemPushDialogActivityLifecycleCallbacksKt {
    private static final Lazy enableSystemPushDialogListener$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.push.pushsetting.system.SystemPushDialogActivityLifecycleCallbacksKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            boolean enableSystemPushDialogListener_delegate$lambda$0;
            enableSystemPushDialogListener_delegate$lambda$0 = SystemPushDialogActivityLifecycleCallbacksKt.enableSystemPushDialogListener_delegate$lambda$0();
            return Boolean.valueOf(enableSystemPushDialogListener_delegate$lambda$0);
        }
    });

    public static final void initSystemPushDialogActivityListener(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        if (getEnableSystemPushDialogListener()) {
            application.registerActivityLifecycleCallbacks(new SystemPushDialogActivityLifecycleCallbacks());
        }
    }

    public static final boolean getEnableSystemPushDialogListener() {
        return ((Boolean) enableSystemPushDialogListener$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean enableSystemPushDialogListener_delegate$lambda$0() {
        return ConfigManager.Companion.isHitFF("ff_enable_system_push_dialog_listener");
    }

    public static final boolean getShouldShowRequestNotificationPermission(AppCompatActivity $this$shouldShowRequestNotificationPermission) {
        Intrinsics.checkNotNullParameter($this$shouldShowRequestNotificationPermission, "<this>");
        if (Build.VERSION.SDK_INT < 33) {
            return false;
        }
        return $this$shouldShowRequestNotificationPermission.shouldShowRequestPermissionRationale("android.permission.POST_NOTIFICATIONS");
    }
}