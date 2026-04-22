package kntr.common.photonic.permission;

import androidx.activity.result.ActivityResultLauncher;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.permission.AndroidPermissionStatus;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PermissionState.android.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0017\u001a\u00020\u0018H\u0016J!\u0010!\u001a\u00020\u00182\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00100#H\u0000¢\u0006\u0002\b$R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR!\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\f\u0010\nR\u001b\u0010\u000f\u001a\u00020\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0014\u001a\u00020\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0015\u0010\u0012R(\u0010\u0019\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001b\u0018\u00010\u001aX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006%"}, d2 = {"Lkntr/common/photonic/permission/MutableMultiplePermissionState;", "Lkntr/common/photonic/permission/MultiplePermissionState;", "mutablePermissions", "", "Lkntr/common/photonic/permission/MutablePermissionState;", "<init>", "(Ljava/util/List;)V", "permissions", "Lkntr/common/photonic/permission/PermissionState;", "getPermissions", "()Ljava/util/List;", "revokedPermissions", "getRevokedPermissions", "revokedPermissions$delegate", "Landroidx/compose/runtime/State;", "allPermissionsGranted", "", "getAllPermissionsGranted", "()Z", "allPermissionsGranted$delegate", "shouldShowRationale", "getShouldShowRationale", "shouldShowRationale$delegate", "launchMultiplePermissionRequest", "", "launcher", "Landroidx/activity/result/ActivityResultLauncher;", "", "", "getLauncher$permission_debug", "()Landroidx/activity/result/ActivityResultLauncher;", "setLauncher$permission_debug", "(Landroidx/activity/result/ActivityResultLauncher;)V", "updatePermissionsStatus", "permissionsStatus", "", "updatePermissionsStatus$permission_debug", "permission_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class MutableMultiplePermissionState implements MultiplePermissionState {
    public static final int $stable = 0;
    private final State allPermissionsGranted$delegate;
    private ActivityResultLauncher<String[]> launcher;
    private final List<MutablePermissionState> mutablePermissions;
    private final List<PermissionState> permissions;
    private final State revokedPermissions$delegate;
    private final State shouldShowRationale$delegate;

    public MutableMultiplePermissionState(List<MutablePermissionState> list) {
        Intrinsics.checkNotNullParameter(list, "mutablePermissions");
        this.mutablePermissions = list;
        this.permissions = this.mutablePermissions;
        this.revokedPermissions$delegate = SnapshotStateKt.derivedStateOf(new Function0() { // from class: kntr.common.photonic.permission.MutableMultiplePermissionState$$ExternalSyntheticLambda0
            public final Object invoke() {
                List revokedPermissions_delegate$lambda$0;
                revokedPermissions_delegate$lambda$0 = MutableMultiplePermissionState.revokedPermissions_delegate$lambda$0(MutableMultiplePermissionState.this);
                return revokedPermissions_delegate$lambda$0;
            }
        });
        this.allPermissionsGranted$delegate = SnapshotStateKt.derivedStateOf(new Function0() { // from class: kntr.common.photonic.permission.MutableMultiplePermissionState$$ExternalSyntheticLambda1
            public final Object invoke() {
                boolean allPermissionsGranted_delegate$lambda$0;
                allPermissionsGranted_delegate$lambda$0 = MutableMultiplePermissionState.allPermissionsGranted_delegate$lambda$0(MutableMultiplePermissionState.this);
                return Boolean.valueOf(allPermissionsGranted_delegate$lambda$0);
            }
        });
        this.shouldShowRationale$delegate = SnapshotStateKt.derivedStateOf(new Function0() { // from class: kntr.common.photonic.permission.MutableMultiplePermissionState$$ExternalSyntheticLambda2
            public final Object invoke() {
                boolean shouldShowRationale_delegate$lambda$0;
                shouldShowRationale_delegate$lambda$0 = MutableMultiplePermissionState.shouldShowRationale_delegate$lambda$0(MutableMultiplePermissionState.this);
                return Boolean.valueOf(shouldShowRationale_delegate$lambda$0);
            }
        });
    }

    @Override // kntr.common.photonic.permission.MultiplePermissionState
    public List<PermissionState> getPermissions() {
        return this.permissions;
    }

    @Override // kntr.common.photonic.permission.MultiplePermissionState
    public List<PermissionState> getRevokedPermissions() {
        State $this$getValue$iv = this.revokedPermissions$delegate;
        return (List) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List revokedPermissions_delegate$lambda$0(MutableMultiplePermissionState this$0) {
        Iterable $this$filter$iv = this$0.getPermissions();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            PermissionState it = (PermissionState) element$iv$iv;
            if (!Intrinsics.areEqual(it.getStatus(), AndroidPermissionStatus.Granted.INSTANCE)) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        return (List) destination$iv$iv;
    }

    @Override // kntr.common.photonic.permission.MultiplePermissionState
    public boolean getAllPermissionsGranted() {
        State $this$getValue$iv = this.allPermissionsGranted$delegate;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean allPermissionsGranted_delegate$lambda$0(MutableMultiplePermissionState this$0) {
        Iterable $this$all$iv;
        Iterable $this$all$iv2 = this$0.getPermissions();
        if (!($this$all$iv2 instanceof Collection) || !((Collection) $this$all$iv2).isEmpty()) {
            Iterator<T> it = $this$all$iv2.iterator();
            while (true) {
                if (it.hasNext()) {
                    Object element$iv = it.next();
                    PermissionState it2 = (PermissionState) element$iv;
                    if (!PermissionState_androidKt.isGranted(it2.getStatus())) {
                        $this$all$iv = null;
                        break;
                    }
                } else {
                    $this$all$iv = 1;
                    break;
                }
            }
        } else {
            $this$all$iv = 1;
        }
        return $this$all$iv != null || this$0.getRevokedPermissions().isEmpty();
    }

    @Override // kntr.common.photonic.permission.MultiplePermissionState
    public boolean getShouldShowRationale() {
        State $this$getValue$iv = this.shouldShowRationale$delegate;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean shouldShowRationale_delegate$lambda$0(MutableMultiplePermissionState this$0) {
        Iterable $this$any$iv;
        Iterable $this$none$iv;
        PermissionState it;
        Iterable $this$any$iv2 = this$0.getPermissions();
        if (!($this$any$iv2 instanceof Collection) || !((Collection) $this$any$iv2).isEmpty()) {
            Iterator<T> it2 = $this$any$iv2.iterator();
            while (true) {
                if (it2.hasNext()) {
                    Object element$iv = it2.next();
                    if (PermissionState_androidKt.getShouldShowRationale(((PermissionState) element$iv).getStatus())) {
                        $this$any$iv = 1;
                        break;
                    }
                } else {
                    $this$any$iv = null;
                    break;
                }
            }
        } else {
            $this$any$iv = null;
        }
        if ($this$any$iv != null) {
            Iterable $this$none$iv2 = this$0.getPermissions();
            if (!($this$none$iv2 instanceof Collection) || !((Collection) $this$none$iv2).isEmpty()) {
                Iterator<T> it3 = $this$none$iv2.iterator();
                while (true) {
                    if (it3.hasNext()) {
                        Object element$iv2 = it3.next();
                        PermissionState it4 = (PermissionState) element$iv2;
                        if (PermissionState_androidKt.isGranted(it4.getStatus()) || PermissionState_androidKt.getShouldShowRationale(it4.getStatus())) {
                            it = null;
                            continue;
                        } else {
                            it = 1;
                            continue;
                        }
                        if (it != null) {
                            $this$none$iv = null;
                            break;
                        }
                    } else {
                        $this$none$iv = 1;
                        break;
                    }
                }
            } else {
                $this$none$iv = 1;
            }
            if ($this$none$iv != null) {
                return true;
            }
        }
        return false;
    }

    @Override // kntr.common.photonic.permission.MultiplePermissionState
    public void launchMultiplePermissionRequest() {
        ActivityResultLauncher<String[]> activityResultLauncher = this.launcher;
        if (activityResultLauncher != null) {
            Iterable $this$map$iv = getPermissions();
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                PermissionState it = (PermissionState) item$iv$iv;
                destination$iv$iv.add(it.getPermission());
            }
            Collection $this$toTypedArray$iv = (List) destination$iv$iv;
            activityResultLauncher.launch($this$toTypedArray$iv.toArray(new String[0]));
            return;
        }
        throw new IllegalStateException("ActivityResultLauncher cannot be null");
    }

    public final ActivityResultLauncher<String[]> getLauncher$permission_debug() {
        return this.launcher;
    }

    public final void setLauncher$permission_debug(ActivityResultLauncher<String[]> activityResultLauncher) {
        this.launcher = activityResultLauncher;
    }

    public final void updatePermissionsStatus$permission_debug(Map<String, Boolean> map) {
        Object element$iv;
        Boolean bool;
        Intrinsics.checkNotNullParameter(map, "permissionsStatus");
        for (String permission : map.keySet()) {
            Iterable $this$firstOrNull$iv = this.mutablePermissions;
            Iterator<T> it = $this$firstOrNull$iv.iterator();
            while (true) {
                if (!it.hasNext()) {
                    element$iv = null;
                    break;
                }
                element$iv = it.next();
                MutablePermissionState it2 = (MutablePermissionState) element$iv;
                if (Intrinsics.areEqual(it2.getPermission(), permission)) {
                    break;
                }
            }
            MutablePermissionState $this$updatePermissionsStatus_u24lambda_u241 = (MutablePermissionState) element$iv;
            if ($this$updatePermissionsStatus_u24lambda_u241 != null && (bool = map.get(permission)) != null) {
                bool.booleanValue();
                $this$updatePermissionsStatus_u24lambda_u241.refreshPermissionStatus$permission_debug();
            }
        }
    }
}