package kntr.app.im.chat.service.sender.image;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ImageMessageSender.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.service.sender.image.ImageMessageSendTask", f = "ImageMessageSender.kt", i = {}, l = {307}, m = "send-IoAF18A", n = {}, s = {}, v = 1)
public final class ImageMessageSendTask$send$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ImageMessageSendTask this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageMessageSendTask$send$1(ImageMessageSendTask imageMessageSendTask, Continuation<? super ImageMessageSendTask$send$1> continuation) {
        super(continuation);
        this.this$0 = imageMessageSendTask;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object mo1358sendIoAF18A = this.this$0.mo1358sendIoAF18A((Continuation) this);
        return mo1358sendIoAF18A == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? mo1358sendIoAF18A : Result.box-impl(mo1358sendIoAF18A);
    }
}