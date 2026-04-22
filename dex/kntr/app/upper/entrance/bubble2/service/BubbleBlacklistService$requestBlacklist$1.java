package kntr.app.upper.entrance.bubble2.service;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BubbleBlacklistService.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.upper.entrance.bubble2.service.BubbleBlacklistService", f = "BubbleBlacklistService.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {88, 89}, m = "requestBlacklist", n = {"mid", "url", "$this$get_u24default$iv", "url$iv", "$this$get$iv$iv", "$this$get$iv$iv$iv", "builder$iv$iv$iv", "$this$request$iv$iv$iv$iv", "$i$f$get", "$i$f$get", "$i$f$get", "$i$f$request", "mid", "url", "httpResponse", "$this$body$iv", "$i$f$body"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
public final class BubbleBlacklistService$requestBlacklist$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BubbleBlacklistService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BubbleBlacklistService$requestBlacklist$1(BubbleBlacklistService bubbleBlacklistService, Continuation<? super BubbleBlacklistService$requestBlacklist$1> continuation) {
        super(continuation);
        this.this$0 = bubbleBlacklistService;
    }

    public final Object invokeSuspend(Object obj) {
        Object requestBlacklist;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        requestBlacklist = this.this$0.requestBlacklist(null, (Continuation) this);
        return requestBlacklist;
    }
}