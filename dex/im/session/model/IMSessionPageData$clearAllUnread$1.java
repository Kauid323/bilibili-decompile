package im.session.model;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMSessionPageData.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.model.IMSessionPageData", f = "IMSessionPageData.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {172}, m = "clearAllUnread$session_debug", n = {"summaryService", "$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "it", "$i$f$map", "$i$f$mapTo", "$i$a$-map-IMSessionPageData$clearAllUnread$3"}, s = {"L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "I$0", "I$1", "I$2"}, v = 1)
public final class IMSessionPageData$clearAllUnread$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
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
    final /* synthetic */ IMSessionPageData this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMSessionPageData$clearAllUnread$1(IMSessionPageData iMSessionPageData, Continuation<? super IMSessionPageData$clearAllUnread$1> continuation) {
        super(continuation);
        this.this$0 = iMSessionPageData;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.clearAllUnread$session_debug(null, (Continuation) this);
    }
}