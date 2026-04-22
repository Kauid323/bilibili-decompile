package kntr.base.dd.impl.internal.container;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.upper.trace.config.AppKey;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DDContainer.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.base.dd.impl.internal.container.DDContainer", f = "DDContainer.kt", i = {0, 0, 0}, l = {171}, m = "update", n = {"from", AppKey.VERSION, "env"}, s = {"L$0", "L$1", "L$2"}, v = 1)
public final class DDContainer$update$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DDContainer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DDContainer$update$1(DDContainer dDContainer, Continuation<? super DDContainer$update$1> continuation) {
        super(continuation);
        this.this$0 = dDContainer;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.update(null, null, null, (Continuation) this);
    }
}