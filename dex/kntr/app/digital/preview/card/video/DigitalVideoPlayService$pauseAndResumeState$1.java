package kntr.app.digital.preview.card.video;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DigitalVideoPlayService.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.digital.preview.card.video.DigitalVideoPlayService", f = "DigitalVideoPlayService.kt", i = {0}, l = {82}, m = "pauseAndResumeState", n = {"action"}, s = {"L$0"}, v = 1)
public final class DigitalVideoPlayService$pauseAndResumeState$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DigitalVideoPlayService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DigitalVideoPlayService$pauseAndResumeState$1(DigitalVideoPlayService digitalVideoPlayService, Continuation<? super DigitalVideoPlayService$pauseAndResumeState$1> continuation) {
        super(continuation);
        this.this$0 = digitalVideoPlayService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.pauseAndResumeState(null, (Continuation) this);
    }
}