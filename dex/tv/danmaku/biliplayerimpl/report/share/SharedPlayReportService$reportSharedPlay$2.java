package tv.danmaku.biliplayerimpl.report.share;

import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SharedPlayReportService.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "state", "Landroidx/lifecycle/Lifecycle$State;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.biliplayerimpl.report.share.SharedPlayReportService$reportSharedPlay$2", f = "SharedPlayReportService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class SharedPlayReportService$reportSharedPlay$2 extends SuspendLambda implements Function2<Lifecycle.State, Continuation<? super Boolean>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SharedPlayReportService$reportSharedPlay$2(Continuation<? super SharedPlayReportService$reportSharedPlay$2> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> sharedPlayReportService$reportSharedPlay$2 = new SharedPlayReportService$reportSharedPlay$2(continuation);
        sharedPlayReportService$reportSharedPlay$2.L$0 = obj;
        return sharedPlayReportService$reportSharedPlay$2;
    }

    public final Object invoke(Lifecycle.State state, Continuation<? super Boolean> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                Lifecycle.State state = (Lifecycle.State) this.L$0;
                return Boxing.boxBoolean(state.isAtLeast(Lifecycle.State.RESUMED));
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}