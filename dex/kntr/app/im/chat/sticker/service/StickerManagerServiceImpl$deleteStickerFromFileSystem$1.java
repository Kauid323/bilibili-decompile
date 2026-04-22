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
@DebugMetadata(c = "kntr.app.im.chat.sticker.service.StickerManagerServiceImpl", f = "StickerManagerService.kt", i = {0}, l = {134}, m = "deleteStickerFromFileSystem-gIAlu-s", n = {"sticker"}, s = {"L$0"}, v = 1)
public final class StickerManagerServiceImpl$deleteStickerFromFileSystem$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StickerManagerServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerManagerServiceImpl$deleteStickerFromFileSystem$1(StickerManagerServiceImpl stickerManagerServiceImpl, Continuation<? super StickerManagerServiceImpl$deleteStickerFromFileSystem$1> continuation) {
        super(continuation);
        this.this$0 = stickerManagerServiceImpl;
    }

    public final Object invokeSuspend(Object obj) {
        Object m1695deleteStickerFromFileSystemgIAlus;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        m1695deleteStickerFromFileSystemgIAlus = this.this$0.m1695deleteStickerFromFileSystemgIAlus(null, (Continuation) this);
        return m1695deleteStickerFromFileSystemgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m1695deleteStickerFromFileSystemgIAlus : Result.box-impl(m1695deleteStickerFromFileSystemgIAlus);
    }
}