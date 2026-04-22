package kntr.app.im.chat.db.service;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChatInfoDatabaseServiceImpl.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.db.service.ChatInfoDatabaseServiceImpl", f = "ChatInfoDatabaseServiceImpl.kt", i = {}, l = {31}, m = "load", n = {}, s = {}, v = 1)
public final class ChatInfoDatabaseServiceImpl$load$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChatInfoDatabaseServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatInfoDatabaseServiceImpl$load$1(ChatInfoDatabaseServiceImpl chatInfoDatabaseServiceImpl, Continuation<? super ChatInfoDatabaseServiceImpl$load$1> continuation) {
        super(continuation);
        this.this$0 = chatInfoDatabaseServiceImpl;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.load((Continuation) this);
    }
}