package im.session.track;

import im.base.IMLog;
import im.session.IMState;
import im.session.log.LogTagKt;
import kntr.base.neuron.KNeuron;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TechTracker.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lim/session/IMState;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.track.TechTrackerKt$bindTechTracker$1$4$1", f = "TechTracker.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class TechTrackerKt$bindTechTracker$1$4$1 extends SuspendLambda implements Function2<IMState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TechTrackerKt$bindTechTracker$1$4$1(Continuation<? super TechTrackerKt$bindTechTracker$1$4$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> techTrackerKt$bindTechTracker$1$4$1 = new TechTrackerKt$bindTechTracker$1$4$1(continuation);
        techTrackerKt$bindTechTracker$1$4$1.L$0 = obj;
        return techTrackerKt$bindTechTracker$1$4$1;
    }

    public final Object invoke(IMState iMState, Continuation<? super Unit> continuation) {
        return create(iMState, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        IMState it = (IMState) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                IMLog.Companion.i(LogTagKt.getTechTrackLogTag(), "Report Tech Track: " + it.getTechTrack$session_debug());
                KNeuron.INSTANCE.simpleTrackT("im.bff.session.load.time", it.getTechTrack$session_debug().buildReportMap());
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}