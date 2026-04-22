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
@DebugMetadata(c = "kntr.app.im.chat.service.personal.ConversationServiceImpl", f = "ConversationServiceImpl.kt", i = {0, 0, 0, 0}, l = {55}, m = "setChatSetting-0E7RQCE", n = {"type", "switchOn", "$i$f$runSuspendCatching", "$i$a$-runSuspendCatching-ConversationServiceImpl$setChatSetting$2"}, s = {"L$0", "Z$0", "I$0", "I$1"}, v = 1)
public final class ConversationServiceImpl$setChatSetting$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ConversationServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConversationServiceImpl$setChatSetting$1(ConversationServiceImpl conversationServiceImpl, Continuation<? super ConversationServiceImpl$setChatSetting$1> continuation) {
        super(continuation);
        this.this$0 = conversationServiceImpl;
    }

    public final Object invokeSuspend(Object obj) {
        Object m1587setChatSetting0E7RQCE;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        m1587setChatSetting0E7RQCE = this.this$0.m1587setChatSetting0E7RQCE(null, false, (Continuation) this);
        return m1587setChatSetting0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m1587setChatSetting0E7RQCE : Result.box-impl(m1587setChatSetting0E7RQCE);
    }
}