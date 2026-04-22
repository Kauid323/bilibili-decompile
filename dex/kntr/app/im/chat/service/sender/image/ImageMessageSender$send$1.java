package kntr.app.im.chat.service.sender.image;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ImageMessageSender.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.service.sender.image.ImageMessageSender", f = "ImageMessageSender.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {65, 85}, m = "send", n = {"sessionId", "content", "msgType", "userPlaceholder", "offsetProvider", "sessionId", "content", "msgType", "userPlaceholder", "offsetProvider"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4"}, v = 1)
public final class ImageMessageSender$send$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ImageMessageSender this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageMessageSender$send$1(ImageMessageSender imageMessageSender, Continuation<? super ImageMessageSender$send$1> continuation) {
        super(continuation);
        this.this$0 = imageMessageSender;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.send(null, null, null, null, null, (Continuation) this);
    }
}