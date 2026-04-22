package video.biz.offline.list.logic.statemachine;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.list.logic.statemachine.DiagnosticState;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfflineDiagnosePageStore.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.list.logic.statemachine.DiagnosticState$Companion", f = "OfflineDiagnosePageStore.kt", i = {0, 1, 1}, l = {223, 234}, m = "from", n = {"entity", "entity", "validationCode"}, s = {"L$0", "L$0", "L$1"}, v = 1)
public final class DiagnosticState$Companion$from$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DiagnosticState.Companion this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiagnosticState$Companion$from$1(DiagnosticState.Companion companion, Continuation<? super DiagnosticState$Companion$from$1> continuation) {
        super(continuation);
        this.this$0 = companion;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.from(null, (Continuation) this);
    }
}