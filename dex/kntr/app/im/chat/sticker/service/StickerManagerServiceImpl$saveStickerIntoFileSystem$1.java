package kntr.app.im.chat.sticker.service;

import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StickerManagerService.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.sticker.service.StickerManagerServiceImpl", f = "StickerManagerService.kt", i = {0, 0, 0, 0, 0, 0}, l = {150}, m = "saveStickerIntoFileSystem-0E7RQCE", n = {"sticker", "mimeType", "extension", "fileName", "savePath", ReportBuildInParam.MID}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "J$0"}, v = 1)
public final class StickerManagerServiceImpl$saveStickerIntoFileSystem$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StickerManagerServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerManagerServiceImpl$saveStickerIntoFileSystem$1(StickerManagerServiceImpl stickerManagerServiceImpl, Continuation<? super StickerManagerServiceImpl$saveStickerIntoFileSystem$1> continuation) {
        super(continuation);
        this.this$0 = stickerManagerServiceImpl;
    }

    public final Object invokeSuspend(Object obj) {
        Object m1697saveStickerIntoFileSystem0E7RQCE;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        m1697saveStickerIntoFileSystem0E7RQCE = this.this$0.m1697saveStickerIntoFileSystem0E7RQCE(null, 0L, (Continuation) this);
        return m1697saveStickerIntoFileSystem0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? m1697saveStickerIntoFileSystem0E7RQCE : Result.box-impl(m1697saveStickerIntoFileSystem0E7RQCE);
    }
}