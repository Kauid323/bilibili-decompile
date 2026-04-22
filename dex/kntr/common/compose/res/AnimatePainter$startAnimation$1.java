package kntr.common.compose.res;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RefreshAnimatePainter.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.compose.res.AnimatePainter", f = "RefreshAnimatePainter.kt", i = {}, l = {61}, m = "startAnimation", n = {}, s = {}, v = 1)
public final class AnimatePainter$startAnimation$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AnimatePainter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnimatePainter$startAnimation$1(AnimatePainter animatePainter, Continuation<? super AnimatePainter$startAnimation$1> continuation) {
        super(continuation);
        this.this$0 = animatePainter;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.startAnimation((Continuation) this);
    }
}