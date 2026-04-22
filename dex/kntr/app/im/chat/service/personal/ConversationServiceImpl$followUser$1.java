package kntr.app.im.chat.service.personal;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConversationServiceImpl.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.service.personal.ConversationServiceImpl", f = "ConversationServiceImpl.kt", i = {0, 0, 1, 1}, l = {31, 40}, m = "followUser-IoAF18A", n = {"$i$f$runSuspendCatching", "$i$a$-runSuspendCatching-ConversationServiceImpl$followUser$2", "it", "$i$a$-map-ConversationServiceImpl$followUser$3"}, s = {"I$0", "I$1", "L$0", "I$0"}, v = 1)
public final class ConversationServiceImpl$followUser$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ConversationServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConversationServiceImpl$followUser$1(ConversationServiceImpl conversationServiceImpl, Continuation<? super ConversationServiceImpl$followUser$1> continuation) {
        super(continuation);
        this.this$0 = conversationServiceImpl;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object mo1356followUserIoAF18A = this.this$0.mo1356followUserIoAF18A((Continuation) this);
        return mo1356followUserIoAF18A == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? mo1356followUserIoAF18A : Result.box-impl(mo1356followUserIoAF18A);
    }
}