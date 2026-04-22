package kntr.app.im.chat.frame.bubble;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChatBubbleFrame.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.frame.bubble.ChatBubbleFrame", f = "ChatBubbleFrame.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {39}, m = "restoreFrame", n = {"$this$map$iv", "$this$mapTo$iv$iv", "destination$iv$iv", "item$iv$iv", "it", "$i$f$map", "$i$f$mapTo", "$i$a$-map-ChatBubbleFrame$restoreFrame$2"}, s = {"L$0", "L$1", "L$2", "L$4", "L$5", "I$0", "I$1", "I$2"}, v = 1)
public final class ChatBubbleFrame$restoreFrame$1 extends ContinuationImpl {
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
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChatBubbleFrame this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatBubbleFrame$restoreFrame$1(ChatBubbleFrame chatBubbleFrame, Continuation<? super ChatBubbleFrame$restoreFrame$1> continuation) {
        super(continuation);
        this.this$0 = chatBubbleFrame;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.restoreFrame((Continuation) this);
    }
}