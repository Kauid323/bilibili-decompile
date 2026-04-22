package kntr.app.im.chat.ui;

import kntr.app.im.chat.ui.ChatPageKt$ChatPage$5$1;
import kntr.common.photonic.aphro.ui.preview.model.ImagePreviewSelectResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChatPage.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.ui.ChatPageKt$ChatPage$5$1$1$2", f = "ChatPage.kt", i = {0, 1}, l = {193, 200}, m = "emit", n = {"it", "it"}, s = {"L$0", "L$0"}, v = 1)
public final class ChatPageKt$ChatPage$5$1$1$2$emit$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChatPageKt$ChatPage$5$1.AnonymousClass1.AnonymousClass2<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ChatPageKt$ChatPage$5$1$1$2$emit$1(ChatPageKt$ChatPage$5$1.AnonymousClass1.AnonymousClass2<? super T> anonymousClass2, Continuation<? super ChatPageKt$ChatPage$5$1$1$2$emit$1> continuation) {
        super(continuation);
        this.this$0 = anonymousClass2;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((ImagePreviewSelectResult) null, (Continuation) this);
    }
}