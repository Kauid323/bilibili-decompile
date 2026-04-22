package kntr.app.im.chat.service.sender;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TextMessageSender.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.service.sender.TextMessageTask", f = "TextMessageSender.kt", i = {}, l = {144}, m = "send-IoAF18A", n = {}, s = {}, v = 1)
public final class TextMessageTask$send$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TextMessageTask this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextMessageTask$send$1(TextMessageTask textMessageTask, Continuation<? super TextMessageTask$send$1> continuation) {
        super(continuation);
        this.this$0 = textMessageTask;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object mo1358sendIoAF18A = this.this$0.mo1358sendIoAF18A((Continuation) this);
        return mo1358sendIoAF18A == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? mo1358sendIoAF18A : Result.box-impl(mo1358sendIoAF18A);
    }
}