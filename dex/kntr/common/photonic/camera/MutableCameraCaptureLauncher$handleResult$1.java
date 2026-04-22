package kntr.common.photonic.camera;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RequestCamera.android.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.photonic.camera.MutableCameraCaptureLauncher", f = "RequestCamera.android.kt", i = {0, 0, 0, 0}, l = {83}, m = "handleResult", n = {"resultUri", "it", "success", "$i$a$-let-MutableCameraCaptureLauncher$handleResult$asset$1"}, s = {"L$0", "L$1", "Z$0", "I$0"}, v = 1)
public final class MutableCameraCaptureLauncher$handleResult$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MutableCameraCaptureLauncher this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MutableCameraCaptureLauncher$handleResult$1(MutableCameraCaptureLauncher mutableCameraCaptureLauncher, Continuation<? super MutableCameraCaptureLauncher$handleResult$1> continuation) {
        super(continuation);
        this.this$0 = mutableCameraCaptureLauncher;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.handleResult(false, (Continuation) this);
    }
}