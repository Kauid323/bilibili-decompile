package kntr.app.im.chat.sticker.service;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StickerManagerService.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.sticker.service.StickerManagerServiceImpl", f = "StickerManagerService.kt", i = {0, 0, 1, 1, 1, 1}, l = {120, 127}, m = "saveSticker-0E7RQCE", n = {"imageUrl", "resolution", "imageUrl", "resolution", "it", "$i$a$-map-StickerManagerServiceImpl$saveSticker$2"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "I$0"}, v = 1)
public final class StickerManagerServiceImpl$saveSticker$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StickerManagerServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerManagerServiceImpl$saveSticker$1(StickerManagerServiceImpl stickerManagerServiceImpl, Continuation<? super StickerManagerServiceImpl$saveSticker$1> continuation) {
        super(continuation);
        this.this$0 = stickerManagerServiceImpl;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object mo1691saveSticker0E7RQCE = this.this$0.mo1691saveSticker0E7RQCE(null, null, (Continuation) this);
        return mo1691saveSticker0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? mo1691saveSticker0E7RQCE : Result.box-impl(mo1691saveSticker0E7RQCE);
    }
}