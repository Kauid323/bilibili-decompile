package kntr.common.photonic.permission;

import androidx.compose.runtime.State;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: PermissionState.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u000b\u001a\u00020\bH¦@¢\u0006\u0002\u0010\fJ\u000e\u0010\r\u001a\u00020\u000eH¦@¢\u0006\u0002\u0010\fR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lkntr/common/photonic/permission/BPermissionState;", "", "permissionType", "Lkntr/common/photonic/permission/BPermissionType;", "getPermissionType", "()Lkntr/common/photonic/permission/BPermissionType;", "currentStatus", "Landroidx/compose/runtime/State;", "Lkntr/common/photonic/permission/PermissionStatus;", "getCurrentStatus", "()Landroidx/compose/runtime/State;", "requestAuthorization", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestMoreAssets", "", "permission_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface BPermissionState {
    State<PermissionStatus> getCurrentStatus();

    BPermissionType getPermissionType();

    Object requestAuthorization(Continuation<? super PermissionStatus> continuation);

    Object requestMoreAssets(Continuation<? super Unit> continuation);
}