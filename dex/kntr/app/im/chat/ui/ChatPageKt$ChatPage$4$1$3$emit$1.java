package kntr.app.im.chat.ui;

import kntr.app.im.chat.ui.ChatPageKt$ChatPage$4$1;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChatPage.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.ui.ChatPageKt$ChatPage$4$1$3", f = "ChatPage.kt", i = {0}, l = {175}, m = "emit", n = {"it"}, s = {"Z$0"}, v = 1)
public final class ChatPageKt$ChatPage$4$1$3$emit$1 extends ContinuationImpl {
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChatPageKt$ChatPage$4$1.AnonymousClass3<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChatPageKt$ChatPage$4$1$3$emit$1(ChatPageKt$ChatPage$4$1.AnonymousClass3<? super T> anonymousClass3, Continuation<? super ChatPageKt$ChatPage$4$1$3$emit$1> continuation) {
        super(continuation);
        this.this$0 = anonymousClass3;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit(false, (Continuation) this);
    }
}