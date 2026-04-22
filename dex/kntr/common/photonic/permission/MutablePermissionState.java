package kntr.common.photonic.permission;

import android.app.Activity;
import android.content.Context;
import androidx.activity.result.ActivityResultLauncher;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.permission.AndroidPermissionStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PermissionState.android.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u001b\u001a\u00020\u001cH\u0016J\r\u0010\u001d\u001a\u00020\u001cH\u0000¢\u0006\u0002\b\u001eJ\b\u0010\u001f\u001a\u00020\u0013H\u0002R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R+\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00138V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006 "}, d2 = {"Lkntr/common/photonic/permission/MutablePermissionState;", "Lkntr/common/photonic/permission/PermissionState;", "permission", "", "context", "Landroid/content/Context;", "activity", "Landroid/app/Activity;", "<init>", "(Ljava/lang/String;Landroid/content/Context;Landroid/app/Activity;)V", "getPermission", "()Ljava/lang/String;", "launcher", "Landroidx/activity/result/ActivityResultLauncher;", "getLauncher$permission_debug", "()Landroidx/activity/result/ActivityResultLauncher;", "setLauncher$permission_debug", "(Landroidx/activity/result/ActivityResultLauncher;)V", "<set-?>", "Lkntr/common/photonic/permission/AndroidPermissionStatus;", "status", "getStatus", "()Lkntr/common/photonic/permission/AndroidPermissionStatus;", "setStatus", "(Lkntr/common/photonic/permission/AndroidPermissionStatus;)V", "status$delegate", "Landroidx/compose/runtime/MutableState;", "launchPermissionRequest", "", "refreshPermissionStatus", "refreshPermissionStatus$permission_debug", "getPermissionStatus", "permission_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class MutablePermissionState implements PermissionState {
    public static final int $stable = 0;
    private final Activity activity;
    private final Context context;
    private ActivityResultLauncher<String> launcher;
    private final String permission;
    private final MutableState status$delegate;

    public MutablePermissionState(String permission, Context context, Activity activity) {
        Intrinsics.checkNotNullParameter(permission, "permission");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.permission = permission;
        this.context = context;
        this.activity = activity;
        this.status$delegate = SnapshotStateKt.mutableStateOf$default(getPermissionStatus(), (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    @Override // kntr.common.photonic.permission.PermissionState
    public String getPermission() {
        return this.permission;
    }

    public final ActivityResultLauncher<String> getLauncher$permission_debug() {
        return this.launcher;
    }

    public final void setLauncher$permission_debug(ActivityResultLauncher<String> activityResultLauncher) {
        this.launcher = activityResultLauncher;
    }

    @Override // kntr.common.photonic.permission.PermissionState
    public AndroidPermissionStatus getStatus() {
        State $this$getValue$iv = this.status$delegate;
        return (AndroidPermissionStatus) $this$getValue$iv.getValue();
    }

    public void setStatus(AndroidPermissionStatus androidPermissionStatus) {
        Intrinsics.checkNotNullParameter(androidPermissionStatus, "<set-?>");
        MutableState $this$setValue$iv = this.status$delegate;
        $this$setValue$iv.setValue(androidPermissionStatus);
    }

    @Override // kntr.common.photonic.permission.PermissionState
    public void launchPermissionRequest() {
        ActivityResultLauncher<String> activityResultLauncher = this.launcher;
        if (activityResultLauncher != null) {
            activityResultLauncher.launch(getPermission());
            return;
        }
        throw new IllegalStateException("ActivityResultLauncher cannot be null");
    }

    public final void refreshPermissionStatus$permission_debug() {
        setStatus(getPermissionStatus());
    }

    private final AndroidPermissionStatus getPermissionStatus() {
        boolean hasPermission;
        boolean shouldShowRationale;
        hasPermission = PermissionState_androidKt.checkPermission(this.context, getPermission());
        if (!hasPermission) {
            shouldShowRationale = PermissionState_androidKt.shouldShowRationale(this.activity, getPermission());
            return new AndroidPermissionStatus.Denied(shouldShowRationale);
        }
        return AndroidPermissionStatus.Granted.INSTANCE;
    }
}