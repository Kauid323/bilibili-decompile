package kntr.app.upper.entrance.bubble2.service;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BubbleBlacklistService.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.upper.entrance.bubble2.service.BubbleBlacklistService", f = "BubbleBlacklistService.kt", i = {0, 0, 0}, l = {33}, m = "checkInBlacklist", n = {"mid", "resourceId", "$i$a$-runCatching-BubbleBlacklistService$checkInBlacklist$2"}, s = {"L$0", "L$1", "I$0"}, v = 1)
public final class BubbleBlacklistService$checkInBlacklist$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BubbleBlacklistService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BubbleBlacklistService$checkInBlacklist$1(BubbleBlacklistService bubbleBlacklistService, Continuation<? super BubbleBlacklistService$checkInBlacklist$1> continuation) {
        super(continuation);
        this.this$0 = bubbleBlacklistService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.checkInBlacklist(null, null, (Continuation) this);
    }
}