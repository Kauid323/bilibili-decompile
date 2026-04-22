package kntr.app.upper.entrance.bubble2.service;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BubbleCouponService.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.upper.entrance.bubble2.service.BubbleCouponService", f = "BubbleCouponService.kt", i = {0, 0, 0}, l = {34}, m = "checkCouponValid", n = {"bubbleType", "mid", "$i$a$-runCatching-BubbleCouponService$checkCouponValid$2"}, s = {"L$0", "L$1", "I$0"}, v = 1)
public final class BubbleCouponService$checkCouponValid$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BubbleCouponService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BubbleCouponService$checkCouponValid$1(BubbleCouponService bubbleCouponService, Continuation<? super BubbleCouponService$checkCouponValid$1> continuation) {
        super(continuation);
        this.this$0 = bubbleCouponService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.checkCouponValid(null, null, (Continuation) this);
    }
}