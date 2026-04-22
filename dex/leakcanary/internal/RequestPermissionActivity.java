package leakcanary.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;
import com.bilibili.infra.base.aop.PendingIntentCreateHook;
import com.bilibili.lib.spy.generated.android_app_Activity;
import com.bilibili.lib.tribe.core.internal.Hooks;
import com.squareup.leakcanary.core.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RequestPermissionActivity.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\b\u0001\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0002J\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J+\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016¢\u0006\u0002\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, d2 = {"Lleakcanary/internal/RequestPermissionActivity;", "Landroid/app/Activity;", "()V", RequestPermissionActivity.TARGET_PERMISSION_EXTRA, "", "getTargetPermission", "()Ljava/lang/String;", "finish", "", "hasTargetPermission", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onRequestPermissionsResult", "requestCode", "", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "Companion", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
public final class RequestPermissionActivity extends android_app_Activity {
    public static final Companion Companion = new Companion(null);
    private static final String TARGET_PERMISSION_EXTRA = "targetPermission";

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    /* compiled from: RequestPermissionActivity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lleakcanary/internal/RequestPermissionActivity$Companion;", "", "()V", "TARGET_PERMISSION_EXTRA", "", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "permission", "createPendingIntent", "Landroid/app/PendingIntent;", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        private static PendingIntent __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getActivity(Context context, int requestCode, Intent intent, int flags) {
            PendingIntentCreateHook.setPackageIfAbsent(context, intent, flags);
            if (Build.VERSION.SDK_INT >= 30) {
                try {
                    return PendingIntent.getActivity(context, Integer.valueOf(requestCode).intValue(), intent, Integer.valueOf(flags).intValue());
                } catch (IllegalArgumentException e) {
                    return PendingIntent.getActivity(context, Integer.valueOf(requestCode).intValue(), intent, Integer.valueOf(33554432 | flags).intValue());
                }
            }
            return PendingIntent.getActivity(context, Integer.valueOf(requestCode).intValue(), intent, Integer.valueOf(flags).intValue());
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        public final Intent createIntent(Context context, String permission) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            Intrinsics.checkParameterIsNotNull(permission, "permission");
            Intent $this$apply = new Intent(context, RequestPermissionActivity.class);
            $this$apply.setFlags(335544320);
            $this$apply.putExtra(RequestPermissionActivity.TARGET_PERMISSION_EXTRA, permission);
            return $this$apply;
        }

        public final PendingIntent createPendingIntent(Context context, String permission) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            Intrinsics.checkParameterIsNotNull(permission, "permission");
            Intent intent = createIntent(context, permission);
            PendingIntent __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getActivity = __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getActivity(context, 1, intent, 201326592);
            Intrinsics.checkExpressionValueIsNotNull(__Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getActivity, "PendingIntent.getActivit…ontext, 1, intent, flags)");
            return __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getActivity;
        }
    }

    private final String getTargetPermission() {
        String stringExtra = getIntent().getStringExtra(TARGET_PERMISSION_EXTRA);
        if (stringExtra == null) {
            Intrinsics.throwNpe();
        }
        return stringExtra;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            if (hasTargetPermission()) {
                finish();
                return;
            }
            String[] permissions = {getTargetPermission()};
            requestPermissions(permissions, 42);
        }
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Intrinsics.checkParameterIsNotNull(permissions, "permissions");
        Intrinsics.checkParameterIsNotNull(grantResults, "grantResults");
        if (!hasTargetPermission()) {
            Toast.makeText(getApplication(), R.string.leak_canary_permission_not_granted, 1).show();
        }
        finish();
    }

    public void finish() {
        overridePendingTransition(0, 0);
        super.finish();
    }

    private final boolean hasTargetPermission() {
        return checkSelfPermission(getTargetPermission()) == 0;
    }
}