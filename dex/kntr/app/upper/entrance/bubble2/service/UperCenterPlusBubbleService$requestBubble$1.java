package kntr.app.upper.entrance.bubble2.service;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UperCenterPlusBubbleService.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.upper.entrance.bubble2.service.UperCenterPlusBubbleService", f = "UperCenterPlusBubbleService.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {170, 171}, m = "requestBubble$entrance_debug", n = {"mid", "now", "bubbleCache", "bubble", "localInfo", "url", "$this$get_u24default$iv", "url$iv", "$this$get$iv$iv", "$this$get$iv$iv$iv", "builder$iv$iv$iv", "$this$request$iv$iv$iv$iv", "zeroTs", "$i$f$get", "$i$f$get", "$i$f$get", "$i$f$request", "mid", "now", "bubbleCache", "bubble", "localInfo", "url", "httpResponse", "$this$body$iv", "zeroTs", "$i$f$body"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "J$0", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "J$0", "I$0"}, v = 1)
public final class UperCenterPlusBubbleService$requestBubble$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$10;
    Object L$11;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UperCenterPlusBubbleService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UperCenterPlusBubbleService$requestBubble$1(UperCenterPlusBubbleService uperCenterPlusBubbleService, Continuation<? super UperCenterPlusBubbleService$requestBubble$1> continuation) {
        super(continuation);
        this.this$0 = uperCenterPlusBubbleService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.requestBubble$entrance_debug(null, (Continuation) this);
    }
}