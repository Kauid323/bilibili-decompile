package kntr.app.im.chat.service;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FetchMessagesWithSendingProgressService.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.service.FetchMessagesWithSendingProgressService", f = "FetchMessagesWithSendingProgressService.kt", i = {0, 0, 1, 1, 1, 2, 2, 2, 2, 2}, l = {460, 478, 487}, m = "loadPrev", n = {"state", "currentRange", "state", "currentRange", "prevRange", "state", "currentRange", "prevRange", "it", "$i$a$-fold-FetchMessagesWithSendingProgressService$loadPrev$3"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
public final class FetchMessagesWithSendingProgressService$loadPrev$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FetchMessagesWithSendingProgressService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FetchMessagesWithSendingProgressService$loadPrev$1(FetchMessagesWithSendingProgressService fetchMessagesWithSendingProgressService, Continuation<? super FetchMessagesWithSendingProgressService$loadPrev$1> continuation) {
        super(continuation);
        this.this$0 = fetchMessagesWithSendingProgressService;
    }

    public final Object invokeSuspend(Object obj) {
        Object loadPrev;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        loadPrev = this.this$0.loadPrev(null, (Continuation) this);
        return loadPrev;
    }
}