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
@DebugMetadata(c = "kntr.app.im.chat.service.personal.ConversationServiceImpl", f = "ConversationServiceImpl.kt", i = {}, l = {26}, m = "blockUser-IoAF18A", n = {}, s = {}, v = 1)
public final class ConversationServiceImpl$blockUser$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ConversationServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConversationServiceImpl$blockUser$1(ConversationServiceImpl conversationServiceImpl, Continuation<? super ConversationServiceImpl$blockUser$1> continuation) {
        super(continuation);
        this.this$0 = conversationServiceImpl;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object mo1354blockUserIoAF18A = this.this$0.mo1354blockUserIoAF18A((Continuation) this);
        return mo1354blockUserIoAF18A == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? mo1354blockUserIoAF18A : Result.box-impl(mo1354blockUserIoAF18A);
    }
}