package kntr.common.photonic.permission;

import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: PermissionState.android.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\ba\u0018\u00002\u00020\u0001J\b\u0010\u000f\u001a\u00020\u0010H&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0012\u0010\t\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0012\u0010\r\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\f¨\u0006\u0011À\u0006\u0003"}, d2 = {"Lkntr/common/photonic/permission/MultiplePermissionState;", "", "permissions", "", "Lkntr/common/photonic/permission/PermissionState;", "getPermissions", "()Ljava/util/List;", "revokedPermissions", "getRevokedPermissions", "allPermissionsGranted", "", "getAllPermissionsGranted", "()Z", "shouldShowRationale", "getShouldShowRationale", "launchMultiplePermissionRequest", "", "permission_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface MultiplePermissionState {
    boolean getAllPermissionsGranted();

    List<PermissionState> getPermissions();

    List<PermissionState> getRevokedPermissions();

    boolean getShouldShowRationale();

    void launchMultiplePermissionRequest();
}