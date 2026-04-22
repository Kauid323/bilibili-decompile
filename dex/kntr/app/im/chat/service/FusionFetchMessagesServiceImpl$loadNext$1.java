package kntr.app.im.chat.service;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FusionFetchMessagesServiceImpl.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.service.FusionFetchMessagesServiceImpl", f = "FusionFetchMessagesServiceImpl.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {425, 430}, m = "loadNext", n = {"state", "policy", "currentRange", "beginSequenceNumber", "state", "policy", "currentRange", "it", "beginSequenceNumber", "$i$a$-fold-FusionFetchMessagesServiceImpl$loadNext$2"}, s = {"L$0", "L$1", "L$2", "J$0", "L$0", "L$1", "L$2", "L$3", "J$0", "I$0"}, v = 1)
public final class FusionFetchMessagesServiceImpl$loadNext$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FusionFetchMessagesServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FusionFetchMessagesServiceImpl$loadNext$1(FusionFetchMessagesServiceImpl fusionFetchMessagesServiceImpl, Continuation<? super FusionFetchMessagesServiceImpl$loadNext$1> continuation) {
        super(continuation);
        this.this$0 = fusionFetchMessagesServiceImpl;
    }

    public final Object invokeSuspend(Object obj) {
        Object loadNext;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        loadNext = this.this$0.loadNext(null, (Continuation) this);
        return loadNext;
    }
}