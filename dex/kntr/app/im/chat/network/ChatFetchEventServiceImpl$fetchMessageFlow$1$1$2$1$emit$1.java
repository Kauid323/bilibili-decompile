package kntr.app.im.chat.network;

import kntr.app.im.chat.network.ChatFetchEventServiceImpl$fetchMessageFlow$1;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChatFetchEventServiceImpl.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.network.ChatFetchEventServiceImpl$fetchMessageFlow$1$1$2$1", f = "ChatFetchEventServiceImpl.kt", i = {0, 0, 1, 1}, l = {73, 79}, m = "emit", n = {"it", "lockBefore", "it", "lockBefore"}, s = {"L$0", "I$0", "L$0", "I$0"}, v = 1)
public final class ChatFetchEventServiceImpl$fetchMessageFlow$1$1$2$1$emit$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChatFetchEventServiceImpl$fetchMessageFlow$1.AnonymousClass1.AnonymousClass2.C00171<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChatFetchEventServiceImpl$fetchMessageFlow$1$1$2$1$emit$1(ChatFetchEventServiceImpl$fetchMessageFlow$1.AnonymousClass1.AnonymousClass2.C00171<? super T> c00171, Continuation<? super ChatFetchEventServiceImpl$fetchMessageFlow$1$1$2$1$emit$1> continuation) {
        super(continuation);
        this.this$0 = c00171;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((MessageEvent) null, (Continuation) this);
    }
}