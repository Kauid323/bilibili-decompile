package kntr.common.photonic.permission;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: PermissionState.android.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\ba\u0018\u00002\u00020\u0001J\b\u0010\n\u001a\u00020\u000bH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lkntr/common/photonic/permission/PermissionState;", "", "permission", "", "getPermission", "()Ljava/lang/String;", "status", "Lkntr/common/photonic/permission/AndroidPermissionStatus;", "getStatus", "()Lkntr/common/photonic/permission/AndroidPermissionStatus;", "launchPermissionRequest", "", "permission_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface PermissionState {
    String getPermission();

    AndroidPermissionStatus getStatus();

    void launchPermissionRequest();
}