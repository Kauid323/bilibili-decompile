package kntr.common.photonic.camera;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* compiled from: RequestCamera.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0004¨\u0006\u0005À\u0006\u0003"}, d2 = {"Lkntr/common/photonic/camera/CameraCaptureLauncher;", "", "launch", "Lkntr/common/photonic/camera/CameraCaptureResultStatus;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "camera_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface CameraCaptureLauncher {
    Object launch(Continuation<? super CameraCaptureResultStatus> continuation);
}